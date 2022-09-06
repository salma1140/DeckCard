package com.Game;

public class GameResult {

    private Player winner;
    private Player looser;
    public GameResult(){

    }
    public void setResult(Player winner, Player looser){
     this.winner = winner;
     this.looser = looser;

     }
     public void setWinner(Player player){
        this.winner = player;
     }
     public void setLooser(Player player){
        this.looser = player;
    }
     public String getResult(){

            String result = "The winner is: "+ winner.getName() +"\n"+ winner.getName()+" :"+winner.getCards() +
                    "\n"+ looser.getName()+" :"+looser.getCards();


            return result;
     }

}
