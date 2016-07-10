package com.company.militaryElite.interfaces;

import java.util.List;

public interface ILeutenantGeneral {
    List<ISoldier> getPrivates();
    void addPrivate(ISoldier soldier);
}
