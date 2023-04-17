package com.david.drxtransportsolution.controllers;

import com.david.drxtransportsolution.entities.Employee;
import com.david.drxtransportsolution.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping(path = "/getAllEmployees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping(path = "/getEmployee/{id}")
    public Optional<Employee> getEmployee(@PathVariable int id){
        return employeeService.getEmployeeById(id);
    }

    @PostMapping(path = "/addEmployee")
    public void addEmployee(@RequestBody Employee requestEmployee){
        employeeService.addNewEmployee(requestEmployee.getIdLocation(), requestEmployee.getFirstName(),
                requestEmployee.getLastName(), requestEmployee.getPhoneNumber(), requestEmployee.getEmail());
    }

    @PutMapping(path = "/updateEmployee/{id}")
    public void updateEmployee(@PathVariable int id, @RequestBody Employee requestEmployee){
        employeeService.updateEmployee(id, requestEmployee.getIdLocation(), requestEmployee.getFirstName(),
                requestEmployee.getLastName(), requestEmployee.getPhoneNumber(), requestEmployee.getEmail());
    }

    @DeleteMapping(path = "/deleteEmployee/{id}")
    public void deleleEmployee(@PathVariable int id){
        employeeService.deleteEmployeeById(id);
    }
}
