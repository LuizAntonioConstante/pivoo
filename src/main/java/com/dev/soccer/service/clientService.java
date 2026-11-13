package com.dev.soccer.service;

import com.dev.soccer.DTO.requests.clientRequest;
import com.dev.soccer.Mapper.clientMapper;
import com.dev.soccer.Repository.clientRepository;
import com.dev.soccer.model.client;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

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

    @Transactional
    public void deleteClient(Long id){

        boolean exists = clientRepository.existsById(id);
        if(exists){
            clientRepository.deleteById(id);
        }
        else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Client not found"
            );
        }
    }

    @Transactional
    public client editClient(Long id, clientRequest request){

        client editClient = clientRepository.findById(id).orElseThrow(
                ()-> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Client not found")
        );

        clientMapper.updateEntity(editClient, request);

        return clientRepository.save(editClient);
    }

    @Transactional(readOnly = true)
    public List<client> findAllClients(){

        return clientRepository.findAll();
    }

    @Transactional(readOnly = true)
    public client getClientById(Long id){

        return clientRepository.findById(id).orElseThrow();
    }

    @Transactional
    public client deactivateClient(Long id){

        client editClient = clientRepository.findById(id).orElseThrow(
                ()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Client not found")
        );

        if (editClient.getCancel_date() == null) {
            editClient.setCancel_date(LocalDateTime.now());
        }

        return clientRepository.save(editClient);

    }

    @Transactional
    public client reactivateClient(Long id){

        client editClient = clientRepository.findById(id).orElseThrow(
                ()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Client not found")
        );

        if (editClient.getCancel_date() != null) {
            editClient.setCancel_date(null);
        }

        return clientRepository.save(editClient);

    }
}
