package ec.edu.espe.mazesystem.generator; 

import ec.edu.espe.mazesystem.model.AbstractMaze;
import ec.edu.espe.mazesystem.model.Door;
import ec.edu.espe.mazesystem.model.Path;
import ec.edu.espe.mazesystem.model.Room;

import java.util.Random;

public class MazeGenerator implements MazeGeneratorAlgorithm {
    private Random random;

    public MazeGenerator() {
        this.random = new Random();
    }

    @Override
    public void generateMaze(AbstractMaze maze) {
        for (int y = 0; y < maze.getHeight(); y++) {
            for (int x = 0; x < maze.getWidth(); x++) {
                Room room = new Room(x, y);
                
                if (random.nextBoolean()) {
                    room.addDoor(new Door());
                }
                if (random.nextBoolean()) {
                    room.addDoor(new Door(true));
                }
                
                maze.addRoom(x, y, room);
            }
        }

        Room entrance = maze.getRoom(0, 0);
        if (entrance != null) {
            entrance.setEntrance(true);
        }

        Room exit = maze.getRoom(maze.getWidth() - 1, maze.getHeight() - 1);
        if (exit != null) {
            exit.setExit(true);
        }

        Path path = new Path();
        for (int y = 0; y < maze.getHeight(); y++) {
            for (int x = 0; x < maze.getWidth(); x++) {
                Room room = maze.getRoom(x, y);
                if (room != null) {
                    path.addRoom(room);
                }
            }
        }
        maze.setSolutionPath(path);
    }
}