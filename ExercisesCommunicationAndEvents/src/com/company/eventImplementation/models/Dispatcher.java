package com.company.eventImplementation.models;

import com.company.eventImplementation.models.contracts.NameChangeListener;
import com.company.eventImplementation.events.NameChangeEvent;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher {
    private String name;
    private List<NameChangeListener> observers;

    public Dispatcher(){
        this.observers = new ArrayList<>();
        this.setName(null);
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
        this.fireNameChangeEvent();
    }

    public void addNameChangeListener(NameChangeListener observer){
        this.observers.add(observer);
    }

    public void removeNameChangeListener(NameChangeListener observer){
        this.observers.remove(observer);
    }

    private void fireNameChangeEvent(){
        NameChangeEvent event = new NameChangeEvent(this,this.getName());
        for (NameChangeListener observer : observers) {
            observer.handleNameChange(event);
        }
    }
}
