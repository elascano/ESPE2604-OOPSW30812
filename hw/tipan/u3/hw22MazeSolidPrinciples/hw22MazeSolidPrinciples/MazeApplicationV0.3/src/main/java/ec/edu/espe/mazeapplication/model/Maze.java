/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.mazeapplication.model;

/**
 *
 * @author Cristian Palomo, Error 404, @ESPE
 */
public class Maze {
    private int rows;
    private int columns;

    private Room[][] rooms;

    private Path path;

    public Maze(int rows, int columns) {

        this.rows = rows;
        this.columns = columns;

        rooms = new Room[rows][columns];

        path = new Path();

    }

    public Room[][] getRooms() {
        return rooms;
    }

    public Path getPath() {
        return path;
    }
}
