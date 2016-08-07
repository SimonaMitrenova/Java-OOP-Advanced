package com.company.kingsGambit.models;

import com.company.kingsGambit.events.UnderAttackEvent;
import com.company.kingsGambit.models.contracts.UnderAttackListener;

import java.util.ArrayList;
import java.util.List;

public class King {
    private String name;
    private List<UnderAttackListener> observers;

    public King(String name){
        this.setName(name);
        this.observers = new ArrayList<>();
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void respondToAttack(){
        System.out.println(String.format("King %s is under attack!",this.getName()));
        this.fireUnderAttackEvent();
    }

    public void addUnderAttackListener(UnderAttackListener observer){
        this.observers.add(observer);
    }

    public void removeUnderAttackListener(UnderAttackListener observer){
        this.observers.remove(observer);
    }

    protected  void fireUnderAttackEvent() {
        UnderAttackEvent event = new UnderAttackEvent(this);
        for (UnderAttackListener observer : observers) {
            observer.handleUnitAttacked(event);
        }
    }
}
