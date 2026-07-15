import { MazeGenerator } from './MazeGenerator.js';
import { CommonDoor } from '../model/CommonDoor.js';
import { StartDoor } from '../model/StartDoor.js';
import { ExitDoor } from '../model/ExitDoor.js';
import { Room } from '../model/Room.js';
import { Wall } from '../model/Wall.js';

export class RandomMazeGenerator extends MazeGenerator {
  constructor() {
    super();
    this.maze = null;
    this.visited = null;
  }

  setMaze(maze) {
    this.maze = maze;
  }

  getMaze() {
    return this.maze;
  }

  generateMaze() {
    if (this.maze === null) {
      return null;
    }
    this.createRooms();
    this.generateUniquePath();
    return this.maze;
  }

  validateMaze() {
    return this.maze !== null && this.maze.getRooms() !== null;
  }

  createRooms() {
    for (let i = 0; i < this.maze.getRows(); i++) {
      for (let j = 0; j < this.maze.getColumns(); j++) {
        this.maze.getRooms()[i][j] = new Room(i, j);
      }
    }
  }

  generateUniquePath() {
    const rows = this.maze.getRows();
    const columns = this.maze.getColumns();

    this.visited = Array.from({ length: rows }, () => new Array(columns).fill(false));
    this.initializeWalls();

    const stack = [];
    const start = this.maze.getRoom(0, 0);
    start.setVisited(true);
    this.visited[0][0] = true;
    stack.push(start);

    while (stack.length > 0) {
      const current = stack[stack.length - 1]; // stack.peek()
      const next = this.getRandomUnvisitedNeighbor(current);

      if (next !== null) {
        this.removeWallBetween(current, next);
        next.setVisited(true);
        this.visited[next.getX()][next.getY()] = true;
        stack.push(next);
      } else {
        stack.pop();
      }
    }

    this.placeStartDoor();
    this.placeExitDoor();
  }

  initializeWalls() {
    for (let i = 0; i < this.maze.getRows(); i++) {
      for (let j = 0; j < this.maze.getColumns(); j++) {
        const room = this.maze.getRoom(i, j);
        const wall = new Wall(true, true, true, true);
        room.addWall(wall);
      }
    }
  }

  getRandomUnvisitedNeighbor(room) {
    const x = room.getX();
    const y = room.getY();

    const neighbors = [];

    if (x > 0 && !this.visited[x - 1][y]) {
      neighbors.push(this.maze.getRoom(x - 1, y));
    }
    if (x < this.maze.getRows() - 1 && !this.visited[x + 1][y]) {
      neighbors.push(this.maze.getRoom(x + 1, y));
    }
    if (y > 0 && !this.visited[x][y - 1]) {
      neighbors.push(this.maze.getRoom(x, y - 1));
    }
    if (y < this.maze.getColumns() - 1 && !this.visited[x][y + 1]) {
      neighbors.push(this.maze.getRoom(x, y + 1));
    }

    if (neighbors.length === 0) {
      return null;
    }

    return neighbors[Math.floor(Math.random() * neighbors.length)];
  }

  removeWallBetween(current, next) {
    const x1 = current.getX();
    const y1 = current.getY();
    const x2 = next.getX();
    const y2 = next.getY();

    if (x1 === x2) {
      if (y2 > y1) {
        this.removeWallDirection(current, 'east');
        this.removeWallDirection(next, 'west');
      } else {
        this.removeWallDirection(current, 'west');
        this.removeWallDirection(next, 'east');
      }
    } else if (x2 > x1) {
      this.removeWallDirection(current, 'south');
      this.removeWallDirection(next, 'north');
    } else {
      this.removeWallDirection(current, 'north');
      this.removeWallDirection(next, 'south');
    }

    current.addDoor(new CommonDoor());
    next.addDoor(new CommonDoor());
  }

  removeWallDirection(room, direction) {
    const walls = room.getWalls();
    for (const wall of walls) {
      if (wall !== null) {
        switch (direction) {
          case 'north': wall.setNorthWall(false); break;
          case 'south': wall.setSouthWall(false); break;
          case 'east': wall.setEastWall(false); break;
          case 'west': wall.setWestWall(false); break;
          default: break;
        }
      }
    }
  }

  placeStartDoor() {
    const start = this.maze.getRoom(0, 0);
    const walls = start.getWalls();
    if (walls[0] !== null) {
      walls[0].setNorthWall(false);
    }
    start.addDoor(new StartDoor());
  }

  placeExitDoor() {
    const exit = this.maze.getRoom(this.maze.getRows() - 1, this.maze.getColumns() - 1);
    const walls = exit.getWalls();
    if (walls[0] !== null) {
      walls[0].setSouthWall(false);
    }
    exit.addDoor(new ExitDoor());
  }
}
