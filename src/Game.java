import java.util.Scanner;

/**
 * Created by jessicahuffstutler on 10/8/15.
 */
public class Game {
    static Player player; //Static field, diff than static method, storing in global object

    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to my text adventure.");
        player = new Player(); //calling the static field player

        player.chooseName(); //call those three methods from Player class
        player.chooseWeapon(); //call those three methods from Player class
        player.chooseArea(); //call those three methods from Player class
        player.findItem("Shield");

        Enemy ogre = new Enemy("Ogre", 50, 5);
        player.battle(ogre);
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
                for (Object item : player.items) { //declare a variable that represents that particular item in parenthesis
                    System.out.println(item); //technically, you could put this in an else clause
                }
            }
            return nextLine(); //(recursion, call the method again) call a function inside of itself; it's going to call itself again and read itself again and if it's a forward slash, it will do it all again until it's not a forward slash
        } else {
            return s;
        }
    }
}
