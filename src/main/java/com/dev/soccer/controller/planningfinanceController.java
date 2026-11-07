package com.dev.soccer.controller;

import com.dev.soccer.DTO.requests.planningfinanceRequest;
import com.dev.soccer.model.planningfinance;
import com.dev.soccer.service.planningfinanceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/planningfinance")
public class planningfinanceController {

    private final planningfinanceService planningfinanceService;

    public planningfinanceController(planningfinanceService planningfinanceService) {
        this.planningfinanceService = planningfinanceService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(
            @RequestBody planningfinanceRequest request
    )
    {
        planningfinance planningfinance = planningfinanceService.saveplanningfinance(request);

        return ResponseEntity.ok(planningfinance);
    }
}
