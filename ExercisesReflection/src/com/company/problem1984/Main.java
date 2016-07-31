package com.company.problem1984;

import com.company.problem1984.core.DataBase;
import com.company.problem1984.core.Engine;
import com.company.problem1984.core.ProgramDispatcher;
import com.company.problem1984.core.contracts.Data;
import com.company.problem1984.core.contracts.Runnable;
import com.company.problem1984.core.contracts.Dispatcher;
import com.company.problem1984.factories.ObservableFactory;
import com.company.problem1984.factories.ObserverFactory;
import com.company.problem1984.factories.contracts.ObservableCreator;
import com.company.problem1984.factories.contracts.ObserverCreator;
import com.company.problem1984.io.ConsoleReader;
import com.company.problem1984.io.ConsoleWriter;
import com.company.problem1984.io.contracts.Reader;
import com.company.problem1984.io.contracts.Writer;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) {

        Data data = new DataBase();
        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
        ObserverCreator observerCreator = new ObserverFactory();
        ObservableCreator observableCreator = new ObservableFactory();

        Dispatcher dispatcher = new ProgramDispatcher(data, reader, writer, observerCreator, observableCreator);
        Runnable engine = new Engine(reader, dispatcher);

        try {
            engine.run();
        } catch (IllegalAccessException | InvocationTargetException | IOException e) {
            e.printStackTrace();
        }
    }
}
