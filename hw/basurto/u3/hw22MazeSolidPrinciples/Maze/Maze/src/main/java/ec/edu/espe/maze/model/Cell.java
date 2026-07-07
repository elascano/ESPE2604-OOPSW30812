/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.maze.model;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author Usuario
 */
public class Cell {
    private final int row;
    private final int col;
    // Walls: true means the wall exists, false means it is open/removed
    private final Map<String, Boolean> walls;
    private boolean visited;
    private boolean isStart;
    private boolean isEnd;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.visited = false;
        this.isStart = false;
        this.isEnd = false;
        
        this.walls = new HashMap<>();
        this.walls.put("top", true);
        this.walls.put("right", true);
        this.walls.put("bottom", true);
        this.walls.put("left", true);
    }

    // Getters and Setters
    public int getRow() { return row; }
    public int getCol() { return col; }
    public boolean isVisited() { return visited; }
    public void setVisited(boolean visited) { this.visited = visited; }
    public boolean isStart() { return isStart; }
    public void setStart(boolean start) { isStart = start; }
    public boolean isEnd() { return isEnd; }
    public void setEnd(boolean end) { isEnd = end; }
    public Map<String, Boolean> getWalls() { return walls; 
    }
}
