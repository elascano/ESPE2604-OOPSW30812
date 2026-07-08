import Cell from './Cell.js';

export default class Maze {
    constructor(width, height) {
        if (width <= 0 || height <= 0) {
            throw new Error("Dimensions must be positive");
        }
        this._width = width;
        this._height = height;
        this._grid = [];
        for (let y = 0; y < height; y++) {
            let row = [];
            for (let x = 0; x < width; x++) {
                row.push(new Cell(x, y));
            }
            this._grid.push(row);
        }
        this._entrance = null;
        this._exit = null;
    }

    getCell(x, y) {
        if (x < 0 || x >= this._width || y < 0 || y >= this._height) {
            return null;
        }
        return this._grid[y][x];
    }

    configureEntranceExit(entrance, exit) {
        this._entrance = entrance;
        this._exit = exit;
    }

    get entrance() { return this._entrance; }
    get exit() { return this._exit; }
    get width() { return this._width; }
    get height() { return this._height; }
    get grid() { return this._grid; }
}
