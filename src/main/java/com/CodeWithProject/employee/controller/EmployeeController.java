package com.CodeWithProject.employee.controller;

import com.CodeWithProject.employee.entity.Employee;
import com.CodeWithProject.employee.service.EmployeeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/employee")
    public Employee postEmployee(@RequestBody Employee employee)
    {
        return service.postEmployee(employee);
    }
    @GetMapping("/employees")
    public List<Employee> getAllEmployees()
    {
        return service.getAllEmployees();
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
        try {

            service.deleteEmployee(id);
            return new ResponseEntity<>("Employee With ID  " + id + "  Deleted SuccessFully", HttpStatus.OK);
        }catch (EntityNotFoundException e)
        {
           return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);

        }
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable Long id)
    {
        Employee employee= service.getEmployeeById(id);
        if (employee == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(employee);
    }

    @PatchMapping("/employee/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long id,@RequestBody Employee employee)
    {
        Employee updateEmployee=service.updateEmployee(id, employee);
        if (updateEmployee == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        return ResponseEntity.ok(updateEmployee);

    }






}
