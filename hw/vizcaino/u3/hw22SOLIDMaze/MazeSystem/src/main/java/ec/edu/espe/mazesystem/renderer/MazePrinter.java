package ec.edu.espe.mazesystem.renderer;  

import ec.edu.espe.mazesystem.model.AbstractMaze;
import ec.edu.espe.mazesystem.model.Room;

public class MazePrinter implements MazeRenderer {
    @Override
    public void render(AbstractMaze maze) {
        System.out.println("=== Maze Display ===");
        System.out.println("Width: " + maze.getWidth());
        System.out.println("Height: " + maze.getHeight());
        System.out.println();

        for (int y = 0; y < maze.getHeight(); y++) {
            for (int x = 0; x < maze.getWidth(); x++) {
                Room room = maze.getRoom(x, y);
                if (room != null) {
                    String symbol = ".";
                    if (room.isEntrance()) symbol = "S";
                    else if (room.isExit()) symbol = "E";
                    System.out.print(symbol + " ");
                } else {
                    System.out.print("# ");
                }
            }
            System.out.println();
        }

        System.out.println("\nSolution Path: " + 
            (maze.getSolutionPath() != null ? 
             "Valid: " + maze.getSolutionPath().isValidUniquePath() : 
             "No path"));
    }
}