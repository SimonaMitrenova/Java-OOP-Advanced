package com.company.cardsWithPower;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        Ranks firstRank = Ranks.valueOf(reader.readLine());
//        Suits firstSuit = Suits.valueOf(reader.readLine());
//        Card firstCard = new Card(firstRank, firstSuit);
//
//        Ranks secondRank = Ranks.valueOf(reader.readLine());
//        Suits secondSuit = Suits.valueOf(reader.readLine());
//        Card secondCard = new Card(secondRank, secondSuit);
//
//        Card maxCard = getMax(firstCard, secondCard);
//        System.out.println(maxCard);

//        String type = reader.readLine();
//        Class<Ranks> rankClass = Ranks.class;
//        Class<Suits> suitsClass = Suits.class;
//
//        EnumInfo rankInfo = rankClass.getAnnotation(EnumInfo.class);
//        EnumInfo suitInfo = suitsClass.getAnnotation(EnumInfo.class);
//
//
//        switch (type){
//            case "Rank":
//                System.out.printf("Type = %s, Description = %s%n", rankInfo.type(), rankInfo.description());
//                break;
//
//            case "Suit":
//                System.out.printf("Type = %s, Description = %s%n", suitInfo.type(), suitInfo.description());
//                break;
//        }

//        for (Suits suit : Suits.values()) {
//            for (Ranks rank : Ranks.values()) {
//                System.out.printf("%s of %s%n", rank, suit);
//            }
//        }
        HashSet<Card> deck = new HashSet<>();

        Player firstPlayer = new Player(reader.readLine());
        Player secondPlayer= new Player(reader.readLine());

        addCards(reader, deck, firstPlayer);
        addCards(reader, deck, secondPlayer);

        Player winner = firstPlayer;
        if (secondPlayer.compareTo(firstPlayer) > 0){
            winner = secondPlayer;
        }

        System.out.println(winner);
    }

    private static void addCards(BufferedReader reader, HashSet<Card> deck, Player player) throws IOException {
        while (player.getCardsCount() < 5){
            String[] params = reader.readLine().split("[\\sof]+");
            Ranks rank;
            Suits suit;
            try{
                rank = Ranks.valueOf(params[0]);
                suit = Suits.valueOf(params[1]);
            } catch (IllegalArgumentException ex){
                System.out.println("No such card exists.");
                continue;
            }

            Card card = new Card(rank, suit);
            if (deck.contains(card)){
                System.out.println("Card is not in the deck.");
                continue;
            }

            player.addCard(card);
            deck.add(card);
        }
    }

    private static Card getMax(Card firstCard, Card secondCard) {
        Card max = firstCard;
        if (secondCard.compareTo(firstCard) > 0) {
            max = secondCard;
        }

        return max;
    }
}
