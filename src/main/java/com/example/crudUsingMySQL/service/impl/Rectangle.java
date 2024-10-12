package com.example.crudUsingMySQL.service.impl;

import com.example.crudUsingMySQL.service.Shape;

public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Rectangle draw");
    }
}
