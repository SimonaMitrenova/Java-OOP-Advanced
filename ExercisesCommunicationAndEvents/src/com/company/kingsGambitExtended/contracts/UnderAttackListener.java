package com.company.kingsGambitExtended.contracts;

import com.company.kingsGambitExtended.events.UnderAttackEvent;

public interface UnderAttackListener {
    void handleUnitAttacked(UnderAttackEvent event);
}
