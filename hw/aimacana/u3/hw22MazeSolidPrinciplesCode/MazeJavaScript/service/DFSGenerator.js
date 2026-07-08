import IMazeGenerator from './IMazeGenerator.js';
import Direction from '../model/Direction.js';

export default class DFSGenerator extends IMazeGenerator {
    generate(maze) {
        const width = maze.width;
        const height = maze.height;
        if (width <= 0 || height <= 0) return;

        for (let y = 0; y < height; y++) {
            for (let x = 0; x < width; x++) {
                const cell = maze.getCell(x, y);
                if (cell) cell.setVisited(false);
            }
        }

        let current = maze.getCell(0, 0);
        if (!current) return;

        current.markVisited();
        const stack = [current];

        while (stack.length > 0) {
            const nextCell = this.getRandomUnvisitedNeighbor(current, maze);
            if (nextCell) {
                this.breakWalls(current, nextCell);
                nextCell.markVisited();
                stack.push(current);
                current = nextCell;
            } else {
                current = stack.pop();
            }
        }

        for (let y = 0; y < height; y++) {
            for (let x = 0; x < width; x++) {
                const cell = maze.getCell(x, y);
                if (cell) cell.setVisited(false);
            }
        }

        const entrance = maze.getCell(0, 0);
        const exitCell = maze.getCell(width - 1, height - 1);
        maze.configureEntranceExit(entrance, exitCell);
    }

    getRandomUnvisitedNeighbor(c, m) {
        const unvisited = [];
        const x = c.x;
        const y = c.y;

        if (y > 0) {
            const neighbor = m.getCell(x, y - 1);
            if (neighbor && !neighbor.visited) unvisited.push(neighbor);
        }
        if (y < m.height - 1) {
            const neighbor = m.getCell(x, y + 1);
            if (neighbor && !neighbor.visited) unvisited.push(neighbor);
        }
        if (x > 0) {
            const neighbor = m.getCell(x - 1, y);
            if (neighbor && !neighbor.visited) unvisited.push(neighbor);
        }
        if (x < m.width - 1) {
            const neighbor = m.getCell(x + 1, y);
            if (neighbor && !neighbor.visited) unvisited.push(neighbor);
        }

        if (unvisited.length === 0) return null;
        const idx = Math.floor(Math.random() * unvisited.length);
        return unvisited[idx];
    }

    breakWalls(current, nextCell) {
        if (nextCell.y < current.y) {
            current.breakWall(Direction.NORTH);
            nextCell.breakWall(Direction.SOUTH);
        } else if (nextCell.y > current.y) {
            current.breakWall(Direction.SOUTH);
            nextCell.breakWall(Direction.NORTH);
        } else if (nextCell.x > current.x) {
            current.breakWall(Direction.EAST);
            nextCell.breakWall(Direction.WEST);
        } else if (nextCell.x < current.x) {
            current.breakWall(Direction.WEST);
            nextCell.breakWall(Direction.EAST);
        }
    }
}
