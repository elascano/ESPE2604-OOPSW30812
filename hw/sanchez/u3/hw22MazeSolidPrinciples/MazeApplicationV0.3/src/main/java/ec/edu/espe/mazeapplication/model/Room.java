package ec.edu.espe.mazeapplication.model;

/**
 *
 * @author Joel Sanchez
 */
public class Room {

    private int x;
    private int y;

    private Door[] doors;
    private Wall[] walls;

    private boolean visited;

    public Room(int x, int y) {

        this.x = x;
        this.y = y;

        doors = new Door[3];
        walls = new Wall[3];

        visited = false;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Door[] getDoors() {
        return doors;
    }

    public void setDoors(Door[] doors) {
        this.doors = doors;
    }

    public Wall[] getWalls() {
        return walls;
    }

    public void setWalls(Wall[] walls) {
        this.walls = walls;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public void addDoor(Door door) {

        for (int i = 0; i < doors.length; i++) {
            if (doors[i] == null) {
                doors[i] = door;
                return;
            }
        }
    }

    public void addWall(Wall wall) {

        for (int i = 0; i < walls.length; i++) {
            if (walls[i] == null) {
                walls[i] = wall;
                return;
            }
        }
    }

    public int countDoors() {

        int count = 0;

        for (Door door : doors) {
            if (door != null) {
                count++;
            }
        }

        return count;
    }

    public int countWalls() {

        int count = 0;

        for (Wall wall : walls) {
            if (wall != null) {
                count++;
            }
        }

        return count;
    }

    @Override
    public String toString() {
        return "Room(" + x + "," + y + ")";
    }
}