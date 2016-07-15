package com.company.mood3;

import com.company.mood3.models.Archangel;
import com.company.mood3.models.Demon;
import com.company.mood3.models.GameObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("[\\s\\|]+");
        String username = input[0];
        String type = input[1];
        int level = Integer.valueOf(input[3]);
        GameObject gameObject = null;
        switch (type){
            case "Demon":
                double energy = Double.valueOf(input[2]);
                gameObject = new Demon(username, level, energy);
                break;

            case "Archangel":
                int mana = Integer.valueOf(input[2]);
                gameObject = new Archangel(username, level, mana);
                break;
        }

        if (gameObject != null){
            System.out.println(gameObject);
        }
    }
}
