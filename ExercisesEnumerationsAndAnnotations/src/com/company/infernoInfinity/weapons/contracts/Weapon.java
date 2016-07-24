package com.company.infernoInfinity.weapons.contracts;

import com.company.infernoInfinity.gems.contracts.Gem;

public interface Weapon extends Comparable<Weapon>{
    void addGem(Gem gem, int index);
    void remove(int index);
    String getName();
    double calculateLevel();
}
