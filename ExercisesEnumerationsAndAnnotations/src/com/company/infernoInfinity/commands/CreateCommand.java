package com.company.infernoInfinity.commands;

import com.company.infernoInfinity.core.contracts.Database;
import com.company.infernoInfinity.enums.WeaponType;
import com.company.infernoInfinity.weapons.Axe;
import com.company.infernoInfinity.weapons.Knife;
import com.company.infernoInfinity.weapons.Sword;
import com.company.infernoInfinity.weapons.contracts.Weapon;

public class CreateCommand extends Command{

    public CreateCommand(Database database, String[] params) {
        super(database, params);
    }

    @Override
    public String execute() {
        String[] input = this.getParams();
        WeaponType type = WeaponType.valueOf(input[1]);
        String name = input[2];
        Weapon weapon;
        switch (type){
            case AXE:
                weapon = new Axe(name);
                break;

            case SWORD:
                weapon = new Sword(name);
                break;

            case KNIFE:
                weapon = new Knife(name);
                break;

            default:
                return null;
        }

        this.getDatabase().addWeapon(weapon);
        return null;
    }
}
