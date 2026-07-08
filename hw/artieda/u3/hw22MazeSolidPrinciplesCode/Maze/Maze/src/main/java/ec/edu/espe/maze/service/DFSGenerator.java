package ec.edu.espe.maze.service;

import ec.edu.espe.maze.model.Cell;
import ec.edu.espe.maze.model.Maze;
import ec.edu.espe.maze.model.Direction;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ArrayDeque;
import java.util.Deque;

public class DFSGenerator implements IMazeGenerator {
    private final Random random;

    public DFSGenerator() {
        this.random = new Random();
    }

    public DFSGenerator(long seed) {
        this.random = new Random(seed);
    }

    @Override
    public void generate(Maze maze) {
        int width = maze.getWidth();
        int height = maze.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Cell cell = maze.getCell(x, y);
                if (cell != null) {
                    cell.setVisited(false);
                }
            }
        }

        Cell current = maze.getCell(0, 0);
        if (current == null) {
            return;
        }
        current.markVisited();
        Deque<Cell> stack = new ArrayDeque<>();
        stack.push(current);

        while (!stack.isEmpty()) {
            Cell next = getRandomUnvisitedNeighbor(current, maze);
            if (next != null) {
                breakWalls(current, next);
                next.markVisited();
                stack.push(current);
                current = next;
            } else {
                current = stack.pop();
            }
        }

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Cell cell = maze.getCell(x, y);
                if (cell != null) {
                    cell.setVisited(false);
                }
            }
        }

        Cell entrance = maze.getCell(0, 0);
        Cell exit = maze.getCell(width - 1, height - 1);
        maze.configureEntranceExit(entrance, exit);
    }

    public Cell getRandomUnvisitedNeighbor(Cell c, Maze m) {
        List<Cell> unvisited = new ArrayList<>();
        int x = c.getX();
        int y = c.getY();

        if (y > 0) {
            Cell neighbor = m.getCell(x, y - 1);
            if (neighbor != null && !neighbor.isVisited()) {
                unvisited.add(neighbor);
            }
        }
        if (y < m.getHeight() - 1) {
            Cell neighbor = m.getCell(x, y + 1);
            if (neighbor != null && !neighbor.isVisited()) {
                unvisited.add(neighbor);
            }
        }
        if (x > 0) {
            Cell neighbor = m.getCell(x - 1, y);
            if (neighbor != null && !neighbor.isVisited()) {
                unvisited.add(neighbor);
            }
        }
        if (x < m.getWidth() - 1) {
            Cell neighbor = m.getCell(x + 1, y);
            if (neighbor != null && !neighbor.isVisited()) {
                unvisited.add(neighbor);
            }
        }

        if (unvisited.isEmpty()) {
            return null;
        }
        return unvisited.get(random.nextInt(unvisited.size()));
    }

    private void breakWalls(Cell current, Cell next) {
        if (next.getY() < current.getY()) {
            current.breakWall(Direction.NORTH);
            next.breakWall(Direction.SOUTH);
        } else if (next.getY() > current.getY()) {
            current.breakWall(Direction.SOUTH);
            next.breakWall(Direction.NORTH);
        } else if (next.getX() > current.getX()) {
            current.breakWall(Direction.EAST);
            next.breakWall(Direction.WEST);
        } else if (next.getX() < current.getX()) {
            current.breakWall(Direction.WEST);
            next.breakWall(Direction.EAST);
        }
    }
}
