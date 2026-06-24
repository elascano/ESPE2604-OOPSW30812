package ec.edu.espe.rpg.model.entities;

public class Mage extends Character {
    private double intelligence;
    private double mana;

    public Mage(String id, String name, int level, double maxHp, double intelligence, double maxMana) {
        super(id, name, level, maxHp);
        this.intelligence = intelligence;
        this.mana = maxMana;
    }

    public double getIntelligence() { return intelligence; }
    public void setIntelligence(double intelligence) { this.intelligence = intelligence; }

    public double getMana() { return mana; }
    public void setMana(double mana) { this.mana = mana; }

    @Override
    public void attack(Character target) throws ec.edu.espe.rpg.model.exceptions.CharacterDeadException {
        if (this.getHp() <= 0) {
            throw new ec.edu.espe.rpg.model.exceptions.CharacterDeadException("El mago está muerto y no puede atacar.");
        }
        double damage;
        if (mana >= 10) {
            damage = (intelligence * 2.0) + getBonusDamage();
            this.mana -= 10;
        } else {
            // Weak attack when out of mana
            damage = (intelligence * 0.5) + getBonusDamage();
            this.mana += 15; // Regenerate mana
            if (this.mana > 100) this.mana = 100;
        }
        target.takeDamage(damage);
    }
}
