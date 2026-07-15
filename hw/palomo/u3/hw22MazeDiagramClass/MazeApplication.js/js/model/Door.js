export class Door {
  constructor() {
    this.open = false;
  }

  isOpen() {
    return this.open;
  }

  openDoor() {
    this.open = true;
  }

  closeDoor() {
    this.open = false;
  }

  toString() {
    return this.open ? 'Open Door' : 'Closed Door';
  }
}
