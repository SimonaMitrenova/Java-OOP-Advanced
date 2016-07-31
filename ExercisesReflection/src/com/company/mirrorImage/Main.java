package com.company.mirrorImage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] params = reader.readLine().split("\\s+");

        String name = params[0];
        int damage = Integer.valueOf(params[1]);
        Wizard wizard = new Wizard(name, damage);

        while (true){
            params = reader.readLine().split("\\s+");
            if (params[0].equals("END")){
                break;
            }
            int id = Integer.valueOf(params[0]);
            SpellType type = SpellType.valueOf(params[1]);

            Wizard current = Wizard.getWizardById(id);
            if (current == null){
                continue;
            }

            switch (type){
                case REFLECTION:
                    current.castReflection();
                    break;

                case FIREBALL:
                    current.castFireBall();
                    break;
            }
        }
    }
}
