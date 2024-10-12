package com.example.crudUsingMySQL.service.impl;

import com.example.crudUsingMySQL.dto.BulkEmployeeDto;
import com.example.crudUsingMySQL.dto.EmployeeDto;
import com.example.crudUsingMySQL.entity.Employee;
import com.example.crudUsingMySQL.repository.EmployeeRepository;
import com.example.crudUsingMySQL.service.EmployeeService;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setName(employeeDto.getName());
        employee.setDepartment(employeeDto.getDepartment());
        employee.setSalary(employeeDto.getSalary());
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> fetchAllEmployee() {
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    public Employee getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent())
            return employee.get();
        return null;
    }

    @Override
    public Employee updateEmployeeById(Long id, Employee employee) {
        Employee oldEmployee = employeeRepository.findById(id).orElse(null);
        if (null == oldEmployee) {
            logger.error("Employee with id {} not present", id);
            throw new EntityNotFoundException("Loan not found");
        }
        oldEmployee.setName(employee.getName());
        oldEmployee.setDepartment(employee.getDepartment());
        oldEmployee.setSalary(employee.getSalary());
        return employeeRepository.save(oldEmployee);
    }

    @Override
    public String deleteEmployeeById(Long id) {
        if(employeeRepository.findById(id).isPresent()) {
            employeeRepository.deleteById(id);
            return "Employee deleted successfully";
        }
        return "No such employee in the database";
    }

    @Override
    public void addMockEmployees(BulkEmployeeDto bulkEmployeeDto) {
        for(int cnt=1; cnt<=bulkEmployeeDto.getNoOfEmployeesToBeAdded(); cnt++) {
            EmployeeDto employeeDto = new EmployeeDto();
            employeeDto.setName("Mock employee " + cnt);
            employeeDto.setDepartment(bulkEmployeeDto.getDepartment());
            employeeDto.setSalary(bulkEmployeeDto.getSalary());
            saveEmployee(employeeDto);
        }
    }

}
