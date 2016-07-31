package com.company.problem1984.entities;

import com.company.problem1984.entities.contracts.Event;
import com.company.problem1984.entities.contracts.Observable;
import com.company.problem1984.entities.contracts.Observer;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public abstract class Entity implements Observable{

    private String id;
    private List<Observer> observers;

    protected Entity(String id) {
        this.id = id;
        this.observers = new ArrayList<>();
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public <T> void triggerEvent(Field field, T oldValue, T newValue) {
        Event<T> event = new ChangeEvent<T>(this, field, oldValue, newValue);
        for (Observer observer : observers) {
            observer.update(event);
        }
    }

    @Override
    public void attachObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void detachObserver(Observer observer) {
        this.observers.remove(observer);
    }

    protected <T> void fieldChanged(Class<?> fieldClass, String fieldName, T oldValue, T newValue){
        try {
            Field field = fieldClass.getDeclaredField(fieldName);
            this.triggerEvent(field, oldValue, newValue);
        }  catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
