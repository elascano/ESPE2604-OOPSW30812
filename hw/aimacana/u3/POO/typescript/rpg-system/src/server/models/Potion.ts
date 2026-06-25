import { Item } from './Item';
import type { IConsumable, ISellable } from './interfaces';
import type { Character } from './Character';

export class Potion extends Item implements IConsumable, ISellable {
  private restorationAmount: number;

  constructor(id: string, name: string, weight: number, description: string, baseValue: number, restorationAmount: number) {
    super(id, name, weight, description, baseValue);
    this.restorationAmount = restorationAmount;
  }

  public getRestorationAmount(): number { return this.restorationAmount; }

  public consume(target: Character): void {
    console.log(`${target.getName()} consumes ${this.getName()}`);
    target.heal(this.restorationAmount);
  }

  public calculateSaleValue(): number {
    // Potions maintain their value unless consumed
    return this.getBaseValue();
  }
}
