/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.mazeapplication.controller;

import ec.edu.espe.mazeapplication.model.Maze;
import ec.edu.espe.mazeapplication.model.Room;
/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */
public class MazeController {

    private Maze maze;

    public void createMaze(int rows, int columns) {

        maze = new Maze(rows, columns);

        MazeGenerator generator = new RandomMazeGenerator(maze);

        generator.createRooms();
        generator.assignWalls();
        generator.assignDoors();

    }

    public Maze getMaze() {
        return maze;
    }

    public String drawMaze() {

    StringBuilder mazeView = new StringBuilder();

    Room[][] rooms = maze.getRooms();

    for (int i = 0; i < rooms.length; i++) {

        for (int j = 0; j < rooms[0].length; j++) {

            Room room = rooms[i][j];

            if (i == 0 && j == 0) {
                mazeView.append("[E]");
            } else if (i == rooms.length - 1 && j == rooms[0].length - 1) {
                mazeView.append("[S]");
            } else {
                mazeView.append("[R]");
            }

        }

        mazeView.append("\n");
    }

    mazeView.append("\nLegend:\n");
    mazeView.append("E = Entrance\n");
    mazeView.append("S = Exit\n");
    mazeView.append("R = Room\n");
    mazeView.append("D = Door\n");
    mazeView.append("W = Wall\n");

    return mazeView.toString();
}
}