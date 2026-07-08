package ec.edu.espe.maze.view;

import ec.edu.espe.maze.model.Maze;
import ec.edu.espe.maze.model.Cell;
import java.util.List;

public interface IMazeRenderer {
    void draw(Maze maze, List<Cell> path);
}
