package com.company.mirrorImage;

import java.util.HashMap;

public class Wizard {
    private static int currentId;
    private static HashMap<Integer, Wizard> wizards;

    static {
        currentId = 0;
        wizards = new HashMap<>();
    }

    private int id;
    private String name;
    private int damage;
    private Wizard firstChild;
    private Wizard secondChild;

    public Wizard(String name, int damage) {
        this.name = name;
        this.damage = damage;

        this.id = currentId;
        currentId++;
        this.firstChild = null;
        this.secondChild = null;
        wizards.put(this.id, this);
    }

    public int getDamage() {
        return damage;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static Wizard getWizardById(int id){
        if (!wizards.containsKey(id)){
            return null;
        }

        return wizards.get(id);
    }

    public void castReflection() {
        System.out.printf("%s %s casts Reflection%n", this.getName(), this.getId());

        if (this.firstChild ==  null || this.secondChild == null){
            this.firstChild = new Wizard(this.name, this.damage / 2);
            this.secondChild = new Wizard(this.name, this.damage / 2);
            return;
        }

        this.firstChild.castReflection();
        this.secondChild.castReflection();
    }

    public void castFireBall(){
        System.out.printf("%s %s casts Fireball for %s damage%n", this.getName(), this.getId(), this.getDamage());

        if (this.firstChild == null || this.secondChild == null){
            return;
        }

        this.firstChild.castFireBall();
        this.secondChild.castFireBall();
    }
}
