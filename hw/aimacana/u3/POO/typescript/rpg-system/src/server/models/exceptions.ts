export class GameRuleException extends Error {
  constructor(message: string) {
    super(message);
    this.name = 'GameRuleException';
  }
}

export class CharacterDeadException extends GameRuleException {
  constructor(message: string) {
    super(message);
    this.name = 'CharacterDeadException';
  }
}

export class InventoryFullException extends GameRuleException {
  constructor(message: string) {
    super(message);
    this.name = 'InventoryFullException';
  }
}
