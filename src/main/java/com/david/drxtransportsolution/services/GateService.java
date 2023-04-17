package com.david.drxtransportsolution.services;

import com.david.drxtransportsolution.entities.Gate;
import com.david.drxtransportsolution.repositories.GateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Optional<Gate> getGateById(int id){
        Optional<Gate> optionalGate = gateRepository.findById(id);
        if(optionalGate.isPresent()){
            return gateRepository.findById(id);
        }else{
            throw new IllegalArgumentException("Gate with id " + id + " not found");
        }
    }

    public void addNewGate(int idLocation){
        Gate gate = new Gate();
        gate.setIdLocation(idLocation);
        gateRepository.save(gate);
    }

    public void updateGate(int id, int idLocation){
        Optional<Gate> optionalGate = gateRepository.findById(id);
        if(optionalGate.isPresent()){
            Gate gate = optionalGate.get();
            gate.setIdLocation(idLocation);

            gateRepository.save(gate);
        }else{
            throw new IllegalArgumentException("Gate with id " + id + " not found");
        }
    }

    public void deleteGate(int id){
        Optional<Gate> optionalGate = gateRepository.findById(id);
        if(optionalGate.isPresent()){
            gateRepository.deleteById(id);
        }else{
            throw new IllegalArgumentException("Gate with id " + id + " not found");
        }
    }
}
