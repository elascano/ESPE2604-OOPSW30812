/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.maze.model;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;
/**
 *
 * @author Usuario
 */
public class Maze {
    private final int rows;
    private final int cols;
    private final Cell[][] grid;
    private Cell startCell;
    private Cell endCell;

    public Maze(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.grid = new Cell[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                grid[r][c] = new Cell(r, c);
            }
        }
    }

    public void generateMaze() {
        Stack<Cell> stack = new Stack<>();
        Cell current = grid[0][0];
        current.setVisited(true);
        stack.push(current);
        Random random = new Random();

        while (!stack.isEmpty()) {
            List<Cell> neighbors = getUnvisitedNeighbors(current);
            if (!neighbors.isEmpty()) {
                Cell nextCell = neighbors.get(random.nextInt(neighbors.size()));
                removeWalls(current, nextCell);
                nextCell.setVisited(true);
                stack.push(nextCell);
                current = nextCell;
            } else {
                current = stack.pop();
            }
        }
        startCell = grid[0][0];
        startCell.setStart(true);
        endCell = grid[rows - 1][cols - 1];
        endCell.setEnd(true);
    }

    private List<Cell> getUnvisitedNeighbors(Cell cell) {
        List<Cell> neighbors = new ArrayList<>();
        int r = cell.getRow();
        int c = cell.getCol();
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                Cell neighbor = grid[nr][nc];
                if (!neighbor.isVisited()) neighbors.add(neighbor);
            }
        }
        return neighbors;
    }

    private void removeWalls(Cell c1, Cell c2) {
        int dx = c2.getCol() - c1.getCol();
        int dy = c2.getRow() - c1.getRow();
        if (dx == 1) { c1.getWalls().put("right", false); c2.getWalls().put("left", false); }
        else if (dx == -1) { c1.getWalls().put("left", false); c2.getWalls().put("right", false); }
        else if (dy == 1) { c1.getWalls().put("bottom", false); c2.getWalls().put("top", false); }
        else if (dy == -1) { c1.getWalls().put("top", false); c2.getWalls().put("bottom", false); }
    }

    public List<int[]> solve() {
        List<int[]> path = new ArrayList<>();
        boolean[][] visited = new boolean[rows][cols];
        if (dfsRoute(startCell.getRow(), startCell.getCol(), endCell.getRow(), endCell.getCol(), visited, path)) {
            return path;
        }
        return new ArrayList<>();
    }

    private boolean dfsRoute(int r, int c, int endR, int endC, boolean[][] visited, List<int[]> path) {
        if (r == endR && c == endC) { path.add(new int[]{r, c}); return true; }
        visited[r][c] = true;
        path.add(new int[]{r, c});
        Cell cell = grid[r][c];
        Object[][] moves = {{-1, 0, "top"}, {1, 0, "bottom"}, {0, -1, "left"}, {0, 1, "right"}};

        for (Object[] move : moves) {
            int nr = r + (int) move[0];
            int nc = c + (int) move[1];
            String wall = (String) move[2];
            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                if (!cell.getWalls().get(wall) && !visited[nr][nc]) {
                    if (dfsRoute(nr, nc, endR, endC, visited, path)) return true;
                }
            }
        }
        path.remove(path.size() - 1);
        return false;
    }

    // Getters for the View component
    public int getRows() { return rows; }
    public int getCols() { return cols; }
    public Cell[][] getGrid() { return grid; }
}
