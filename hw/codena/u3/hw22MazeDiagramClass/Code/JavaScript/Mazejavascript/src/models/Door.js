class Door {
  constructor(cardinalDirection, horizontalLine = false) {
    this.cardinalDirection = cardinalDirection;
    this.horizontalLine = horizontalLine;
  }

  toString() {
    return `Door{cardinalDirection=${this.cardinalDirection}, horizontalLine=${this.horizontalLine}}`;
  }
}

export { Door };
