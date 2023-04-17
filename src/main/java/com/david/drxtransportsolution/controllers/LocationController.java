package com.david.drxtransportsolution.controllers;

import com.david.drxtransportsolution.entities.Location;
import com.david.drxtransportsolution.services.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/location")
public class LocationController {

    private final LocationService locationService;

    @GetMapping(path = "/getLocations")
    public List<Location> getLocations(){
        return locationService.getAllLocations();
    }

    @GetMapping(path = "/getLocation/{id}")
    public Optional<Location> getLocation(@PathVariable int id){
        return locationService.getLocationById(id);
    }

    @PostMapping(path = "/addLocation")
    public void addLocation(@RequestBody Location requestLocation){
        locationService.addNewLocation(requestLocation.getAddress());
    }

    @PutMapping(path = "/updateLocation/{id}")
    public void updateLocation(@PathVariable int id, @RequestBody Location requestLocation){
        locationService.updateLocation(id, requestLocation.getAddress());
    }

    @DeleteMapping(path = "/deleteLocation/{id}")
    public void deleteLocation(@PathVariable int id){
        locationService.deleteLocation(id);
    }
}
