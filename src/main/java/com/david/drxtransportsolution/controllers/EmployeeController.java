package com.david.drxtransportsolution.controllers;

import com.david.drxtransportsolution.dtos.EmployeeDTO;
import com.david.drxtransportsolution.entities.Employee;
import com.david.drxtransportsolution.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employeeList = employeeService.getAllEmployees();
        return ResponseEntity.ok(employeeList);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable long id) {
        Employee employee = employeeService.getEmployeeById(id);
        if(employee != null){
            return ResponseEntity.ok(employee);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public ResponseEntity<String> addEmployee(@Validated @RequestBody EmployeeDTO employeeDTO) {
        employeeService.addNewEmployee(employeeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Employee created successfully");
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable long id,@Validated @RequestBody EmployeeDTO employeeDTO) {
        employeeService.updateEmployee(id, employeeDTO);
        return ResponseEntity.ok("Employee updated successfully");
    }

    @DeleteMapping(path = "/{id}")
    public void deleteEmployee(@PathVariable long id) {
        employeeService.deleteEmployeeById(id);
    }
}
