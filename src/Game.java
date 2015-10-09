/**
 * Created by jessicahuffstutler on 10/8/15.
 */
public class Game {
    public static void run() throws Exception {
        System.out.println("Welcome to my text adventure.");

        Player player = new Player(); //how to create the player
        player.chooseName(); //call those three methods from Player.java
        player.chooseWeapon(); //call those three methods from Player.java
        player.chooseArea(); //call those three methods from Player.java
    }
}
