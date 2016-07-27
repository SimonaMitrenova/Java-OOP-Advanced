package com.company.barracksWars.core.commands;

import com.company.barracksWars.contracts.Inject;
import com.company.barracksWars.contracts.Repository;
import com.company.barracksWars.contracts.Unit;
import com.company.barracksWars.contracts.UnitFactory;

public class AddCommand extends Command {

    @Inject
    private Repository repository;

    @Inject
    private UnitFactory unitFactory;

    public AddCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String unitType = getData()[1];
        Unit unitToAdd = this.unitFactory.createUnit(unitType);
        this.repository.addUnit(unitToAdd);
        return unitType + " added!";
    }
}
