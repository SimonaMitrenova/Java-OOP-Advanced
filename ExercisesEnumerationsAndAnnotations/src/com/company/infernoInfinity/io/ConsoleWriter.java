package com.company.infernoInfinity.io;

import com.company.infernoInfinity.io.contracts.Writer;

public class ConsoleWriter implements Writer {
    @Override
    public void write(Object message) {
        System.out.println(message);
    }
}
