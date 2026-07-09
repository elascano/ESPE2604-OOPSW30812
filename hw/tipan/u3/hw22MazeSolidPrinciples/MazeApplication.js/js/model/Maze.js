import { Path } from './Path.js';

export class Maze {
  constructor(rows, columns) {
    this.rows = rows;
    this.columns = columns;
    this.rooms = Array.from({ length: rows }, () => new Array(columns).fill(null));
    this.path = new Path();
  }

  getRows() { return this.rows; }
  getColumns() { return this.columns; }

  getRooms() { return this.rooms; }
  setRooms(rooms) { this.rooms = rooms; }

  getRoom(row, column) {
    return this.rooms[row][column];
  }

  setRoom(row, column, room) {
    this.rooms[row][column] = room;
  }

  getPath() { return this.path; }
  setPath(path) { this.path = path; }
}
