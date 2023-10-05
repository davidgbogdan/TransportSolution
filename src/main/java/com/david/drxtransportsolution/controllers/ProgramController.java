package com.david.drxtransportsolution.controllers;

import com.david.drxtransportsolution.dtos.ProgramDTO;
import com.david.drxtransportsolution.entities.Program;
import com.david.drxtransportsolution.services.ProgramService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/program")
public class ProgramController {
    private final ProgramService programService;

    @GetMapping
    public ResponseEntity<List<Program>> getPrograms() {
        List<Program> programList = programService.getAllPrograms();
        return ResponseEntity.ok(programList);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Program> getProgram(@PathVariable long id) {
        Program program = programService.getProgramById(id);
        if(program != null){
            return ResponseEntity.ok(program);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> addProgram(@Validated @RequestBody ProgramDTO programDTO) {
        programService.addNewProgram(programDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Program created successfully");
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<String> updateProgram(@PathVariable long id, @RequestBody ProgramDTO programDTO) {
        programService.updateProgram(id, programDTO);
        return ResponseEntity.ok("Program updated successfully");
    }

    @DeleteMapping(path = "/{id}")
    public void deleteProgram(@PathVariable long id) {
        programService.deleteProgram(id);
    }
}
