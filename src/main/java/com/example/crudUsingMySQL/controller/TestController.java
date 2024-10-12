package com.example.crudUsingMySQL.controller;

import com.example.crudUsingMySQL.service.impl.BirdImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    private BirdImpl bird;

    @GetMapping("/test-get-api")
    public String testGetApi() {
//        bird.anonymousClassImpl();
        return "Get api call successful";
    }
}
