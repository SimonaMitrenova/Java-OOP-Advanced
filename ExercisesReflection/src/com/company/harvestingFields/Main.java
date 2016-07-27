package com.company.harvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Class<RichSoilLand> richSoilLandClass = RichSoilLand.class;

        while (true){
            String command = reader.readLine();
            if (command.equals("HARVEST")){
                break;
            }
            Field[] fields = richSoilLandClass.getDeclaredFields();

            for (Field field : fields) {
                int modifierInt = field.getModifiers();
                String modifier = Modifier.toString(modifierInt);
                if (!modifier.equals(command) && !command.equals("all")){
                    continue;
                }
                System.out.printf("%s %s %s%n", modifier, field.getType().getSimpleName(), field.getName());
            }
        }
    }
}
