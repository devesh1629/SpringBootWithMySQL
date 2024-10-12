package com.example.crudUsingMySQL.dto;

import lombok.Data;

@Data
public class BulkEmployeeDto {

    public int noOfEmployeesToBeAdded;
    public String department;
    public Integer salary;
}
