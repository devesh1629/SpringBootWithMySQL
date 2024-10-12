package com.example.crudUsingMySQL.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CalculatorServiceTest {

    @Test
    public void testSpyCalculator() {
        // Create a real instance of Calculator
        CalculatorService realCalculator = new CalculatorService();

        // Create a spy on the real instance
        CalculatorService spyCalculator = Mockito.spy(realCalculator);

        // Use real method for addition
        assertEquals(5, spyCalculator.add(2, 3));

        // Mock multiply method behavior
        when(spyCalculator.multiply(2, 3)).thenReturn(10);

        // Verify multiply method with mock behavior
        assertEquals(10, spyCalculator.multiply(2, 3));

        // Verify that the add method is still using the real implementation
        verify(spyCalculator).add(2, 3);
        verify(spyCalculator).multiply(2, 3);  // Called on spy with mock
    }
}