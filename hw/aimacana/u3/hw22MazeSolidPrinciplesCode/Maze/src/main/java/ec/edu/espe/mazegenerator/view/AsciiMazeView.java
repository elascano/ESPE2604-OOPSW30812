package ec.edu.espe.mazegenerator.view;

import ec.edu.espe.mazegenerator.model.Direction;
import ec.edu.espe.mazegenerator.model.Maze;
import ec.edu.espe.mazegenerator.model.Room;

public class AsciiMazeView implements IMazeView {
    @Override
    public void render(Maze maze, java.util.List<Room> solution) {
        int width = maze.getWidth();
        int height = maze.getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Room room = maze.getRoom(x, y);
                System.out.print("+");
                if (room.hasDoor(Direction.NORTH) || (room.isEntrance() && y == 0)) {
                    System.out.print("   ");
                } else {
                    System.out.print("---");
                }
            }
            System.out.println("+");

            for (int x = 0; x < width; x++) {
                Room room = maze.getRoom(x, y);
                if (room.hasDoor(Direction.WEST) || (room.isEntrance() && x == 0)) {
                    System.out.print(" ");
                } else {
                    System.out.print("|");
                }
                
                if (room.isEntrance()) {
                    System.out.print(" S ");
                } else if (room.isExit()) {
                    System.out.print(" E ");
                } else {
                    System.out.print("   ");
                }
            }
            Room lastRoom = maze.getRoom(width - 1, y);
            if (lastRoom.isExit() && y == height - 1) { 
                System.out.println(" ");
            } else {
                System.out.println("|");
            }
        }

        for (int x = 0; x < width; x++) {
            Room room = maze.getRoom(x, height - 1);
            System.out.print("+");
            if (room.hasDoor(Direction.SOUTH) || (room.isExit() && x == width - 1)) {
                 System.out.print("   ");
            } else {
                 System.out.print("---");
            }
        }
        System.out.println("+");
    }
}
