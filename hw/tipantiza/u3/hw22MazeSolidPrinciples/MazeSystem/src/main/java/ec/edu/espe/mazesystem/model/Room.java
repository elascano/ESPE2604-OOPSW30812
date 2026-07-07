package ec.edu.espe.mazesystem.model;  
import java.util.ArrayList;
import java.util.List;

public class Room {
    private int x;
    private int y;
    private boolean isEntrance;
    private boolean isExit;
    private List<Door> connectingDoors;

    public Room(int x, int y) {
        this.x = x;
        this.y = y;
        this.isEntrance = false;
        this.isExit = false;
        this.connectingDoors = new ArrayList<>();
    }

    public List<Door> getConnectingDoors() {
        return connectingDoors;
    }

    public void addDoor(Door door) {
        connectingDoors.add(door);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isEntrance() {
        return isEntrance;
    }

    public void setEntrance(boolean entrance) {
        isEntrance = entrance;
    }

    public boolean isExit() {
        return isExit;
    }

    public void setExit(boolean exit) {
        isExit = exit;
    }

    @Override
    public String toString() {
        return String.format("Room(%d, %d) [Entrance: %s, Exit: %s]", 
            x, y, isEntrance, isExit);
    }
}