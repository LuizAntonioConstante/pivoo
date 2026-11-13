package com.dev.pivoo.service;

import com.dev.pivoo.DTO.requests.timeslotRequest;
import com.dev.pivoo.Mapper.timeslotMapper;
import com.dev.pivoo.Repository.clientRepository;
import com.dev.pivoo.Repository.timeslotRepository;
import com.dev.pivoo.model.client;
import com.dev.pivoo.model.timeslot;
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

        client client = clientRepository.findById(request.id_client())
                .orElseThrow(() ->
                        new IllegalArgumentException("Client Not Found")
                );
        timeslot timeslotfinal = timeslotMapper.toEntity(request);

        timeslotfinal.setClient(client);

        return timeslotRepository.save(timeslotfinal);
    }

}
