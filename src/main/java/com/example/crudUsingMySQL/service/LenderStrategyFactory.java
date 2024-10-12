package com.example.crudUsingMySQL.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class LenderStrategyFactory {

    private static final Logger logger = LoggerFactory.getLogger(LenderStrategyFactory.class);

    private final Map<String, LenderStrategy> lenderStrategyMap;

    @Autowired
    public LenderStrategyFactory(List<LenderStrategy> lenderStrategies) {
        logger.info("LenderStrategyFactory constructor invoked with list of size {}", lenderStrategies.size());
        lenderStrategyMap = lenderStrategies.stream().collect(Collectors.toMap(LenderStrategy::getLenderId, Function.identity()));
    }

    public Optional<LenderStrategy> getStrategy(String lenderId) {
        return Optional.ofNullable(lenderStrategyMap.get(lenderId));
    }
}
