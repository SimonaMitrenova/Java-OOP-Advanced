package com.company.threeuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");
        String name = String.format("%s %s", input[0], input[1]);
        String address = input[2];
        String thown = input[3];
        Threeuples<String, String, String> first = new Threeuples<>(name, address, thown);
        System.out.println(first);

        input = reader.readLine().split("\\s+");
        name = input[0];
        Integer litters = Integer.valueOf(input[1]);
        boolean state = input[2].equals("drunk");
        Threeuples<String, Integer, Boolean> second = new Threeuples<>(name, litters, state);
        System.out.println(second);

        input = reader.readLine().split("\\s+");
        name = input[0];
        Double balance = Double.valueOf(input[1]);
        String bankName = input[2];
        Threeuples<String, Double, String> third = new Threeuples<>(name, balance, bankName);
        System.out.println(third);
    }
}
