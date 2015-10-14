import java.util.ArrayList;

/**
 * Created by jessicahuffstutler on 10/9/15.
 */
public class Player extends Character {
    String area;
    ArrayList items = new ArrayList();

    public Player() { //constructor
        health = 100; //set health
        damage = 20; //set damage
    }

    void chooseName() {
        System.out.println("What is your name, traveler?");
        name = Game.nextLine(); //replaced two lines with this so that we do not have to continuously call on the scanner; we also did this below
        System.out.println(String.format("Good luck, %s", name)); //using updated string printing sytax
    }

    void chooseWeapon() throws Exception { //method
        System.out.println("[1] Pick up a sword");
        System.out.println("[2] Pick up a mallet");
        int weaponNum = Integer.valueOf(Game.nextLine()); //we are calling the method Game.nextLine() and the result is Integer.valueOf
        if (weaponNum == 1) {
            weapon = new Weapon();
            weapon.name = "Sword";
            weapon.damage = 10;
        } else if (weaponNum == 2) { //using "else if" because we only want to allow the input "1" or "2". It should throw an error if you put 3 or anything else.
            weapon = new Weapon();
            weapon.name = "Mallet";
            weapon.damage = 10;
        } else {
            throw new Exception("Invalid weapon.");
        }
        System.out.println(String.format("That's a fine %s!", weapon.name.toLowerCase()));
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
            System.out.println(String.format("You found a %s", item)); //using updated string format syntex
            items.add(item);
        }
    }
}