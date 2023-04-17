package com.david.drxtransportsolution.services;

import com.david.drxtransportsolution.entities.Employee;
import com.david.drxtransportsolution.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(int id){
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if(optionalEmployee.isPresent()){
            return employeeRepository.findById(id);
        }else{
            throw new IllegalArgumentException("Employee with id " + id + " not found");
        }
    }

    public void addNewEmployee(int idLocation, String firstName, String lastName, String phoneNumber, String email){
        Employee employee = new Employee();
        employee.setIdLocation(idLocation);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setPhoneNumber(phoneNumber);
        employee.setEmail(email);

        employeeRepository.save(employee);
    }

    public void updateEmployee(int id, int idLocation, String firstName, String lastName, String phoneNumber, String email){
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if(optionalEmployee.isPresent()){
            Employee employee = optionalEmployee.get();
            employee.setIdLocation(idLocation);
            employee.setFirstName(firstName);
            employee.setLastName(lastName);
            employee.setPhoneNumber(phoneNumber);
            employee.setEmail(email);

            employeeRepository.save(employee);
        }else{
            throw new IllegalArgumentException("Employee with id " + id + " not found");
        }
    }

    public void deleteEmployeeById(int id){
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if(optionalEmployee.isPresent()){
            employeeRepository.deleteById(id);
        }else{
            throw new IllegalArgumentException("Employee with id " + id + " not found");
        }
    }
}
