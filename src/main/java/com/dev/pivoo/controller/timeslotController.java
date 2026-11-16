package com.dev.pivoo.controller;

import com.dev.pivoo.DTO.requests.timeslotRequest;
import com.dev.pivoo.DTO.requests.timeslotRequest;
import com.dev.pivoo.model.timeslot;
import com.dev.pivoo.model.timeslot;
import com.dev.pivoo.service.timeslotService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/timeslot")
public class timeslotController {

    private final timeslotService timeslotService;

    public timeslotController(timeslotService timeslotService) {
        this.timeslotService = timeslotService;
    }

    // POST METHOD
    @PostMapping("/save")
    public ResponseEntity<?> save(
            @RequestBody timeslotRequest request
    )
    {
        timeslot timeslot = timeslotService.savetimeslot(request);

        return ResponseEntity.ok(timeslot);
    }


    // PATCH METHOD
    @PatchMapping("/edit/{id}")
    public ResponseEntity<?> edit(
            @PathVariable("id") Long id,
            @RequestBody timeslotRequest request
    ){

        timeslot timeslot = timeslotService.editTimeslot(id, request);

        return ResponseEntity.ok(timeslot);
    }

    @PatchMapping("/reactivate/{id}")
    public ResponseEntity<?> reactivateTimeslot(@PathVariable("id") Long id) {

        timeslot timeslot = timeslotService.reactivateTimeslot(id);

        return ResponseEntity.ok(timeslot);

    }

    @PatchMapping("/deactivate/{id}")
    public ResponseEntity<?> deactivateTimeslot(@PathVariable("id") Long id) {

        timeslot timeslot = timeslotService.deactivateTimeslot(id);

        return ResponseEntity.ok(timeslot);

    }

    // GET METHOD
    @GetMapping("/list")
    public ResponseEntity<List<timeslot>> listTimeslots() {

        List<timeslot> timeslots = timeslotService.findAllTimeslots();

        return ResponseEntity.ok(timeslots);

    }

    @GetMapping("/list/active")
    public ResponseEntity<List<timeslot>> listActiveTimeslots() {

        List<timeslot> timeslots = timeslotService.findActiveTimeslots();

        return ResponseEntity.ok(timeslots);

    }

    @GetMapping("/list/inactive")
    public ResponseEntity<List<timeslot>> listInactiveTimeslots() {

        List<timeslot> timeslots = timeslotService.findInactiveTimeslots();

        return ResponseEntity.ok(timeslots);

    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getTimeslotById(@PathVariable("id") Long id) {

        timeslot timeslot = timeslotService.getTimeslotById(id);

        return ResponseEntity.ok(timeslot);

    }


    // DELETE METHOD
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){

        timeslotService.deleteTimeslot(id);

        return ResponseEntity.noContent().build();
    }

}
