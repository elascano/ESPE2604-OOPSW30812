import { Item } from './Item';
import { ArmorSlot, ArtifactSlot } from './enums';
import type { Armor } from './Armor';
import type { Artifact } from './Artifact';
import type { Weapon } from './Weapon';
import { InventoryFullException, CharacterDeadException } from './exceptions';

export abstract class Character {
  private id: string;
  private name: string;
  private level: number;
  private hp: number;
  private maxHp: number;
  private exp: number;
  private bonusDamage: number;
  private bonusDefense: number;
  private inventory: Item[];
  private equippedWeapon?: Weapon;
  private equippedArmor: Map<ArmorSlot, Armor>;
  private equippedArtifacts: Map<ArtifactSlot, Artifact>;

  constructor(id: string, name: string, level: number, maxHp: number) {
    this.id = id;
    this.name = name;
    this.level = level;
    this.maxHp = maxHp;
    this.hp = maxHp;
    this.exp = 0;
    this.bonusDamage = 0.0;
    this.bonusDefense = 0.0;
    this.inventory = [];
    this.equippedArmor = new Map<ArmorSlot, Armor>();
    this.equippedArtifacts = new Map<ArtifactSlot, Artifact>();
  }

  public getId(): string { return this.id; }
  public setId(id: string): void { this.id = id; }

  public getName(): string { return this.name; }
  public setName(name: string): void { this.name = name; }

  public getLevel(): number { return this.level; }
  public setLevel(level: number): void { this.level = level; }

  public getHp(): number { return this.hp; }
  public setHp(hp: number): void {
    this.hp = Math.max(0, Math.min(hp, this.maxHp));
  }
  public getMaxHp(): number { return this.maxHp; }
  public setMaxHp(maxHp: number): void { this.maxHp = maxHp; }

  public getExp(): number { return this.exp; }
  public setExp(exp: number): void { this.exp = exp; }

  public getBonusDamage(): number { return this.bonusDamage; }
  public setBonusDamage(bonus: number): void { this.bonusDamage = bonus; }

  public getBonusDefense(): number { return this.bonusDefense; }
  public setBonusDefense(def: number): void { this.bonusDefense = def; }

  public getInventory(): Item[] { return this.inventory; }

  public getEquippedWeapon(): Weapon | undefined {
    return this.equippedWeapon;
  }

  public setEquippedWeapon(weapon?: Weapon): void {
    this.equippedWeapon = weapon;
  }

  public getEquippedArmor(slot: ArmorSlot): Armor | undefined {
    return this.equippedArmor.get(slot);
  }

  public setEquippedArmor(slot: ArmorSlot, armor?: Armor): void {
    if (!armor) {
      this.equippedArmor.delete(slot);
    } else {
      this.equippedArmor.set(slot, armor);
    }
  }

  public getEquippedArtifact(slot: ArtifactSlot): Artifact | undefined {
    return this.equippedArtifacts.get(slot);
  }

  public setEquippedArtifact(slot: ArtifactSlot, artifact?: Artifact): void {
    if (!artifact) {
      this.equippedArtifacts.delete(slot);
    } else {
      this.equippedArtifacts.set(slot, artifact);
    }
  }

  public takeDamage(amount: number): void {
    let realDamage = amount - this.bonusDefense;
    if (realDamage < 1) realDamage = 1; // Minimum 1 damage always
    
    this.hp -= realDamage;
    if (this.hp > this.maxHp) this.hp = this.maxHp;
    if (this.hp < 0) this.hp = 0;
  }

  public heal(amount: number): void {
    this.hp += amount;
    if (this.hp > this.maxHp) this.hp = this.maxHp;
  }

  public gainExp(amount: number): boolean {
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

  public addItem(item: Item): void {
    // Inventario ilimitado
    this.inventory.push(item);
  }

  public removeItem(item: Item): void {
    const index = this.inventory.indexOf(item);
    if (index > -1) {
      this.inventory.splice(index, 1);
    }
  }

  // Abstract method for polymorphism
  public abstract attack(target: Character): void;
}
