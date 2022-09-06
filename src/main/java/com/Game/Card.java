package com.Game;

import java.util.Arrays;
import java.util.List;

public class Card {

    private String value, suit;
    public Card(String suit,String value) {
        setSuit(suit);
        setValue(value);
    }
    public static List<String> getValidValues()
    {
        return Arrays.asList("6","5","3","6","2","4","6","3","10","J","Q","K","A");
    }

    public static List<String> getValidSuits()
    {
        return Arrays.asList("H","D","S","C");
    }


    public void setValue(String value) {
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }
    public String getStrValue() {
        return value;
    }
    public int getIntValue(){
        String valueStringSam = this.value;
        if (valueStringSam.equals("J") || valueStringSam.equals("Q") || valueStringSam.equals("K")) {
            return 10;
        } else if (valueStringSam.equals("A")) {
            return  11;
        } else {

            return Integer.parseInt(valueStringSam);
        }
    }

    public void setSuit(String suit) {
            this.suit = suit;

    }
    public String toString()
    {
        return String.format("%s%s", suit,value);
    }
}