abstract class Character {
    protected String name;
    protected int health;

    public Character(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public abstract void attack(Character opponent);

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " (Health: " + health + ")";
    }
}