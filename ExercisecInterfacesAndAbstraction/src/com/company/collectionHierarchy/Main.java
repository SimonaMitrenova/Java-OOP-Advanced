package com.company.collectionHierarchy;

import com.company.collectionHierarchy.models.AddCollection;
import com.company.collectionHierarchy.models.AddRemoveCollection;
import com.company.collectionHierarchy.models.MyList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputParams = reader.readLine().split("\\s+");
        
        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyList myList = new MyList();

        for (String inputParam : inputParams) {
            int index = addCollection.add(inputParam);
            System.out.print(index + " ");
        }
        System.out.println();

        for (String inputParam : inputParams) {
            int index = addRemoveCollection.add(inputParam);
            System.out.print(index + " ");
        }
        System.out.println();

        for (String inputParam : inputParams) {
            int index = myList.add(inputParam);
            System.out.print(index + " ");
        }
        System.out.println();

        int n = Integer.valueOf(reader.readLine());
        for (int i = 0; i < n; i++) {
            String item = addRemoveCollection.remove();
            System.out.print(item + " ");
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            String item = myList.remove();
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
