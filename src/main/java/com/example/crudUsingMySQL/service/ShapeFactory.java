package com.example.crudUsingMySQL.service;

import com.example.crudUsingMySQL.service.impl.Circle;
import com.example.crudUsingMySQL.service.impl.Rectangle;

public class ShapeFactory {

    public Shape getShape(String type) {
        if(type.equals("CIRCLE"))
            return new Circle();
        else if(type.equals("RECTANGLE"))
            return new Rectangle();
        else
            return null;
    }
}
