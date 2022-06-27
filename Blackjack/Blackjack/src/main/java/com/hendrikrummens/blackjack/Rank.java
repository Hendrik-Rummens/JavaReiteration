package com.hendrikrummens.blackjack;

public enum Rank {
    ACE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING;

    public int getValue() {
        return switch (this){
            case JACK, QUEEN, KING -> 10;
            default -> ordinal() + 1;
        };
        //return this.rank == Rank.JACK ? 10 : this.rank.ordinal() + 1;
    }
}
