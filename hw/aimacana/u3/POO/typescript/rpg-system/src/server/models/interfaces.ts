import type { Character } from './Character';

export interface IConsumable {
  consume(target: Character): void;
}

export interface IEquippable {
  equip(target: Character): void;
  unequip(target: Character): void;
}

export interface IRepairable {
  repair(amount: number): void;
}

export interface ISellable {
  calculateSaleValue(): number;
}
