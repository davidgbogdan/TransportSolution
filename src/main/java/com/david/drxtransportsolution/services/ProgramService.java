package com.david.drxtransportsolution.services;

import com.david.drxtransportsolution.dtos.ProgramDTO;
import com.david.drxtransportsolution.entities.Program;
import com.david.drxtransportsolution.repositories.ProgramRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProgramService {

    private final ProgramRepository programRepository;

    public List<Program> getAllPrograms(){
        return programRepository.findAll();
    }

    public Program getProgramById(long programId){
        return programRepository.findById(programId).orElseThrow(() -> new EntityNotFoundException("Location not found"));

    }

    public void addNewProgram(ProgramDTO programDTO){
        Program newProgram = new Program().gateId(programDTO.getGateId())
                .transportId(programDTO.getTransportId())
                .deliveryHour(programDTO.getDeliveryHour());
        programRepository.save(newProgram);
    }

    public void updateProgram(long programId, ProgramDTO programDTO){
       Program existingProgram = programRepository.findById(programId).orElseThrow(() -> new EntityNotFoundException("Program not found"));
       existingProgram.gateId(programDTO.getGateId())
               .transportId(programDTO.getTransportId())
               .deliveryHour(programDTO.getDeliveryHour());
       programRepository.save(existingProgram);
    }
    public void deleteProgram(long programId){
        Program existingProgram = programRepository.findById(programId).orElseThrow(() -> new EntityNotFoundException("Program not found"));
        programRepository.delete(existingProgram);
    }
}
