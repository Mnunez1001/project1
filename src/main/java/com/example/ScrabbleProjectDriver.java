package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Arrays;

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

        // scanner object for user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nWelcome to the Scrabble Score Calculator!");
        System.out.println("Type 'exit' to quit the program.");

        // while loop to play the game until the user types "exit"
        while (true) {
            System.out.print("\nEnter a word to calculate its Scrabble score: ");
            String word = scanner.nextLine().trim();

            // Exit the loop if the user types "exit"
            if (word.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the program.\n");
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

        //scanner.close();





        //Project 3. 
        //Testing the Word class

        // Create a ScrabbleSet object
        ScrabbleSet scrabbleSet6 = new ScrabbleSet("English");

        //Create a Word objects
        Word word1 = new Word("HELLO", scrabbleSet6);
        Word word2 = new Word("WORLD", scrabbleSet6);
        Word word3 = new Word("HELLO", scrabbleSet6);
        Word word4 = new Word("WATER", scrabbleSet6); //water has the same score as hello

        // Print the words and their scores
        System.out.println("word1 is " + word1);
        System.out.println("word2 is " + word2);
        System.out.println("word3 is " + word3);
        System.out.println("word4 is " + word4);

        // Compare the words

        System.out.println("\nComparing word1 and word2: " + word1.compareTo(word2));
        System.out.println("Comparing word1 and word3: " + word1.compareTo(word3));
        System.out.println("Comparing word2 and word1: " + word2.compareTo(word1));
        System.out.println("Comparing word1 and word4: " + word1.compareTo(word4));

        //Testing the constructor that generates a random String 

        Word randomWord = new Word(scrabbleSet6);
        Word randomWord2 = new Word(scrabbleSet6);

        System.out.println("\nRandom word 1: " + randomWord);
        System.out.println("Random word 2: " + randomWord2);

        //generate 10 random words and print them

        System.out.println("\n10 random words: ");
        for (int i = 0; i < 10; i++) {
            Word randomWord3 = new Word(scrabbleSet6);
            System.out.println(randomWord3);
        }




        //user input for the Word class
        Scanner scanner2 = new Scanner(System.in);
        System.out.print("\nHow many random words do you want to generate? ");
        
        if (scanner2.hasNextInt()) {
            int numWords = scanner2.nextInt();
            Word[] randomWords = new Word[numWords];
        
            // Generate random words
            for (int i = 0; i < numWords; i++) {
                randomWords[i] = new Word(scrabbleSet6);
            }
        
            // Print the random words and their scores
            System.out.println("\nGenerated random words and their scores:");
            for (Word randomWord4 : randomWords) {
                System.out.println(randomWord4);
            }
        } else {
            System.out.println("Invalid input. Please enter a valid number.");
        }
        scanner2.close();
        

        //Testing different sorting methods
      
        int smallSize = 10; // small demonstration size
        int[] largeSizes = {1000, 5000, 10000}; // Sizes for performace testing

        //Generate a small array for demonstration
        Word[] smallArray = generateRandomWords(smallSize, scrabbleSet6);
        System.out.println("\nUnsorted small array:");
        printArray(smallArray);

        //sort with Bubble Sort (o(n²)) and display results
        Word[] bubbleSortedArray = smallArray.clone(); //Clone to keep original intact
        bubbleSort(bubbleSortedArray);
        System.out.println("\nBubble Sorted Result:");
        printArray(bubbleSortedArray);

        //Sort with Merge Sort (O(n log n)) and display results
        Word[] mergeSortedArray = smallArray.clone(); //Clone to keep original intact
        mergeSort(mergeSortedArray);
        System.out.println("\nMerge Sorted Result:");
        printArray(mergeSortedArray);

        //Measure sorting time for increasing array sizes
        System.out.println("\nPerformance Sorting Test:");
        for (int size : largeSizes){
            Word[] largeArray = generateRandomWords(size, scrabbleSet6);


            //Measure Bubble Sort time
            Word[]arrayForBubble = largeArray.clone();
            shuffleArray(arrayForBubble); //shuffle before sorting
            long startBubble = System.nanoTime();
            bubbleSort(arrayForBubble);
            long endBubble = System.nanoTime();
            System.out.println("Bubble Sort Time for " + size + " words: " + (endBubble - startBubble) + " ns");

            //Measure Merge Sort time
            Word[] arrayForMerge = largeArray.clone();
            shuffleArray(arrayForMerge); //shuffle before sorting
            long startMerge = System.nanoTime();
            mergeSort(arrayForMerge);
            long endMerge = System.nanoTime();
            System.out.println("Merge Sort Time for " + size + " words: " + (endMerge - startMerge) + " ns");



        }

        //testing different search methods
        System.out.println("\nSearch Test:");

        // Testing different search methods
        for (int size : largeSizes) {
            System.out.println("\nTesting with list size: " + size);
    
            // Use a ScrabbleSet for all words
            ScrabbleSet testSet = new ScrabbleSet("English");
    
            // Generate random words with a consistent length (e.g., 5)
            List<Word> words2 = generateRandomWords(size, 5, testSet);

            // Sort the list for binary search
            Collections.sort(words2);

            // Select random words for searching
            Word targetFound = words2.get(new Random().nextInt(words2.size())); // Word that exists
            Word targetNotFound = new Word("zzzzz", testSet); // Word that does not exist

            // Perform searches for an item that exists
            System.out.println("\nSearch for an item that exists:");
            performSearch(words2, targetFound);

         // Perform searches for an item that does not exist
            System.out.println("\nSearch for an item that does not exist:");
            performSearch(words2, targetNotFound);
        }   

        
        System.out.println("\nTesting Java's Arrays.sort and Arrays.binarySearch:");
        for (int size : largeSizes) {
            System.out.println("\nTesting with array size: " + size);

            // Generate an array of random Word objects
            Word[] wordArray = generateRandomWords(size, scrabbleSet6);

            // Select random targets for searching
            Random random = new Random();
            Word targetFound = wordArray[random.nextInt(wordArray.length)]; // Target that exists
            Word targetNotFound = new Word("ZZZZZ", scrabbleSet6); // Target that doesn't exist

            // Measure sorting time using Arrays.sort
            long startSort = System.nanoTime();
            Arrays.sort(wordArray);
            long endSort = System.nanoTime();
            System.out.println("Arrays.sort time: " + (endSort - startSort) + " ns");

            // Perform binary search for an item that exists
            long startBinarySearch1 = System.nanoTime();
            int indexFound = Arrays.binarySearch(wordArray, targetFound);
            long endBinarySearch1 = System.nanoTime();
            if (indexFound >= 0) {
                System.out.println("Arrays.binarySearch (found): Found " + targetFound +
                        " at index " + indexFound + " in " + (endBinarySearch1 - startBinarySearch1) + " ns");
            } else {
                System.out.println("Arrays.binarySearch (found): Target not found in "
                        + (endBinarySearch1 - startBinarySearch1) + " ns");
            }

            // Perform binary search for an item that doesn't exist
            long startBinarySearch2 = System.nanoTime();
            int indexNotFound = Arrays.binarySearch(wordArray, targetNotFound);
            long endBinarySearch2 = System.nanoTime();
            if (indexNotFound >= 0) {
                System.out.println("Arrays.binarySearch (not found): Unexpectedly found " +
                        targetNotFound + " at index " + indexNotFound + " in " +
                        (endBinarySearch2 - startBinarySearch2) + " ns");
            } else {
                System.out.println("Arrays.binarySearch (not found): Target not found in " +
                        (endBinarySearch2 - startBinarySearch2) + " ns");
            }
        }
        

         
        
    
    }
    



    // Generate an array of random Word objects
    public static Word[] generateRandomWords(int numWords, ScrabbleSet scrabbleSet) {
        Word[] words = new Word[numWords];
        for (int i = 0; i < numWords; i++) {
            words[i] = new Word(scrabbleSet);
        }
        return words;
    }


    // Print the contents of a Word array
    public static void printArray(Word[] array) {
        for (Word word : array) {
            System.out.println(word);
        }
    }



    // Shuffle an array of Word objects
    public static void shuffleArray(Word[] array) {
        List<Word> wordList = Arrays.asList(array);
        Collections.shuffle(wordList);
        wordList.toArray(array);
    }
    
    
    // Bubble Sort (O(n²))
    public static void bubbleSort(Word[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    // Swap elements
                    Word temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Merge Sort (O(n log n))
    public static void mergeSort(Word[] array) {
        if (array.length <= 1) {
            return;
        }

        int mid = array.length / 2;

        // Split into two subarrays
        Word[] left = Arrays.copyOfRange(array, 0, mid);
        Word[] right = Arrays.copyOfRange(array, mid, array.length);

        // Recursively sort the subarrays
        mergeSort(left);
        mergeSort(right);

        // Merge the sorted subarrays
        merge(array, left, right);
    }

    // Merge two sorted arrays
    private static void merge(Word[] array, Word[] left, Word[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) <= 0) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        // Copy remaining elements
        while (i < left.length) {
            array[k++] = left[i++];
        }
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

    
    // Generate a list of random Word objects
    private static List<Word> generateRandomWords(int numWords, int length, ScrabbleSet scrabbleSet) {
        List<Word> words = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < numWords; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < length; j++) {
                char randomChar = (char) ('A' + random.nextInt(26));
                sb.append(randomChar);
            }
            words.add(new Word(sb.toString(), scrabbleSet));
        }

        return words;
    }

    

    // Perform sequential and binary search
    private static void performSearch(List<Word> words, Word target) {
        // Sequential (Linear) Search
        long startSequential = System.nanoTime();
        int sequentialIndex = sequentialSearch(words, target);
        long endSequential = System.nanoTime();

        if (sequentialIndex != -1) {
            System.out.println("Sequential Search: Found " + target + " at index " + sequentialIndex
                    + " in " + (endSequential - startSequential) + " ns.");
        } else {
            System.out.println("Sequential Search: " + target + " not found in "
                    + (endSequential - startSequential) + " ns.");
        }

        // Binary Search
        long startBinary = System.nanoTime();
        int binaryIndex = binarySearch(words, target);
        long endBinary = System.nanoTime();

        if (binaryIndex != -1) {
            System.out.println("Binary Search: Found " + target + " at index " + binaryIndex
                    + " in " + (endBinary - startBinary) + " ns.");
        } else {
            System.out.println("Binary Search: " + target + " not found in "
                    + (endBinary - startBinary) + " ns.");
        }
    }

    // Sequential (Linear) Search
    public static int sequentialSearch(List<Word> words, Word target) {
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).equals(target)) {
                return i;
            }
        }
        return -1; // Not found
    }

    // Binary Search
    public static int binarySearch(List<Word> words, Word target) {
        int left = 0;
        int right = words.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Word midWord = words.get(mid);

            if (midWord.equals(target)) {
                return mid; // Target found
            } else if (midWord.compareTo(target) < 0) {
                left = mid + 1; // Search the right half
            } else {
                right = mid - 1; // Search the left half
            }
        }

        return -1; // Not found
    }










}