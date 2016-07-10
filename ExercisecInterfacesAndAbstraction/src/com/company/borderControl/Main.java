package com.company.borderControl;

import com.company.borderControl.models.Birthable;
import com.company.borderControl.models.Person;
import com.company.borderControl.models.Pet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Birthable> citizens = new LinkedList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String[] params = reader.readLine().split("\\s+");
            if (params[0].equals("End")){
                break;
            }

            switch (params[0]){
                case "Citizen":
                    Birthable citizen = new Person(params[1], Integer.valueOf(params[2]), params[3], params[4]);
                    citizens.add(citizen);
                    break;

                case "Pet":
                    Birthable pet = new Pet(params[1], params[2]);
                    citizens.add(pet);
                    break;
            }
        }

        String year = reader.readLine();
        citizens.stream().filter(c -> c.getBirthdate().endsWith(year)).forEach(c -> System.out.println(c.getBirthdate()));
    }
}
