package com.company.mood3.models;

public abstract class GameObject {
    private String username;
    private String hashedPassword;
    private int level;
    private String specialPointType;

    protected GameObject(String username, int level, String type) {
        this.username = username;
        this.level = level;
        this.specialPointType = type;
        this.hashedPassword = this.generateHeshedPassword(this.username);
    }

    protected String getUsername() {
        return username;
    }

    protected int getLevel() {
        return level;
    }

    protected abstract String generateHeshedPassword(String username);

    @Override
    public String toString() {
        return String.format("\"%s\" | \"%s\" -> %s", this.username, this.hashedPassword, this.specialPointType);
    }
}