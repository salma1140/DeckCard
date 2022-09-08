package com.Game;

import java.util.ArrayList;

public class Game {

    private final ArrayList<Card> deckList;
    private final Player player1;
    private final Player player2;
    private final GameRules gameRules = new GameRules();
    private final GameResult gameResult = new GameResult();
    private Player activePlayer;
    //DrawCardStatus = 0 then player can draw the card for 1 he won't
    private int player1DrawCardStatus = 0;
    private int player2DrawCardStatus = 0;
    public Game(ArrayList<Card> deckList,String namePlayer1, String namePlayer2){
        this.deckList = deckList;
        player1 = new Player(namePlayer1);
        player2 = new Player(namePlayer2);
    }
//Remaining game
    //if player1total  >= 17 he will not remove the card from deck
    //player1 will loose if player1total > 21
    //if player 1 has stopped player 2 will pick
    //player2 stop drawing if player2total > player1total
    //player2 will loose if player2total > 21
    //if both are not picking up card then highest score wins

    private GameResult continuePlaying(int listIndex){
        while(listIndex < 52){
            //if both players can't pick the card announce result
            if(player1DrawCardStatus == 1 && player2DrawCardStatus == 1){
                if (player1.getCards().stream().mapToInt(Card::getIntValue).sum() > player2.getCards().stream().mapToInt(Card::getIntValue).sum()) {
                    gameResult.setWinner(player1);
                    gameResult.setLooser(player2);
                } else {
                    gameResult.setWinner(player2);
                    gameResult.setLooser(player1);
                }
                return gameResult;
            }

            if (activePlayer.getName().equals(player1.getName())){
                if(!gameRules.isPlayer1Total17AndHigher(player1)) {
                    player1.addCardToPlayer(deckList.get(++listIndex));
                    activePlayer = player2;
                    if (player1.getCards().stream().mapToInt(Card::getIntValue).sum() > 21) {
                        gameResult.setWinner(player2);
                        gameResult.setLooser(player1);
                        return gameResult;
                    }
                }else {
                    activePlayer = player2;
                    player1DrawCardStatus = 1;
                }
            }
            else {
                    if(!gameRules.isPlayer2TotalHigherThanPlayer1(player1, player2)) {
                        player2.addCardToPlayer(deckList.get(++listIndex));
                        activePlayer = player1;
                        if (player2.getCards().stream().mapToInt(Card::getIntValue).sum() > 21){
                            gameResult.setWinner(player1);
                            gameResult.setLooser(player2);
                            return gameResult;
                        }
                }else {
                    activePlayer = player1;
                    player2DrawCardStatus = 1;
                }
            }
        }
        return null;
    }
    public GameResult start(){

        int listIndex = 0;
        //check blackjack win
        player1.addCardToPlayer(deckList.get(listIndex));
        player2.addCardToPlayer(deckList.get(++listIndex));
        player1.addCardToPlayer(deckList.get(++listIndex));
        player2.addCardToPlayer(deckList.get(++listIndex));

        //this will check blackjack and will return
        if (gameRules.isBlackJackWin(player1,player2,gameResult) )
            return gameResult;

        // if two AA then Dealer will win
        if (gameRules.isAA(player1,player2,gameResult))
            return gameResult;

        activePlayer = player1;
        return continuePlaying(listIndex);



    }
}
