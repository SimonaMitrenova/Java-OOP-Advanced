package com.company.kingsGambit.models.contracts;

import com.company.kingsGambit.events.UnderAttackEvent;

public interface UnderAttackListener {
    void handleUnitAttacked(UnderAttackEvent event);
}