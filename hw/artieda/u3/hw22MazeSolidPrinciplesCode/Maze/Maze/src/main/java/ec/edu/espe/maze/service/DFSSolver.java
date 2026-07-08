package ec.edu.espe.maze.service;

import ec.edu.espe.maze.model.Cell;
import ec.edu.espe.maze.model.Maze;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ArrayDeque;
import java.util.Deque;

public class DFSSolver implements IMazeSolver {

    @Override
    public List<Cell> findPath(Maze maze) {
        int width = maze.getWidth();
        int height = maze.getHeight();
        if (width <= 0 || height <= 0) {
            return Collections.emptyList();
        }

        Cell entrance = maze.getEntrance();
        Cell exit = maze.getExit();
        if (entrance == null || exit == null) {
            return Collections.emptyList();
        }

        boolean[][] visited = new boolean[height][width];
        Cell[][] parent = new Cell[height][width];

        Deque<Cell> stack = new ArrayDeque<>();
        stack.push(entrance);
        visited[entrance.getY()][entrance.getX()] = true;

        boolean found = false;
        while (!stack.isEmpty()) {
            Cell current = stack.pop();

            if (current == exit) {
                found = true;
                break;
            }

            int x = current.getX();
            int y = current.getY();

            if (!current.isWallNorth() && y > 0) {
                Cell next = maze.getCell(x, y - 1);
                if (next != null && !visited[next.getY()][next.getX()]) {
                    visited[next.getY()][next.getX()] = true;
                    parent[next.getY()][next.getX()] = current;
                    stack.push(next);
                }
            }
            if (!current.isWallSouth() && y < height - 1) {
                Cell next = maze.getCell(x, y + 1);
                if (next != null && !visited[next.getY()][next.getX()]) {
                    visited[next.getY()][next.getX()] = true;
                    parent[next.getY()][next.getX()] = current;
                    stack.push(next);
                }
            }
            if (!current.isWallEast() && x < width - 1) {
                Cell next = maze.getCell(x + 1, y);
                if (next != null && !visited[next.getY()][next.getX()]) {
                    visited[next.getY()][next.getX()] = true;
                    parent[next.getY()][next.getX()] = current;
                    stack.push(next);
                }
            }
            if (!current.isWallWest() && x > 0) {
                Cell next = maze.getCell(x - 1, y);
                if (next != null && !visited[next.getY()][next.getX()]) {
                    visited[next.getY()][next.getX()] = true;
                    parent[next.getY()][next.getX()] = current;
                    stack.push(next);
                }
            }
        }

        if (!found) {
            return Collections.emptyList();
        }

        List<Cell> path = new ArrayList<>();
        Cell curr = exit;
        while (curr != null) {
            path.add(curr);
            curr = parent[curr.getY()][curr.getX()];
        }
        Collections.reverse(path);
        return path;
    }
}
