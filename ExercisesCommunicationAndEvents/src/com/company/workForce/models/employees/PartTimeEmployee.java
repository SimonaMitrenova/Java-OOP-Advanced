package com.company.workForce.models.employees;

public class PartTimeEmployee extends BasicEmployee{
    private static final int PART_TIME_EMPLOYEE_WORK_HOURS = 20;

    public PartTimeEmployee(String name) {
        super(name, PART_TIME_EMPLOYEE_WORK_HOURS);
    }
}
