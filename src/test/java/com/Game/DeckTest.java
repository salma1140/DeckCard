package com.Game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class DeckTest {

    @Test
    void getDeck() {
        Deck deck = new Deck();
        assertEquals(52, deck.getDeck().size());
        assertNotEquals(51, deck.getDeck().size());
    }


}