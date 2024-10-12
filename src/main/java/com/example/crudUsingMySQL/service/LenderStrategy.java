package com.example.crudUsingMySQL.service;

public interface LenderStrategy {

    boolean isPreclosureRequired(String targetLender);
    String getLenderId();
}
