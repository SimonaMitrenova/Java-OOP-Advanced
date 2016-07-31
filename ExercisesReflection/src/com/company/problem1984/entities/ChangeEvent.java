package com.company.problem1984.entities;

import com.company.problem1984.entities.contracts.Event;
import com.company.problem1984.entities.contracts.Observable;

import java.lang.reflect.Field;

public class ChangeEvent<T> implements Event<T>{
    private Observable observable;
    private Field changedField;
    private T oldValue;
    private T newValue;

    public ChangeEvent(Observable observable, Field changedField, T oldValue, T newValue) {
        this.observable = observable;
        this.changedField = changedField;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    @Override
    public Observable getSource() {
        return this.observable;
    }

    @Override
    public Field getChangedField() {
        return this.changedField;
    }

    @Override
    public T getOldValue() {
        return this.oldValue;
    }

    @Override
    public T getNewValue() {
        return this.newValue;
    }
}
