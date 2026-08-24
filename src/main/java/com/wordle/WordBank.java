package com.wordle;
import java.util.List;
import java.util.Scanner;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;

public class WordBank {

    private List<String> words = new ArrayList<>(); //used to load words from file as a list (for random selection) 
    private HashSet<String> validWords = new HashSet<>(); //check for validity - - does it exist in list of valid words?
    //we're doing both to optimize, we don't want to run through that giant list each time
    
    public WordBank() {
    	//load words from text file
		loadWords();
    }
    
    public String getRandomWord() {
    	//check if Words.txt has 0 words/load yielded 0 words
        if (this.words.isEmpty()) {
            throw new IllegalStateException("No words available. Check Words.txt.");
        }
        int randomIndex = (int) (Math.random() * this.words.size());
        return this.words.get(randomIndex);
    }
    
    //keep it private because this is an internal set up method
    //no one else should access it outside of this class :)))
	private void loadWords() {
	    InputStream input = WordBank.class.getResourceAsStream("/Words.txt");

	    if (input == null) {
	        System.out.println("Words.txt could not be found.");
	        return; // stop the method
	    }
	    
		// load the words from the text file into words and validWords
		try (Scanner myReader = new Scanner(input)) {
			while (myReader.hasNextLine()) {
				String word = myReader.nextLine().trim().toUpperCase();
				this.words.add(word);// add word to list
				this.validWords.add(word);// add word to HashSet
			}
		}
	}

    // A note on logic:
    /*We're only going to check if a word exists (is valid) in here, because that is pertinent to WordBank
     * Game -- will check length, will check if previously guessed, because this deals with Game state
     */
    public boolean isValidWord(String guess) {
        // Is this a valid dictionary word
       return this.validWords.contains(guess);
    }
    
	//no getters/setters for list or hashset
    //because we do not need/want people seeing/changing the words!!!
}