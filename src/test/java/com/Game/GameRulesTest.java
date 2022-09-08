package com.Game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameRulesTest {
    GameRules gameRules = new GameRules();
    GameResult gameResult = new GameResult();

    @Test
    void checkBlackJack() {
        Card card1 = mockCard("H", "A");
        Card card2 = mockCard("C", "Q");
        assertTrue(gameRules.checkBlackJack(card1, card2));
    }

    @Test
    void getValue() {
        Card card1 = mockCard("C", "A");
        Card card2 = mockCard("C", "Q");
        Card card3 = mockCard("C", "9");
        assertEquals(gameRules.getValue(card1), 11);
        assertEquals(gameRules.getValue(card2), 10);
        assertEquals(gameRules.getValue(card3), 9);
        assertNotEquals(gameRules.getValue(card2), 11);

    }

    @Test
    public void isBlackJackWin() {
        Player p1 = mockPlayer1();
        Player p2 = mockPlayer2();
        assertTrue(gameRules.isBlackJackWin(p1, p2, gameResult));
    }

    @Test
    void isAA() {
    }

    private Player mockPlayer1() {
        Player player1 = new Player("Sam");
        player1.addCardToPlayer(mockCard("H", "A"));
        player1.addCardToPlayer(mockCard("C", "K"));
        return player1;

    }

    private Player mockPlayer2() {
        Player player1 = new Player("Dealer");
        player1.addCardToPlayer(mockCard("H", "9"));
        player1.addCardToPlayer(mockCard("C", "10"));

        return player1;

    }

    private Card mockCard(String suit, String value) {
        return new Card(suit, value);

    }
}