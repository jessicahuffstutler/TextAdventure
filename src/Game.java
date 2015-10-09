import java.util.Scanner;

/**
 * Created by jessicahuffstutler on 10/8/15.
 */
public class Game {
    public static void run() throws Exception {
        System.out.println("Welcome to my text adventure.");

        Player player = new Player(); //how to create the player
        player.chooseName(); //call those three methods from Player class
        player.chooseWeapon(); //call those three methods from Player class
        player.chooseArea(); //call those three methods from Player class
    }

    static String nextLine() { //new method, like a utility function, not public bc we will not call this from the JREPL and needs to be static so it can be called anytime.
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if (s.startsWith("/")) {
            if (s.equals("/help")) {
                System.out.println("These are the available commands:");
                System.out.println("/help => List available commands");
            }
            return nextLine(); //call a function inside of itself; it's going to call itself again and read itself again and if it's a forward slash, it will do it all again until it's not a forward slash
        } else {
            return s;
        }
    }
}
