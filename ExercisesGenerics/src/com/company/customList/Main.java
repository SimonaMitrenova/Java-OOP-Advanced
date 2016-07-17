package com.company.customList;

import com.company.customList.models.CustomList;
import com.company.customList.models.InsertionSorter;
import com.company.customList.models.Sorter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Sorter<String> sorter = new InsertionSorter<>();
        CustomList<String> list = new CustomList<>(sorter);
        CommandInterpreter interpreter = new CommandInterpreter(list);

        while (true){
            String[] input = reader.readLine().split("\\s+");
            if (input[0].equals("END")){
                break;
            }

            interpreter.execute(input);
        }
    }
}
