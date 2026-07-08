package ec.edu.espe.maze.view;

import ec.edu.espe.maze.model.Cell;
import ec.edu.espe.maze.model.Maze;
import java.util.List;

public class ASCIIRenderer extends BaseRenderer {

    @Override
    public void draw(Maze maze, List<Cell> path) {
        super.draw(maze, path);
        int width = maze.getWidth();
        int height = maze.getHeight();
        boolean[][] isPath = new boolean[height][width];
        if (path != null) {
            for (Cell cell : path) {
                isPath[cell.getY()][cell.getX()] = true;
            }
        }

        for (int y = 0; y < height; y++) {
            StringBuilder topLine = new StringBuilder();
            for (int x = 0; x < width; x++) {
                Cell cell = maze.getCell(x, y);
                topLine.append(cell.isWallNorth() ? "+---" : "+   ");
            }
            System.out.println(topLine.append("+"));

            StringBuilder sideLine = new StringBuilder();
            for (int x = 0; x < width; x++) {
                Cell cell = maze.getCell(x, y);
                String character = " ";
                if (cell == maze.getEntrance()) {
                    character = "S";
                } else if (cell == maze.getExit()) {
                    character = "E";
                } else if (isPath[y][x]) {
                    character = "*";
                }
                sideLine.append(cell.isWallWest() ? "| " + character + " " : "  " + character + " ");
            }
            System.out.println(sideLine.append("|"));
        }

        StringBuilder bottomLine = new StringBuilder();
        for (int x = 0; x < width; x++) {
            bottomLine.append("+---");
        }
        System.out.println(bottomLine.append("+"));
    }
}
