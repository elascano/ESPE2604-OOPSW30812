import { Item } from './Item';
import type { IEquippable, IRepairable, ISellable } from './interfaces';
import type { Character } from './Character';

export class Weapon extends Item implements IEquippable, IRepairable, ISellable {
  private baseDamage: number;
  private attackSpeed: number;
  private durability: number;

  constructor(id: string, name: string, weight: number, description: string, baseValue: number, baseDamage: number, attackSpeed: number) {
    super(id, name, weight, description, baseValue);
    this.baseDamage = baseDamage;
    this.attackSpeed = attackSpeed;
    this.durability = 100.0;
  }

  public getBaseDamage(): number { return this.baseDamage; }
  public getAttackSpeed(): number { return this.attackSpeed; }

  public equip(target: Character): void {
    const currentlyEquipped = target.getEquippedWeapon();
    target.removeItem(this); // Quitar de mochila
    if (currentlyEquipped) {
      currentlyEquipped.unequip(target); // Devolver vieja arma a mochila
    }
    target.setBonusDamage(target.getBonusDamage() + this.baseDamage);
    target.setEquippedWeapon(this);
  }

  public unequip(target: Character): void {
    target.setBonusDamage(target.getBonusDamage() - this.baseDamage);
    target.setEquippedWeapon(undefined);
    try {
      target.addItem(this); // Devolver a mochila
    } catch (e) {
      // Ignorar
    }
  }

  public repair(amount: number): void {
    this.durability += amount;
    if (this.durability > 100.0) this.durability = 100.0;
  }

  public getDurability(): number {
    return this.durability;
  }

  public calculateSaleValue(): number {
    return this.getBaseValue() * (this.durability / 100.0);
  }
}
