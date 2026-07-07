/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.mazeapplication.controller;

import ec.edu.espe.mazeapplication.model.*;

/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */
public class RandomMazeGenerator implements MazeGenerator {

    private Maze maze;

    public RandomMazeGenerator(Maze maze) {
        this.maze = maze;
    }

    @Override
    public void createRooms() {

        Room[][] rooms = maze.getRooms();

        for (int i = 0; i < rooms.length; i++) {

            for (int j = 0; j < rooms[0].length; j++) {

                rooms[i][j] = new Room(i, j);

            }

        }

    }

    @Override
    public void assignWalls() {

        for (Room[] row : maze.getRooms()) {

            for (Room room : row) {

                while (room.countWalls() < 3) {
                    room.addWall(new Wall());
                }

            }

        }

    }

    @Override
    public void assignDoors() {

        Room[][] rooms = maze.getRooms();

        rooms[0][0].addDoor(new EntranceDoor());

        rooms[rooms.length - 1][rooms[0].length - 1]
                .addDoor(new ExitDoor());

    }
}
