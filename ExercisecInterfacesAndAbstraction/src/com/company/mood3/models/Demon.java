package com.company.mood3.models;

public class Demon extends GameObject {
    private double energy;

    public Demon(String username, int level, double energy) {
        super(username, level, "Demon");
        this.energy = energy;
    }

    @Override
    protected String generateHeshedPassword(String username) {
        return String.format("%d", this.getUsername().length() * 217);
    }

    @Override
    public String toString() {
        return String.format("%s%n%s", super.toString(), this.energy * this.getLevel());
    }
}
