package com.dev.soccer.service;

import com.dev.soccer.DTO.requests.clientRequest;
import com.dev.soccer.Mapper.clientMapper;
import com.dev.soccer.Repository.clientRepository;
import com.dev.soccer.model.client;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class clientService {

    private final clientRepository clientRepository;
    private final clientMapper clientMapper;

    public clientService(clientRepository clientRepository, clientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    @Transactional
    public client saveclient(clientRequest request){

        client clientfinal = clientMapper.toEntity(request);

        return clientRepository.save(clientfinal);
    }

}
