/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.mazegenerator.model;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class Maze {

    private int rows;
    private int columns;
    private Room[][] rooms;
    private Path path;

    public Maze() {
    }

    public Maze(int rows, int columns, Room[][] rooms, Path path) {
        this.rows = rows;
        this.columns = columns;
        this.rooms = rooms;
        this.path = path;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public Room[][] getRooms() {
        return rooms;
    }

    public void setRooms(Room[][] rooms) {
        this.rooms = rooms;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

}