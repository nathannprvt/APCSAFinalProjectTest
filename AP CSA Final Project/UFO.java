public class UFO extends Alien {
    // Constructor
    private String name = "UFO";
    private int damageOutput;
    private int health = 100;
    
    public UFO(int damage) {
        super(damage);
    }

    // Additional methods specific to UFO can be added here
    public void hover() {
        System.out.println(getName() + " is hovering in the air!");
    }
}