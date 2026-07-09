import { Door } from './Door.js';

class EntranceDoor extends Door {
  constructor(cardinalDirection, horizontalLine = false) {
    super(cardinalDirection, horizontalLine);
  }
}

export { EntranceDoor };
