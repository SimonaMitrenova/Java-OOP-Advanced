package com.company.problem1984.entities.contracts;

import java.lang.reflect.Field;

public interface Observable extends Identifiable, Nameable {
    <T> void triggerEvent(Field field, T oldValue, T newValue);
    void attachObserver(Observer observer);
    void detachObserver(Observer observer);
}
