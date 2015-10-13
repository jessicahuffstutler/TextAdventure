/**
 * Created by jessicahuffstutler on 10/13/15.
 */
public class Character {
    String name;
    int health;
    int damage;

    void battle(Character opponent) { //constructor with one argument "Character", two character objects, one who calls a battle method and one that is inside of it.
        while (health > 0 && opponent.health > 0) { //this says the character running the method is alive or the enemy is alive
            health -= opponent.damage; //takes the health and removes the damage from it
            opponent.health -= damage; //tekes the opponents health and removes our damage from it
        }

        String deadMessage = "%s has been killed!";

        if (health <= 0) {
            System.out.println(String.format(deadMessage, name)); //if i set name to jess, this will say "jess has been killed!"
        }

        if (opponent.health <= 0) {
            System.out.println(String.format(deadMessage, opponent.name));
        }
    }
}
