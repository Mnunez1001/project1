package com.example;
import java.util.ArrayList;
import java.util.Random;

public class ScrabbleSet {

    // instance variables
    private ArrayList<Tile> tiles;
    private ArrayList<Integer> tileCount;
    private String language;
    private char[] letters = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',' '};
    private Random rand = new Random();

    public ScrabbleSet(){
        this("English");
    }

    // Parameterized constructor

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

    // Constructor for Randomzed Scrabble Set

    public ScrabbleSet(boolean randomized){
        tiles = new ArrayList<Tile>();
        tileCount = new ArrayList<Integer>();
        
        if(randomized){
            initializeRandomScrabbleSet();

        }else{
            System.out.println("Unsupported initialization method.");

        }

    }



    //englishSet method
    private void englishSet(){
            //char[] letters = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',' '};
            int[] values = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10,0};
            int[] counts = {9,2,2,4,12,2,3,2,9,1,1,4,2,6,8,2,1,6,4,6,4,2,2,1,2,1,2};
            
            for(int i = 0; i < letters.length; i++){
                tiles.add(new Tile(letters[i], values[i]));
                tileCount.add(counts[i]);
            }




    }

    //initializeRandomScrabbleSet method
    private void initializeRandomScrabbleSet(){
        //char[] letters = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',' '};
        int[] values = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10,0};

        int totalTiles = 100;
        int remainingTiles = totalTiles - letters.length;

        // add 1 title to each Letter
        for(int i = 0; i < letters.length; i++){
            tiles.add(new Tile(letters[i], values[i]));
            tileCount.add(1);
        }

        // Distribute remaining tiles randomly, favoring vowels
        String vowels = "AEIOU";
        while (remainingTiles > 0){
            int index = rand.nextInt(letters.length);
            char letter = letters[index];

            //favor vowels by increasing their probability
            if(vowels.indexOf(letter) != -1 && rand.nextDouble() < 0.6){
                
                tileCount.set(index, tileCount.get(index) + 1);
                remainingTiles--;

            } else if (vowels.indexOf(letter) == -1 && rand.nextDouble() < 0.4) {

                tileCount.set(index, tileCount.get(index) + 1);
                remainingTiles--;

            }
        }

        // no letter exceeds more than 12 count

        int maxCount = 12;

        for (int i = 0; i < tileCount.size(); i++){

            if (tileCount.get(i) > maxCount){
                int diff = tileCount.get(i) - maxCount;
                tileCount.set(i, maxCount);
                remainingTiles += diff;
            }

        }

        // redistribute any leftover tiles 

        while (remainingTiles > 0){
            int index = rand.nextInt(letters.length);
            tileCount.set(index, tileCount.get(index) + 1);
            remainingTiles--;
        }

    }

    // getters and setters for ArrayList<Tile> tiles and ArrayList<Integer> tileCount

    public ArrayList<Tile> getTiles() {
        return tiles;
    }
    
    public void setTiles(ArrayList<Tile> tiles) {
        this.tiles = tiles;
    }

    public ArrayList<Integer> getTileCount() {
        return tileCount;
    }

    public void setTileCount(ArrayList<Integer> tileCount) {
        this.tileCount = tileCount;
    }


    // toString method

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
    //this is the only line that I added but not sure how it works %100.
    footer += "Total Tiles: " + tileCount.stream().mapToInt(Integer::intValue).sum() + "\n";

    return header + body + footer;
}


// other method

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
        for (int i = 0; i < letters.length; i++){
            if(letters[i] == c){
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
