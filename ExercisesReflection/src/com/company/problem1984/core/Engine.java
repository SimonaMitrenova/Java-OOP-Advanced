package com.company.problem1984.core;

import com.company.problem1984.core.contracts.Dispatcher;
import com.company.problem1984.io.contracts.Reader;
import com.company.problem1984.core.contracts.Runnable;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;


public class Engine implements Runnable {
    private Reader reader;
    private Dispatcher dispatcher;

    public Engine(Reader reader, Dispatcher dispatcher) {
        this.reader = reader;
        this.dispatcher = dispatcher;
    }

    @Override
    public void run() throws IOException, InvocationTargetException, IllegalAccessException {
        String[] params = reader.readLine().split("\\s+");
        int entitiesCount = Integer.valueOf(params[0]);
        int institutionsCount = Integer.valueOf(params[1]);
        int changesCount = Integer.valueOf(params[2]);

        this.dispatcher.readEntities(entitiesCount);
        this.dispatcher.readInstitutions(institutionsCount);

        for (int i = 0; i < changesCount; i++) {
            params = reader.readLine().split("\\s+");
            this.dispatcher.executeChange(params);
        }

        this.dispatcher.printChangeLog();
    }
}
