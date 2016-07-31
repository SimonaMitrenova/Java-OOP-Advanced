package com.company.problem1984.factories.contracts;

import com.company.problem1984.entities.contracts.Observer;

public interface ObserverCreator {
    Observer create(String[] observerParameters);
}
