package com.company.eventImplementation.models;

import com.company.eventImplementation.models.contracts.NameChangeListener;
import com.company.eventImplementation.events.NameChangeEvent;

public class Handler implements NameChangeListener {
    @Override
    public void handleNameChange(NameChangeEvent event) {
        System.out.println(String.format("Dispatcher's name changed to %s.",event.getNewName()));
    }
}
