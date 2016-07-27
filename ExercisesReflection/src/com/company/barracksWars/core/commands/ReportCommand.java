package com.company.barracksWars.core.commands;


import com.company.barracksWars.contracts.Inject;
import com.company.barracksWars.contracts.Repository;

public class ReportCommand extends Command{

    @Inject
    private Repository repository;

    public ReportCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        return this.repository.getStatistics();
    }
}
