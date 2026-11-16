package com.dev.pivoo.service;

import com.dev.pivoo.DTO.requests.timeslotRequest;
import com.dev.pivoo.Mapper.timeslotMapper;
import com.dev.pivoo.Repository.clientRepository;
import com.dev.pivoo.Repository.timeslotRepository;
import com.dev.pivoo.model.client;
import com.dev.pivoo.model.timeslot;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class timeslotService {

    private final timeslotRepository timeslotRepository;
    private final clientRepository clientRepository;
    private final timeslotMapper timeslotMapper;

    public timeslotService(timeslotRepository timeslotRepository, clientRepository clientRepository, timeslotMapper timeslotMapper) {
        this.timeslotRepository = timeslotRepository;
        this.clientRepository = clientRepository;
        this.timeslotMapper = timeslotMapper;
    }

    @Transactional
    public timeslot savetimeslot(timeslotRequest request) {

        client client = clientRepository.findById(request.id_client())
                .orElseThrow(() ->
                        new IllegalArgumentException("Client Not Found")
                );
        timeslot timeslotfinal = timeslotMapper.toEntity(request);

        timeslotfinal.setClient(client);

        return timeslotRepository.save(timeslotfinal);
    }

    @Transactional
    public void deleteTimeslot(Long id) {

        boolean exists = timeslotRepository.existsById(id);
        if (exists) {
            timeslotRepository.deleteById(id);
        }
        else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Timeslot not found"
            );
        }
    }

    @Transactional
    public timeslot editTimeslot(Long id, timeslotRequest request) {

        timeslot editTimeslot = timeslotRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Timeslot not found")
        );

        timeslotMapper.updateEntity(editTimeslot, request);

        return timeslotRepository.save(editTimeslot);
    }

    @Transactional(readOnly = true)
    public List<timeslot> findAllTimeslots() {

        return timeslotRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<timeslot> findActiveTimeslots() {

        return timeslotRepository.findActiveTimeslots();
    }

    @Transactional(readOnly = true)
    public List<timeslot> findInactiveTimeslots() {

        return timeslotRepository.findInactiveTimeslots();
    }

    @Transactional(readOnly = true)
    public timeslot getTimeslotById(Long id) {

        return timeslotRepository.findById(id).orElseThrow();
    }

    @Transactional
    public timeslot deactivateTimeslot(Long id) {

        timeslot editTimeslot = timeslotRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Timeslot not found")
        );

        if (editTimeslot.getCancel_date() == null) {
            editTimeslot.setCancel_date(LocalDateTime.now());
        }

        return timeslotRepository.save(editTimeslot);

    }

    @Transactional
    public timeslot reactivateTimeslot(Long id) {

        timeslot editTimeslot = timeslotRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Timeslot not found")
        );

        if (editTimeslot.getCancel_date() != null) {
            editTimeslot.setCancel_date(null);
        }

        return timeslotRepository.save(editTimeslot);
    }
}

