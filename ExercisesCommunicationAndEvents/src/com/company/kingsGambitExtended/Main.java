package com.company.kingsGambitExtended;

import com.company.kingsGambitExtended.models.ModifiedMap;
import com.company.kingsGambitExtended.models.units.Footman;
import com.company.kingsGambitExtended.models.units.King;
import com.company.kingsGambitExtended.models.units.RoyalGuard;
import com.company.kingsGambitExtended.models.units.Soldier;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ModifiedMap<String,Soldier> soldiersByName = new ModifiedMap<>();
        Scanner scanner = new Scanner(System.in);

        King king = new King(scanner.nextLine());
        String[] guards = scanner.nextLine().split(" ");
        for (String guardName : guards) {
            RoyalGuard newGuard = new RoyalGuard(guardName);
            soldiersByName.put(guardName, newGuard);
            king.addUnderAttackListener(newGuard);
            newGuard.addSoldierDeathListener(soldiersByName);
            newGuard.addSoldierDeathListener(king);
        }
        String[] footmen = scanner.nextLine().split(" ");
        for (String footmanName : footmen) {
            Footman newFootman = new Footman(footmanName);
            soldiersByName.put(footmanName,newFootman);
            king.addUnderAttackListener(newFootman);
            newFootman.addSoldierDeathListener(soldiersByName);
            newFootman.addSoldierDeathListener(king);
        }

        String line = scanner.nextLine();
        while(!line.equals("End")){
            String[] parameters = line.split(" ");
            switch(parameters[0]){
                case "Attack":
                    king.respondToAttack();
                    break;
                case "Kill":
                    Soldier soldierAttacked = soldiersByName.get(parameters[1]);
                    soldierAttacked.respondToAttack();
                    break;
            }
            line = scanner.nextLine();
        }
    }
}
