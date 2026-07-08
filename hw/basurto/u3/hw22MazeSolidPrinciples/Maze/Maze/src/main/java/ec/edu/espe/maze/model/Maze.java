package ec.edu.espe.maze.model;

public class Maze {
    private final int width;
    private final int height;
    private final Cell[][] grid;
    private Cell entrance;
    private Cell exit;

    public Maze(int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException();
        }
        this.width = width;
        this.height = height;
        this.grid = new Cell[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                grid[y][x] = new Cell(x, y);
            }
        }
    }

    public Cell getCell(int x, int y) {
        if (x < 0 || x >= width || y < 0 || y >= height) {
            return null;
        }
        return grid[y][x];
    }

    public void configureEntranceExit(Cell entrance, Cell exit) {
        this.entrance = entrance;
        this.exit = exit;
    }

    public Cell getEntrance() {
        return entrance;
    }

    public Cell getExit() {
        return exit;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Cell[][] getGrid() {
        return grid;
    }
}
