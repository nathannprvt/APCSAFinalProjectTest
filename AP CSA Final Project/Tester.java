/**
 * This class has the main method to run the game.
 */
import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

        // Welcome the user to the game
        System.out.println("Welcome to Moon Explorer!");
        System.out.println("Prepare for an exciting adventure on the lunar surface and watch out for aliens!");

        // Ask for player name
        System.out.print("Enter your player name: ");
        String playerName = scanner.nextLine();

        // Ask for weapon choice
        System.out.print("Choose your weapon: ");
        String weapon = scanner.nextLine();

        // Display the inputs
        System.out.println("Welcome, " + playerName + "! You have chosen the " + weapon + " as your weapon.");

        // Set player details
        Player player = new Player(playerName);

        // Ask for weapon details
        System.out.print("Enter weapon damage: ");
        int weaponDamage = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Set weapon details
        new Weapon(weapon, weaponDamage); // Initialize weapon but do not store unused variable

        // Initialize player health and map
        int playerHealth = 100; // Initial player health
        // Removed unused grid variable
        boolean[][] clearedTiles = new boolean[5][5]; // Track cleared tiles
        int clearedCount = 0;

        // Declare surrendered variable
        boolean surrendered = false;

        // Alien and UFO representations as 2D arrays
        String[][] alienRepresentation = {
            {"   .-\"\"\"\"\"-.   "},
            {"  /         \\  "},
            {" /  O     O  \\ "},
            {"|     .-.     |"},
            {" \\   '---'   / "},
            {"  '-._____.-'  "}
        };

        String[][] ufoRepresentation = {
            {"     _____     "},
            {"  __/     \\__  "},
            {" /  o       o \\ "},
            {"|               |"},
            {" \\__       __/  "},
            {"    \\_____/     "}
        };

        // Game loop
        while (playerHealth > 0 && clearedCount < 25 && !surrendered) {
            // Display the 5x5 grid with cleared tiles marked
            System.out.println("This is your map:");
            for (int i = 0; i < 5; i++) {
                System.out.println("+---+---+---+---+---+"); // Top border of each row
                for (int j = 0; j < 5; j++) {
                    int currentTile = i * 5 + j + 1;
                    if (clearedTiles[i][j]) {
                        System.out.print("| X "); // Mark cleared tiles
                    } else {
                        System.out.print("| " + currentTile + (currentTile < 10 ? " " : ""));
                    }
                }
                System.out.println("|"); // Right border of the row
            }
            System.out.println("+---+---+---+---+---+"); // Bottom border of the grid

            // Prompt the user to choose a tile or surrender
            System.out.print("Enter the tile number you want to go to (1-25) or type 'surrender' to quit: ");
            String input = scanner.nextLine();

            // Check if the user wants to surrender
            if (input.equalsIgnoreCase("surrender")) {
                surrendered = true; // Set surrendered to true when the player chooses to quit
                break;
            }

            int tileChoice;
            try {
                tileChoice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 25 or 'surrender'.");
                continue;
            }

            // Validate the tile choice
            if (tileChoice < 1 || tileChoice > 25) {
                System.out.println("Invalid tile number. Please choose a number between 1 and 25.");
                continue;
            }

            int row = (tileChoice - 1) / 5;
            int col = (tileChoice - 1) % 5;

            if (clearedTiles[row][col]) {
                System.out.println("This tile has already been cleared. Choose another tile.");
                continue;
            }

            System.out.println("You have chosen to move to tile " + tileChoice + " located at row " + (row + 1) + ", column " + (col + 1) + ".");

            // Generate a random enemy (Alien or UFO)
            String enemyType = Math.random() < 0.5 ? "Alien" : "UFO";
            String enemyName = enemyType.equals("Alien") ? "Lunar Alien" : "Flying UFO";
            int enemyHealth = (int) (Math.random() * 50) + 50; // Random health between 50 and 100
            int enemyDamage = (int) (Math.random() * 10) + 10; // Random damage between 10 and 20

            // If the enemy is a UFO, add a random speed variable
            int enemySpeed = 0;
            if (enemyType.equals("UFO")) {
                enemySpeed = (int) (Math.random() * 31) + 20; // Random speed between 20 and 50
                System.out.println("The UFO has a speed of " + enemySpeed + ".");
            }

            // Display enemy appearance
            System.out.println("Prepare for a fight!");
            if (enemyType.equals("Alien")) {
                System.out.println("You have encountered a Lunar Alien!");
                for (String[] line : alienRepresentation) {
                    System.out.println(line[0]);
                }
            } else {
                System.out.println("You have encountered a Flying UFO!");
                for (String[] line : ufoRepresentation) {
                    System.out.println(line[0]);
                }
            }

            System.out.println("Health: " + enemyHealth);
            System.out.println("Damage Output: " + enemyDamage);

            // Combat loop
            while (playerHealth > 0 && enemyHealth > 0) {
                // Player's turn to attack
                System.out.println("Your turn to attack!");
                System.out.println("You attack the " + enemyName + " with your " + weapon + ".");
                
                // Check if the enemy is a UFO and if it dodges the attack
                if (enemyType.equals("UFO")) {
                    int dodgeChance = (int) (Math.random() * 100) + 1; // Random chance between 1 and 100
                    if (dodgeChance <= enemySpeed) {
                        System.out.println("The UFO dodged your attack with its speed of " + enemySpeed + "!");
                    } else {
                        enemyHealth -= weaponDamage;
                        if (enemyHealth <= 0) {
                            System.out.println("You have defeated the " + enemyName + "!");
                            break;
                        }
                        System.out.println("The " + enemyName + " now has " + enemyHealth + " health remaining.");
                    }
                } else {
                    // Regular attack for non-UFO enemies
                    enemyHealth -= weaponDamage;
                    if (enemyHealth <= 0) {
                        System.out.println("You have defeated the " + enemyName + "!");
                        break;
                    }
                    System.out.println("The " + enemyName + " now has " + enemyHealth + " health remaining.");
                }

                // Enemy's turn to attack
                System.out.println("The " + enemyName + " attacks you!");
                playerHealth -= enemyDamage;
                if (playerHealth <= 0) {
                    System.out.println("You have been defeated by the " + enemyName + "...");
                    break;
                }
                System.out.println("You now have " + playerHealth + " health remaining.");
            }

            // End of combat
            if (playerHealth > 0) {
                System.out.println("Congratulations! You survived the encounter.");
                clearedTiles[row][col] = true;
                clearedCount++;

                // Loot system after the battle
                System.out.println("You have won the battle! Time to collect your loot.");
                String[] lootOptions = {"Health Potion", "Damage Boost", "Experience"};
                String loot = lootOptions[(int) (Math.random() * lootOptions.length)];

                if (loot.equals("Health Potion")) {
                    BandAid healthPotion = new BandAid();
                    healthPotion.healPlayer(player);
                    System.out.println("You found a Health Potion!");
                    System.out.println("Your current health is now: " + playerHealth);
                } else if (loot.equals("Damage Boost")) {
                    MoonRock damageBooster = new MoonRock();
                    int damageBoost = (int) damageBooster.use(weaponDamage);
                    weaponDamage = damageBoost;
                    System.out.println("You found a Damage Boost! Your weapon damage increased by " + (int)damageBooster.getBoostPercentage() + "%.");
                    System.out.println("Your current weapon damage is now: " + weaponDamage);
                } else if(loot.equals("Experience")) {
                    int experiencePoints = XP.generateExperience();
                    clearedCount += 1; 
                    System.out.println("You found some Experience Points! Your experience increased by " + experiencePoints + ".");
                    System.out.println("Your current experience level is now: " + clearedCount);
                    player.setExperienceLevel(experiencePoints); // Assuming Player class has a method to set experience level
                }

                // Display player's stats after the battle
                System.out.println("Your current stats:");
                System.out.println("Health: " + playerHealth);
                System.out.println("Damage Output: " + weaponDamage);
                System.out.println("Experience Level: " + player.getExperienceLevel()); // Using clearedCount as experience level
            } else {
                System.out.println("Game Over. Better luck next time!");
                break;
            }
        }
        if(surrendered) {
            System.out.println("You have surrendered. Game Over.");
        } else if (clearedCount >= 25) {
            System.out.println("Congratulations! You have cleared all tiles and won the game!");
        }
    }
}
}
