/**
 * alien class which is a superclass
 * of the UFO class and represents
 * the objects the user will fight
 * against in the game.
 * 
 */
public class Alien {
    private String name = "Alien";
    private int damageOutput;
    private int health = 100;
// Constructor
public Alien(int damageOutput) {
    this.damageOutput = (int) (Math.random() * 11) + 10;
}

// Getter for name
public String getName() {
    return name;
}

// Setter for name
public void setName(String name) {
    this.name = name;
}

// Getter for damageOutput
public int getDamageOutput() {
    return damageOutput;
}

// Setter for damageOutput
public void setDamageOutput(int damageOutput) {
    this.damageOutput = damageOutput;
}

// Getter for health
public int getHealth() {
    return health;
}

// Setter for health
public void setHealth(int health) {
    this.health = health;
}

// Method to display Alien details
@Override
public String toString() {
    return "Alien{name='" + name + "', damageOutput=" + damageOutput + ", health=" + health + "}";
}

}