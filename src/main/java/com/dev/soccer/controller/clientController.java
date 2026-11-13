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

    @PatchMapping("/edit/{id}")
    public ResponseEntity<?> edit(
            @PathVariable("id") Long id,
            @RequestBody clientRequest request
    ){

        client client = clientService.editClient(id, request);

        return ResponseEntity.ok(client);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){

        clientService.deleteClient(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/list")
    public ResponseEntity<List<client>> listClients() {

        List<client> clients = clientService.findAllClients();

        return ResponseEntity.ok(clients);

    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getClientById(@PathVariable("id") Long id) {

        client client = clientService.getClientById(id);

        return ResponseEntity.ok(client);

    }

    @PatchMapping("/deactivate/{id}")
    public ResponseEntity<?> deactivateClient(@PathVariable("id") Long id) {

        client client = clientService.deactivateClient(id);

        return ResponseEntity.ok(client);

    }

    @PatchMapping("/reactivate/{id}")
    public ResponseEntity<?> reactivateClient(@PathVariable("id") Long id) {

        client client = clientService.reactivateClient(id);

        return ResponseEntity.ok(client);

    }



}
