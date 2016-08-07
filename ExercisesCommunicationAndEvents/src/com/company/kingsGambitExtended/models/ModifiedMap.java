package com.company.kingsGambitExtended.models;

import com.company.kingsGambitExtended.contracts.SoldierDeathListener;
import com.company.kingsGambitExtended.events.SoldierDeathEvent;

import java.util.LinkedHashMap;

public class ModifiedMap<K, V> extends LinkedHashMap<K,V> implements SoldierDeathListener {

    @Override
    public void handleSoldierDeath(SoldierDeathEvent event) {
        this.remove(event.getName());
    }
}
