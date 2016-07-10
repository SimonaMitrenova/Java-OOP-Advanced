package com.company.foodShortage;

import com.company.foodShortage.models.Buyer;
import com.company.foodShortage.models.Citizen;
import com.company.foodShortage.models.Rebel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        HashMap<String, Buyer> people = new HashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] params = reader.readLine().split("\\s+");
            if (params.length == 3){
                Rebel rebel = new Rebel(params[0], Integer.valueOf(params[1]), params[2]);
                people.put(params[0], rebel);
            } else if (params.length == 4){
                Citizen citizen = new Citizen(params[0], Integer.valueOf(params[1]), params[2], params[3]);
                people.put(params[0], citizen);
            }
        }

        while (true){
            String input = reader.readLine();
            if (input.equals("End")){
                break;
            }
            if (people.containsKey(input)){
                people.get(input).buyFood();
            }
        }

        int totalFood = people.values().stream().mapToInt(Buyer::getFoodCount).sum();
        System.out.println(totalFood);
    }
}
