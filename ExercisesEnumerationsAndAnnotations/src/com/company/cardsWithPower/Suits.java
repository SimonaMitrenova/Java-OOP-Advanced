package com.company.cardsWithPower;

@EnumInfo(
        category = "Suit",
        description = "Provides suit constants for a Card class."
)

public enum Suits {
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    private int power;

    Suits(int power) {
        this.power = power;
    }

    public int getPower() {
        return this.power;
    }
}
