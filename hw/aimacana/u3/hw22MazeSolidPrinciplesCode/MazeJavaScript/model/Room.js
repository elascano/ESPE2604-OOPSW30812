
import { Direction } from './Direction.js';

export class Room {
    constructor(x, y) {
        this.x = x;
        this.y = y;
        this.doors = { [Direction.NORTH]: false, [Direction.SOUTH]: false, [Direction.EAST]: false, [Direction.WEST]: false };
        this.isEntrance = false;
        this.isExit = false;
    }
    addDoor(dir) { this.doors[dir] = true; }
    hasDoor(dir) { return this.doors[dir]; }
}
