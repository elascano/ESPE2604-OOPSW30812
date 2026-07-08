package ec.edu.espe.maze.view;

import ec.edu.espe.maze.model.Maze;
import ec.edu.espe.maze.model.Cell;
import java.util.List;

public abstract class BaseRenderer implements IMazeRenderer {

    @Override
    public void draw(Maze maze, List<Cell> path) {
        if (!validateMaze(maze)) {
            throw new IllegalArgumentException();
        }
    }

    public boolean validateMaze(Maze maze) {
        return maze != null && maze.getWidth() > 0 && maze.getHeight() > 0 && maze.getGrid() != null;
    }
}
