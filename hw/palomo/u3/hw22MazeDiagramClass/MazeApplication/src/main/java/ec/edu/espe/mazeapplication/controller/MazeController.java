/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.mazeapplication.controller;

import ec.edu.espe.mazeapplication.model.Maze;
/**
 *
 * @author Cristian Palomo, Error 404, @ESPE
 */
public class MazeController {
    private Maze maze;

    public void createMaze(int rows, int columns) {

        maze = new Maze(rows, columns);

        MazeGenerator generator = new MazeGenerator(maze);

        generator.createRooms();
        generator.assignWalls();
        generator.assignDoors();

    }

    public Maze getMaze() {
        return maze;
    }

    public String drawMaze() {

        String text = "";

        for (int i = 0; i < maze.getRooms().length; i++) {

            for (int j = 0; j < maze.getRooms()[0].length; j++) {

                text += "[ ]";

            }

            text += "\n";

        }

        return text;

    }
}
