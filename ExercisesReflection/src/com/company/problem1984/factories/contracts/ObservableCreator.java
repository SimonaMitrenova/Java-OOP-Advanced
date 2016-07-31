package com.company.problem1984.factories.contracts;

import com.company.problem1984.entities.contracts.Observable;

public interface ObservableCreator {
    Observable createObservable(String[] observableParameters);
}
