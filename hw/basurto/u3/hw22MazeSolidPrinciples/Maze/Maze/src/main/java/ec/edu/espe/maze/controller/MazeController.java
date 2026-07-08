package ec.edu.espe.maze.controller;

import ec.edu.espe.maze.model.Cell;
import ec.edu.espe.maze.model.Maze;
import ec.edu.espe.maze.service.IMazeGenerator;
import ec.edu.espe.maze.service.IMazeSolver;
import ec.edu.espe.maze.view.IMazeRenderer;
import java.util.List;

public class MazeController {
    private final IMazeGenerator generator;
    private final IMazeSolver solver;
    private final IMazeRenderer renderer;

    public MazeController(IMazeGenerator g, IMazeSolver s, IMazeRenderer r) {
        this.generator = g;
        this.solver = s;
        this.renderer = r;
    }

    public void createAndShowMaze(int width, int height) {
        Maze maze = new Maze(width, height);
        generator.generate(maze);
        List<Cell> path = solver.findPath(maze);
        renderer.draw(maze, path);
    }
}
