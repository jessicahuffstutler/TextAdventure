import java.util.Scanner;

/**
 * Created by jessicahuffstutler on 10/9/15.
 */
public class Player {
    String name;
    String weapon;
    String area;

    void chooseName(){ //Merric, when do we use curly braces and when to use semi colon?
        System.out.println("What is your name, traveler?");
        Scanner scanner = new Scanner(System.in);
        name = scanner.nextLine(); //get rid of where it said "String name = scanner.nextLine();" and just put "name = scanner.nextLine();" to save the name and have it call the name from the field above
        System.out.println("Good luck, " + name);
    }

    void chooseWeapon() throws Exception {
        System.out.println("[1] Pick up a sword");
        System.out.println("[2] Pick up a mallet");
        Scanner scanner = new Scanner(System.in);
        weapon = scanner.nextLine(); //we removed the first word "String" as above so that we are using the weapon field and it is storing what weapon we chose
        int weaponNum = Integer.valueOf(weapon); //the argument is a string, it will return a number
        if (weaponNum == 1) {
            System.out.println("That's a fine sword!");
        } else if (weaponNum == 2) { //using "else if" because we only want to allow the input "1" or "2". It should throw an error if you put 3 or anything else.
            System.out.println("That's a heavy mallet!");
        } else {
            throw new Exception("Invalid weapon.");
        }
    }

    void chooseArea() throws Exception {
        System.out.println("[1] Enter the forest");
        System.out.println("[2] Enter the underground tunnel");
        Scanner scanner = new Scanner(System.in);
        area = scanner.nextLine(); //remove "String" (before area) as above so it saves it to that field
        int areaNum = Integer.valueOf(area);
        if (area.equals("1")) {
            System.out.println("Entering the forest...");
        } else if (area.equals("2")) {
            System.out.println("Entering the tunnel...");
        } else {
            throw new Exception("Invalid area.");
        }
    }
}
