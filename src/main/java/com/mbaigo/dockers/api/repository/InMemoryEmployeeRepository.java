package com.mbaigo.dockers.api.repository;

import com.mbaigo.dockers.api.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class InMemoryEmployeeRepository {

    private static  final List<Employee> DB = new ArrayList<>();

    static {
        DB.add(new Employee(1,"ISSA","Joseph","562-393-334","isajo@gmail.com","FR2931"));
        DB.add(new Employee(2,"Abakar","Mbai","562-678-334","abakar@gmail.com","FR2932"));
        DB.add(new Employee(3,"Youssouf","Eric","777-393-334","mbai@gmail.com","FR2934"));
        DB.add(new Employee(4,"Youssouf","Eric","777-394-334","mbai@gmail.com","FR3934"));

    }

    //add an employee
    public Employee addEmployee(Employee employee){
        DB.add(employee);
        return employee;

    }

    //Get all employees
  public  List<Employee> getAllEmployee(){
        return List.copyOf(DB);

    }

    //Get an employee
    public Employee getEmployeById(Long id){
        return DB.stream()
                .filter(emp ->id.equals(emp.getId()))
                .findFirst()
                .orElseThrow();
    }

    //Update an employee
    public Employee updateEmployee(Employee employee){

        return new Employee();
    }

    //delete an employee
    public Boolean deletEmployee(Long id){
        Employee employee = DB.stream()
                .filter(emp ->id.equals(emp.getId()))
                .findFirst()
                .orElseThrow();
        DB.remove(employee);
        return Boolean.TRUE;
    }
/*
    //get employee by Name
    public Employee getByFirstName(String firstName){
        return (Employee) DB.stream()
                .map(emp->firstName.equals(emp.getFirsName())).collect(Collectors.toList());
    }*/
    public List<Employee> getByFirstName(String firstName){
         List<Employee> list= DB.stream()
                .filter(emp->firstName.equals(emp.getFirsName())).toList();
         return list;
    }

    //get an employee by matricule
    public Employee getByMatricule(String matricule){
        return  DB.stream()
                .filter(emp ->matricule.equals(emp.getMatricule()))
                .findFirst()
                .orElseThrow();
    }

    //get an employee by email adresse
    public Employee getByEmail(String email){
        return  DB.stream()
                .filter(emp ->email.equals(emp.getEmail()))
                .findFirst()
                .orElseThrow();
    }
//getByPhoneNumber
    public Employee getByPhoneNumber(String phoneNumber){
        return  DB.stream()
                .filter(emp ->phoneNumber.equals(emp.getPhoneNumber()))
                .findFirst()
                .orElseThrow();
    }
}
