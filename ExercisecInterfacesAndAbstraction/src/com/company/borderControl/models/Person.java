package com.company.borderControl.models;

public class Person implements Identifiable, Birthable{
    private String name;
    private int age;
    private String id;
    private String birthdate;

    public Person(String name, int age, String id, String birthdate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthdate = birthdate;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getBirthdate() {
        return this.birthdate;
    }
}
