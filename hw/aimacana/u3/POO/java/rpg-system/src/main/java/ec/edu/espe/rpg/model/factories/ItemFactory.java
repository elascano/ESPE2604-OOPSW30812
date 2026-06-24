package ec.edu.espe.rpg.model.factories;

import ec.edu.espe.rpg.model.entities.Item;
import ec.edu.espe.rpg.model.entities.Potion;
import ec.edu.espe.rpg.model.entities.Weapon;
import java.util.UUID;

/**
 * Patrón Factory Method.
 * Encapsula y centraliza la lógica de creación de botín.
 */
public class ItemFactory {

    public static Item createRandomLoot(int playerLevel) {
        double roll = Math.random();
        if (roll < 0.35) {
            double restore = 20 + (playerLevel * 10);
            return new Potion(UUID.randomUUID().toString(), "Poción Nvl " + playerLevel, 0.5, "Cura " + restore + " HP", 20 * playerLevel, restore);
        } else if (roll < 0.70) {
            double damage = 10 + (playerLevel * 5);
            return new Weapon(UUID.randomUUID().toString(), "Arma Nvl " + playerLevel, 5.0, "Daño +" + damage, 50 * playerLevel, damage, 1.2);
        } else if (roll < 0.90) {
            double def = 5 + (playerLevel * 2);
            double slotRoll = Math.random();
            ec.edu.espe.rpg.model.enums.ArmorSlot slot;
            String namePrefix;
            if (slotRoll < 0.25) { slot = ec.edu.espe.rpg.model.enums.ArmorSlot.HELMET; namePrefix = "Casco"; }
            else if (slotRoll < 0.5) { slot = ec.edu.espe.rpg.model.enums.ArmorSlot.CHEST; namePrefix = "Pechera"; }
            else if (slotRoll < 0.75) { slot = ec.edu.espe.rpg.model.enums.ArmorSlot.LEGS; namePrefix = "Pantalones"; }
            else { slot = ec.edu.espe.rpg.model.enums.ArmorSlot.BOOTS; namePrefix = "Botas"; }
            
            return new ec.edu.espe.rpg.model.entities.Armor(
                UUID.randomUUID().toString(), namePrefix + " Nvl " + playerLevel, 10.0, "Defensa +" + def, 100 * playerLevel, def, slot);
        } else {
            double bonusHp = 50 + (playerLevel * 20);
            ec.edu.espe.rpg.model.enums.ArtifactSlot artSlot = Math.random() > 0.5 ? 
                ec.edu.espe.rpg.model.enums.ArtifactSlot.RING : ec.edu.espe.rpg.model.enums.ArtifactSlot.AMULET;
            String namePrefix = (artSlot == ec.edu.espe.rpg.model.enums.ArtifactSlot.RING) ? "Anillo" : "Amuleto";
            
            return new ec.edu.espe.rpg.model.entities.Artifact(
                UUID.randomUUID().toString(), namePrefix + " Nvl " + playerLevel, 1.0, "Max HP +" + bonusHp, 200 * playerLevel, bonusHp, artSlot);
        }
    }
}
