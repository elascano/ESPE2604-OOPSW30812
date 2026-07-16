class Maze {
    constructor(width, height) {
        if (width <= 0 || height <= 0) {
            throw new Error();
        }
        this.width = width;
        this.height = height;
        this.grid = [];
        for (let y = 0; y < height; y++) {
            this.grid[y] = [];
            for (let x = 0; x < width; x++) {
                this.grid[y][x] = new Cell(x, y);
            }
        }
        this.entrance = null;
        this.exit = null;
    }

    getCell(x, y) {
        if (x < 0 || x >= this.width || y < 0 || y >= this.height) {
            return null;
        }
        return this.grid[y][x];
    }

    configureEntranceExit(entrance, exit) {
        this.entrance = entrance;
        this.exit = exit;
    }

    getEntrance() {
        return this.entrance;
    }

    getExit() {
        return this.exit;
    }

    getWidth() {
        return this.width;
    }

    getHeight() {
        return this.height;
    }

    getGrid() {
        return this.grid;
    }
}
