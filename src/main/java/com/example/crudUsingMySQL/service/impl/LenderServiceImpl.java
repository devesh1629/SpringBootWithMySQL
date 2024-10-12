package com.example.crudUsingMySQL.service.impl;

import com.example.crudUsingMySQL.service.LenderService;
import com.example.crudUsingMySQL.service.LenderStrategy;
import com.example.crudUsingMySQL.service.LenderStrategyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LenderServiceImpl implements LenderService {

    @Autowired
    private LenderStrategyFactory lenderStrategyFactory;

    @Override
    public boolean isPreclosureAmountRequiredByLender(String lenderId) {
        Optional<LenderStrategy> lenderStrategy = lenderStrategyFactory.getStrategy(lenderId);
        return lenderStrategy.map(strategy -> strategy.isPreclosureRequired("Lender One")).orElse(false);
    }
}
