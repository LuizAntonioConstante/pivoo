package com.dev.soccer.controller;

import com.dev.soccer.DTO.requests.clientRequest;
import com.dev.soccer.model.client;
import com.dev.soccer.service.clientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/list")
    public ResponseEntity<List<client>> listClients() {

        List<client> clients = clientService.findAllClients();

        return ResponseEntity.ok(clients);

    }

}
