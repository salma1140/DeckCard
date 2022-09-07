package com.Game;

import java.util.ArrayList;
import java.util.Collections;


public class Deck {

    private final ArrayList<Card> deck;

    // constructor will build a full Deck of Cards
    public Deck() {
        deck = new ArrayList<>();
        for (String suit : Card.getValidSuits()) {
            for (String rank : Card.getValidValues()) {
                deck.add(new Card(suit, rank));
            }
        }
    }
    public ArrayList<Card> getDeck() {
        return deck;
    }
    public void shuffle() {
        Collections.shuffle(deck);
    }
}