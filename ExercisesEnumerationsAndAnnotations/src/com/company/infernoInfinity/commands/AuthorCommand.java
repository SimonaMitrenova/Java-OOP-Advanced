package com.company.infernoInfinity.commands;

import com.company.infernoInfinity.core.contracts.Database;
import com.company.infernoInfinity.weapons.WeaponImpl;
import com.company.infernoInfinity.weapons.WeaponInfo;

public class AuthorCommand extends Command{
    public AuthorCommand(Database database, String[] params) {
        super(database, params);
    }

    @Override
    public String execute() {
        String author = WeaponImpl.class.getAnnotation(WeaponInfo.class).author();
        return String.format("Author: %s", author);
    }
}
