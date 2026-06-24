package ec.edu.espe.rpg.model.entities;

public class Warrior extends Character {
    private double strength;
    private double rage;

    public Warrior(String id, String name, int level, double maxHp, double strength) {
        super(id, name, level, maxHp);
        this.strength = strength;
        this.rage = 0;
    }

    public double getStrength() { return strength; }
    public void setStrength(double strength) { this.strength = strength; }

    public double getRage() { return rage; }

    @Override
    public void attack(Character target) throws ec.edu.espe.rpg.model.exceptions.CharacterDeadException {
        if (this.getHp() <= 0) {
            throw new ec.edu.espe.rpg.model.exceptions.CharacterDeadException("El guerrero está muerto y no puede atacar.");
        }
        double damage = (strength * 1.5) + getBonusDamage();
        target.takeDamage(damage);
        this.rage += 10;
        if (this.rage > 100) this.rage = 100;
    }
}
