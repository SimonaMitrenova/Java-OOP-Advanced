package com.company.cardRank;

public class Main {
    public static void main(String[] args) {
        System.out.println("Card Ranks:");
        for (CardRanks cardRanks : CardRanks.values()) {
            System.out.printf("Ordinal value: %s; Name value: %s%n", cardRanks.ordinal(), cardRanks);
        }
    }
}
