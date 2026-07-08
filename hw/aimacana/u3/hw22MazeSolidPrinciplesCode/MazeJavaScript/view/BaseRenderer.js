import IMazeRenderer from './IMazeRenderer.js';

export default class BaseRenderer extends IMazeRenderer {
    draw(maze, path) {
        if (!this.validateMaze(maze)) {
            throw new Error("Invalid Maze");
        }
    }

    validateMaze(maze) {
        return maze != null && maze.width > 0 && maze.height > 0 && maze.grid != null;
    }
}
