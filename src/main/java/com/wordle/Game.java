package com.wordle;

import java.util.Scanner;

public class Game {

    public static void main(String[] args) {

        System.out.println(Colors.blueText("Welcome to Wordle! :)"));
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name:");
        String name = scanner.nextLine().toLowerCase();

        Player currentPlayer;

        // TO DO: scan if name in file. If existing, welcome them back and load stats.
        // Else say welcome to fist game, create player, print rules
        // For now....

        /*
		 * algorithm: read in text file convert each player into an object if no
		 * players, return no players // new player needed Map<String, Player> where
		 * string is player name and Player (value) is player object Convert hashmap so
		 * we can do easy lookup Ask user for name Use hashmap to look up if found,
		 * prompt welcome back, load in player object info else prompt welcome and rules
		 * of the game. Create new Player, add to map
		 * 
         */
        ReadFile.ReadPlayers(); // should the method be main? Or something else?
        if (ReadFile.getPlayerMap().get(name) == null) { // if player DOES NOT exist in map
            // is this how I check if null or is it is null
            System.out.println();
            System.out.println("Welcome, " + name + "!");
            System.out.println("Here are the rules of Wordle:");
            System.out.println("Guess the hidden 5-letter word in 5 tries.");
            System.out.println();

            System.out.println("After each guess, you'll get feedback:");

            System.out.println(Colors.greenBackground("Green letter") + " -- correct letter, correct position");
            System.out.println(Colors.yellowBackground("Yellow letter") + " -- correct letter, wrong position");
            System.out.println(Colors.grayBackground("Gray letter") + " -- letter not in the word");

            System.out.println();
            System.out.println("Try to guess the word in as few attempts as possible!");
            System.out.println();

            currentPlayer = new Player(name);
            ReadFile.getPlayerMap().put(name, currentPlayer);

        } else {
            currentPlayer = ReadFile.getPlayerMap().get(name);
            System.out.println("Welcome back, " + currentPlayer.getName() + "!");
        }

        // we're going to also want to show which letters have been guessed already and
        // color code
        // based on if in puzzle or not -- maybe a later feature?
        //ALSO, currently name is case sensitive -- so diana and Diana are two different people
        currentPlayer = ReadFile.getPlayerMap().get(name);
        System.out.println(currentPlayer);
        scanner.close();

    }

}
