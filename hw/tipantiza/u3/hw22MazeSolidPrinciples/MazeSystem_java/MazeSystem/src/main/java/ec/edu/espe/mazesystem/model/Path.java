package ec.edu.espe.mazesystem.model;  

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Path {
    private List<Room> steps;

    public Path() {
        this.steps = new ArrayList<>();
    }

    public void addRoom(Room room) {
        steps.add(room);
    }

    public boolean isValidUniquePath() {
        Set<Room> uniqueRooms = new HashSet<>(steps);
        return uniqueRooms.size() == steps.size();
    }

    public List<Room> getSteps() {
        return steps;
    }

    public void clear() {
        steps.clear();
    }
}