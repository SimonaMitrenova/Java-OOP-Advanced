package com.company.problem1984.entities;

import com.company.problem1984.annotations.Setter;

public class Employee extends Entity {
    private int income;
    private String name;

    public Employee(String id, String name, int income) {
        super(id);
        this.name = name;
        this.income = income;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Setter(fieldName = "name", fieldType = "String")
    public void setName(String name) {
        String oldValue = this.name;
        this.name = name;
        this.fieldChanged("name", oldValue, this.name);
    }

    public int getIncome() {
        return this.income;
    }

    @Setter(fieldName = "income", fieldType = "int")
    public void setIncome(int income) {
        int oldValue = this.income;
        this.income = income;
        this.fieldChanged("income", oldValue, this.income);
    }

    private <T> void fieldChanged(String changedFieldName, T oldValue, T newValue){
        Class<?> employeeClass = Employee.class;
        super.fieldChanged(employeeClass, changedFieldName, oldValue, newValue);
    }
}
