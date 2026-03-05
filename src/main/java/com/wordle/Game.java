package com.wordle;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		
		/*
		 *  MMMMMMMMMMMMJACOB -- to get colors to work:
		 *  should work in windows terminal automatically, but can look 
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
		Player player = new Player (name);
	    System.out.println(player);
	    scanner.close();

	}


}
