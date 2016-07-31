package com.company.problem1984.entities.contracts;

import java.util.List;

public interface Observer extends Identifiable, Nameable{
    void update(Event event);
    List<String> getChangeLog();
}
