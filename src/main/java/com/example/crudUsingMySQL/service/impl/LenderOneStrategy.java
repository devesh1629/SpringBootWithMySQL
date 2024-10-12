package com.example.crudUsingMySQL.service.impl;

import com.example.crudUsingMySQL.service.LenderStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LenderOneStrategy implements LenderStrategy {

    private static final Logger logger = LoggerFactory.getLogger(LenderOneStrategy.class);

    @Override
    public boolean isPreclosureRequired(String targetLender) {
        logger.info("LenderStrategy : isPreclosureRequired() called for - {}", targetLender);
        return targetLender.equals(getLenderId());
    }

    @Override
    public String getLenderId() {
        return "Lender One";
    }
}
