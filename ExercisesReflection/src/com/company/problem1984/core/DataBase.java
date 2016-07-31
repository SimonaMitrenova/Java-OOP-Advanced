package com.company.problem1984.core;

import com.company.problem1984.core.contracts.Data;
import com.company.problem1984.entities.contracts.Observable;
import com.company.problem1984.entities.contracts.Observer;

import java.util.HashMap;
import java.util.Set;

public class DataBase implements Data {
    private HashMap<String, Observer> observers;
    private HashMap<String, Observable> observables;

    public DataBase() {
        this.observers = new HashMap<>();
        this.observables = new HashMap<>();
    }

    @Override
    public void addObserver(Observer observer) {
        this.observers.put(observer.getId(), observer);
    }

    @Override
    public Observer getObserver(String id) {
        return this.observers.get(id);
    }

    @Override
    public void addObservable(Observable observable) {
        this.observables.put(observable.getId(), observable);
    }

    @Override
    public Observable getObservable(String id) {
        return this.observables.get(id);
    }

    @Override
    public void subscribeObserver(Observer observer) {
        for (String observableId : this.observables.keySet()) {
            this.observables.get(observableId).attachObserver(observer);
        }
    }

    @Override
    public Set<String> getObservers() {
        return this.observers.keySet();
    }
}
