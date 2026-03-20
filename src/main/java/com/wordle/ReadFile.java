package com.wordle;

import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.*;

public class ReadFile {
	// need to create constructor to initialize player hashmap?
	private static HashMap<String, Player> playerMap = new HashMap<>();

	public static void ReadPlayers() {
		File myObj = new File("src/main/resources/Players.txt"); // need to eventually switch to classpath

		try (Scanner myReader = new Scanner(myObj)) {
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();

				// parse data to give player object:
				// name,wins1,wins2,wins3,wins4,wins5,losses,streak

				List<String> playerStats = Arrays.asList(data.split(","));

				Player currentPlayer = new Player(playerStats.get(0), Integer.parseInt(playerStats.get(1)),
						Integer.parseInt(playerStats.get(2)), Integer.parseInt(playerStats.get(3)),
						Integer.parseInt(playerStats.get(4)), Integer.parseInt(playerStats.get(5)),
						Integer.parseInt(playerStats.get(6)), Integer.parseInt(playerStats.get(7)));
				// System.out.println(currentPlayer); //check loaded values are correct
				// now add Player to Map
				// I guess in theory, we do not need to store name for person since it's the
				// key...
				// and doesn't get used otherwise?
				playerMap = new HashMap<String, Player>();
				playerMap.put(currentPlayer.getName(), currentPlayer); // key is Diana, value is Player Object
			}
			// once we have all players, hashmap has been loaded
			// check if player exists in game. If so, welcome them
			// else create new player
			// should the above be done here or in game?
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
			// we need to return this error to game, so it terminates entire game
		}
	}

	public static HashMap<String, Player> getPlayerMap() {
		return playerMap;
	}

	public static void setPlayerMap(HashMap<String, Player> playerMap) {
		ReadFile.playerMap = playerMap;
	}

}