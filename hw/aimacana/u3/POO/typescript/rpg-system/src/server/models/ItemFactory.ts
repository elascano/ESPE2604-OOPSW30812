import { Item } from './Item';
import { Potion } from './Potion';
import { Weapon } from './Weapon';
import { Armor } from './Armor';
import { Artifact } from './Artifact';
import { ArmorSlot, ArtifactSlot } from './enums';

/**
 * Patrón Factory Method.
 * Encapsula y centraliza la lógica de creación de botín en TypeScript.
 */
export class ItemFactory {
  public static createRandomLoot(playerLevel: number): Item {
    const roll = Math.random();
    const id = Math.random().toString(36).substring(2, 9);
    
    if (roll < 0.35) {
      const restore = 20 + (playerLevel * 10);
      return new Potion(id, `Poción Nvl ${playerLevel}`, 0.5, `Cura ${restore} HP`, 20 * playerLevel, restore);
    } else if (roll < 0.70) {
      const damage = 10 + (playerLevel * 5);
      return new Weapon(id, `Arma Nvl ${playerLevel}`, 5.0, `Daño +${damage}`, 50 * playerLevel, damage, 1.2);
    } else if (roll < 0.90) {
      const def = 5 + (playerLevel * 2);
      const slotRoll = Math.random();
      let slot: ArmorSlot;
      let namePrefix: string;
      
      if (slotRoll < 0.25) { slot = ArmorSlot.HELMET; namePrefix = "Casco"; }
      else if (slotRoll < 0.5) { slot = ArmorSlot.CHEST; namePrefix = "Pechera"; }
      else if (slotRoll < 0.75) { slot = ArmorSlot.LEGS; namePrefix = "Pantalones"; }
      else { slot = ArmorSlot.BOOTS; namePrefix = "Botas"; }
      
      return new Armor(id, `${namePrefix} Nvl ${playerLevel}`, 10.0, `Defensa +${def}`, 100 * playerLevel, def, slot);
    } else {
      const bonusHp = 50 + (playerLevel * 20);
      const artSlot = Math.random() > 0.5 ? ArtifactSlot.RING : ArtifactSlot.AMULET;
      const namePrefix = (artSlot === ArtifactSlot.RING) ? "Anillo" : "Amuleto";
      
      return new Artifact(id, `${namePrefix} Nvl ${playerLevel}`, 1.0, `Max HP +${bonusHp}`, 200 * playerLevel, bonusHp, artSlot);
    }
  }
}
