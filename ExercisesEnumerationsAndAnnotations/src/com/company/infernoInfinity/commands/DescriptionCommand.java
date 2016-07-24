package com.company.infernoInfinity.commands;

import com.company.infernoInfinity.core.contracts.Database;
import com.company.infernoInfinity.weapons.WeaponImpl;
import com.company.infernoInfinity.weapons.WeaponInfo;

public class DescriptionCommand extends Command {
    public DescriptionCommand(Database database, String[] params) {
        super(database, params);
    }

    @Override
    public String execute() {
        String description = WeaponImpl.class.getAnnotation(WeaponInfo.class).description();
        return String.format("Class description: %s", description);
    }
}
