package com.mbaigo.dockers.api.resource;

import com.mbaigo.dockers.api.model.Employee;
import com.mbaigo.dockers.api.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping(path = "api/employees")
@AllArgsConstructor
public class EmployeeResource {
    private final EmployeeService employeeService;
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return ResponseEntity.ok(employeeService.getAllEmployee());
    }
    @GetMapping("{id}")
    public ResponseEntity<Employee> getById(@PathVariable("id") long id){
        return ResponseEntity.ok(employeeService.getEmployeById(id));
    }

    @GetMapping("/searchByFirstName")
    public ResponseEntity<List<Employee>> getByFirstName(@RequestParam("firstName") String firstName){
        return (ResponseEntity<List<Employee>>) ResponseEntity.ok(employeeService.getByFirstName(firstName));
    }

    @GetMapping("/searchByEmail")
    public ResponseEntity<Employee> getByEmail(@RequestParam String email){
        return ResponseEntity.ok(employeeService.getByEmail(email));
    }

    @GetMapping("/searchByMatricule")
    public ResponseEntity<Employee> getByMatricule(@RequestParam("matricule") String matricule){
        return ResponseEntity.ok(employeeService.getByMatricule(matricule));
    }

    @GetMapping("/searchByPhoneNumber")
    public ResponseEntity<Employee> getByPhoneNumber(@RequestParam("phoneNumber") String phoneNumber){
        return ResponseEntity.ok(employeeService.getByPhoneNumber(phoneNumber));
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        employee.setId(employeeService.getAllEmployee().size()+1);
        return ResponseEntity.created(getLocation(employee.getId())).body(employeeService.addEmployee(employee));
    }

    private URI getLocation(long id) {
        return fromCurrentRequest().path("{id}").buildAndExpand(id).toUri();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable("id") long id){
        return ResponseEntity.ok(employeeService.deletEmployee(id));
    }


    @PutMapping
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee e){
        return ResponseEntity.ok(employeeService.updateEmployee(e));
    }

}
