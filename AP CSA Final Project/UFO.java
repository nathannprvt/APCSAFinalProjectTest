public class UFO extends Alien {
    // Constructor
    public UFO(String name, int health, int damage) {
        super(name, health, damage);
    }

    // Additional methods specific to UFO can be added here
    public void hover() {
        System.out.println(getName() + " is hovering in the air!");
    }
}