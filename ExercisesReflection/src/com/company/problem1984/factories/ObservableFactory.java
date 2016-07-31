package com.company.problem1984.factories;

import com.company.problem1984.entities.Company;
import com.company.problem1984.entities.Employee;
import com.company.problem1984.entities.contracts.Observable;
import com.company.problem1984.factories.contracts.ObservableCreator;

public class ObservableFactory implements ObservableCreator {
    @Override
    public Observable createObservable(String[] observableParameters) {
        String type = observableParameters[0];
        String id = observableParameters[1];
        String name = observableParameters[2];

        switch (type) {
            case "Employee":
                int income = Integer.valueOf(observableParameters[3]);
                return new Employee(id, name, income);
            case "Company":
                int turnover = Integer.valueOf(observableParameters[3]);
                int revenue = Integer.valueOf(observableParameters[4]);
                return new Company(id, name, turnover, revenue);
            default:
                throw new IllegalArgumentException("Invalid arguments.");
        }
    }
}
