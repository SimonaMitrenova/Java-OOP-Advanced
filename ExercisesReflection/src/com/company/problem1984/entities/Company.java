package com.company.problem1984.entities;

import com.company.problem1984.annotations.Setter;
import com.company.problem1984.entities.contracts.Nameable;

public class Company extends Entity implements Nameable {

    private int turnover;
    private int revenue;
    private String name;

    public Company(String id, String name, int turnover, int revenue) {
        super(id);
        this.turnover = turnover;
        this.revenue = revenue;
        this.name = name;
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

    public double getTurnover() {
        return this.turnover;
    }

    @Setter(fieldName = "turnover", fieldType = "int")
    public void setTurnover(int turnover) {
        int oldValue = this.turnover;
        this.turnover = turnover;
        this.fieldChanged("turnover", oldValue, this.turnover);
    }

    public double getRevenue() {
        return this.revenue;
    }

    @Setter(fieldName = "revenue", fieldType = "int")
    public void setRevenue(int revenue) {
        int oldValue = this.revenue;
        this.revenue = revenue;
        this.fieldChanged("revenue", oldValue, this.revenue);
    }

    private <T> void fieldChanged(String changedFieldName, T oldValue, T newValue) {
        Class<?> companyClass = Company.class;
        super.fieldChanged(companyClass, changedFieldName, oldValue, newValue);
    }
}
