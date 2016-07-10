package com.company.militaryElite.models;

import com.company.militaryElite.interfaces.*;

import java.util.LinkedList;
import java.util.List;

public class Commando extends Private implements ISpecialisedSoldier, ICommando{
    private List<IMission> missions;
    private String corp;

    public Commando(String id, String firstName, String lastName, double salary, String corp) {
        super(id, firstName, lastName, salary);
        this.missions = new LinkedList<>();
        this.setCorp(corp);
    }

    @Override
    public List<IMission> getMissions() {
        return this.missions;
    }

    @Override
    public void addMission(IMission mission) {
        this.missions.add(mission);
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
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(super.toString()).append(System.lineSeparator());
        output.append("Corps: ").append(this.getCorps()).append(System.lineSeparator());
        output.append("Missions:").append(System.lineSeparator());
        for (IMission mission : missions) {
            output.append("  ").append(mission.toString()).append(System.lineSeparator());
        }
        return output.toString();
    }
}
