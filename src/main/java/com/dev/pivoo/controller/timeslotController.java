package com.dev.pivoo.controller;

import com.dev.pivoo.DTO.requests.timeslotRequest;
import com.dev.pivoo.model.timeslot;
import com.dev.pivoo.service.timeslotService;
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
