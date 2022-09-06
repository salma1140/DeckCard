package com.Game;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadFile {
    String line = "";
    String splitBy = ",";
    ArrayList<Card> deck = new ArrayList<>();
    String[] cards;

    public List<String> getDeck(String args) {
            BufferedReader br = null;
            try {

                br = new BufferedReader(new FileReader(args));
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
            while (true)   //returns a Boolean value
            {
                try {
                    if (!((line = br.readLine()) != null)) break;
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                 cards = line.split(splitBy);    // use comma as separator
                System.out.println(cards);
            }
        return Arrays.asList(cards);
    }

    public ArrayList<Card> convertFileListToDeck(List<String> fileList) {

        Card card;
        for (String data: fileList) {
            String cardStr = data.trim();
            String suitValue = cardStr.substring(0,1);
            String rankValue = cardStr.substring(1);
            card = new Card(suitValue,rankValue);
            deck.add(card);

        }
        return deck;



    }
}

