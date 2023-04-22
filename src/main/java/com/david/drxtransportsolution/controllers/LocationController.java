package com.david.drxtransportsolution.controllers;

import com.david.drxtransportsolution.dtos.LocationDTO;
import com.david.drxtransportsolution.entities.Location;
import com.david.drxtransportsolution.services.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/location")
public class LocationController {

    private final LocationService locationService;

    @GetMapping
    public List<Location> getLocations() {
        return locationService.getAllLocations();
    }

    @GetMapping(path = "/{id}")
    public Location getLocation(@PathVariable long id) {
        return locationService.getLocation(id);
    }

    @PostMapping
    public void addLocation(@RequestBody LocationDTO locationDTO) {
        locationService.addNewLocation(locationDTO);
    }

    @PutMapping(path = "/{id}")
    public void updateLocation(@PathVariable long id, @RequestBody LocationDTO locationDTO) {
        locationService.updateLocation(id, locationDTO);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteLocation(@PathVariable long id) {
        locationService.deleteLocation(id);
    }
}
