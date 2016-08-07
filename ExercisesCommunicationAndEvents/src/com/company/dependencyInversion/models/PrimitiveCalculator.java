package com.company.dependencyInversion.models;

import com.company.dependencyInversion.models.strategies.AdditionStrategy;
import com.company.dependencyInversion.models.strategies.CalculationStrategy;

public class PrimitiveCalculator {
    private CalculationStrategy strategy;

    public PrimitiveCalculator(){
        this.strategy = new AdditionStrategy();
    }

    public PrimitiveCalculator(CalculationStrategy strategy){
        this.strategy = strategy;
    }

    public void changeStrategy(CalculationStrategy strategy){
        this.strategy = strategy;
    }

    public int performCalculation(int firstOperand,int secondOperand){
        return this.strategy.calculate(firstOperand,secondOperand);
    }
}
