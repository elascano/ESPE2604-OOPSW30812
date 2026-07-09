package ec.edu.espe.mazeapplication.controller;

import ec.edu.espe.mazeapplication.model.Maze;
import ec.edu.espe.mazeapplication.model.Room;
import ec.edu.espe.mazeapplication.model.Wall;

public class MazeController {

    private Maze maze;
    private MazeGenerator generator;

    public MazeController() {
        this.generator = new RandomMazeGenerator();
    }

    public void createMaze(int rows, int columns) {
        maze = new Maze(rows, columns);
        initializeMaze();
    }

    public void initializeMaze() {
        if (generator instanceof RandomMazeGenerator) {
            RandomMazeGenerator randomGen = (RandomMazeGenerator) generator;
            randomGen.setMaze(this.maze);
            randomGen.generateMaze();
        }
    }

    public Maze getMaze() {
        return maze;
    }

    public String drawMaze() {
        if (maze == null) {
            return "Maze not generated.";
        }

        StringBuilder builder = new StringBuilder();
        int rows = maze.getRows();
        int columns = maze.getColumns();
        
        for (int c = 0; c < columns; c++) {
            builder.append("+---");
        }
        builder.append("+\n");
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                Room room = maze.getRoom(r, c);
                Wall wall = room.getWalls()[0];
                
                if (c == 0) {
                    builder.append("|");
                } else {
                    Room leftRoom = maze.getRoom(r, c-1);
                    Wall leftWall = leftRoom.getWalls()[0];
                    if (leftWall != null && leftWall.isEastWall()) {
                        builder.append("|");
                    } else {
                        builder.append(" ");
                    }
                }
                
                if (r == 0 && c == 0) {
                    builder.append(" S ");
                } else if (r == rows - 1 && c == columns - 1) {
                    builder.append(" E ");
                } else {
                    builder.append("   ");
                }
            }
            builder.append("|\n");
            
            for (int c = 0; c < columns; c++) {
                Room room = maze.getRoom(r, c);
                Wall wall = room.getWalls()[0];
                
                builder.append("+");
                
                if (wall != null && wall.isSouthWall()) {
                    builder.append("---");
                } else {
                    builder.append("   ");
                }
            }
            builder.append("+\n");
        }
        
        return builder.toString();
    }
}