package com.company.barracksWars;

import com.company.barracksWars.contracts.CommandInterpreter;
import com.company.barracksWars.contracts.Repository;
import com.company.barracksWars.contracts.Runnable;
import com.company.barracksWars.contracts.UnitFactory;
import com.company.barracksWars.core.CommandInterpreterImpl;
import com.company.barracksWars.core.Engine;
import com.company.barracksWars.core.factories.UnitFactoryImpl;
import com.company.barracksWars.data.UnitRepository;

public class Main {
    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();
        CommandInterpreter interpreter = new CommandInterpreterImpl(repository, unitFactory);
        Runnable engine = new Engine(interpreter);
        engine.run();
    }
}
