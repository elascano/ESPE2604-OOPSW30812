/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.Maze.model;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Angie Nacato, Error 404, @ESPE
 */
public class Room {
    private int x;
    private int y;
    private List<Door> doors;
    private List<Wall> walls;

    public Room(int x, int y) {
        this.x = x;
        this.y = y;
        this.doors = new ArrayList<>();
        this.walls = new ArrayList<>();
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public void addDoor(Door door) { this.doors.add(door); }
    public void addWall(Wall wall) { this.walls.add(wall); }
}
