package com.Game;

public class GameResult {

    private Player winner;
    private Player looser;
    public GameResult() {

    }

    public void setWinner(Player player) {
        this.winner = player;
    }
    public void setLooser(Player player) {
        this.looser = player;
    }

    public String getResult() {


        return "The winner is: " + winner.getName() + "\n" + winner.getName() + " :" + winner.getCards() +
                "\n" + looser.getName() + " :" + looser.getCards();
    }

}
