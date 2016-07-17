package com.company.customList;

import com.company.customList.models.CustomList;

public class CommandInterpreter {
    private CustomList<String> customList;

    public CommandInterpreter(CustomList<String> customList) {
        this.customList = customList;
    }

    public void execute(String[] params){
        String command = params[0];
        String element;
        int index;
        switch (command){
            case "Add":
                element = params[1];
                this.customList.add(element);
                break;

            case "Remove":
                index = Integer.valueOf(params[1]);
                this.customList.remove(index);
                break;

            case "Contains":
                element = params[1];
                boolean contains = this.customList.contains(element);
                System.out.println(contains);
                break;

            case "Swap":
                index = Integer.valueOf(params[1]);
                int secIndex = Integer.valueOf(params[2]);
                this.customList.swap(index, secIndex);
                break;

            case "Greater":
                element = params[1];
                int count = this.customList.countGreaterThat(element);
                System.out.println(count);
                break;

            case "Max":
                String max = this.customList.getMax();
                System.out.println(max);
                break;

            case "Min":
                String min = this.customList.getMin();
                System.out.println(min);
                break;

            case "Print":
                this.customList.forEach(System.out::println);
                break;

            case "Sort":
                this.customList.sort();
                break;
        }
    }
}
