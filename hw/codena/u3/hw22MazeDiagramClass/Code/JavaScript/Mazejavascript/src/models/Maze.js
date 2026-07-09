class Maze {
  constructor(rows, columns, rooms = [], path = null) {
    this.rows = rows;
    this.columns = columns;
    this.rooms = rooms;
    this.path = path;
  }

  toString() {
    return `Maze{rows=${this.rows}, columns=${this.columns}, rooms=${this.rooms.length}, path=${this.path ? 'set' : 'null'}}`;
  }
}

export { Maze };
