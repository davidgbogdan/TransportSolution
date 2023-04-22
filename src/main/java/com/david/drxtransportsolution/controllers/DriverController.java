package com.david.drxtransportsolution.controllers;

import com.david.drxtransportsolution.dtos.DriverDTO;
import com.david.drxtransportsolution.entities.Driver;
import com.david.drxtransportsolution.services.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/driver")
@RequiredArgsConstructor
public class DriverController {

    private final DriverService driverService;

    @GetMapping
    public List<Driver> getAllDrivers() {
        return driverService.getAllDrivers();
    }

    @GetMapping(path = "/{id}")
    public Driver getDriver(@PathVariable long id) {
        return driverService.getDriverById(id);
    }

    @PostMapping
    public void addDriver(@RequestBody DriverDTO driverDTO) {
        driverService.addNewDriver(driverDTO);
    }

    @PutMapping(path = "/{id}")
    public void updateDriver(@PathVariable long id, @RequestBody DriverDTO driverDTO) {
        driverService.updateDriver(id, driverDTO);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteDriver(@PathVariable long id) {
        driverService.deleteDriver(id);
    }

}
