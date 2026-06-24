import { Character } from './Character';
import { CharacterDeadException } from './exceptions';

export class Warrior extends Character {
  private strength: number;
  private rage: number;

  constructor(id: string, name: string, level: number, maxHp: number, strength: number) {
    super(id, name, level, maxHp);
    this.strength = strength;
    this.rage = 0;
  }

  public getStrength(): number { return this.strength; }
  public setStrength(strength: number): void { this.strength = strength; }

  public getRage(): number { return this.rage; }

  public attack(target: Character): void {
    if (this.getHp() <= 0) {
      throw new CharacterDeadException('El guerrero está muerto y no puede atacar.');
    }
    const damage = (this.strength * 1.5) + this.getBonusDamage();
    target.takeDamage(damage);
    this.rage += 10;
    if (this.rage > 100) this.rage = 100;
  }
}
