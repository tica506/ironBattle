import java.util.Random;

public class Wizard extends Character implements Attacker {
    private int mana;
    private int intelligence;

    public Wizard(String name) {
        super(name, new Random().nextInt(51) + 50); // HP between 50-100
        this.mana = new Random().nextInt(41) + 10; // Mana between 10-50
        this.intelligence = new Random().nextInt(50) + 1; // Intelligence between 1-50
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    @Override
    public void attack(Character target) {
        Random rand = new Random();
        boolean fireball = rand.nextBoolean();
        int damage = fireball ? intelligence : 2;
        if (fireball && mana >= 5) {
            target.setHp(target.getHp() - damage);
            mana -= 5;
        } else if (mana >= 1) {
            target.setHp(target.getHp() - damage);
            mana += 1;
        } else {
            mana += 2;
        }
        if (target.getHp() <= 0) {
            target.setAlive(false);
        }
    }
}
