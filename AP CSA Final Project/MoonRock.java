
/**
*class that represents a damage booster and increases the damage of a weapon by a random percentage.
*/
public class MoonRock {
    private double boostPercentage;

    public MoonRock() {
        // Generate a random boost percentage between 5% and 10%
        this.boostPercentage = 5 + Math.random() * 5;
    }

    public double getBoostPercentage() {
        return boostPercentage;
    }
/**
* Applies the damage boost to the base damage.
* @return the boosted damage
*/
    public double use(int baseDamage) {
        return baseDamage * (1 + boostPercentage / 100);
    }

    @Override
    public String toString() {
        return "DamageBooster{" +
                "boostPercentage=" + boostPercentage +
                "%}";
    }
}