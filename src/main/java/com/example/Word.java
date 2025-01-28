package com.example;

import java.util.Random;

/**
 * Represents a word in a Scrabble game.
 * This class provides functionality to store a word, calculate its Scrabble
 * score,
 * compare it with other words, and generate random words.
 * 
 * 
 * The Word class depends on the {@link ScrabbleSet} class to calculate the
 * score
 * of the word based on Scrabble rules.
 * 
 * 
 * @author Miguel Alexander Nunez Palomares
 * @version 1.0
 * @see java.util.Random
 */

public class Word implements Comparable<Word> {

    /**
     * The word represented as a string.
     */
    private String word;

    /**
     * The ScrabbleSet used to calculate the score of the word.
     */
    private ScrabbleSet scrabbleSet;

    /**
     * Random number generator for creating random words.
     */
    private Random random = new Random();

    /**
     * Creates a Word object with the specified word and Scrabble set.
     * 
     * @param word        the word to represent.
     * @param scrabbleSet the Scrabble set used for score calculations.
     */

    public Word(String word, ScrabbleSet scrabbleSet) {
        this.word = word;
        this.scrabbleSet = scrabbleSet;
    }

    /**
     * Creates a Word object with a random word of length between 2 and 14
     * (inclusive),
     * using uppercase letters. The word is generated based on the provided Scrabble
     * set.
     * 
     * @param scrabbleSet the Scrabble set used for score calculations.
     */

    public Word(ScrabbleSet scrabbleSet) {
        this.scrabbleSet = scrabbleSet;

        // Generate random length uppercase word in the range [2,14]
        int length = random.nextInt(13) + 2;

        // Generate random string of uppercase letters
        StringBuilder randomWord = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char randomChar = (char) ('A' + random.nextInt(26));
            randomWord.append(randomChar);
        }

        this.word = randomWord.toString();
    }

    /**
     * Gets the word represented by this object.
     * 
     * @return the word as a string.
     */

    public String getWord() {
        return word;
    }

    /**
     * Sets the word represented by this object.
     * 
     * @param word the word to set.
     */
    public void setWord(String word) {
        this.word = word;
    }

    /**
     * Gets the ScrabbleSet associated with this word.
     * 
     * @return the ScrabbleSet used for score calculations.
     */
    public ScrabbleSet getScrabbleSet() {
        return scrabbleSet;
    }

    /**
     * Sets the ScrabbleSet associated with this word.
     * 
     * @param scrabbleSet the ScrabbleSet to associate with this word.
     */
    public void setScrabbleSet(ScrabbleSet scrabbleSet) {
        this.scrabbleSet = scrabbleSet;
    }

    /**
     * Calculates the Scrabble score of this word using the associated ScrabbleSet.
     * 
     * @return the Scrabble score of the word, or -1 if the word contains invalid
     *         characters
     *         or cannot be scored with the available tiles in the ScrabbleSet.
     * @see ScrabbleSet#calculateWordScore(String)
     */

    public int getScore() {
        return scrabbleSet.calculateWordScore(word);
    }

    /**
     * Compares this Word object with another Word object. The comparison is based
     * on the
     * Scrabble score of the words. If the scores are equal, the words are compared
     * lexicographically.
     * 
     * @param otherWord the Word object to compare with.
     * @return a negative integer, zero, or a positive integer if this word's score
     *         is
     *         less than, equal to, or greater than the other word's score. If the
     *         scores
     *         are equal, the comparison is based on lexicographic order.
     */
    @Override
    public int compareTo(Word otherWord) {
        // compare scores
        int thisScore = this.getScore();
        int otherScore = otherWord.getScore();

        if (thisScore == otherScore) {
            // if scores are the same, compare the words lexicographically
            return this.word.compareTo(otherWord.word);
        }

        // return 1 if this word has a higher score, -1 if other word has a higher score
        return thisScore > otherScore ? 1 : -1;

    }

    /**
     * Returns a string representation of the Word object.
     * 
     * @return a string containing the word and its Scrabble score.
     */
    @Override
    public String toString() {
        return "Word: " + word + ", Score: " + getScore();
    }

}
