package com.company.eventImplementation.models.contracts;

import com.company.eventImplementation.events.NameChangeEvent;

public interface NameChangeListener {
    void handleNameChange(NameChangeEvent event);
}