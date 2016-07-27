package com.company.barracksWars.core;

import com.company.barracksWars.contracts.*;
import com.company.barracksWars.core.commands.Command;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class CommandInterpreterImpl implements CommandInterpreter{

    private Repository repository;
    private UnitFactory unitFactory;

    public CommandInterpreterImpl(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public Executable interpretCommand(String[] data, String commandName) {
        char firstChar = (char) (commandName.charAt(0) - ('a' - 'A'));
        String fullName = Command.class.getName();
        int index = fullName.lastIndexOf('.') + 1;
        String packageName = fullName.substring(0, index);

        commandName = packageName + firstChar + commandName.substring(1) + "Command";
        Command commandInstance = null;
        try {
            Class<Command> commandClass = (Class<Command>) Class.forName(commandName);
            Constructor ctor = commandClass.getConstructor(String[].class);
            commandInstance = (Command) ctor.newInstance((Object) data);
            this.injectDependencies(commandInstance, commandClass);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return commandInstance;
    }

    private void injectDependencies(Executable commandInstance, Class<Command> commandClass) throws IllegalAccessException {
        Field[] cmdFields = commandClass.getDeclaredFields();
        Field[] theseFields = CommandInterpreterImpl.class.getDeclaredFields();

        for (Field field : cmdFields) {
            if (!field.isAnnotationPresent(Inject.class)) {
                continue;
            }
            field.setAccessible(true);

            for (Field thisField : theseFields) {
                if (!thisField.getType().equals(field.getType())) {
                    continue;
                }
                thisField.setAccessible(true);
                field.set(commandInstance, thisField.get(this));
            }
        }
    }
}
