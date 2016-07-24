package com.company.cardsWithPower;

public class Card implements Comparable<Card>{
    private Ranks rank;
    private Suits suit;
    private int power;

    public Card(Ranks rank, Suits suit) {
        this.rank = rank;
        this.suit = suit;
        this.power = this.calculatePower();
    }

    public Ranks getRank() {
        return rank;
    }

    public Suits getSuit() {
        return suit;
    }

    public int getPower() {
        return this.power;
    }

    private int calculatePower() {
        return this.rank.getPower() + this.suit.getPower();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || this.getClass() != other.getClass()) {
            return false;
        }

        Card card = (Card) other;

        if (this.rank != card.rank) {
            return false;
        }
        return suit == card.suit;
    }

    @Override
    public int hashCode() {
        int result = this.rank.hashCode();
        result = 31 * result + this.suit.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %s", this.rank, this.suit, this.getPower());
    }

    @Override
    public int compareTo(Card other) {
        return Integer.compare(this.getPower(), other.getPower());
    }
}
