package com.david.drxtransportsolution.controllers;

import com.david.drxtransportsolution.dtos.GateDTO;
import com.david.drxtransportsolution.entities.Gate;
import com.david.drxtransportsolution.services.GateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/gate")
public class GateController {

    private final GateService gateService;

    @GetMapping
    public List<Gate> getAllGates(){
        return gateService.getAllGates();
    }

    @GetMapping(path = "/{id}")
    public Gate getGetById(long gateId){
        return gateService.getGateById(gateId);
    }

    @PostMapping
    public void addNewGate(@RequestBody GateDTO gateDTO){
        gateService.addNewGate(gateDTO);
    }

    @PutMapping(path = "/{id}")
    public void updateGate(@PathVariable long id, @RequestBody GateDTO gateDTO){
        gateService.updateGate(id, gateDTO);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteGate(@PathVariable long id){
        gateService.deleteGate(id);
    }
}
