package com.example;
import java.util.ArrayList;

public class ScrabbleSet {

    // instance variables
    private ArrayList<Tile> tiles;
    private ArrayList<Integer> tileCount;
    private String language;

    // Parameterized construcot

    public ScrabbleSet(String language){
        this.language = language;
        this.tiles = new ArrayList<Tile>();
        this.tileCount = new ArrayList<Integer>();
        
        if(language.equalsIgnoreCase("English")){
            englishSet();
        }else{
            System.out.println("Scrabble set for language '" + language + "' is not implemented.");
        }


    }

    //englishSet method
    private void englishSet(){
            char[] letters = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',' '};
            int[] values = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10,0};
            int[] counts = {9,2,2,4,12,2,3,2,9,1,1,4,2,6,8,2,1,6,4,6,4,2,2,1,2,1,2};
            
            for(int i = 0; i < letters.length; i++){
                tiles.add(new Tile(letters[i], values[i]));
                tileCount.add(counts[i]);
            }




    }




}
