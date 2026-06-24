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
    target.setBonusDamage(target.getBonusDamage() + this.baseDamage);
  }

  public unequip(target: Character): void {
    target.setBonusDamage(target.getBonusDamage() - this.baseDamage);
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
