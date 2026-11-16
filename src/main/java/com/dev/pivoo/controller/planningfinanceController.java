package com.dev.pivoo.controller;

import com.dev.pivoo.DTO.requests.clientRequest;
import com.dev.pivoo.DTO.requests.planningfinanceRequest;
import com.dev.pivoo.model.client;
import com.dev.pivoo.model.planningfinance;
import com.dev.pivoo.service.planningfinanceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    ){
        planningfinance planningfinance = planningfinanceService.saveplanningfinance(request);

        return ResponseEntity.ok(planningfinance);
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<?> edit(
            @PathVariable("id") Long id,
            @RequestBody planningfinanceRequest request
    ){

        planningfinance planningfinance = planningfinanceService.editPlanningfinance(id, request);

        return ResponseEntity.ok(planningfinance);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){

        planningfinanceService.deletePlanningfinance(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/list")
    public ResponseEntity<List<planningfinance>> listPlanningfinance() {

        List<planningfinance> planningfinance = planningfinanceService.findAllPlanningfinances();

        return ResponseEntity.ok(planningfinance);

    }

    @GetMapping("/list/active")
    public ResponseEntity<List<planningfinance>> listActivePlanningfinance() {

        List<planningfinance> planningfinance = planningfinanceService.findActivePlanningfinances();

        return ResponseEntity.ok(planningfinance);

    }

    @GetMapping("/list/inactive")
    public ResponseEntity<List<planningfinance>> listInactivePlanningfinance() {

        List<planningfinance> planningfinance = planningfinanceService.findInactivePlanningfinances();

        return ResponseEntity.ok(planningfinance);

    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getClientById(@PathVariable("id") Long id) {

        planningfinance planningfinance = planningfinanceService.getplanningfinanceById(id);

        return ResponseEntity.ok(planningfinance);

    }

    @PatchMapping("/deactivate/{id}")
    public ResponseEntity<?> deactivatePlanningfinance(@PathVariable("id") Long id) {

        planningfinance planningfinance = planningfinanceService.deactivatePlanningfinance(id);

        return ResponseEntity.ok(planningfinance);

    }

    @PatchMapping("/reactivate/{id}")
    public ResponseEntity<?> reactivatePlanningfinance(@PathVariable("id") Long id) {

        planningfinance planningfinance = planningfinanceService.reactivatePlanningfinance(id);

        return ResponseEntity.ok(planningfinance);

    }
}
