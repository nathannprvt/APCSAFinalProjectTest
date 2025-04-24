public class BandAid {
    private int healingAmount;

    public BandAid(int healingAmount) {
        this.healingAmount = healingAmount;
    }

    public int getHealingAmount() {
        return healingAmount;
    }

    public void healPlayer(Player player) {
        player.increaseHealth(healingAmount);
        System.out.println("Player healed by " + healingAmount + " points!");
    }
}