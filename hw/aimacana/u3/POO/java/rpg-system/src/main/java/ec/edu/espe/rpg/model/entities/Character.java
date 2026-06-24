package ec.edu.espe.rpg.model.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Character {
    private String id;
    private String name;
    private int level;
    private double hp;
    private double maxHp;
    private int exp;
    private double bonusDamage;
    private double bonusDefense;
    private List<Item> inventory;
    private java.util.Map<ec.edu.espe.rpg.model.enums.ArmorSlot, ec.edu.espe.rpg.model.entities.Armor> equippedArmor;
    private java.util.Map<ec.edu.espe.rpg.model.enums.ArtifactSlot, ec.edu.espe.rpg.model.entities.Artifact> equippedArtifacts;

    public Character(String id, String name, int level, double maxHp) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.exp = 0;
        this.bonusDamage = 0.0;
        this.bonusDefense = 0.0;
        this.inventory = new ArrayList<>();
        this.equippedArmor = new java.util.HashMap<>();
        this.equippedArtifacts = new java.util.HashMap<>();
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }

    public double getHp() { return hp; }
    public double getMaxHp() { return maxHp; }
    public void setMaxHp(double maxHp) { this.maxHp = maxHp; }

    public int getExp() { return exp; }
    public void setExp(int exp) { this.exp = exp; }

    public double getBonusDamage() { return bonusDamage; }
    public void setBonusDamage(double bonus) { this.bonusDamage = bonus; }

    public double getBonusDefense() { return bonusDefense; }
    public void setBonusDefense(double def) { this.bonusDefense = def; }

    public List<Item> getInventory() { return inventory; }

    public ec.edu.espe.rpg.model.entities.Armor getEquippedArmor(ec.edu.espe.rpg.model.enums.ArmorSlot slot) {
        return equippedArmor.get(slot);
    }

    public void setEquippedArmor(ec.edu.espe.rpg.model.enums.ArmorSlot slot, ec.edu.espe.rpg.model.entities.Armor armor) {
        if (armor == null) {
            equippedArmor.remove(slot);
        } else {
            equippedArmor.put(slot, armor);
        }
    }

    public ec.edu.espe.rpg.model.entities.Artifact getEquippedArtifact(ec.edu.espe.rpg.model.enums.ArtifactSlot slot) {
        return equippedArtifacts.get(slot);
    }

    public void setEquippedArtifact(ec.edu.espe.rpg.model.enums.ArtifactSlot slot, ec.edu.espe.rpg.model.entities.Artifact artifact) {
        if (artifact == null) {
            equippedArtifacts.remove(slot);
        } else {
            equippedArtifacts.put(slot, artifact);
        }
    }

    public void takeDamage(double amount) {
        double realDamage = amount - bonusDefense;
        if (realDamage < 1) realDamage = 1; // Minimum 1 damage always
        
        this.hp -= realDamage;
        if (this.hp > this.maxHp) this.hp = this.maxHp;
        if (this.hp < 0) this.hp = 0;
    }

    public void heal(double amount) {
        this.hp += amount;
        if (this.hp > this.maxHp) this.hp = this.maxHp;
    }

    public boolean gainExp(int amount) {
        this.exp += amount;
        if (this.exp >= 100) {
            this.level++;
            this.exp -= 100;
            this.maxHp += 20;
            this.hp = this.maxHp; // Heal fully on level up
            return true; // Leveled up
        }
        return false;
    }

    public void addItem(Item item) throws ec.edu.espe.rpg.model.exceptions.InventoryFullException {
        // Inventario ilimitado
        inventory.add(item);
    }

    public void removeItem(Item item) {
        inventory.remove(item);
    }

    // Abstract method for polymorphism
    public abstract void attack(Character target) throws ec.edu.espe.rpg.model.exceptions.CharacterDeadException;
}
