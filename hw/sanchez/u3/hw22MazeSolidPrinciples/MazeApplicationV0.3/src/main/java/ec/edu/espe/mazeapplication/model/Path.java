package ec.edu.espe.mazeapplication.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Joel Sanchez
 */
public class Path {

    private ArrayList<Room> rooms;

    public Path() {
        rooms = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Room getRoom(int index) {
        return rooms.get(index);
    }

    public int getSize() {
        return rooms.size();
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public boolean contains(Room room) {
        return rooms.contains(room);
    }
}