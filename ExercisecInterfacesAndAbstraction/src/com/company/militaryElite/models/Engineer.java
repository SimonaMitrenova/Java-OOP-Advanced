package com.company.militaryElite.models;

import com.company.militaryElite.interfaces.*;

import java.util.LinkedList;
import java.util.List;

public class Engineer extends Private implements ISpecialisedSoldier, IEngineer{
    private List<IRepair> repairs;
    private String corp;

    public Engineer(String id, String firstName, String lastName, double salary, String corp) {
        super(id, firstName, lastName, salary);
        this.setCorp(corp);
        this.repairs = new LinkedList<>();
    }

    @Override
    public String getCorps() {
        return this.corp;
    }

    private void setCorp(String corp) {
        if (!corp.equalsIgnoreCase("AirForces") && !corp.equalsIgnoreCase("Marines")){
            throw new IllegalArgumentException();
        }
        this.corp = corp;
    }

    @Override
    public List<IRepair> getRepairs() {
        return this.repairs;
    }

    @Override
    public void addRepair(IRepair repair) {
        this.repairs.add(repair);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(super.toString()).append(System.lineSeparator());
        output.append("Corps: ").append(this.getCorps()).append(System.lineSeparator());
        output.append("Repairs:").append(System.lineSeparator());
        for (IRepair repair : repairs) {
            output.append("  ").append(repair.toString()).append(System.lineSeparator());
        }

        return output.toString();
    }
}
