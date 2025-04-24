import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask for player name
        System.out.print("Enter your player name: ");
        String playerName = scanner.nextLine();

        // Ask for weapon choice
        System.out.print("Choose your weapon: ");
        String weapon = scanner.nextLine();

        // Display the inputs
        System.out.println("Welcome, " + playerName + "! You have chosen the " + weapon + " as your weapon.");
        

        // Ask for player details
        

        // Set player details
        Player player = new Player(playerName);
        

        // Ask for weapon details
        

        System.out.print("Enter weapon damage: ");
        int weaponDamage = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Set weapon details
        Weapon playerWeapon = new Weapon(weapon, weaponDamage);

        // Display the created objects
        System.out.println("Player created: " + player);
        System.out.println("Weapon created: " + playerWeapon);
    }
}