package com.example.crudUsingMySQL.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Data
@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMPLOYEE_ID")
    private Long id;

    @Column(name = "EMPLOYEE_NAME")
    private String name;

    @Column(name = "DEPARTMENT")
    private String department;

    @Column(name = "SALARY")
    private Integer salary;

    @Column(name = "CREATED_DATE")
    @CreationTimestamp
    private Date createdTime;

    @Column(name = "UPDATED_DATE")
    @UpdateTimestamp
    private Date updatedTime;
}
