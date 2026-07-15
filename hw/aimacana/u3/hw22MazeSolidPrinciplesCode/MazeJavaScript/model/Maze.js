
import { Room } from './Room.js';

export class Maze {
    constructor(w, h) {
        this.width = w;
        this.height = h;
        this.grid = Array.from({length: h}, (_, y) => Array.from({length: w}, (_, x) => new Room(x, y)));
    }
    getRoom(x, y) { return this.grid[y][x]; }
}
