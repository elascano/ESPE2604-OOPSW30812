import Maze from '../model/Maze.js';

export default class MazeController {
    constructor(generator, solver, renderer) {
        this.generator = generator;
        this.solver = solver;
        this.renderer = renderer;
    }

    createAndShowMaze(width, height) {
        const maze = new Maze(width, height);
        this.generator.generate(maze);
        const path = this.solver.findPath(maze);
        this.renderer.draw(maze, path);
    }
}
