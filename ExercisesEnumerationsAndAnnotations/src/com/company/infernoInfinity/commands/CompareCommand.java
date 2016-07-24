package com.company.infernoInfinity.commands;

import com.company.infernoInfinity.core.contracts.Database;
import com.company.infernoInfinity.weapons.contracts.Weapon;

public class CompareCommand extends Command{
    public CompareCommand(Database database, String[] params) {
        super(database, params);
    }

    @Override
    public String execute() {
        String[] input = this.getParams();
        String firstName = input[1];
        String secondName = input[2];
        Weapon first = this.getDatabase().getWeapon(firstName);
        Weapon second = this.getDatabase().getWeapon(secondName);

        if (first == null || second == null){
            return null;
        }

        Weapon greater = first;
        if (second.compareTo(greater) > 0){
            greater = second;
        }
        return String.format("%s (Item Level: %.1f)", greater, greater.calculateLevel());
    }
}
