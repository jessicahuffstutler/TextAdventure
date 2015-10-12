import java.util.ArrayList;

/**
 * Created by jessicahuffstutler on 10/9/15.
 */
public class Player {
    String name;
    String weapon;
    String area;
    ArrayList items = new ArrayList(); //had to import ArrayList by using option, enter

    void chooseName(){ //Merric, when do we use curly braces and when to use semi colon?
        System.out.println("What is your name, traveler?");
        name = Game.nextLine(); //replaced two lines with this so that we do not have to continuously call on the scanner; we also did this below
        System.out.println("Good luck, " + name);
    }

    void chooseWeapon() throws Exception { //method
        System.out.println("[1] Pick up a sword");
        System.out.println("[2] Pick up a mallet");
        weapon = Game.nextLine();
        int weaponNum = Integer.valueOf(weapon); //the argument is a string, it will return a number
        if (weaponNum == 1) {
            System.out.println("That's a fine sword!");
        } else if (weaponNum == 2) { //using "else if" because we only want to allow the input "1" or "2". It should throw an error if you put 3 or anything else.
            System.out.println("That's a heavy mallet!");
        } else {
            throw new Exception("Invalid weapon.");
        }
    }

    void chooseArea() throws Exception { //method
        System.out.println("[1] Enter the forest");
        System.out.println("[2] Enter the underground tunnel");
        area = Game.nextLine();
        int areaNum = Integer.valueOf(area);
        if (area.equals("1")) {
            System.out.println("Entering the forest...");
        } else if (area.equals("2")) {
            System.out.println("Entering the tunnel...");
        } else {
            throw new Exception("Invalid area.");
        }
    }

    void findItem(String item) {
        System.out.println("Found item! Pick it up? [y/n]");
        String s = Game.nextLine(); //WHY ARE WE USING THIS HERE?
        if (s.equals("y")) {
            System.out.println("You found a " + item);
            items.add(item);
        }
    }
}