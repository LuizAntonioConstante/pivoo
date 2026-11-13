package com.dev.pivoo.controller;

import com.dev.pivoo.DTO.requests.financeRequest;
import com.dev.pivoo.model.finance;
import com.dev.pivoo.service.financeService;
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
