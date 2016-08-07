package com.company.dependencyInversion;

import com.company.dependencyInversion.models.PrimitiveCalculator;
import com.company.dependencyInversion.models.strategies.AdditionStrategy;
import com.company.dependencyInversion.models.strategies.DivisionStrategy;
import com.company.dependencyInversion.models.strategies.MultiplicationStrategy;
import com.company.dependencyInversion.models.strategies.SubtractionStrategy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PrimitiveCalculator calculator = new PrimitiveCalculator();
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        while(!line.equals("End")){
            String[] parameters = line.split(" ");
            if(parameters[0].equals("mode")){
                switch (parameters[1]){
                    case "+": calculator.changeStrategy(new AdditionStrategy());
                        break;
                    case "-": calculator.changeStrategy(new SubtractionStrategy());
                        break;
                    case "*": calculator.changeStrategy(new MultiplicationStrategy());
                        break;
                    case "/": calculator.changeStrategy(new DivisionStrategy());
                        break;
                }
            }
            else{
                int firstOperand = Integer.parseInt(parameters[0]);
                int secondOperand = Integer.parseInt(parameters[1]);
                System.out.println(calculator.performCalculation(firstOperand,secondOperand));
            }
            line = scanner.nextLine();
        }
    }
}
