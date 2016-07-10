package com.company.militaryElite.interfaces;

import java.util.List;

public interface IEngineer {
    List<IRepair> getRepairs();
    void addRepair(IRepair repair);
}
