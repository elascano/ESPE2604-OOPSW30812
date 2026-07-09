package ec.edu.espe.mazegenerator.model;

import java.util.ArrayList;
import java.util.List;

public class DFSMazeSolver implements MazeSolver {
    @Override
    public List<Room> solve(Maze maze) {
        int w = maze.getWidth();
        int h = maze.getHeight();
        boolean[][] visited = new boolean[w][h];
        List<Room> path = new ArrayList<>();
        
        dfs(maze.getRoom(0, 0), maze, visited, path);
        return path;
    }

    private boolean dfs(Room current, Maze maze, boolean[][] visited, List<Room> path) {
        visited[current.getX()][current.getY()] = true;
        path.add(current);

        if (current.isExit()) {
            return true;
        }

        for (Direction dir : Direction.values()) {
            if (current.hasDoor(dir)) {
                int nx = current.getX();
                int ny = current.getY();
                switch (dir) {
                    case NORTH: ny--; break;
                    case SOUTH: ny++; break;
                    case EAST: nx++; break;
                    case WEST: nx--; break;
                }
                
                if (nx >= 0 && ny >= 0 && nx < maze.getWidth() && ny < maze.getHeight()) {
                    if (!visited[nx][ny]) {
                        if (dfs(maze.getRoom(nx, ny), maze, visited, path)) {
                            return true;
                        }
                    }
                }
            }
        }
        
        path.remove(path.size() - 1);
        return false;
    }
}
