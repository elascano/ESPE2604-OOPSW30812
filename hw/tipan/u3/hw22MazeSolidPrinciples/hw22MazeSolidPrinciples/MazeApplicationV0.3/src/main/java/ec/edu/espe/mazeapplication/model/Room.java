/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.mazeapplication.model;

import java.util.ArrayList;
/**
 *
 * @author Cristian Palomo, Error 404, @ESPE
 */
public class Room {
     private int x;
    private int y;

    private ArrayList<Door> doors;
    private ArrayList<Wall> walls;

    public Room(int x, int y) {

        this.x = x;
        this.y = y;

        doors = new ArrayList<>();
        walls = new ArrayList<>();
    }

    public void addDoor(Door door) {

        if (doors.size() < 3)
            doors.add(door);

    }

    public void addWall(Wall wall) {

        if (walls.size() < 3)
            walls.add(wall);

    }

    public int countDoors() {
        return doors.size();
    }

    public int countWalls() {
        return walls.size();
    }

}

