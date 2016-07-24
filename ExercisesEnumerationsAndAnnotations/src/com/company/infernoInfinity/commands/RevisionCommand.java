package com.company.infernoInfinity.commands;

import com.company.infernoInfinity.core.contracts.Database;
import com.company.infernoInfinity.weapons.WeaponImpl;
import com.company.infernoInfinity.weapons.WeaponInfo;

public class RevisionCommand extends Command{
    public RevisionCommand(Database database, String[] params) {
        super(database, params);
    }

    @Override
    public String execute() {
        int revision = WeaponImpl.class.getAnnotation(WeaponInfo.class).revision();
        return String.format("Revision: %d", revision);
    }
}
