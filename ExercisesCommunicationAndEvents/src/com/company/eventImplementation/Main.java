package com.company.eventImplementation;

import com.company.eventImplementation.models.Dispatcher;
import com.company.eventImplementation.models.Handler;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Dispatcher dispatcher = new Dispatcher();
        Handler handler = new Handler();

        dispatcher.addNameChangeListener(handler);

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        while(!line.equals("End")){
            dispatcher.setName(line);
            line = scanner.nextLine();
        }
    }
}
