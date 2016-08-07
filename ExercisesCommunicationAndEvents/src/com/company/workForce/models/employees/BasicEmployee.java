package com.company.workForce.models.employees;

import com.company.workForce.contracts.Employee;

public abstract class BasicEmployee implements Employee{
    private String name;
    private int weeklyWorkHours;

    public BasicEmployee(String name, int weeklyWorkHours) {
        this.setName(name);
        this.setWeeklyWorkHours(weeklyWorkHours);
    }

    @Override
    public String getName() {
        return null;
    }

    private void setName(String name){
        this.name = name;
    }

    @Override
    public int getWeeklyWorkHours() {
        return 0;
    }

    private void setWeeklyWorkHours(int hours){
        this.weeklyWorkHours = hours;
    }
}
