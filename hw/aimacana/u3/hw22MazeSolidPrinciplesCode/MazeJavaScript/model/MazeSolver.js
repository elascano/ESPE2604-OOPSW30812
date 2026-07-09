
import { Direction } from './Direction.js';

export class MazeSolver {
    solve(maze) { throw new Error('Method not implemented.'); }
}

export class DFSMazeSolver extends MazeSolver {
    solve(maze) {
        const visited = Array.from({length: maze.height}, () => Array(maze.width).fill(false));
        const path = [];
        this.dfs(maze.getRoom(0, 0), maze, visited, path);
        return path;
    }

    dfs(curr, maze, visited, path) {
        visited[curr.y][curr.x] = true;
        path.push(curr);
        if (curr.isExit) return true;
        
        for (let d of [Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST]) {
            if (curr.hasDoor(d)) {
                let nx = curr.x, ny = curr.y;
                if (d === Direction.NORTH) ny--;
                else if (d === Direction.SOUTH) ny++;
                else if (d === Direction.EAST) nx++;
                else if (d === Direction.WEST) nx--;
                
                if (nx >= 0 && nx < maze.width && ny >= 0 && ny < maze.height && !visited[ny][nx]) {
                    if (this.dfs(maze.getRoom(nx, ny), maze, visited, path)) return true;
                }
            }
        }
        path.pop();
        return false;
    }
}
