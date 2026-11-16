package com.dev.pivoo.controller;

import com.dev.pivoo.DTO.requests.financeRequest;
import com.dev.pivoo.DTO.requests.financeRequest;
import com.dev.pivoo.model.finance;
import com.dev.pivoo.model.finance;
import com.dev.pivoo.service.financeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/finance")
public class financeController {

    private final financeService financeService;

    public financeController(financeService financeService) {
        this.financeService = financeService;
    }


    // POST METHOD
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody financeRequest request){

        finance finance = financeService.savefinance(request);

        return ResponseEntity.ok(finance);
    }


    // PATCH METHOD
    @PatchMapping("/edit/{id}")
    public ResponseEntity<?> edit(@PathVariable("id") Long id, @RequestBody financeRequest request){

        finance finance = financeService.editFinance(id, request);

        return ResponseEntity.ok(finance);
    }

    @PatchMapping("/settle/{id}")
    public ResponseEntity<?> settle(@PathVariable Long id){

        finance finance = financeService.settleFinance(id);

        return ResponseEntity.ok(finance);
    }

    @PatchMapping("/reopen/{id}")
    public ResponseEntity<?> reopen(@PathVariable Long id){

        finance finance = financeService.reopenFinance(id);

        return ResponseEntity.ok(finance);
    }

    @PatchMapping("/deactivate/{id}")
    public ResponseEntity<?> deactivateFinance(@PathVariable("id") Long id) {

        finance finance = financeService.deactivateFinance(id);

        return ResponseEntity.ok(finance);
    }

    @PatchMapping("/reactivate/{id}")
    public ResponseEntity<?> reactivateFinance(@PathVariable("id") Long id) {

        finance finance = financeService.reactivateFinance(id);

        return ResponseEntity.ok(finance);
    }


    // GET METHOD
    @GetMapping("/list")
    public ResponseEntity<List<finance>> listFinances() {

        List<finance> finances = financeService.findAllFinances();

        return ResponseEntity.ok(finances);
    }

    @GetMapping("/list/active")
    public ResponseEntity<List<finance>> listActiveFinances() {

        List<finance> finances = financeService.findActiveFinances();

        return ResponseEntity.ok(finances);
    }

    @GetMapping("/list/inactive")
    public ResponseEntity<List<finance>> listInactiveFinances() {

        List<finance> finances = financeService.findInactiveFinances();

        return ResponseEntity.ok(finances);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getFinanceById(@PathVariable("id") Long id) {

        finance finance = financeService.getFinanceById(id);

        return ResponseEntity.ok(finance);
    }


    // DELETE METHOD
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){

        financeService.deleteFinance(id);

        return ResponseEntity.noContent().build();
    }

}
