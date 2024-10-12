package com.example.crudUsingMySQL.service;

import com.example.crudUsingMySQL.dto.BulkEmployeeDto;
import com.example.crudUsingMySQL.dto.EmployeeDto;
import com.example.crudUsingMySQL.entity.Employee;
import java.util.List;


public interface EmployeeService {

    Employee saveEmployee(EmployeeDto employeeDto);

    List<Employee> fetchAllEmployee();

    Employee getEmployeeById(Long id);

    Employee updateEmployeeById(Long id, Employee employee);

    String deleteEmployeeById(Long id);

    void addMockEmployees(BulkEmployeeDto bulkEmployeeDto);
}
