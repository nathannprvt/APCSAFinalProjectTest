/**
 * Gives experience points to the player.
 */
import java.util.Random;

public class XP {

    private static final int MIN_EXPERIENCE = 10;
    private static final int MAX_EXPERIENCE = 100;
/**
     * Generates a random amount of experience points.
     * @return Randomly generated experience points.
     */
    public static int generateExperience() {
        Random random = new Random();
        return random.nextInt(MAX_EXPERIENCE - MIN_EXPERIENCE + 1) + MIN_EXPERIENCE;
    }

    
}