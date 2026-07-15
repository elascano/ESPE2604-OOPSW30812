package ec.edu.espe.mazegenerator.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BacktrackingMazeGenerator implements IMazeGenerator {
    private final Random random = new Random();

    @Override
    public Maze generate(int width, int height) {
        Maze maze = new Maze(width, height);
        boolean[][] visited = new boolean[width][height];
        
        carvePassagesFrom(0, 0, maze, visited);

        maze.getRoom(0, 0).setEntrance(true);
        maze.getRoom(width - 1, height - 1).setExit(true);

        return maze;
    }

    private void carvePassagesFrom(int cx, int cy, Maze maze, boolean[][] visited) {
        visited[cx][cy] = true;

        List<Direction> directions = Arrays.asList(Direction.values());
        Collections.shuffle(directions, random);

        for (Direction direction : directions) {
            int nx = cx;
            int ny = cy;

            switch (direction) {
                case NORTH: ny = cy - 1; break;
                case SOUTH: ny = cy + 1; break;
                case EAST:  nx = cx + 1; break;
                case WEST:  nx = cx - 1; break;
            }

            if (nx >= 0 && ny >= 0 && nx < maze.getWidth() && ny < maze.getHeight() && !visited[nx][ny]) {
                maze.getRoom(cx, cy).addDoor(direction);
                maze.getRoom(nx, ny).addDoor(direction.getOpposite());
                carvePassagesFrom(nx, ny, maze, visited);
            }
        }
    }
}
