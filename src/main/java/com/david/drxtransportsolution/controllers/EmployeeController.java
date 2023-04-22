package com.david.drxtransportsolution.controllers;

import com.david.drxtransportsolution.dtos.EmployeeDTO;
import com.david.drxtransportsolution.entities.Employee;
import com.david.drxtransportsolution.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping(path = "/{id}")
    public Employee getEmployee(@PathVariable long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping()
    public void addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        employeeService.addNewEmployee(employeeDTO);
    }

    @PutMapping(path = "/{id}")
    public void updateEmployee(@PathVariable long id, @RequestBody EmployeeDTO employeeDTO) {
        employeeService.updateEmployee(id, employeeDTO);
    }

    @DeleteMapping(path = "/{id}")
    public void deleleEmployee(@PathVariable long id) {
        employeeService.deleteEmployeeById(id);
    }
}
