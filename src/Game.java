import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * Created by jessicahuffstutler on 10/8/15.
 */
public class Game {
    static Player player; //Static field, diff than static method, storing in global object
    static final String FILE_NAME = "save.json";

    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to my text adventure.");
        player = loadGame();

        if (player == null) {
            player = new Player();
            player.chooseName(); //call those three methods from Player class
            player.chooseWeapon(); //call those three methods from Player class
            player.chooseArea(); //call those three methods from Player class
        }

        player.findItem("Shield");
        player.findItem("Boots");

        Weapon ogreWeapon = new Weapon();
        ogreWeapon.name = "Club";
        ogreWeapon.damage = 5;
        Enemy ogre = new Enemy("Ogre", 50, 5, ogreWeapon);

        player.battle(ogre); //pass enemy into the battle method

        saveGame();
    }

    static String nextLine() { //new method, like a utility function, not public bc we will not call this from the JREPL and needs to be static so it can be called anytime.
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if (s.startsWith("/")) {
            if (s.equals("/help")) {
                System.out.println("These are the available commands:");
                System.out.println("/help => List available commands");
            } else if (s.equals("/exit")) {
                System.exit(0); //means nothing wrong happened, i just wanted to shut it down.
            } else if (s.equals("/inv")) { //inv would be inventory?
                if (player.items.size() == 0) {
                    System.out.println("You have no items.");
                }
                for (String item : player.items) { //declare a variable that represents that particular item in parenthesis
                    System.out.println(item); //technically, you could put this in an else clause
                }
            }
            return nextLine(); //(recursion, call the method again) call a function inside of itself; it's going to call itself again and read itself again and if it's a forward slash, it will do it all again until it's not a forward slash
        } else {
            return s;
        }
    }

    static void saveGame() { //method: save game
        File f = new File(FILE_NAME); //json library wants you to set getters for anything you want to save
        JsonSerializer serializer = new JsonSerializer();
        String contentToSave = serializer.serialize(player);//serialize the player

        try {
            FileWriter fw = new FileWriter(f);
            fw.write(contentToSave);
            fw.close();
        } catch (Exception e) {

        }
    }

    static Player loadGame() {
        try {
            File f = new File(FILE_NAME);
            FileReader fr = new FileReader(f);
            int fileSize = (int) f.length(); //how big is the file?, we are casting it to and int by using (int) in the line since it wants to be a "long" which is double the size of an int
            char[] contents = new char[fileSize];
            fr.read(contents);
            String fileContents = new String(contents);
            JsonParser parser = new JsonParser();
            return parser.parse(fileContents, Player.class);
        } catch (Exception e) {
            return null;
        }
    }
}
