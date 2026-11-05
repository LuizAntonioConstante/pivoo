package com.dev.soccer.controller;

import com.dev.soccer.DTO.requests.timeslotRequest;
import com.dev.soccer.model.timeslot;
import com.dev.soccer.service.timeslotService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/timeslot")
public class timeslotController {

    private final timeslotService timeslotService;

    public timeslotController(timeslotService timeslotService) {
        this.timeslotService = timeslotService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(
            @RequestBody timeslotRequest request
    )
    {
        timeslot timeslot = timeslotService.savetimeslot(request);

        return ResponseEntity.ok(timeslot);
    }

}
