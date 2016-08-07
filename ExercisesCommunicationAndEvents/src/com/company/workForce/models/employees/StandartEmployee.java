package com.company.workForce.models.employees;

public class StandartEmployee extends BasicEmployee {
    private static final int FULL_TIME_EMPLOYEE_WORK_HOURS = 40;

    public StandartEmployee(String name) {
        super(name, FULL_TIME_EMPLOYEE_WORK_HOURS);
    }
}
