package com.company.telephony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        Smartphone smartphone = new Smartphone();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = reader.readLine().split("\\s+");
        for (String number : numbers) {
            System.out.println(smartphone.call(number));
        }

        String[] urls = reader.readLine().split("\\s+");
        for (String url : urls) {
            System.out.println(smartphone.browse(url));
        }
    }
}
