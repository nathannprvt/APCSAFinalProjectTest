import java.util.Random;

/**
 * 
 * This class represents a UFO alien in the game.
 * Subclass of Alien.
 */


public class UFO extends Alien {
    // Fields
    private int speed; // Speed variable to determine dodging ability

    // Constructor
    public UFO(int damage, int speed) {
        super(damage);
        this.speed = speed;
    }

    // Getter for speed
    public int getSpeed() {
        return speed;
    }

    // Setter for speed
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /*
     * Method that enables UFO to dodge attacks.
     * The chance to dodge is based on the speed of the UFO.
     * 
     * @return true if the UFO dodges the attack, false otherwise.
     */
    public boolean dodgeAttack() {
        Random random = new Random();
        int dodgeChance = random.nextInt(100); // Random number between 0 and 99
        return dodgeChance < speed; // Higher speed increases chance to dodge
    }

    
}