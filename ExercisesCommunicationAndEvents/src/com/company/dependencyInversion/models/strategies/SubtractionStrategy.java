package com.company.dependencyInversion.models.strategies;

public class SubtractionStrategy implements CalculationStrategy {
    @Override
    public int calculate(int firstOperand, int secondOperand) {
        return firstOperand - secondOperand;
    }
}
