import { Door } from './Door.js';

export class StartDoor extends Door {
  constructor() {
    super();
    this.openDoor();
  }

  toString() {
    return 'Start Door';
  }
}
