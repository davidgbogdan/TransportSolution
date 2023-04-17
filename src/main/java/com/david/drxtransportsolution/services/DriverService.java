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

    public Driver getDriverById(long id) {
        return driverRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Driver not found"));
    }

    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    public void addNewDriver(DriverDTO driverDTO) {
        Driver driver = new Driver()
                .firstName(driverDTO.getFirstName())
                .lastName(driverDTO.getLastName())
                .phoneNumber(driverDTO.getPhoneNumber())
                .email(driverDTO.getEmail());

        driverRepository.save(driver);
    }

    public void updateDriver(long id, DriverDTO driverDTO) {
        Driver existingDriver = driverRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Driver not found"));
        existingDriver.setFirstName(driverDTO.getFirstName());
        existingDriver.setLastName(driverDTO.getLastName());
        existingDriver.setPhoneNumber(driverDTO.getPhoneNumber());
        existingDriver.setEmail(driverDTO.getEmail());

        driverRepository.save(existingDriver);
    }

    public void deleteDriver(long id) {
        Driver existingDriver = driverRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Driver not found"));
        driverRepository.delete(existingDriver);
    }
}
