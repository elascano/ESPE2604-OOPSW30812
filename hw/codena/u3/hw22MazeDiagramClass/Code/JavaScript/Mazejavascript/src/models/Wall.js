class Wall {
  constructor(cardinalDirection, horizontalLine = false) {
    this.cardinalDirection = cardinalDirection;
    this.horizontalLine = horizontalLine;
  }

  toString() {
    return `Wall{cardinalDirection=${this.cardinalDirection}, horizontalLine=${this.horizontalLine}}`;
  }
}

export { Wall };
