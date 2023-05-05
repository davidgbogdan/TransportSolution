package com.david.drxtransportsolution.services;

import com.david.drxtransportsolution.dtos.EmployeeDTO;
import com.david.drxtransportsolution.entities.Employee;
import com.david.drxtransportsolution.repositories.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(long employeeId) {
        return employeeRepository.findById(employeeId).orElseThrow(() -> new EntityNotFoundException("Employee not found"));
    }

    public void addNewEmployee(EmployeeDTO employeeDTO) {
        Employee newEmployee = new Employee()
                .setFirstName(employeeDTO.getFirstName())
                .setLocationId(employeeDTO.getLocationId())
                .setLastName(employeeDTO.getLastName())
                .setPhoneNumber(employeeDTO.getPhoneNumber())
                .setEmail(employeeDTO.getEmail());

        employeeRepository.save(newEmployee);
    }

    public void updateEmployee(long employeeId, EmployeeDTO employeeDTO) {
        Employee existingEmployee = employeeRepository.findById(employeeId).orElseThrow(() -> new EntityNotFoundException("Employee not found"));
        existingEmployee.setLocationId(employeeDTO.getLocationId())
                .setFirstName(employeeDTO.getFirstName())
                .setLastName(employeeDTO.getLastName())
                .setPhoneNumber(employeeDTO.getPhoneNumber())
                .setEmail(employeeDTO.getEmail());

        employeeRepository.save(existingEmployee);
    }

    public void deleteEmployeeById(long employeeId) {
        Employee existingEmployee = employeeRepository.findById(employeeId).orElseThrow(() -> new EntityNotFoundException("Employee not found"));
        employeeRepository.delete(existingEmployee);
    }
}
