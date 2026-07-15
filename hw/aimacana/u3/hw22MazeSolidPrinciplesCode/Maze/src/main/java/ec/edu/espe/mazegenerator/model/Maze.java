package ec.edu.espe.mazegenerator.model;

public class Maze {
    private final int width;
    private final int height;
    private final Room[][] grid;

    public Maze(int width, int height) {
        this.width = width;
        this.height = height;
        this.grid = new Room[width][height];

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                grid[x][y] = new Room(x, y);
            }
        }
    }

    public Room getRoom(int x, int y) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            return grid[x][y];
        }
        return null;
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }
}
