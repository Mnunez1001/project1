package com.example;

public class Tile {

    // instance variables
    private char letter;
    private int value;

    // constructor
    public Tile(char letter, int value) {
        this.letter = letter;
        this.value = value;
    }

    // getter and setters

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    // toString method

    @Override
    public String toString() {
        return "Title {The letter is:"  + letter +"\n" +  " The value is:"  + value + " } ";
                        
                    
    }

    










}
