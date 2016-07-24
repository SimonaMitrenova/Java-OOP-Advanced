package com.company.infernoInfinity.commands;

import com.company.infernoInfinity.core.contracts.Database;
import com.company.infernoInfinity.weapons.contracts.Weapon;

public class PrintCommand extends Command{
    public PrintCommand(Database database, String[] params) {
        super(database, params);
    }

    @Override
    public String execute() {
        String[] input = this.getParams();
        String name = input[1];
        Weapon weapon = this.getDatabase().getWeapon(name);
        if (weapon == null){
            return null;
        }

        return weapon.toString();
    }
}
