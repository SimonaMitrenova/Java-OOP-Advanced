package com.company.problem1984.entities.contracts;

import java.lang.reflect.Field;

public interface Event<T> {
    Observable getSource();
    Field getChangedField();
    T getOldValue();
    T getNewValue();
}
