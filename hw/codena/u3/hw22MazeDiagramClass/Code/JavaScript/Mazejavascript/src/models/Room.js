class Room {
  constructor(coordinate, doors = [], walls = []) {
    this.coordinate = coordinate;
    this.doors = doors;
    this.walls = walls;
  }

  toString() {
    return `Room{coordinate=${this.coordinate.toString()}, doors=${JSON.stringify(this.doors)}, walls=${JSON.stringify(this.walls)}}`;
  }
}

export { Room };
