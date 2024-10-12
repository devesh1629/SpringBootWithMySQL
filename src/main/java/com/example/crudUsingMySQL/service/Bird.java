package com.example.crudUsingMySQL.service;

@FunctionalInterface
public interface Bird {

    void canFly(String name);

    static void canEat(String name) {
        System.out.println(name + " can eat!");
    }

    String toString();
}
