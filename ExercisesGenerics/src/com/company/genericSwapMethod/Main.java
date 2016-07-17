package com.company.genericSwapMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(reader.readLine());
        List<Integer> elements = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.valueOf(reader.readLine());
            elements.add(num);
        }
        int[] indexes = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        swapPlaces(elements, indexes[0], indexes[1]);
        for (int i = 0; i < elements.size(); i++) {
            System.out.printf("%s: %s%n", elements.get(i).getClass().getName(), elements.get(i));
        }
    }

    public static <T> void swapPlaces(List<T> elements, int firstIndex, int secondIndex) {
        T temp = elements.get(firstIndex);
        elements.set(firstIndex, elements.get(secondIndex));
        elements.set(secondIndex, temp);
    }
}
