
import { Maze } from './Maze.js';
import { Direction } from './Direction.js';

export class IMazeGenerator {
    generate(w, h) { throw new Error('Method not implemented.'); }
}

export class BacktrackingMazeGenerator extends IMazeGenerator {
    generate(w, h) {
        const maze = new Maze(w, h);
        const visited = Array.from({length: h}, () => Array(w).fill(false));
        this.carve(0, 0, maze, visited);
        
        maze.getRoom(0, 0).isEntrance = true;
        maze.getRoom(0, 0).addDoor(Direction.NORTH);
        maze.getRoom(w-1, h-1).isExit = true;
        maze.getRoom(w-1, h-1).addDoor(Direction.SOUTH);
        return maze;
    }

    carve(cx, cy, maze, visited) {
        visited[cy][cx] = true;
        const dirs = [Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST].sort(() => Math.random() - 0.5);
        
        for (let d of dirs) {
            let nx = cx, ny = cy;
            if (d === Direction.NORTH) ny--;
            else if (d === Direction.SOUTH) ny++;
            else if (d === Direction.EAST) nx++;
            else if (d === Direction.WEST) nx--;
            
            if (nx >= 0 && nx < maze.width && ny >= 0 && ny < maze.height && !visited[ny][nx]) {
                maze.getRoom(cx, cy).addDoor(d);
                const opp = { [Direction.NORTH]: Direction.SOUTH, [Direction.SOUTH]: Direction.NORTH, [Direction.EAST]: Direction.WEST, [Direction.WEST]: Direction.EAST };
                maze.getRoom(nx, ny).addDoor(opp[d]);
                this.carve(nx, ny, maze, visited);
            }
        }
    }
}
