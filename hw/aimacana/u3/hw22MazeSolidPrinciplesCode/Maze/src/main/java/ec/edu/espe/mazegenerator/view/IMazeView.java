package ec.edu.espe.mazegenerator.view;

import ec.edu.espe.mazegenerator.model.Maze;
import ec.edu.espe.mazegenerator.model.Room;
import java.util.List;

public interface IMazeView {
    void render(Maze maze, List<Room> solution);
}
