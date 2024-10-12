package com.example.crudUsingMySQL.controller;

import com.example.crudUsingMySQL.service.LenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class LenderController {

    @Autowired
    private LenderService lenderService;

    @GetMapping("/lender/{lenderId}")
    public boolean isPreclosureAmountRequiredByLender(@PathVariable("lenderId") String lenderId) {
        return lenderService.isPreclosureAmountRequiredByLender(lenderId);
    }
}
