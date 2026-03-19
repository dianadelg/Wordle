import java.io.File;                  // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner;             // Import the Scanner class to read text files
import java.utils.HashMap; 
import java.utils.List;

private HashMap<String,Player> playerMap; //is this how we initialize it? is this the class where we'd put it?

public class ReadFile {
    //need to create constructor to initialize player hashmap?    
  public static void main(String[] args) {
    File myObj = new File("Players.txt"); //need to check path

    // try-with-resources: Scanner will be closed automatically
    try (Scanner myReader = new Scanner(myObj)) {
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        System.out.println(data); //data is the line
        //parse data to give player object name,wins1,wins2,wins3,wins4,wins5,losses,streak
        //need to use delimeter ","
        List<String> playerStats = Arrays.asList(data.split(","));
        //playerStats contains each element -- double check this
        Player currentPlayer = new Player(playerStats[0], playerStats[1], playerStats[2], playerStats[3]
            playerStats[4], playerStats[5], playerStats[6], playerStats[7]
         );
         System.out.println(Player); //check values are correct
         //now add Player to Map
         //I guess in theory, we do not need to store name for person since it's the key
         //and doesn't get used otherwise?
         this.playerMap = new HashMap<String, Player>();
         playerMap.put(currentPlayer.getName(), currentPlayer); //key is Diana, value is Player Object
      }
      //once we have all players, hashmap has been loaded
      //check if player exists in game. If so, welcome them
      //else create new player
      //should the above be done here or in game?
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
      //we need to return this error to game, so it terminates entire game
    }
  }
}