package com.david.drxtransportsolution.services;

import com.david.drxtransportsolution.dtos.LocationDTO;
import com.david.drxtransportsolution.entities.Gate;
import com.david.drxtransportsolution.entities.Location;
import com.david.drxtransportsolution.repositories.GateRepository;
import com.david.drxtransportsolution.repositories.LocationRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;
    private final GateRepository gateRepository;

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    public Location getLocation(long locationId) {
        return locationRepository.findById(locationId).orElseThrow(() -> new EntityNotFoundException("Location not found"));
    }

    public void addNewLocation(LocationDTO locationDTO) {
        Location newLocation = new Location().setAddress(locationDTO.getAddress());
        locationRepository.save(newLocation);
    }

    public void updateLocation(long locationId, LocationDTO locationDTO) {
        Location existingLocation = locationRepository.findById(locationId).orElseThrow(() -> new EntityNotFoundException("Location not found"));
        existingLocation.setAddress(locationDTO.getAddress());
        locationRepository.save(existingLocation);
    }

    public void deleteLocation(long locationId) {
        Location existingLocation = locationRepository.findById(locationId).orElseThrow(() -> new EntityNotFoundException("Location not found"));

        List<Gate> gatesToDelete = gateRepository.findByLocationId(locationId);
        gateRepository.deleteAll(gatesToDelete);

        locationRepository.delete(existingLocation);
    }
}
