import { Door } from './Door.js';

class ExitDoor extends Door {
  constructor(cardinalDirection, horizontalLine = false) {
    super(cardinalDirection, horizontalLine);
  }
}

export { ExitDoor };
