/**
 * Created by jessicahuffstutler on 10/13/15.
 */
public class Character {
    String name;
    int health;
    int damage;
    Weapon weapon;

    void battle(Character opponent) { //constructor with one argument "Character", two character objects, one who calls a battle method and one that is inside of it.
        System.out.println(String.format("%s commences battle with %s", name, opponent.name)); //We are saying that we are calling the battle method on the player object, and we are in the player now, so we just need name for the first %s
        while (health > 0 && opponent.health > 0) { //this says the character running the method is alive or the enemy is alive
            health -= opponent.damage + opponent.weapon.damage; //takes the health and removes the damage from it
            opponent.health -= damage + weapon.damage; //tekes the opponents health and removes our damage from it
            System.out.println(String.format("%s's health: %d, %s's health: %d", name, health, opponent.name, opponent.health));
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
