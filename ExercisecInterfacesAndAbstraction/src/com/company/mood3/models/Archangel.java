package com.company.mood3.models;

public class Archangel extends GameObject{
    private int mana;
    public Archangel(String username, int level, int mana) {
        super(username, level, "Archangel");
        this.mana = mana;
    }

    @Override
    protected String generateHeshedPassword(String username) {
        return new StringBuilder().append(this.getUsername()).reverse().append(this.getUsername().length() * 21).toString();
    }

    @Override
    public String toString() {
        return String.format("%s%n%s", super.toString(), this.getLevel() * this.mana);
    }
}
