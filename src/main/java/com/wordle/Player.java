package com.wordle;

/*
    TO DO: we need to create a file reader class that will read if a user exists or not, and if so:
    will need to load in stats. Will create separate file handler service of sorts :D 
*/

public class Player {
    private String name;
    private int winsIn5; // keeps track of how many wins in 5 guesses, etc
    private int winsIn4;
    private int winsIn3;
    private int winsIn2;
    private int winsIn1;
    private int losses;
    private int streakCount; // keeps track of any streaks -- updated +1 if any type of win

    public Player(String name){
        // Create new player not in file. Set name
        this.name = name;
        this.winsIn1 = 0;
        this.winsIn2 = 0;
        this.winsIn3 = 0;
        this.winsIn4 = 0;
        this.winsIn5 = 0;
        this.losses = 0;
        this.streakCount = 0;
    }

    public Player (String name, int winsIn1, int winsIn2, int winsIn3, int winsIn4, int winsIn5, int losses, int streakCount){
        // For existing player from file, set player statistics accordingly
        this.name = name;
        this.winsIn1 = winsIn1;
        this.winsIn2 = winsIn2;
        this.winsIn3 = winsIn3;
        this.winsIn4 = winsIn4;
        this.winsIn5 = winsIn5;
        this.losses = losses;
        this.streakCount = streakCount;
    }

    public void wonGame(int rounds){
        // increments win count based on the number of rounds it took to solve the word
        switch (rounds) {
        case 1:
            this.winsIn1++;
            break;
        case 2:
            this.winsIn2++;
            break;
        case 3:
            this.winsIn3++;
            break;
        case 4:
            this.winsIn4++;
            break;
        case 5:
            this.winsIn5++;
            break;
        }

        // increment streak count
        this.streakCount++;
    }

    public void loseGame(){
        // increment losses, reset streak
        this.losses++;
        this.streakCount=0;
    }

    public int calculateTotalWins(){
        // used for analytics
        return this.winsIn1 + this.winsIn2 + this.winsIn3 + this.winsIn4 + this.winsIn5;
    }

    @Override
    public String toString() {
        StringBuilder analytics = new StringBuilder();

    analytics.append("-----------------------").append(System.lineSeparator());
    analytics.append("Wordle Stats for: ").append(this.name).append(System.lineSeparator());
    analytics.append("------------------------").append(System.lineSeparator());
    analytics.append("Wins in 1 round: ").append(this.winsIn1).append(System.lineSeparator());
    analytics.append("Wins in 2 round: ").append(this.winsIn2).append(System.lineSeparator());
    analytics.append("Wins in 3 round: ").append(this.winsIn3).append(System.lineSeparator());
    analytics.append("Wins in 4 round: ").append(this.winsIn4).append(System.lineSeparator());
    analytics.append("Wins in 5 round: ").append(this.winsIn5).append(System.lineSeparator());
    analytics.append("------------------------").append(System.lineSeparator());
    analytics.append("Total wins: ")
      .append(calculateTotalWins())
      .append("      Total losses: ")
      .append(this.losses)
      .append(System.lineSeparator());
    analytics.append("------------------------");

    return analytics.toString();
    }

}