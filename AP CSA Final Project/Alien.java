public class Alien {
    private String name;
    private int damageOutput;
    private int health;
// Constructor
public Alien(String name, int damageOutput, int health) {
    this.name = name;
    this.damageOutput = damageOutput;
    this.health = health;
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