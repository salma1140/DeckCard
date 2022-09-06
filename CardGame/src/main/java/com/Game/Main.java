package com.Game;

import java.util.ArrayList;
import java.util.List;
public class Main {

    public static void main(String[] args) {
        List<String> fileList;
        ArrayList<Card> deckList;
         //Either reads from file or generate deck of cards
        if (args.length > 0){

            ReadFile readFile = new ReadFile();
            fileList =  readFile.getDeck(args[0]);
            deckList = readFile.convertFileListToDeck(fileList);
        }
        else {
            Deck deck = new Deck();
            deck.shuffle();
            deckList = deck.getDeck();
        }
        Game game = new Game(deckList,"Sam","Dealer");
        GameResult gameResult = game.start();
        if (gameResult != null){
            System.out.println(gameResult.getResult());
        }
        else {
            System.out.println("something went wrong");
        }
          System.out.println(deckList);
        }

}
