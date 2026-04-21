package com.wordle;

import java.util.Arrays; // Import the File class
import java.util.HashMap; // Import this class to handle errors
import java.util.List;
import java.util.Scanner;

public class ReadFile {
    // need to create constructor to initialize player hashmap?

    private static HashMap<String, Player> playerMap = new HashMap<>(); // should this be initialized here or in the method? line 18 seems redundant

    public static void ReadPlayers() {

        // We use the ClassLoader to find the file inside the 'resources' folder
        try (Scanner myReader = new Scanner(ReadFile.class.getResourceAsStream("/Players.txt"))) {

            playerMap = new HashMap<>();

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                // parse data to give player object:
                // name,wins1,wins2,wins3,wins4,wins5,losses,streak
                List<String> playerStats = Arrays.asList(data.split(","));

                Player currentPlayer = new Player(playerStats.get(0), Integer.parseInt(playerStats.get(1)),
                        Integer.parseInt(playerStats.get(2)), Integer.parseInt(playerStats.get(3)),
                        Integer.parseInt(playerStats.get(4)), Integer.parseInt(playerStats.get(5)),
                        Integer.parseInt(playerStats.get(6)), Integer.parseInt(playerStats.get(7)), Integer.parseInt(playerStats.get(8)));
                // System.out.println(currentPlayer); //check loaded values are correct
                // now add Player to Map
                // I guess in theory, we do not need to store name for person since it's the
                // key...
                // and doesn't get used otherwise?

                playerMap.put(currentPlayer.getName().toLowerCase(), currentPlayer); // key is Diana, value is Player Object
            }
            // once we have all players, hashmap has been loaded
            // check if player exists in game. If so, welcome them
            // else create new player
            // should the above be done here or in game?
        } catch (NullPointerException e) {
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
