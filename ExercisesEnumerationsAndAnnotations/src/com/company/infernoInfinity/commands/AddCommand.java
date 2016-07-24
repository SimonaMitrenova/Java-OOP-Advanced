package com.company.infernoInfinity.commands;

import com.company.infernoInfinity.core.contracts.Database;
import com.company.infernoInfinity.enums.GemType;
import com.company.infernoInfinity.gems.Amethyst;
import com.company.infernoInfinity.gems.Emerald;
import com.company.infernoInfinity.gems.Ruby;
import com.company.infernoInfinity.gems.contracts.Gem;
import com.company.infernoInfinity.weapons.contracts.Weapon;

public class AddCommand extends Command{
    public AddCommand(Database database, String[] params) {
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

        int index = Integer.valueOf(input[2]);
        GemType gemType = GemType.valueOf(input[3]);
        Gem gem;
        switch (gemType){
            case RUBY:
                gem = new Ruby();
                break;

            case EMERALD:
                gem = new Emerald();
                break;

            case AMETHYST:
                gem = new Amethyst();
                break;

            default:
                return null;
        }
        weapon.addGem(gem, index);
        return null;
    }
}
