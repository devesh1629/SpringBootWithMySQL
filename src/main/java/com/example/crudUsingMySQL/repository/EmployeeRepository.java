package com.example.crudUsingMySQL.repository;

import com.example.crudUsingMySQL.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
