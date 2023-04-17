package com.david.drxtransportsolution.services;

import com.david.drxtransportsolution.entities.Program;
import com.david.drxtransportsolution.repositories.ProgramRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProgramService {

    private final ProgramRepository programRepository;

    public List<Program> getAllPrograms(){
        return programRepository.findAll();
    }

    public Optional<Program> getProgramById(int id){
        Optional<Program> optionalProgram = programRepository.findById(id);
        if(optionalProgram.isPresent()){
            return programRepository.findById(id);
        }else{
            throw new IllegalArgumentException("Location with id " + id + " not found");
        }
    }

    public void addNewProgram(int idGate, int idTransport, java.util.Date deliveryHour){
        Program program = new Program();
        program.setIdGate(idGate);
        program.setIdTransport(idTransport);
        program.setDeliveryHour(deliveryHour);

        programRepository.save(program);
    }

    public void updateProgram(int id, int idGate, int idTransport, java.util.Date deliveryHour){
        Optional<Program> optionalProgram = programRepository.findById(id);
        if(optionalProgram.isPresent()){
            Program program = optionalProgram.get();
            program.setIdGate(idGate);
            program.setIdTransport(idTransport);
            program.setDeliveryHour(deliveryHour);

            programRepository.save(program);
        }else{
            throw new IllegalArgumentException("Program with id " + id + " not found");
        }
    }

    public void deleteProgram(int id){
        Optional<Program> optionalProgram = programRepository.findById(id);
        if(optionalProgram.isPresent()){
            programRepository.deleteById(id);
        }else{
            throw new IllegalArgumentException("Program with id " + id + " not found");
        }
    }
}
