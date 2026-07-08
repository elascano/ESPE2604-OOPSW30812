import { Maze } from '../model/Maze.js';
import { RandomMazeGenerator } from './RandomMazeGenerator.js';

export class MazeController {
  constructor() {
    this.maze = null;
    this.generator = new RandomMazeGenerator();
  }

  createMaze(rows, columns) {
    this.maze = new Maze(rows, columns);
    this.initializeMaze();
  }

  initializeMaze() {
    if (this.generator instanceof RandomMazeGenerator) {
      this.generator.setMaze(this.maze);
      this.generator.generateMaze();
    }
  }

  getMaze() {
    return this.maze;
  }

  drawMaze() {
    if (this.maze === null) {
      return 'Maze not generated.';
    }

    let builder = '';
    const rows = this.maze.getRows();
    const columns = this.maze.getColumns();

    for (let c = 0; c < columns; c++) {
      builder += '+---';
    }
    builder += '+\n';

    for (let r = 0; r < rows; r++) {
      for (let c = 0; c < columns; c++) {
        const room = this.maze.getRoom(r, c);
        const wall = room.getWalls()[0];

        if (c === 0) {
          builder += '|';
        } else {
          const leftRoom = this.maze.getRoom(r, c - 1);
          const leftWall = leftRoom.getWalls()[0];
          if (leftWall !== null && leftWall.isEastWall()) {
            builder += '|';
          } else {
            builder += ' ';
          }
        }

        if (r === 0 && c === 0) {
          builder += ' S ';
        } else if (r === rows - 1 && c === columns - 1) {
          builder += ' E ';
        } else {
          builder += '   ';
        }
      }
      builder += '|\n';

      for (let c = 0; c < columns; c++) {
        const room = this.maze.getRoom(r, c);
        const wall = room.getWalls()[0];

        builder += '+';

        if (wall !== null && wall.isSouthWall()) {
          builder += '---';
        } else {
          builder += '   ';
        }
      }
      builder += '+\n';
    }

    return builder;
  }
}
