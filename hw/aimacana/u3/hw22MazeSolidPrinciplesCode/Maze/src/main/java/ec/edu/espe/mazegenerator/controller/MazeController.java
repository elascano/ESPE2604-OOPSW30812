package ec.edu.espe.mazegenerator.controller;

import ec.edu.espe.mazegenerator.model.IMazeGenerator;
import ec.edu.espe.mazegenerator.model.Maze;
import ec.edu.espe.mazegenerator.model.MazeSolver;
import ec.edu.espe.mazegenerator.model.DFSMazeSolver;
import ec.edu.espe.mazegenerator.model.Room;
import ec.edu.espe.mazegenerator.view.IMazeView;

import java.util.List;

public class MazeController {
    private final IMazeGenerator generator;
    private final IMazeView view;
    private final MazeSolver solver;

    public MazeController(IMazeGenerator generator, IMazeView view) {
        this.generator = generator;
        this.view = view;
        this.solver = new DFSMazeSolver();
    }

    public void createAndRenderMaze(int width, int height) {
        Maze maze = generator.generate(width, height);
        List<Room> solution = solver.solve(maze);
        view.render(maze, solution);
    }
}
