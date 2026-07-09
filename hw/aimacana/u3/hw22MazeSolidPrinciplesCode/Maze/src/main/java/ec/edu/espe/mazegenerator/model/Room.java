package ec.edu.espe.mazegenerator.model;

import java.util.HashMap;
import java.util.Map;

public class Room {
    private final int x;
    private final int y;
    private final Map<Direction, Boolean> doors = new HashMap<>();
    private boolean isEntrance = false;
    private boolean isExit = false;

    public Room(int x, int y) {
        this.x = x;
        this.y = y;
        for (Direction dir : Direction.values()) {
            doors.put(dir, false);
        }
    }

    public void addDoor(Direction direction) {
        doors.put(direction, true);
    }

    public boolean hasDoor(Direction direction) {
        return doors.get(direction);
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public boolean isEntrance() { return isEntrance; }
    public void setEntrance(boolean entrance) { this.isEntrance = entrance; }

    public boolean isExit() { return isExit; }
    public void setExit(boolean exit) { this.isExit = exit; }
}
