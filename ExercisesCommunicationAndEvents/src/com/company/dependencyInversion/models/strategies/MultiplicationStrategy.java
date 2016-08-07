package com.company.dependencyInversion.models.strategies;

public class MultiplicationStrategy implements CalculationStrategy {
    @Override
    public int calculate(int firstOperand, int secondOperand) {
        return firstOperand * secondOperand;
    }
}
