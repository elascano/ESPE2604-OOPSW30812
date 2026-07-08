import Direction from './Direction.js';

export default class Cell {
    constructor(x, y) {
        this._x = x;
        this._y = y;
        this._wallNorth = true;
        this._wallSouth = true;
        this._wallEast = true;
        this._wallWest = true;
        this._visited = false;
    }

    get x() { return this._x; }
    get y() { return this._y; }
    get visited() { return this._visited; }

    markVisited() {
        this._visited = true;
    }

    setVisited(visited) {
        this._visited = visited;
    }

    breakWall(dir) {
        switch (dir) {
            case Direction.NORTH: this._wallNorth = false; break;
            case Direction.SOUTH: this._wallSouth = false; break;
            case Direction.EAST: this._wallEast = false; break;
            case Direction.WEST: this._wallWest = false; break;
        }
    }

    get wallNorth() { return this._wallNorth; }
    get wallSouth() { return this._wallSouth; }
    get wallEast() { return this._wallEast; }
    get wallWest() { return this._wallWest; }
}
