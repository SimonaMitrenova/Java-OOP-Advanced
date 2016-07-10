package com.company.militaryElite.models;

import com.company.militaryElite.interfaces.ISpy;

public class Spy extends Soldier implements ISpy{
    private int codeNumber;

    public Spy(String id, String firstName, String lastName, int codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    @Override
    public int getCodeNumber() {
        return this.codeNumber;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(super.toString()).append(System.lineSeparator());
        output.append("Code Number: ").append(this.getCodeNumber());
        return output.toString();
    }
}
