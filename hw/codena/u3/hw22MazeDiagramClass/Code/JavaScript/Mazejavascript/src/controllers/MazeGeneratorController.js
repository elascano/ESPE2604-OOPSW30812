import { Maze } from '../models/Maze.js';
import { Room } from '../models/Room.js';
import { Coordinate } from '../models/Coordinate.js';
import { Wall } from '../models/Wall.js';
import { EntranceDoor } from '../models/EntranceDoor.js';
import { ExitDoor } from '../models/ExitDoor.js';

class MazeGeneratorController {
  constructor(rows = 4, columns = 4) {
    this.maze = this.generateMaze(rows, columns);
  }

  generateMaze(rows, columns) {
    const rooms = [];

    for (let row = 0; row < rows; row += 1) {
      for (let col = 0; col < columns; col += 1) {
        const coordinate = new Coordinate(row, col);
        const doors = [];
        const walls = [];

        if (row === 0) {
          doors.push(new EntranceDoor('NORTH', true));
        } else {
          walls.push(new Wall('NORTH', true));
        }

        if (row === rows - 1) {
          doors.push(new ExitDoor('SOUTH', true));
        } else {
          walls.push(new Wall('SOUTH', true));
        }

        if (col === 0) {
          walls.push(new Wall('WEST', false));
        }

        if (col === columns - 1) {
          walls.push(new Wall('EAST', false));
        }

        rooms.push(new Room(coordinate, doors, walls));
      }
    }

    this.maze = new Maze(rows, columns, rooms);
    return this.maze;
  }

  drawMaze() {
    if (!this.maze) {
      throw new Error('No maze generated yet.');
    }

    return this.maze.rooms.map((room) => ({
      coordinate: room.coordinate,
      doors: room.doors,
      walls: room.walls,
    }));
  }
}

export { MazeGeneratorController };
