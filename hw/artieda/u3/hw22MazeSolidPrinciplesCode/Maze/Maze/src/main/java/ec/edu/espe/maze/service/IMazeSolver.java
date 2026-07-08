package ec.edu.espe.maze.service;

import ec.edu.espe.maze.model.Cell;
import ec.edu.espe.maze.model.Maze;
import java.util.List;

public interface IMazeSolver {
    List<Cell> findPath(Maze maze);
}
