package com.example;

public class ScrabbleProjectDriver {
    public static void main(String[] args) {
        
        //ScrabbleSet scrabbleSet1 = new ScrabbleSet("English");
        //System.out.println(scrabbleSet1);

        //ScrabbleSet scrabbleSet2 = new ScrabbleSet(true);
        //System.out.println(scrabbleSet2);

        ScrabbleSet scrabbleSet3 = new ScrabbleSet();

        String word = "Hello";

        int score = scrabbleSet3.calculateWordScore(word);
            System.out.println("Word: " + word + ", Score: " + score);






    }
}