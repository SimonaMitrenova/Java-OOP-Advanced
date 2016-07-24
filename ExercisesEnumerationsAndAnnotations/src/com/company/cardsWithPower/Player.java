package com.company.cardsWithPower;

import java.util.TreeSet;

public class Player implements Comparable<Player>{
    private String name;
    TreeSet<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new TreeSet<>();
    }

    public void addCard(Card card){
        this.hand.add(card);
    }

    public Card getHighestPoweredCard(){
        return this.hand.last();
    }

    public int getCardsCount(){
        return this.hand.size();
    }

    @Override
    public int compareTo(Player other) {
        return this.getHighestPoweredCard().compareTo(other.getHighestPoweredCard());
    }

    @Override
    public String toString() {
        return String.format("%s wins with %s of %s.",
                this.name,
                this.getHighestPoweredCard().getRank(),
                this.getHighestPoweredCard().getSuit());
    }
}
