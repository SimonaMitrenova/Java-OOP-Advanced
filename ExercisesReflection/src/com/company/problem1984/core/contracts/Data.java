package com.company.problem1984.core.contracts;

import com.company.problem1984.entities.contracts.Observable;
import com.company.problem1984.entities.contracts.Observer;

import java.util.Set;

public interface Data {
    void addObserver(Observer observer);
    Observer getObserver(String id);
    void addObservable(Observable observable);
    Observable getObservable(String id);
    void subscribeObserver(Observer observer);
    Set<String> getObservers();
}
