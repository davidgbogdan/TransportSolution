package com.david.drxtransportsolution.controllers;

import com.david.drxtransportsolution.dtos.LocationDTO;
import com.david.drxtransportsolution.entities.Location;
import com.david.drxtransportsolution.services.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/location")
public class LocationController {

    private final LocationService locationService;

    @GetMapping
    public ResponseEntity<List<Location>> getLocations() {
        List<Location> locationList = locationService.getAllLocations();
        return ResponseEntity.ok(locationList);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Location> getLocation(@PathVariable long id) {
        Location location = locationService.getLocationById(id);
        if(location != null){
            return ResponseEntity.ok(location);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> addLocation(@Validated @RequestBody LocationDTO locationDTO) {
        locationService.addNewLocation(locationDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Location created successfully");
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<String> updateLocation(@PathVariable long id,@Validated @RequestBody LocationDTO locationDTO) {
        locationService.updateLocation(id, locationDTO);
        return ResponseEntity.ok("Location updated successfully");
    }

    @DeleteMapping(path = "/{id}")
    public void deleteLocation(@PathVariable long id) {
        locationService.deleteLocation(id);
    }
}
