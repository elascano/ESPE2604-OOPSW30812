export class Room {
  constructor(x, y) {
    this.x = x;
    this.y = y;

    this.doors = [null, null, null];
    this.walls = [null, null, null];

    this.visited = false;
  }

  getX() { return this.x; }
  setX(x) { this.x = x; }

  getY() { return this.y; }
  setY(y) { this.y = y; }

  getDoors() { return this.doors; }
  setDoors(doors) { this.doors = doors; }

  getWalls() { return this.walls; }
  setWalls(walls) { this.walls = walls; }

  isVisited() { return this.visited; }
  setVisited(visited) { this.visited = visited; }

  addDoor(door) {
    for (let i = 0; i < this.doors.length; i++) {
      if (this.doors[i] === null) {
        this.doors[i] = door;
        return;
      }
    }
  }

  addWall(wall) {
    for (let i = 0; i < this.walls.length; i++) {
      if (this.walls[i] === null) {
        this.walls[i] = wall;
        return;
      }
    }
  }

  countDoors() {
    return this.doors.filter((d) => d !== null).length;
  }

  countWalls() {
    return this.walls.filter((w) => w !== null).length;
  }

  toString() {
    return `Room(${this.x},${this.y})`;
  }
}
