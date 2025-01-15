package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ScrabbleProjectDriver {
    public static void main(String[] args) {
        
        ScrabbleSet scrabbleSet1 = new ScrabbleSet("English");
        System.out.println(scrabbleSet1);

        ScrabbleSet scrabbleSet2 = new ScrabbleSet(true);
        System.out.println(scrabbleSet2);

        ScrabbleSet scrabbleSet3 = new ScrabbleSet();

        // 25 words to test. Different words to test the possible scenarios.
        String[] testWord = {"HELLO", "SCRABBLE", "HYDROGEN", "OXYGEN", "WATER", "ELEMENT", 
            "JAZZ", "QUIZ", "ZEBRA", "XENON", "HELLO123", "$CR@BBLE", "", "TOOOO", "WATER!", 
            "A", "Z", "BLANK", "NONEXISTENT", "FFFFFF", "DOG", "CAT", "PYTHON", "JAVA", "C++"

        };

        // Test the calculateWordScore method
        for(String word: testWord){
            int score = scrabbleSet3.calculateWordScore(word);

            System.out.println("The word is: " + word + " The score is: " + score);

        }

        //Read words from the file
        ArrayList<String> words = new ArrayList<>();

        try (BufferedReader bur = new BufferedReader(new FileReader("src/frankenstein.txt"))) {
            String line;
            while ((line = bur.readLine()) != null) {
                //Split the line into words using a regular expression
                String[] splitWords = line.split("\\W+");
                for (String word : splitWords) {
                    if (!word.isEmpty()){
                        words.add(word.trim());
                    }
                }
            }   
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }

        System.out.println("\nFile read successfully. Total words: " + words.size());

        // Initialize the Scrabble set
        ScrabbleSet scrabbleSet = new ScrabbleSet("English");

        // Variables to track the results
        String highestScoringWord = null;
        int highestScore = 0;
        String shortestInvalidWord = null;

        //  Process each word
        for (String word : words) {
            // Ignore empty lines
            if (word.isEmpty()) continue;

            // Calculate the Scrabble score
            int score = scrabbleSet.calculateWordScore(word);

            // Check if it's the highest scoring word
            if (score > highestScore) {
                highestScoringWord = word;
                highestScore = score;
            }

            // Check for shortest invalid word
            if (score == -1 && word.matches("[a-zA-Z]+")) { // Invalid word without digits or punctuation
                if (shortestInvalidWord == null || word.length() < shortestInvalidWord.length()) {
                    shortestInvalidWord = word;
                }
            }
        }

        // Step 4: Print results
        System.out.println("Highest Scoring Word: " + highestScoringWord + " (Score: " + highestScore + ")");
        System.out.println("Shortest Invalid Word: " + shortestInvalidWord);

        // small test
        System.out.println("First 10 words from the file:");
        for (int i = 0; i < 10 && i < words.size(); i++) {
         System.out.println(words.get(i));
        }









    }
}