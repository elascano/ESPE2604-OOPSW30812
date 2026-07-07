/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.mazegenerator.model;

import java.util.ArrayList;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class Room {

    private int xCoordinate;
    private int yCoordinate;
    
    private Door doors[];
    private Wall walls[];

    public Room(int xCoordinate, int yCoordinate, Door[] doors, Wall[] walls) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.doors = doors;
        this.walls = walls;
    }

    
    @Override
    public String toString() {
        return "Room{" + "xCoordinate=" + xCoordinate + ", yCoordinate=" + yCoordinate + ", doors=" + doors + ", walls=" + walls + '}';
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
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
