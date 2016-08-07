package com.company.kingsGambitExtended.contracts;

import com.company.kingsGambitExtended.events.SoldierDeathEvent;

public interface SoldierDeathListener {
    void handleSoldierDeath(SoldierDeathEvent event);
}
