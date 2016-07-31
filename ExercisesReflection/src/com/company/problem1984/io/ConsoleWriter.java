package com.company.problem1984.io;

import com.company.problem1984.io.contracts.Writer;

public class ConsoleWriter implements Writer{
    @Override
    public void writeLine(String message) {
        System.out.println(message);
    }
}
