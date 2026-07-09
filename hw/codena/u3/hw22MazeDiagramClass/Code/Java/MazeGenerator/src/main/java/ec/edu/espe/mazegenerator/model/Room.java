/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.mazegenerator.model;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class Room {
    private Coordinate coordinate;
    private Door[] doors;
    private Wall[] walls;

    public Room(Coordinate coordinate, Door[] doors, Wall[] walls) {
        this.coordinate = coordinate;
        this.doors = doors;
        this.walls = walls;
    }

    @Override
    public String toString() {
        return "Room{" + "coordinate=" + coordinate + ", doors=" + doors + ", walls=" + walls + '}';
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
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
}
