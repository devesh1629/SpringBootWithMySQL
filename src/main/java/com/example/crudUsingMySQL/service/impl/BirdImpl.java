package com.example.crudUsingMySQL.service.impl;

import com.example.crudUsingMySQL.service.Bird;
import com.example.crudUsingMySQL.service.Shape;
import com.example.crudUsingMySQL.service.ShapeFactory;
import org.springframework.stereotype.Service;

@Service
public class BirdImpl implements Bird {

    @Override
    public void canFly(String name) {
        System.out.println(name + " can fly");
    }

    public void anonymousClassImpl() {
        Bird eagle = new Bird() {
            @Override
            public void canFly(String name) {
                System.out.println("Eagle can fly " + name);
            }
        };

        Bird crow = (String value) -> {
            System.out.println(value + " is black");
        };
        Bird bird = new BirdImpl();
        bird.canFly("bird");
        eagle.canFly("eagle");
        crow.canFly("crow");

        ShapeFactory shapeFactory = new ShapeFactory();

        Shape shape1 = shapeFactory.getShape("CIRCLE");
        shape1.draw();
        Shape shape2 = shapeFactory.getShape("RECTANGLE");
        shape2.draw();
    }
}
