package com.wordle;

import java.util.Random;

public class WordBank {

    // A small starting list - you can expand this to 1000s later!
    private String[] words = {"CRANE", "STARE", "PLANT", "SHIRT", "ROBOT", "GLASS"};
    private String secretWord;

    public WordBank() {
        // Pick a random word when the bank is initialized
        Random rand = new Random();
        this.secretWord = words[rand.nextInt(words.length)];
    }

    public String getSecretWord() {
        return this.secretWord;
    }

    public boolean isValidGuess(String guess) {
        // Wordle only allows 5-letter words
        return guess != null && guess.length() == 5;
    }
}
