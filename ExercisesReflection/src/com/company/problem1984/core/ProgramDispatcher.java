package com.company.problem1984.core;

import com.company.problem1984.annotations.Setter;
import com.company.problem1984.core.contracts.Data;
import com.company.problem1984.core.contracts.Dispatcher;
import com.company.problem1984.entities.contracts.Observable;
import com.company.problem1984.entities.contracts.Observer;
import com.company.problem1984.factories.contracts.ObservableCreator;
import com.company.problem1984.factories.contracts.ObserverCreator;
import com.company.problem1984.io.contracts.Reader;
import com.company.problem1984.io.contracts.Writer;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class ProgramDispatcher implements Dispatcher{
    private Data data;
    private Reader reader;
    private Writer writer;
    private ObserverCreator observerCreator;
    private ObservableCreator observableCreator;

    public ProgramDispatcher(Data data, Reader reader, Writer writer, ObserverCreator observerCreator, ObservableCreator observableCreator) {
        this.data = data;
        this.reader = reader;
        this.writer = writer;
        this.observerCreator = observerCreator;
        this.observableCreator = observableCreator;
    }

    @Override
    public void readEntities(int entitiesCount) throws IOException {
        for (int i = 0; i < entitiesCount; i++) {
            String[] params = reader.readLine().split("\\s+");
            Observable observable = this.observableCreator.createObservable(params);
            this.data.addObservable(observable);
        }
    }

    @Override
    public void readInstitutions(int institutionsCount) throws IOException {
        for (int i = 0; i < institutionsCount; i++) {
            String[] params = reader.readLine().split("\\s+");
            Observer observer = this.observerCreator.create(params);
            this.data.addObserver(observer);
            this.data.subscribeObserver(observer);
        }
    }

    @Override
    public void executeChange(String[] changeTokens) throws IllegalAccessException, InvocationTargetException {
        String id = changeTokens[0];
        String fieldName = changeTokens[1];
        String parameter = changeTokens[2];

        Observable observable = data.getObservable(id);
        String observableSimpleClass = observable.getClass().getSimpleName();

        Class<?> observableClass = observable.getClass();
        Method[] observableClassDeclaredMethods = observableClass.getDeclaredMethods();

        for (Method method : observableClassDeclaredMethods) {
            Setter setter = method.getAnnotation(Setter.class);
            if (setter != null && setter.fieldName().equals(fieldName)) {
                if (setter.fieldType().equals("int")) {
                    method.invoke(observable, Integer.valueOf(parameter));
                } else {
                    method.invoke(observable, parameter);
                }
            }
        }
    }

    @Override
    public void printChangeLog() {
        for (String observerId : this.data.getObservers()) {
            Observer observer = this.data.getObserver(observerId);
            List<String> observerChangeLog = observer.getChangeLog();

            String heading = String.format("%s: %s changes registered", observer.getName(), observerChangeLog.size());
            this.writer.writeLine(heading);

            for (String change : observerChangeLog) {
                this.writer.writeLine(change);
            }
        }
    }
}
