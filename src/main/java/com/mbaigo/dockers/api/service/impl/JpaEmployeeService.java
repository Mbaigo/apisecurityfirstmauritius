package com.mbaigo.dockers.api.service.impl;

import com.mbaigo.dockers.api.exceptions.ResourceNotFoundException;
import com.mbaigo.dockers.api.model.Employee;
import com.mbaigo.dockers.api.repository.EmployeeRepository;
import com.mbaigo.dockers.api.service.EmployeeService;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@Qualifier(value = "jpaEmployeeService")
public class JpaEmployeeService implements EmployeeService {
   private final EmployeeRepository employeeRepository;
    public JpaEmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeById(Long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public Boolean deletEmployee(Long id) {
         employeeRepository.deleteById(id);
        return Boolean.TRUE;
    }

    @Override
    public List<Employee> getByFirstName(String firstName) {
        return employeeRepository
                .findAll()
                .stream()
                .filter(empl->firstName.toLowerCase().equals(empl.getFirstName().toLowerCase()))
                .toList();
    }

    @Override
    public Employee getEmployeeByMatricule(String matricule) {
        return employeeRepository
                .findAll()
                .stream()
                .filter(empl->matricule.equals(empl.getMatricule()))
                .findFirst()
                .orElseThrow();
    }

    @Override
    public Employee getEmployeeByEmail(String email) {
        return employeeRepository
                .findAll()
                .stream()
                .filter(empl->email.equals(empl.getEmail()))
                .findFirst()
                .orElseThrow();
    }

    @Override
    public Employee getEmployeeByPhoneNumber(String phoneNumber) {
        return employeeRepository.findAll()
                .stream()
                .filter(empl->phoneNumber.equals(empl.getPhoneNumber()))
                .findFirst()
                .orElseThrow();
    }

    //Méthode génération des alphabets du matricule
    private static List<String> generateAlphabetList() {
        List<String> alphabets = new ArrayList<>();
        // Générer les lettres individuelles de 'A' à 'Z'
        List<String> singleLetters = IntStream.rangeClosed('A', 'Z')
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.toList());
        alphabets.addAll(singleLetters);

        // Générer les combinaisons à deux lettres
        List<String> doubleLetters = singleLetters.stream()
                //le flatMap permet de parcourir une liste en imbrequant
                .flatMap(letter1 -> singleLetters.stream().map(letter2 -> letter1 + letter2))
                .collect(Collectors.toList());

        alphabets.addAll(doubleLetters);

        return alphabets;
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {

        // we need to check whether employee with given id is exist in DB or not
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "id", id));

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        // save existing employee to DB
        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }
}
