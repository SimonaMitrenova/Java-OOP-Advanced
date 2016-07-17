package com.company.genericCountMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(reader.readLine());
        List<Double> elements = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            double num = Double.valueOf(reader.readLine());
            elements.add(num);
        }
        double toCompare = Double.valueOf(reader.readLine());
        int result = getCountGreaterThan(elements, toCompare);
        System.out.println(result);
    }

    public static <T extends Comparable<T>> int getCountGreaterThan(List<T> elements, T toCompare){
        int count = 0;
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).compareTo(toCompare) > 0){
                count++;
            }
        }
        return count;
    }
}
