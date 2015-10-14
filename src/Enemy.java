/**
 * Created by jessicahuffstutler on 10/13/15.
 */
public class Enemy extends Character{
    public Enemy(String name, int health, int damage, Weapon weapon) { //constructor where we set the enemies name here.
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.weapon = weapon;
    }
}
