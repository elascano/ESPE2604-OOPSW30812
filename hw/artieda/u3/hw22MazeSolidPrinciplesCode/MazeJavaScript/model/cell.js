class Cell {
    constructor(x, y) {
        this.x = x;
        this.y = y;
        this.wallNorth = true;
        this.wallSouth = true;
        this.wallEast = true;
        this.wallWest = true;
        this.visited = false;
    }

    isVisited() {
        return this.visited;
    }

    markVisited() {
        this.visited = true;
    }

    setVisited(visited) {
        this.visited = visited;
    }

    breakWall(dir) {
        if (dir === 'NORTH') this.wallNorth = false;
        else if (dir === 'SOUTH') this.wallSouth = false;
        else if (dir === 'EAST') this.wallEast = false;
        else if (dir === 'WEST') this.wallWest = false;
    }

    getX() {
        return this.x;
    }

    getY() {
        return this.y;
    }

    isWallNorth() {
        return this.wallNorth;
    }

    isWallSouth() {
        return this.wallSouth;
    }

    isWallEast() {
        return this.wallEast;
    }

    isWallWest() {
        return this.wallWest;
    }
}
