package com.company.kingsGambit.models;

import com.company.kingsGambit.events.UnderAttackEvent;

public class RoyalGuard extends Soldier{
    public RoyalGuard(String name) {
        super(name);
    }

    @Override
    public void handleUnitAttacked(UnderAttackEvent event) {
        System.out.println(String.format("Royal Guard %s is defending!",this.getName()));
    }
}
