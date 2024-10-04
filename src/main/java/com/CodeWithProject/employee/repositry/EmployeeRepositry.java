package com.CodeWithProject.employee.repositry;

import com.CodeWithProject.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface EmployeeRepositry extends JpaRepository<Employee,Long> {
}
