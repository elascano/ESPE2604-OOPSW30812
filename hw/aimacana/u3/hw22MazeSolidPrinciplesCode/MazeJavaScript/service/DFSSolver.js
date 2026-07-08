import IMazeSolver from './IMazeSolver.js';

export default class DFSSolver extends IMazeSolver {
    findPath(maze) {
        const width = maze.width;
        const height = maze.height;
        if (width <= 0 || height <= 0) return [];

        const entrance = maze.entrance;
        const exitCell = maze.exit;
        if (!entrance || !exitCell) return [];

        const visited = Array.from({ length: height }, () => Array(width).fill(false));
        const parent = Array.from({ length: height }, () => Array(width).fill(null));

        const stack = [entrance];
        visited[entrance.y][entrance.x] = true;
        let found = false;

        while (stack.length > 0) {
            const current = stack.pop();

            if (current === exitCell) {
                found = true;
                break;
            }

            const x = current.x;
            const y = current.y;

            if (!current.wallNorth && y > 0) {
                const nxt = maze.getCell(x, y - 1);
                if (nxt && !visited[nxt.y][nxt.x]) {
                    visited[nxt.y][nxt.x] = true;
                    parent[nxt.y][nxt.x] = current;
                    stack.push(nxt);
                }
            }
            if (!current.wallSouth && y < height - 1) {
                const nxt = maze.getCell(x, y + 1);
                if (nxt && !visited[nxt.y][nxt.x]) {
                    visited[nxt.y][nxt.x] = true;
                    parent[nxt.y][nxt.x] = current;
                    stack.push(nxt);
                }
            }
            if (!current.wallEast && x < width - 1) {
                const nxt = maze.getCell(x + 1, y);
                if (nxt && !visited[nxt.y][nxt.x]) {
                    visited[nxt.y][nxt.x] = true;
                    parent[nxt.y][nxt.x] = current;
                    stack.push(nxt);
                }
            }
            if (!current.wallWest && x > 0) {
                const nxt = maze.getCell(x - 1, y);
                if (nxt && !visited[nxt.y][nxt.x]) {
                    visited[nxt.y][nxt.x] = true;
                    parent[nxt.y][nxt.x] = current;
                    stack.push(nxt);
                }
            }
        }

        if (!found) return [];

        const path = [];
        let curr = exitCell;
        while (curr) {
            path.push(curr);
            curr = parent[curr.y][curr.x];
        }
        return path.reverse();
    }
}
