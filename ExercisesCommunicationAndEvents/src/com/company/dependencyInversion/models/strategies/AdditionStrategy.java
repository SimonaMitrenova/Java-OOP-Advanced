package com.company.dependencyInversion.models.strategies;

public class AdditionStrategy implements CalculationStrategy {
    @Override
    public int calculate(int firstOperand, int secondOperand) {
        return firstOperand + secondOperand;
    }
}
