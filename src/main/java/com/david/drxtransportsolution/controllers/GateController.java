package com.david.drxtransportsolution.controllers;

import com.david.drxtransportsolution.dtos.GateDTO;
import com.david.drxtransportsolution.entities.Gate;
import com.david.drxtransportsolution.services.GateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/gate")
public class GateController {

    private final GateService gateService;

    @GetMapping
    public ResponseEntity<List<Gate>> getAllGates() {
        List<Gate> gateList = gateService.getAllGates();
        return ResponseEntity.ok(gateList);
    }

    @GetMapping("/location/{locationId}")
    public ResponseEntity<List<Gate>> getByLocationId(@PathVariable long locationId){
        List<Gate> gateByLocationList = gateService.getByLocationId(locationId);
        return ResponseEntity.ok(gateByLocationList);
    }
    @PostMapping
    public ResponseEntity<String> addNewGate(@Validated @RequestBody GateDTO gateDTO) {
        gateService.addNewGate(gateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Gate created successfully");
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<String> updateGate(@PathVariable long id,@Validated @RequestBody GateDTO gateDTO) {
        gateService.updateGate(id, gateDTO);
        return ResponseEntity.ok("Gate updated successfully");
    }

    @DeleteMapping(path = "/{id}")
    public void deleteGate(@PathVariable long id) {
        gateService.deleteGate(id);
    }
}
