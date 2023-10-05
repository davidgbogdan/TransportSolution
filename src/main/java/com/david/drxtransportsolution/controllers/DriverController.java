package com.david.drxtransportsolution.controllers;

import com.david.drxtransportsolution.dtos.DriverDTO;
import com.david.drxtransportsolution.entities.Driver;
import com.david.drxtransportsolution.services.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/driver")
@RequiredArgsConstructor
public class DriverController {

    private final DriverService driverService;

    @GetMapping
    public ResponseEntity<List<Driver>> getAllDrivers() {
        List<Driver> driverList = driverService.getAllDrivers();
        return ResponseEntity.ok(driverList);

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Driver> getDriver(@PathVariable long id) {
        Driver driver  = driverService.getDriverById(id);
        if(driver != null){
            return ResponseEntity.ok(driver);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> addDriver(@Validated @RequestBody DriverDTO driverDTO) {
        driverService.addNewDriver(driverDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Driver created successfully");
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<String> updateDriver(@PathVariable long id,@Validated @RequestBody DriverDTO driverDTO) {
        driverService.updateDriver(id, driverDTO);
        return ResponseEntity.ok("Driver updated successfully");
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteDriver(@PathVariable long id) {
        if (driverService.deleteDriver(id)) {
            return ResponseEntity.ok("Driver deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
