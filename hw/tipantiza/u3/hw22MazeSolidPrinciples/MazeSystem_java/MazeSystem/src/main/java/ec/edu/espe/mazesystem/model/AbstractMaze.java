package ec.edu.espe.mazesystem.model;  

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMaze {
    protected int width;
    protected int height;
    protected List<List<List<Room>>> rooms;
    protected Path solutionPath;

    public AbstractMaze(int width, int height) {
        this.width = width;
        this.height = height;
        this.rooms = new ArrayList<>();
        this.solutionPath = new Path();
        initializeRooms();
    }

    public AbstractMaze() {
        this(5, 5);
    }

    private void initializeRooms() {
        for (int i = 0; i < height; i++) {
            List<List<Room>> row = new ArrayList<>();
            for (int j = 0; j < width; j++) {
                List<Room> roomList = new ArrayList<>();
                row.add(roomList);
            }
            rooms.add(row);
        }
    }

    public abstract void generate();

    public Room getRoom(int x, int y) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            List<Room> roomList = rooms.get(y).get(x);
            return roomList.isEmpty() ? null : roomList.get(0);
        }
        return null;
    }

    public void addRoom(int x, int y, Room room) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            rooms.get(y).get(x).add(room);
        }
    }

    public Path getSolutionPath() {
        return solutionPath;
    }

    public void setSolutionPath(Path solutionPath) {
        this.solutionPath = solutionPath;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}