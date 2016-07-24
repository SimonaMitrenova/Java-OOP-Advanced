package com.company.infernoInfinity.core;

import com.company.infernoInfinity.commands.*;
import com.company.infernoInfinity.weapons.WeaponInfo;
import com.company.infernoInfinity.core.contracts.*;
import com.company.infernoInfinity.enums.*;
import com.company.infernoInfinity.gems.*;
import com.company.infernoInfinity.gems.contracts.Gem;
import com.company.infernoInfinity.io.contracts.*;
import com.company.infernoInfinity.weapons.*;
import com.company.infernoInfinity.weapons.contracts.Weapon;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class InfinityEngine implements Engine {
    private Reader reader;
    private Writer writer;
    private Database database;

    public InfinityEngine(Reader reader, Writer writer, Database database) {
        this.reader = reader;
        this.writer = writer;
        this.database = database;
    }

    @Override
    public void run() throws IOException {
        while (true){
            String[] input = reader.readLine().split(";");
            if (input[0].equals("END")){
                break;
            }
            Command command;

            switch (input[0]){
                case "Create":
                    command = new CreateCommand(this.database, input);
                    break;

                case "Add":
                    command = new AddCommand(this.database, input);
                    break;

                case "Remove":
                    command = new RemoveCommand(this.database, input);
                    break;

                case "Print":
                    command = new PrintCommand(this.database, input);
                    break;

                case "Compare":
                    command = new CompareCommand(this.database, input);
                    break;

                case "Author":
                    command = new AuthorCommand(this.database, input);
                    break;

                case "Revision":
                    command = new RevisionCommand(this.database, input);
                    break;

                case "Description":
                    command = new DescriptionCommand(this.database, input);
                    break;

                case "Reviewers":
                    command = new ReviewersCommand(this.database, input);
                    break;

                default:
                    continue;
            }

            String result = command.execute();
            if (result != null){
                writer.write(result);
            }
        }
    }
}
