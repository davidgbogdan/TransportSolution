package com.david.drxtransportsolution.controllers;

import com.david.drxtransportsolution.dtos.TransportDTO;
import com.david.drxtransportsolution.entities.Transport;
import com.david.drxtransportsolution.services.TransportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/transport")
public class TransportController {

    private final TransportService transportService;

    @GetMapping
    public ResponseEntity<List<Transport>> getTransports() {
        List<Transport> transportList = transportService.getAllTransports();
        return ResponseEntity.ok(transportList);
    }

    @GetMapping(path = "/{id}")
    public Transport getTransport(@PathVariable long id) {
        return transportService.getTransportById(id);
    }

    @PostMapping
    public ResponseEntity<Long> addTransport(@RequestBody TransportDTO transportDTO){
        long transportId = transportService.addNewTransport(transportDTO);
        return ResponseEntity.ok(transportId);
    }

    @PutMapping(path = "/{id}")
    public void updateTransport(@PathVariable long id, @RequestBody TransportDTO transportDTO) {
        transportService.updateTransport(id, transportDTO);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteTransport(@PathVariable long id) {
        transportService.deleteTransport(id);
    }

    @GetMapping(path = "/status")
    public ResponseEntity<Transport.Status[]> getTransportStatuses() {
        Transport.Status[] statuses = Transport.Status.values();
        return ResponseEntity.ok(statuses);
    }
}
