package com.david.drxtransportsolution.controllers;

import com.david.drxtransportsolution.dtos.TransportDTO;
import com.david.drxtransportsolution.entities.Transport;
import com.david.drxtransportsolution.services.TransportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/transport")
public class TransportController {

    private final TransportService transportService;

    @GetMapping
    public List<Transport> getTransports(){
        return transportService.getAllTransports();
    }

    @GetMapping(path = "/{id}")
    public Transport getTransport(@PathVariable long id){
        return transportService.getTransportById(id);
    }

    @PostMapping
    public void addTransport(@RequestBody TransportDTO transportDTO){
        transportService.addNewTransport(transportDTO);
    }

    @PutMapping(path = "/{id}")
    public void updateTransport(@PathVariable long id, @RequestBody TransportDTO transportDTO){
        transportService.updateTransport(id, transportDTO);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteTransport(@PathVariable long id){
        transportService.deleteTransport(id);
    }
}