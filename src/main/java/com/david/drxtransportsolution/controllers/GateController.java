package com.david.drxtransportsolution.controllers;

import com.david.drxtransportsolution.entities.Gate;
import com.david.drxtransportsolution.services.GateService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/gate")
public class GateController {

    private final GateService gateService;

    @GetMapping(path = "/getALlGates")
    public List<Gate> getAllGates(){
        return gateService.getAllGates();
    }

    @GetMapping(path = "/getGate/{id}")
    public Optional<Gate> getGate(@PathVariable int id){
        return gateService.getGateById(id);
    }

    @PostMapping(path = "/addNewGate")
    public void addNewGate(@RequestBody Gate requestGate){
        gateService.addNewGate(requestGate.getIdLocation());
    }

    @PutMapping(path = "updateGate/{id}")
    public void updateGate(@PathVariable int id, @RequestBody Gate requestGate){
        gateService.updateGate(id, requestGate.getIdLocation());
    }

    @DeleteMapping(path = "/deleteGate/{id}")
    public void deleteGate(@PathVariable int id){
        gateService.deleteGate(id);
    }
}
