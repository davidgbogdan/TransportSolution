package com.david.drxtransportsolution.controllers;

import com.david.drxtransportsolution.entities.Program;
import com.david.drxtransportsolution.services.ProgramService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/program")
public class ProgramController {
    private final ProgramService programService;

    @GetMapping(path = "/getAllPrograms")
    public List<Program> getPrograms(){
        return programService.getAllPrograms();
    }

    @GetMapping(path = "/getProgram/{id}")
    public Optional<Program> getProgram(@PathVariable int id){
        return programService.getProgramById(id);
    }

    @PostMapping(path = "/addProgram")
    public void addProgram(@RequestBody Program requestProgram){
        programService.addNewProgram(requestProgram.getIdGate(),
                requestProgram.getIdTransport(),
                requestProgram.getDeliveryHour());
    }

    @PutMapping(path = "/updateProgram")
    public void updateProgram(@PathVariable int id, @RequestBody Program requestProgram){
        programService.updateProgram(id, requestProgram.getIdGate(),
                requestProgram.getIdTransport(),
                requestProgram.getDeliveryHour());
    }

    @DeleteMapping(path = "/deleteProgram")
    public void deleteProgram(@PathVariable int id){
        programService.deleteProgram(id);
    }
}
