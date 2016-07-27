package com.company.barracksWars.contracts;

public interface CommandInterpreter {
	Executable interpretCommand(String[] data, String commandName);
}
