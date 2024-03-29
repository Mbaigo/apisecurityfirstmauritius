package com.mbaigo.dockers.api.service;

import com.mbaigo.dockers.api.model.Employee;

import java.util.List;

public interface EmployeeService {
    //add an employee
    Employee addEmployee(Employee employee);

    //Get all employees
    List<Employee> getAllEmployee();

    //Get an employee
    Employee getEmployeById(Long id);

    //Update an employee
    Employee updateEmployee(Employee employee, long id);

    //delete an employee
    Boolean deletEmployee(Long id);

    //get employee by Name
    List<Employee> getByFirstName(String firstName);

    //get an employee by matricule
    Employee getEmployeeByMatricule(String matricule);

    //get an employee by email adresse
    Employee getEmployeeByEmail(String email);

    Employee getEmployeeByPhoneNumber(String phoneNumber);
}
