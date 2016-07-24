package com.company.infernoInfinity.core.contracts;

import com.company.infernoInfinity.weapons.contracts.Weapon;

public interface Database {
    void addWeapon(Weapon weapon);
    Weapon getWeapon(String name);
}
