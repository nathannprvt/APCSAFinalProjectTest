/**
 * weapon class the user will modify at the beggining of the game and fight aliens with
 */
public class Weapon {
    private String name;
    private int damage;

    // Constructor
    public Weapon(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for damage
    public int getDamage() {
        return damage;
    }

    // Setter for damage
    public void setDamage(int damage) {
        this.damage = damage;
    }


    @Override
    public String toString() {
        return name + " has " + damage + " damage.";
    }
}