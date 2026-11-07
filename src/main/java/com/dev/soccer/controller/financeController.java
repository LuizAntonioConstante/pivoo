package com.dev.soccer.controller;

import com.dev.soccer.DTO.requests.financeRequest;
import com.dev.soccer.model.finance;
import com.dev.soccer.service.financeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/finance")
public class financeController {

    private final financeService financeService;

    public financeController(financeService financeService) {
        this.financeService = financeService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(
            @RequestBody financeRequest request
    )
    {
        finance finance = financeService.savefinance(request);

        return ResponseEntity.ok(finance);
    }
}
