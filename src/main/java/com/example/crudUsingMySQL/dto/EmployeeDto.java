package com.example.crudUsingMySQL.dto;

import lombok.Data;

@Data
public class EmployeeDto {

    private String name;
    private String department;
    private Integer salary;
}
