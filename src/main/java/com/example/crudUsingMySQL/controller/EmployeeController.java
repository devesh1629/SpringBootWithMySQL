package com.example.crudUsingMySQL.controller;

import com.example.crudUsingMySQL.dto.BulkEmployeeDto;
import com.example.crudUsingMySQL.dto.EmployeeDto;
import com.example.crudUsingMySQL.entity.Employee;
import com.example.crudUsingMySQL.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employee")
    public Employee saveEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.saveEmployee(employeeDto);
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.fetchAllEmployee();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/employee/{id}")
    public Employee updateEmployeeById(@PathVariable("id") Long id, @RequestBody Employee employee) {
        return employeeService.updateEmployeeById(id, employee);
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployeeById(@PathVariable("id") Long id) {
        return employeeService.deleteEmployeeById(id);
    }

    @PostMapping("/add-mock-employees")
    public void addMockEmployees(@RequestBody BulkEmployeeDto bulkEmployeeDto) {
        employeeService.addMockEmployees(bulkEmployeeDto);
    }


}
