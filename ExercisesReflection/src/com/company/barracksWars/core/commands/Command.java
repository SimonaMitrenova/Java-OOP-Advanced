package com.company.barracksWars.core.commands;

import com.company.barracksWars.contracts.Executable;
import com.company.barracksWars.contracts.Repository;
import com.company.barracksWars.contracts.UnitFactory;

public abstract class Command implements Executable {
    private String[] data;

    public Command(String[] data) {
        this.data = data;
    }

    protected String[] getData() {
        return data;
    }
}
