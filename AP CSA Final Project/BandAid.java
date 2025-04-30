/**
 * A bandaid object that will heal the player
 *  if they obtain it.
 */
public class BandAid {
    private int healingAmount;

    public BandAid() {
        healingAmount = (int) (Math.random() * (50 - 25 + 1)) + 25;
    }

    public int getHealingAmount() {
        return healingAmount;
    }
/**
 * Method to heal the player.
 * @param player
 */
    public void healPlayer(Player player) {
        if (player == null) {
            System.out.println("Error: Player object is null. Cannot heal.");
            return;
        }
        player.increaseHealth(healingAmount);
        System.out.println("Player healed by " + healingAmount + " points!");
    }
}