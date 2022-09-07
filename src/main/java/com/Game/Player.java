package com.Game;

import java.util.ArrayList;

public class Player {

    public String name;
    public ArrayList<Card> cards = new ArrayList<>();
    public Player() {
    }
    public Player(String name) {
        this.name = name;

    }
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Card> getCards() {
        return this.cards;
    }

    public void addCardToPlayer(Card card) {

        this.cards.add(card);
    }
}