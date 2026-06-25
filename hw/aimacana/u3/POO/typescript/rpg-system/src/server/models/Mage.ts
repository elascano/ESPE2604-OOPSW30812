import { Character } from './Character';
import { CharacterDeadException } from './exceptions';

export class Mage extends Character {
  private intelligence: number;
  private mana: number;

  constructor(id: string, name: string, level: number, maxHp: number, intelligence: number, maxMana: number) {
    super(id, name, level, maxHp);
    this.intelligence = intelligence;
    this.mana = maxMana;
  }

  public getIntelligence(): number { return this.intelligence; }
  public setIntelligence(intelligence: number): void { this.intelligence = intelligence; }

  public getMana(): number { return this.mana; }
  public setMana(mana: number): void { this.mana = mana; }

  public attack(target: Character): void {
    if (this.getHp() <= 0) {
      throw new CharacterDeadException('El mago está muerto y no puede atacar.');
    }
    let damage: number;
    if (this.mana >= 10) {
      damage = (this.intelligence * 2.0) + this.getBonusDamage();
      this.mana -= 10;
    } else {
      // Weak attack when out of mana
      damage = (this.intelligence * 0.5) + this.getBonusDamage();
      this.mana += 15; // Regenerate mana
      if (this.mana > 100) this.mana = 100;
    }
    target.takeDamage(damage);
  }
}
