package com.CodeWithProject.employee.service;

import com.CodeWithProject.employee.entity.Employee;
import com.CodeWithProject.employee.repositry.EmployeeRepositry;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepositry repositry;

    public Employee postEmployee(Employee employee) {
        return repositry.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return repositry.findAll();
    }

    public void deleteEmployee(Long id){
        if (!repositry.existsById(id))
        {
            throw new EntityNotFoundException("Employee With ID " + id+" Not Found");
        }
        repositry.deleteById(id);
    }

    public Employee getEmployeeById(Long id)
    {
      return repositry.findById(id).orElse(null);
    }

    public Employee updateEmployee(Long id, Employee employee)
    {
        Optional<Employee> optionalEmployee=repositry.findById(id);
         if (optionalEmployee.isPresent())
         {
             Employee existingEmployee= optionalEmployee.get();

             existingEmployee.setEmail(employee.getEmail());
             existingEmployee.setName(employee.getName());
             existingEmployee.setPhone(employee.getPhone());
             existingEmployee.setDepartment(existingEmployee.getDepartment());
             return repositry.save(existingEmployee);




         }
         return null;
    }
}
