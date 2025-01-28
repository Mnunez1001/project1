package com.example;

/**
 * Represents a tile with a letter and a corresponding value.
 * This class is typically used in word games where each tile
 * has a specific letter and a score associated with it.
 * 
 * @author Miguel Alexander Nunez Palomares
 * @version 1.0
 */

public class Tile {

    /**
     * The letter represented by the tile.
     */
    private char letter;

    /**
     * The point value of the tile.
     */
    private int value;

    /**
     * Constructs a new Tile with the specified letter and value.
     * 
     * @param letter the letter represented by the tile
     * @param value  the point value of the tile
     */
    public Tile(char letter, int value) {
        this.letter = letter;
        this.value = value;
    }

    /**
     * Retrieves the letter of the tile.
     * 
     * @return the letter represented by the tile
     */
    public char getLetter() {
        return letter;
    }

    /**
     * Sets the letter of the tile.
     * 
     * @param letter the new letter to set for the tile
     */
    public void setLetter(char letter) {
        this.letter = letter;
    }

    /**
     * Retrieves the value of the tile.
     * 
     * @return the point value of the tile
     */
    public int getValue() {
        return value;
    }

    /**
     * Sets the value of the tile.
     * 
     * @param value the new point value to set for the tile
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Returns a string representation of the tile.
     * The string includes the letter and the value of the tile.
     * 
     * @return a string representation of the tile
     */

    @Override
    public String toString() {
        return "Title {The letter is:" + letter + "\n" + " The value is:" + value + " } ";

    }

}
