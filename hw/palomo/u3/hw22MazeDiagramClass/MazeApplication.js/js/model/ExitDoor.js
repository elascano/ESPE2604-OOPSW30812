import { Door } from './Door.js';

export class ExitDoor extends Door {
  constructor() {
    super();
    this.openDoor();
  }

  toString() {
    return 'Exit Door';
  }
}
