package com.mbaigo.dockers.api.service.impl;

import com.mbaigo.dockers.api.model.Employee;
import com.mbaigo.dockers.api.repository.InMemoryEmployeeRepository;
import com.mbaigo.dockers.api.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
@Qualifier(value = "inMemoryEmployeeService")
public class InMemoryEmployeeServiceImpl implements EmployeeService {
    private final InMemoryEmployeeRepository inMemoryEmployeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
      return   inMemoryEmployeeRepository.addEmployee(employee);

    }

    @Override
    public List<Employee> getAllEmployee() {
        return inMemoryEmployeeRepository.getAllEmployee();
    }

    @Override
    public Employee getEmployeById(Long id) {
        return inMemoryEmployeeRepository.getEmployeById(id);
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
       return inMemoryEmployeeRepository.updateEmployee(employee);

    }

    @Override
    public Boolean deletEmployee(Long id) {
        return inMemoryEmployeeRepository.deletEmployee(id);
    }

    @Override
    public List<Employee> getByFirstName(String firstName) {
        return inMemoryEmployeeRepository.getByFirstName(firstName);

    }

    @Override
    public Employee getEmployeeByMatricule(String matricule) {
        return inMemoryEmployeeRepository.getByMatricule(matricule);
    }

    @Override
    public Employee getEmployeeByEmail(String email) {
        return inMemoryEmployeeRepository.getByEmail(email);
    }

    @Override
    public Employee getEmployeeByPhoneNumber(String phoneNumber) {
        return inMemoryEmployeeRepository.getByPhoneNumber(phoneNumber);
    }
}
