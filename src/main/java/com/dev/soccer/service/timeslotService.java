package com.dev.soccer.service;

import com.dev.soccer.DTO.requests.timeslotRequest;
import com.dev.soccer.Mapper.timeslotMapper;
import com.dev.soccer.Repository.clientRepository;
import com.dev.soccer.Repository.timeslotRepository;
import com.dev.soccer.model.client;
import com.dev.soccer.model.timeslot;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

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
    public timeslot savetimeslot(timeslotRequest request){

        client client = clientRepository.findById(request.client_id())
                .orElseThrow(() ->
                        new IllegalArgumentException("Client Not Found")
                );
        timeslot timeslotfinal = timeslotMapper.toEntity(request);

        timeslotfinal.setClient(client);

        return timeslotRepository.save(timeslotfinal);
    }

}
