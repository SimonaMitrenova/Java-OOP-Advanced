package com.company.foodShortage.models;

public class Rebel implements Buyer{
    private String name;
    private int age;
    private String group;
    private int foodCount;

    public Rebel(String name, int age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
        this.foodCount = 0;
    }

    @Override
    public int getFoodCount() {
        return this.foodCount;
    }

    @Override
    public void buyFood() {
        this.foodCount += 5;
    }
}
