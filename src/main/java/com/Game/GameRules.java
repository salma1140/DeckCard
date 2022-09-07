package com.Game;

import java.util.ArrayList;

public class GameRules {

    public int getSumOfCards(ArrayList<Card> cardsList) {
        return cardsList.stream().mapToInt(Card::getIntValue).sum();
    }

    public boolean checkBlackJack(Card card1, Card card2) {

        ArrayList<Card> cardsList = new ArrayList<>();
        cardsList.add(card1);
        cardsList.add(card2);
        int sumOfCard = getSumOfCards(cardsList);
        return sumOfCard == 21;
    }

    public int getValue(Card card) {
        String valueStringSam = card.getStrValue();
        if (valueStringSam.equals("J") || valueStringSam.equals("Q") || valueStringSam.equals("K")) {
            return 10;
        } else if (valueStringSam.equals("A")) {
            return 11;
        } else {

            return Integer.parseInt(valueStringSam);
        }
    }

    public boolean isBlackJackWin(Player player1, Player player2, GameResult gameResult) {

        if (checkBlackJack(player1.getCards().get(0), player1.getCards().get(1))) {

            gameResult.setWinner(player1);
            gameResult.setLooser(player2);
            return true;
        }
        if (checkBlackJack(player2.getCards().get(0), player2.getCards().get(1))) {
            gameResult.setWinner(player2);
            gameResult.setLooser(player1);
            return true;
        }
        return false;
    }

    public boolean isAA(Player player1, Player player2, GameResult gameResult) {

        int sumPlayer1 = player1.getCards().stream().mapToInt(Card::getIntValue).sum();
        int sumPlayer2 = player2.getCards().stream().mapToInt(Card::getIntValue).sum();
        if (sumPlayer1 == 22 && sumPlayer2 == 22) {
            gameResult.setWinner(player2);
            gameResult.setLooser(player1);
            return true;
        }

        return false;


    }

    public boolean isPlayer1Total17AndHigher(Player player1) {
        int sumPlayer1 = player1.getCards().stream().mapToInt(Card::getIntValue).sum();
        return sumPlayer1 >= 17;
    }

    public boolean isPlayer2TotalHigherThanPlayer1(Player player1, Player player2) {

        return player2.getCards().stream().mapToInt(Card::getIntValue).sum() > player1.getCards().stream().mapToInt(Card::getIntValue).sum();

    }

}
