package com.company.infernoInfinity.commands;

import com.company.infernoInfinity.core.contracts.Database;
import com.company.infernoInfinity.weapons.WeaponImpl;
import com.company.infernoInfinity.weapons.WeaponInfo;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReviewersCommand extends Command{
    public ReviewersCommand(Database database, String[] params) {
        super(database, params);
    }

    @Override
    public String execute() {
        String[] reviewers = WeaponImpl.class.getAnnotation(WeaponInfo.class).reviewers();
        return String.format("Reviewers: %s", Arrays.stream(reviewers).collect(Collectors.joining(", ")));
    }
}
