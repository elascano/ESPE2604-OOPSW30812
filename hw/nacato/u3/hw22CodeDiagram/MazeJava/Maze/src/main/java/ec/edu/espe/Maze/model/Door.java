/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.Maze.model;

/**
 *
 * @author Angie Nacato, Error 404, @ESPE
 */
public abstract class Door {
    protected Room room1;
    protected Room room2;
    protected Direction direction;

    public Door(Room room1, Room room2, Direction direction) {
        this.room1 = room1;
        this.room2 = room2;
        this.direction = direction;
    }

    public abstract void open();
}
