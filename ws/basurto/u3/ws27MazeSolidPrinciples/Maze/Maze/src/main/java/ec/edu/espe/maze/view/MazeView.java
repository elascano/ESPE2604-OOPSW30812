/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.maze.view;
import ec.edu.espe.maze.model.Cell;
import ec.edu.espe.maze.model.Maze;
import java.util.List;
/**
 *
 * @author Usuario
 */
public class MazeView {
   public void displayMaze(Maze maze, List<int[]> path) {
        int rows = maze.getRows();
        int cols = maze.getCols();
        Cell[][] grid = maze.getGrid();
        
        boolean[][] isPath = new boolean[rows][cols];
        if (path != null) {
            for (int[] p : path) {
                isPath[p[0]][p[1]] = true;
            }
        }

        for (int r = 0; r < rows; r++) {
            StringBuilder topLine = new StringBuilder();
            for (int c = 0; c < cols; c++) {
                topLine.append(grid[r][c].getWalls().get("top") ? "+---" : "+   ");
            }
            System.out.println(topLine.append("+"));

            StringBuilder sideLine = new StringBuilder();
            for (int c = 0; c < cols; c++) {
                Cell cell = grid[r][c];
                String character = " ";
                if (cell.isStart()) character = "S";
                else if (cell.isEnd()) character = "E";
                else if (isPath[r][c]) character = "*";

                sideLine.append(cell.getWalls().get("left") ? "| " + character + " " : "  " + character + " ");
            }
            System.out.println(sideLine.append("|"));
        }

        StringBuilder bottomLine = new StringBuilder();
        for (int c = 0; c < cols; c++) {
            bottomLine.append("+---");
        }
        System.out.println(bottomLine.append("+"));
    }
    
    public void showMessage(String message) {
        System.out.println(message);
    } 
}
