package com.david.drxtransportsolution.controllers;

import com.david.drxtransportsolution.dtos.GateDTO;
import com.david.drxtransportsolution.entities.Gate;
import com.david.drxtransportsolution.services.GateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public void addNewGate(@RequestBody GateDTO gateDTO) {
        gateService.addNewGate(gateDTO);
    }

    @PutMapping(path = "/{id}")
    public void updateGate(@PathVariable long id, @RequestBody GateDTO gateDTO) {
        gateService.updateGate(id, gateDTO);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteGate(@PathVariable long id) {
        gateService.deleteGate(id);
    }
}
