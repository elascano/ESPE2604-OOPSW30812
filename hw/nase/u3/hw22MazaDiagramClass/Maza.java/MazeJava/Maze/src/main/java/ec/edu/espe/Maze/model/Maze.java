/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.Maze.model;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Angie Nacato, Error 404, @ESPE
 */
public class Maze {
    private int width;
    private int height;
    private List<Room> rooms;
    private Player player;
    private boolean[][] hWalls;
    private boolean[][] vWalls;

    public Maze(int width, int height) {
        this.width = width;
        this.height = height;
        this.rooms = new ArrayList<>();
    }

    public void generate(int width, int height) {
        this.width = width;
        this.height = height;
        this.rooms = new ArrayList<>();
        
        hWalls = new boolean[width][height + 1];
        vWalls = new boolean[width + 1][height];
        
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height + 1; j++) hWalls[i][j] = true;
        }
        for (int i = 0; i < width + 1; i++) {
            for (int j = 0; j < height; j++) vWalls[i][j] = true;
        }

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                this.rooms.add(new Room(x, y));
            }
        }
        
        Random rand = new Random();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                boolean removeNorth = (y > 0);
                boolean removeWest = (x > 0);

                if (removeNorth && removeWest) {
                    if (rand.nextBoolean()) {
                        hWalls[x][y] = false;
                    } else {
                        vWalls[x][y] = false;
                    }
                } else if (removeNorth) {
                    hWalls[x][y] = false;
                } else if (removeWest) {
                    vWalls[x][y] = false;
                }
            }
        }
    }

    public boolean hasHorizontalWall(int x, int y) { return hWalls[x][y]; }
    public boolean hasVerticalWall(int x, int y) { return vWalls[x][y]; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public List<Room> getRooms() { return rooms; }
    public void setPlayer(Player player) { this.player = player; }
    public Player getPlayer() { return player; }
}
