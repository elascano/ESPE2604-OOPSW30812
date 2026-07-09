package ec.edu.espe.mazeapplication.controller;

import ec.edu.espe.mazeapplication.model.Maze;

public interface MazeGenerator {
    Maze generateMaze();
    boolean validateMaze();
    void createRooms();
    void generateUniquePath();
}