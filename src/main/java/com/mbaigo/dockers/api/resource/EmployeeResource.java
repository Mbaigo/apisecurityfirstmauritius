package com.mbaigo.dockers.api.resource;

import com.mbaigo.dockers.api.model.Employee;
import com.mbaigo.dockers.api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping(path = "api/employees")
public class EmployeeResource {

    private final EmployeeService employeeService;

    public EmployeeResource(@Qualifier(value = "jpaEmployeeService")
            EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return ResponseEntity.ok(employeeService.getAllEmployee());
    }
    @GetMapping("{id}")
    public ResponseEntity<Employee> getById(@PathVariable("id") Long id){
        return ResponseEntity.ok(employeeService.getEmployeById(id));
    }

    @GetMapping("/searchByFirstName")
    public ResponseEntity<List<Employee>> getByFirstName(@RequestParam("firstName") String firstName){
        return (ResponseEntity<List<Employee>>) ResponseEntity.ok(employeeService.getByFirstName(firstName));
    }

    @GetMapping("/searchByEmail")
    public ResponseEntity<Employee> getEmployeeByEmail(@RequestParam String email){
        return ResponseEntity.ok(employeeService.getEmployeeByEmail(email));
    }

    @GetMapping("/searchByMatricule")
    public ResponseEntity<Employee> getEmployeeByMatricule(@RequestParam("matricule") String matricule){
        return ResponseEntity.ok(employeeService.getEmployeeByMatricule(matricule));
    }

    @GetMapping("/searchByPhoneNumber")
    public ResponseEntity<Employee> getByPhoneNumber(@RequestParam("phoneNumber") String phoneNumber){
        return ResponseEntity.ok(employeeService.getEmployeeByPhoneNumber(phoneNumber));
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        employee.setId(Long.valueOf(employeeService.getAllEmployee().size()+1));
        return ResponseEntity.created(getLocation(employee.getId())).body(employeeService.addEmployee(employee));
    }

    protected static URI getLocation(long id) {
        return fromCurrentRequest().path("{id}").buildAndExpand(id).toUri();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable("id") Long id){
        return ResponseEntity.ok(employeeService.deletEmployee(id));
    }

    // http://localhost:8080/api/employees/1
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id
            ,@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
    }

}
