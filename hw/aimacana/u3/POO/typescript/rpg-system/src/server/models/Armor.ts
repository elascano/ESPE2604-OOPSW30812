import { Item } from './Item';
import type { IEquippable, ISellable } from './interfaces';
import type { Character } from './Character';
import { ArmorSlot } from './enums';
import { InventoryFullException } from './exceptions';

export class Armor extends Item implements IEquippable, ISellable {
  private defense: number;
  private slot: ArmorSlot;

  constructor(id: string, name: string, weight: number, description: string, baseValue: number, defense: number, slot: ArmorSlot) {
    super(id, name, weight, description, baseValue);
    this.defense = defense;
    this.slot = slot;
  }

  public getDefense(): number { return this.defense; }
  public getSlot(): ArmorSlot { return this.slot; }

  public equip(target: Character): void {
    const currentlyEquipped = target.getEquippedArmor(this.slot);
    target.removeItem(this); // Quitar de mochila
    if (currentlyEquipped) {
      currentlyEquipped.unequip(target); // Devolver el viejo a mochila
    }
    target.setBonusDefense(target.getBonusDefense() + this.defense);
    target.setEquippedArmor(this.slot, this);
  }

  public unequip(target: Character): void {
    target.setBonusDefense(target.getBonusDefense() - this.defense);
    target.setEquippedArmor(this.slot, undefined);
    try {
      target.addItem(this); // Devolver a mochila
    } catch (e) {
      if (e instanceof InventoryFullException) {
        // Ignorar
      }
    }
  }

  public calculateSaleValue(): number {
    return this.getBaseValue();
  }
}
