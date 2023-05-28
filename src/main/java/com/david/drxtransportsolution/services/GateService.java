package com.david.drxtransportsolution.services;

import com.david.drxtransportsolution.dtos.GateDTO;
import com.david.drxtransportsolution.entities.Gate;
import com.david.drxtransportsolution.repositories.GateRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GateService {

    private final GateRepository gateRepository;

    public List<Gate> getAllGates(){
        return gateRepository.findAll();
    }

    public List<Gate> getByLocationId(long locationId){
        return gateRepository.findByLocationId(locationId);
    }

    public void addNewGate(GateDTO gateDTO){
        Gate newGate = new Gate().setLocationId(gateDTO.getLocationId());
        gateRepository.save(newGate);
    }

    public void updateGate(long gateId, GateDTO gateDTO){
        Gate existingGate = gateRepository.findById(gateId).orElseThrow(() -> new EntityNotFoundException("Gate not found"));
        existingGate.setLocationId(gateDTO.getLocationId());
        gateRepository.save(existingGate);
    }

    public void deleteGate(long gateId){
        Gate existingGate = gateRepository.findById(gateId).orElseThrow(() -> new EntityNotFoundException("Gate not found"));
        gateRepository.delete(existingGate);
    }
}
