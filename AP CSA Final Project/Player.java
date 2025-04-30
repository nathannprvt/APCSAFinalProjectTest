/**
 * Player class that the user will control.
 */
public class Player {
    private String name;
    private int health = 100;
    private int experienceLevel = 0;

    // Constructor
    public Player(String name) {
        this.name = name;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void increaseHealth(int health) {
        this.health += health;
    }

    public int getExperienceLevel() {
        return experienceLevel;
    }

    public void setExperienceLevel(int experienceLevel) {
        this.experienceLevel += experienceLevel;
    }

    // Method to display player information
    public String toString() {
        // Display player information
        return name + " has " + health + " health and " + experienceLevel + " experience level.";
    }
}