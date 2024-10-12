package com.example.crudUsingMySQL.service.impl;

import com.example.crudUsingMySQL.service.Shape;

public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Circle draw");
    }
}
