/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.Maze.model;

/**
 *
 * @author Angie Nacato, Error 404, @ESPE
 */
public class Wall {
    private boolean isExterior;
    private Direction direction;

    public Wall(boolean isExterior, Direction direction) {
        this.isExterior = isExterior;
        this.direction = direction;
    }

    public boolean isExterior() { return isExterior; }
    public Direction getDirection() { return direction; }
}
