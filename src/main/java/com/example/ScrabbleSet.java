package com.example;

import java.util.ArrayList;
import java.util.Random;

/**
 * Represents a Scrabble set containing tiles with letters and their associated
 * values.
 * The set supports different configurations based on language or randomization.
 * 
 * Each tile has a letter, a point value, and a count indicating the quantity of
 * that tile.
 * This class provides methods to initialize Scrabble sets, calculate word
 * scores, and display the set.
 * 
 * @author Miguel Alexander Nunez Palomares
 * @version 1.0
 * @see java.util.ArrayList, java.util.Random
 */

public class ScrabbleSet {

    /**
     * List of tiles in the Scrabble set, where each tile represents a letter and
     * its point value.
     */
    private ArrayList<Tile> tiles;

    /**
     * List of counts corresponding to each tile, indicating how many of each letter
     * are in the set.
     */
    private ArrayList<Integer> tileCount;

    /**
     * The language of the Scrabble set (e.g., "English").
     */
    private String language;

    /**
     * Array of letters in the Scrabble set (including a blank space represented by
     * ' ').
     */

    private char[] letters = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
            'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', ' ' };
    /**
     * Random number generator used for randomizing tile distribution.
     */

    private Random rand = new Random();

    /**
     * Default constructor that initializes an English Scrabble set.
     */
    public ScrabbleSet() {
        this("English");
    }

    /**
     * Constructor that initializes a Scrabble set based on the specified language.
     * If the language is not implemented, an appropriate message is displayed.
     * 
     * @param language The language for the Scrabble set (e.g., "English").
     */

    public ScrabbleSet(String language) {
        this.language = language;
        this.tiles = new ArrayList<Tile>();
        this.tileCount = new ArrayList<Integer>();

        if (language.equalsIgnoreCase("English")) {
            englishSet();
        } else {
            System.out.println("Scrabble set for language '" + language + "' is not implemented.");
        }

    }

    /**
     * Constructor that initializes a random Scrabble set if {@code randomized} is
     * true.
     * Otherwise, displays an unsupported initialization method message.
     * 
     * @param randomized Indicates whether the Scrabble set should be randomly
     *                   initialized.
     */

    public ScrabbleSet(boolean randomized) {
        tiles = new ArrayList<Tile>();
        tileCount = new ArrayList<Integer>();

        if (randomized) {
            initializeRandomScrabbleSet();

        } else {
            System.out.println("Unsupported initialization method.");

        }

    }

    /**
     * Initializes an English Scrabble set with predefined letter values and counts.
     */
    private void englishSet() {
        // char[] letters =
        // {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','
        // '};
        int[] values = { 1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10, 0 };
        int[] counts = { 9, 2, 2, 4, 12, 2, 3, 2, 9, 1, 1, 4, 2, 6, 8, 2, 1, 6, 4, 6, 4, 2, 2, 1, 2, 1, 2 };

        for (int i = 0; i < letters.length; i++) {
            tiles.add(new Tile(letters[i], values[i]));
            tileCount.add(counts[i]);
        }

    }

    /**
     * Initializes a random Scrabble set, favoring vowels and ensuring no letter
     * exceeds 12 counts.
     */
    private void initializeRandomScrabbleSet() {
        // char[] letters =
        // {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','
        // '};
        int[] values = { 1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10, 0 };

        int totalTiles = 100;
        int remainingTiles = totalTiles - letters.length;

        // add 1 title to each Letter
        for (int i = 0; i < letters.length; i++) {
            tiles.add(new Tile(letters[i], values[i]));
            tileCount.add(1);
        }

        // Distribute remaining tiles randomly, favoring vowels
        String vowels = "AEIOU";
        while (remainingTiles > 0) {
            int index = rand.nextInt(letters.length);
            char letter = letters[index];

            // favor vowels by increasing their probability
            if (vowels.indexOf(letter) != -1 && rand.nextDouble() < 0.6) {

                tileCount.set(index, tileCount.get(index) + 1);
                remainingTiles--;

            } else if (vowels.indexOf(letter) == -1 && rand.nextDouble() < 0.4) {

                tileCount.set(index, tileCount.get(index) + 1);
                remainingTiles--;

            }
        }

        // no letter exceeds more than 12 count

        int maxCount = 12;

        for (int i = 0; i < tileCount.size(); i++) {

            if (tileCount.get(i) > maxCount) {
                int diff = tileCount.get(i) - maxCount;
                tileCount.set(i, maxCount);
                remainingTiles += diff;
            }

        }

        // redistribute any leftover tiles

        while (remainingTiles > 0) {
            int index = rand.nextInt(letters.length);
            tileCount.set(index, tileCount.get(index) + 1);
            remainingTiles--;
        }

    }

    /**
     * Gets the list of tiles in the Scrabble set.
     * 
     * @return A list of {@link Tile} objects.
     */

    public ArrayList<Tile> getTiles() {
        return tiles;
    }

    /**
     * Sets the list of tiles in the Scrabble set.
     * 
     * @param tiles The list of {@link Tile} objects to set.
     */
    public void setTiles(ArrayList<Tile> tiles) {
        this.tiles = tiles;
    }

    /**
     * Gets the list of tile counts in the Scrabble set.
     * 
     * @return A list of integers representing the counts of each tile.
     */
    public ArrayList<Integer> getTileCount() {
        return tileCount;
    }

    /**
     * Sets the list of tile counts in the Scrabble set.
     * 
     * @param tileCount A list of integers representing the counts of each tile.
     */
    public void setTileCount(ArrayList<Integer> tileCount) {
        this.tileCount = tileCount;
    }

    /**
     * Returns a string representation of the Scrabble set, including tile details
     * and total tile count.
     * 
     * @return A string representation of the Scrabble set.
     */

    @Override
    public String toString() {

        String header = "Scrabble Set:\n ";
        header += String.format("%-10s %-12s %-10s\n", "Letter", "Point Value", "Count");
        header += "-----------------------------------\n";

        String body = "";
        for (int i = 0; i < tiles.size(); i++) {
            Tile tile = tiles.get(i);
            int count = tileCount.get(i);

            body += String.format("%-10s %-12d %-10d\n", tile.getLetter(), tile.getValue(), count);
        }

        String footer = "-----------------------------------\n";
        // this is the only line that I added but not sure how it works %100.
        footer += "Total Tiles: " + tileCount.stream().mapToInt(Integer::intValue).sum() + "\n";

        return header + body + footer;
    }

    /**
     * Calculates the score of a word based on the tiles in the Scrabble set.
     * 
     * @param word The word to calculate the score for.
     * @return The total score of the word, or -1 if the word contains invalid
     *         characters.
     */

    public int calculateWordScore(String word) {
        // Validate input: Check if word contains only letters
        if (!word.matches("[a-zA-Z]+")) {
            return -1; // Invalid word, contains non-letter characters
        }

        // Convert the word to uppercase to make it case-insensitive
        word = word.toUpperCase();

        // Create a temporary copy of tile counts to simulate using the tiles
        ArrayList<Integer> tempTileCounts = new ArrayList<>(tileCount);

        int totalScore = 0;

        // Iterate through each character in the word
        for (char c : word.toCharArray()) {
            // Find the index of the letter in the Scrabble set
            int index = -1;
            for (int i = 0; i < letters.length; i++) {
                if (letters[i] == c) {
                    index = i;
                    break;
                }
            }

            if (index == -1 || tempTileCounts.get(index) <= 0) {
                // Letter not found or not enough tiles available
                return -1;
            }

            // Add the point value of the letter to the total score
            totalScore += tiles.get(index).getValue();

            // Decrement the count of the letter tile used
            tempTileCounts.set(index, tempTileCounts.get(index) - 1);
        }

        return totalScore;
    }

}
