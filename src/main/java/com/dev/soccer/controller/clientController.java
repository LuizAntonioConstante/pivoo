package com.dev.soccer.controller;

import com.dev.soccer.DTO.requests.clientRequest;
import com.dev.soccer.model.client;
import com.dev.soccer.service.clientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client")
public class clientController {

    private final clientService clientService;

    public clientController(clientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(
            @RequestBody clientRequest request
    )
    {
        client client = clientService.saveclient(request);

        return ResponseEntity.ok(client);
    }

}
