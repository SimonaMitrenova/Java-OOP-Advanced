package com.company.militaryElite.models;

import com.company.militaryElite.interfaces.IPrivate;

public class Private extends Soldier implements IPrivate{

    private double salary;

    public Private(String id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(super.toString());
        output.append(String.format(" Salary: %.2f", this.getSalary()));
        return output.toString();
    }
}
