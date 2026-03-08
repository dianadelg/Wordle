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
		Player player = new Player (name);
	    System.out.println(player);
	    scanner.close();

	}


}
