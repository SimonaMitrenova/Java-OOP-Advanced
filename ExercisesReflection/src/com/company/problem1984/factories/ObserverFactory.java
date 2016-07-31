package com.company.problem1984.factories;

import com.company.problem1984.entities.Institution;
import com.company.problem1984.entities.contracts.Observer;
import com.company.problem1984.factories.contracts.ObserverCreator;

public class ObserverFactory implements ObserverCreator{
    @Override
    public Observer create(String[] observerParameters) {
        String id = observerParameters[1];
        String name = observerParameters[2];
        String[] subjects = new String[observerParameters.length - 3];
        for (int i = 3; i < observerParameters.length; i++) {
            subjects[i - 3] = observerParameters[i];
        }

        return new Institution(id, name, subjects);
    }
}
