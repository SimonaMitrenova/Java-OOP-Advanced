package com.company.infernoInfinity;


import com.company.infernoInfinity.core.*;
import com.company.infernoInfinity.core.contracts.*;
import com.company.infernoInfinity.io.*;
import com.company.infernoInfinity.io.contracts.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
        Database database = new DatabaseImpl();
        Engine engine = new InfinityEngine(reader, writer, database);
        engine.run();
    }
}
