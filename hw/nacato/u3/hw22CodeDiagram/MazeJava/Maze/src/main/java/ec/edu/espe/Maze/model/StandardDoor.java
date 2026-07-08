/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.Maze.model;

/**
 *
 * @author Angie Nacato, Error 404, @ESPE
 */
public class StandardDoor extends Door {
    public StandardDoor(Room room1, Room room2, Direction direction) {
        super(room1, room2, direction);
    }

    @Override
    public void open() {}
}
