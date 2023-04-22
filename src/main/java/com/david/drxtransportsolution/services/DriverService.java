package com.david.drxtransportsolution.services;

import com.david.drxtransportsolution.dtos.DriverDTO;
import com.david.drxtransportsolution.entities.Driver;
import com.david.drxtransportsolution.repositories.DriverRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverService {

    private final DriverRepository driverRepository;

    public Driver getDriverById(long driverId) {
        return driverRepository.findById(driverId).orElseThrow(() -> new EntityNotFoundException("Driver not found"));
    }

    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    public void addNewDriver(DriverDTO driverDTO) {
        Driver newDriver = new Driver()
                .firstName(driverDTO.getFirstName())
                .lastName(driverDTO.getLastName())
                .phoneNumber(driverDTO.getPhoneNumber())
                .email(driverDTO.getEmail());

        driverRepository.save(newDriver);
    }

    public void updateDriver(long driverId, DriverDTO driverDTO) {
        Driver existingDriver = driverRepository.findById(driverId).orElseThrow(() -> new EntityNotFoundException("Driver not found"));
        existingDriver.firstName(driverDTO.getFirstName())
                .lastName(driverDTO.getLastName())
                .phoneNumber(driverDTO.getPhoneNumber())
                .email(driverDTO.getEmail());

        driverRepository.save(existingDriver);
    }

    public void deleteDriver(long driverId) {
        Driver existingDriver = driverRepository.findById(driverId).orElseThrow(() -> new EntityNotFoundException("Driver not found"));
        driverRepository.delete(existingDriver);
    }
}
