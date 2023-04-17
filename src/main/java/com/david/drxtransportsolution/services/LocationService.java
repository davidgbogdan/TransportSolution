package com.david.drxtransportsolution.services;

import com.david.drxtransportsolution.entities.Location;
import com.david.drxtransportsolution.repositories.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;
    public List<Location> getAllLocations(){
        return locationRepository.findAll();
    }

    public Optional<Location> getLocationById(int id){
        Optional<Location> optionalLocation = locationRepository.findById(id);
        if(optionalLocation.isPresent()){
            return locationRepository.findById(id);
        }else{
            throw new IllegalArgumentException("Location with id " + id + " not found");
        }
    }

    public void addNewLocation(String address){
        Location location = new Location();
        location.setAddress(address);

        locationRepository.save(location);
    }

    public void updateLocation(int id, String address){
        Optional<Location> optionalLocation = locationRepository.findById(id);
        if(optionalLocation.isPresent()){
            Location location = optionalLocation.get();
            location.setAddress(address);
            locationRepository.save(location);
        }else{
            throw new IllegalArgumentException("Location with id " + id + " not found");
        }
    }

    public void deleteLocation(int id){
        Optional<Location> optionalLocation = locationRepository.findById(id);
        if(optionalLocation.isPresent()){
            locationRepository.deleteById(id);
        }else{
            throw new IllegalArgumentException("Location with id " + id + " not found");
        }
    }
}
