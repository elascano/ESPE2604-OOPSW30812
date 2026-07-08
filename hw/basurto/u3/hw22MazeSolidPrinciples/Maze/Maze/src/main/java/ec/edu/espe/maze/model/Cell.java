package ec.edu.espe.maze.model;

public class Cell {
    private final int x;
    private final int y;
    private boolean wallNorth = true;
    private boolean wallSouth = true;
    private boolean wallEast = true;
    private boolean wallWest = true;
    private boolean visited = false;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isVisited() {
        return visited;
    }

    public void markVisited() {
        this.visited = true;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public void breakWall(Direction dir) {
        switch (dir) {
            case NORTH -> wallNorth = false;
            case SOUTH -> wallSouth = false;
            case EAST -> wallEast = false;
            case WEST -> wallWest = false;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isWallNorth() {
        return wallNorth;
    }

    public boolean isWallSouth() {
        return wallSouth;
    }

    public boolean isWallEast() {
        return wallEast;
    }

    public boolean isWallWest() {
        return wallWest;
    }
}
