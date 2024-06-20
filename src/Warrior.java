import java.util.Random;

public class Warrior extends Character implements Attacker{
    private int stamina;
    private int strength;

    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
        this.stamina = stamina;
        this.strength = strength;
    }

    public Warrior(String name) {
        super(name, new Random().nextInt(101) + 100); // health points between 100-200
        this.stamina = new Random().nextInt(41) + 10; // Stamina between 10-50
        this.strength = new Random().nextInt(10) + 1; // Strength between 1-10
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public void attack(Character target) {
        Random rand = new Random();
        boolean heavyAttack = rand.nextBoolean();
        int damage = heavyAttack ? strength : (int) Math.floor(strength / 2.0);
        if (heavyAttack && stamina >= 5) {
            target.setHp(target.getHp() - damage);
            stamina -= 5;
        } else if (stamina >= 1) {
            target.setHp(target.getHp() - damage);
            stamina += 1;
        } else {
            stamina += 2;
        }
        if (target.getHp() <= 0) {
            target.setAlive(false);
        }
    }
}