package com.wordle;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		
		/*
		 *  MMMMMMMMMMMMJACOB -- to get colors to work:
		 *  should work in terminal and vs code automatically, but can look 
		 *  into how to enable it into your editor. In eclipse, it was:
		 *  help > marketplace > ANSI escape in console > relaunch
		 */
		System.out.println(Colors.blueText("Welcome to Wordle! :)"));
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter your name:");
		String name = scanner.nextLine();
		
		//TO DO: scan if name in file. If existing, welcome them back and load stats.
		//Else say welcome to fist game, create player, print rules
        //For now....
		
		/*
		 * algorithm:
		 * 	read in text file
		 * 	convert each player into an object
		 * 		if no players, return no players // new player needed
		 * 	Map<String, Player> where string is player name and Player (value) is player object
		 *  	Convert hashmap so we can do easy lookup
		 *  Ask user for name
		 *  	Use hashmap to look up
		 *  		if found, prompt welcome back, load in player object info
		 *  		else prompt welcome and rules of the game. Create new Player, add to map
		 * 		
		 */


		// read in text file: ReadFile .java
		// if name exists in playerMap, 
		if(ReadFile.playerMap.get(name) == null){
			//is this how I check if null or is it is null
			System.out.println("Welcome, " + name);
			System.out.println("Here are the rules of Wordle:");
			System.out.println("Guess the hidden 5-letter word in 5 tries.");
			System.out.println();

			System.out.println("After each guess, you'll get feedback:");

			System.out.println("- " + Colors.tileGreen("GREEN") + "  → correct letter, correct position");
			System.out.println("- " + Colors.tileYellow("YELLOW") + " → correct letter, wrong position");
			System.out.println("- " + Colors.tileGray("GRAY") + "   → letter not in the word");

			System.out.println();
			System.out.println("Try to guess the word in as few attempts as possible!");
			System.out.println();

		}else{
			System.out.println("Welcome back, " + ReadFile.playerMap.get(name)+ "!");
		}
		

		Player player = new Player (name);
	    System.out.println(player);
	    scanner.close();

	}


}
