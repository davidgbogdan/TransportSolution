package com.david.drxtransportsolution.controllers;

import com.david.drxtransportsolution.entities.Transport;
import com.david.drxtransportsolution.services.TransportService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/transport")
public class TransportController {

    private final TransportService transportService;

    @GetMapping(path = "/getTransports")
    public List<Transport> getTransports(){
        return transportService.getAllTransports();
    }

    @GetMapping(path = "/getTransport/{id}")
    public Optional<Transport> getTransport(@PathVariable long id){
        return transportService.getTransportById(id);
    }

    @PostMapping(path = "/addTransport")
    public void addTransport(@RequestBody Transport requestTransport){
        transportService.addNewTransport(requestTransport.getIdDriver(),
                requestTransport.getIdLocation(),
                requestTransport.getStatus(),
                requestTransport.getDispatchDate(),
                requestTransport.getDeliveryDate());
    }

    @PutMapping(path = "/updateTransport/{id}")
    public void updateTransport(@PathVariable int id, @RequestBody Transport requestTransport){
        transportService.updateTransport(id, requestTransport.getIdDriver(),
                requestTransport.getIdLocation(),
                requestTransport.getStatus(),
                requestTransport.getDispatchDate(),
                requestTransport.getDeliveryDate());
    }

    @DeleteMapping(path = "/deleteTransport/{id}")
    public void deleteTransport(@PathVariable int id){
        transportService.deleteTransport(id);
    }
}
