package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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

        //  Print results
        System.out.println("Highest Scoring Word: " + highestScoringWord + " (Score: " + highestScore + ")");
        System.out.println("Shortest Invalid Word: " + shortestInvalidWord);

        // small test
        System.out.println("\nFirst 10 words from the file:");
        for (int i = 0; i < 10 && i < words.size(); i++) {
         System.out.println(words.get(i));
        }

       
       
        //Read words from the file (random version)
        ArrayList<String> wordss = new ArrayList<>();

        try (BufferedReader burr = new BufferedReader(new FileReader("src/frankenstein.txt"))) {
            String line2;
            while ((line2 = burr.readLine()) != null) {
                //Split the line into words using a regular expression
                String[] splitWordsS = line2.split("\\W+");
                for (String word2 : splitWordsS) {
                    if (!word2.isEmpty()){
                        wordss.add(word2.trim());
                    }
                }
            }   
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }

        System.out.println("\nFile read successfully. Total words: " + wordss.size());

        // Initialize the Scrabble set
        ScrabbleSet scrabbleSet5 = new ScrabbleSet(true);

        // Variables to track the results
        String highestScoringWordR = null;
        int highestScoreR = 0;
        String shortestInvalidWordR = null;

        //  Process each word
        for (String word : wordss) {
            // Ignore empty lines
            if (word.isEmpty()) continue;

            // Calculate the Scrabble score
            int score2 = scrabbleSet5.calculateWordScore(word);

            // Check if it's the highest scoring word
            if (score2 > highestScoreR) {
                highestScoringWordR = word;
                highestScoreR = score2;
            }

            // Check for shortest invalid word
            if (score2 == -1 && word.matches("[a-zA-Z]+")) { // Invalid word without digits or punctuation
                if (shortestInvalidWordR == null || word.length() < shortestInvalidWordR.length()) {
                    shortestInvalidWordR = word;
                }
            }
        }

        // Print results
        System.out.println("Highest Scoring Word: " + highestScoringWordR + " (Score: " + highestScoreR + ")");
        System.out.println("Shortest Invalid Word: " + shortestInvalidWordR);

         
        // user input part of the code
        ScrabbleSet standardScrabbleSet = new ScrabbleSet("English");
        ScrabbleSet randomScrabbleSet = new ScrabbleSet(true);

        // scanneralex object for user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nWelcome to the Scrabble Score Calculator!");
        System.out.println("Type 'exit' to quit the program.");

        // Start the loop
        while (true) {
            System.out.print("\nEnter a word to calculate its Scrabble score: ");
            String word = scanner.nextLine().trim();

            // Exit the loop if the user types "exit"
            if (word.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the program.");
                break;
            }

            // Calculate the point value for the word in both sets
            int standardScore = standardScrabbleSet.calculateWordScore(word);
            int randomScore = randomScrabbleSet.calculateWordScore(word);

            //  results
            if (standardScore == -1) {
                System.out.println("The word '" + word + "' is invalid in the standard Scrabble set.");
            } else {
                System.out.println("The word '" + word + "' has " + standardScore + " points in the standard Scrabble set.");
            }

            if (randomScore == -1) {
                System.out.println("The word '" + word + "' is invalid in the randomly generated Scrabble set.");
            } else {
                System.out.println("The word '" + word + "' has " + randomScore + " points in the randomly generated Scrabble set.");
            }
        }






    }
}