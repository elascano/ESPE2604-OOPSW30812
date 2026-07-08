export class Wall {
  constructor(northWall = false, southWall = false, eastWall = false, westWall = false) {
    this.northWall = northWall;
    this.southWall = southWall;
    this.eastWall = eastWall;
    this.westWall = westWall;
  }

  isNorthWall() { return this.northWall; }
  setNorthWall(value) { this.northWall = value; }

  isSouthWall() { return this.southWall; }
  setSouthWall(value) { this.southWall = value; }

  isEastWall() { return this.eastWall; }
  setEastWall(value) { this.eastWall = value; }

  isWestWall() { return this.westWall; }
  setWestWall(value) { this.westWall = value; }
}
