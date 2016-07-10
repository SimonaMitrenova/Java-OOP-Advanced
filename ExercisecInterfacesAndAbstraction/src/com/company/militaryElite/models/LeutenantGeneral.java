package com.company.militaryElite.models;

import com.company.militaryElite.interfaces.*;

import java.util.LinkedList;
import java.util.List;

public class LeutenantGeneral extends Private implements ILeutenantGeneral {
    private List<ISoldier> privates;

    public LeutenantGeneral(String id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new LinkedList<>();
    }

    @Override
    public List<ISoldier> getPrivates() {
        return this.privates;
    }

    @Override
    public void addPrivate(ISoldier soldier) {
        this.privates.add(soldier);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(super.toString()).append(System.lineSeparator());
        output.append("Privates:").append(System.lineSeparator());
        for (ISoldier aPrivate : privates) {
            output.append("  ").append(aPrivate.toString()).append(System.lineSeparator());
        }

        return output.toString();
    }
}
