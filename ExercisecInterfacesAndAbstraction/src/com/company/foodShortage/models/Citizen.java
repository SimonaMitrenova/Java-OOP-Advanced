package com.company.foodShortage.models;

public class Citizen implements Buyer{
    private String name;
    private int age;
    private String id;
    private String birthdate;
    private int foodCount;

    public Citizen(String name, int age, String id, String birthdate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthdate = birthdate;
        this.foodCount = 0;
    }

    @Override
    public int getFoodCount() {
        return this.foodCount;
    }

    @Override
    public void buyFood() {
        this.foodCount += 10;
    }
}
