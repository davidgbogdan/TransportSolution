package com.david.drxtransportsolution.controllers;

import com.david.drxtransportsolution.dtos.ProgramDTO;
import com.david.drxtransportsolution.entities.Program;
import com.david.drxtransportsolution.services.ProgramService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/program")
public class ProgramController {
    private final ProgramService programService;

    @GetMapping
    public List<Program> getPrograms() {
        return programService.getAllPrograms();
    }

    @GetMapping(path = "/{id}")
    public Program getProgram(@PathVariable long id) {
        return programService.getProgramById(id);
    }

    @PostMapping
    public void addProgram(@RequestBody ProgramDTO programDTO) {
        programService.addNewProgram(programDTO);
    }

    @PutMapping(path = "/{id}")
    public void updateProgram(@PathVariable long id, @RequestBody ProgramDTO programDTO) {
        programService.updateProgram(id, programDTO);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteProgram(@PathVariable long id) {
        programService.deleteProgram(id);
    }
}
