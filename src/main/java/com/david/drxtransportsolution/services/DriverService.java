package com.david.drxtransportsolution.services;

import com.david.drxtransportsolution.dtos.DriverDTO;
import com.david.drxtransportsolution.entities.Driver;
import com.david.drxtransportsolution.entities.Transport;
import com.david.drxtransportsolution.repositories.DriverRepository;
import com.david.drxtransportsolution.repositories.TransportRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverService {

    private final DriverRepository driverRepository;
    private final TransportRepository transportRepository;

    public Driver getDriverById(long driverId) {
        return driverRepository.findById(driverId).orElseThrow(() -> new EntityNotFoundException("Driver not found"));
    }

    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    public void addNewDriver(DriverDTO driverDTO) {
        Driver newDriver = new Driver()
                .setFirstName(driverDTO.getFirstName())
                .setLastName(driverDTO.getLastName())
                .setPhoneNumber(driverDTO.getPhoneNumber())
                .setEmail(driverDTO.getEmail());

        driverRepository.save(newDriver);
    }

    public void updateDriver(long driverId, DriverDTO driverDTO) {
        Driver existingDriver = driverRepository.findById(driverId).orElseThrow(() -> new EntityNotFoundException("Driver not found"));
        existingDriver.setFirstName(driverDTO.getFirstName())
                .setLastName(driverDTO.getLastName())
                .setPhoneNumber(driverDTO.getPhoneNumber())
                .setEmail(driverDTO.getEmail());

        driverRepository.save(existingDriver);
    }

    public boolean deleteDriver(long driverId) {
        Driver existingDriver = driverRepository.findById(driverId).orElseThrow(() -> new EntityNotFoundException("Driver not found"));

        List<Transport> transportsToDelete = transportRepository.findByDriverId(driverId);
        transportRepository.deleteAll(transportsToDelete);

        driverRepository.delete(existingDriver);
        return true;
    }
}
