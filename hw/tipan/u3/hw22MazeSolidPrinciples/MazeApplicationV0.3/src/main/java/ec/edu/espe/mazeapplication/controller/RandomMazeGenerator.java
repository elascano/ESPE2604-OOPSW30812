package ec.edu.espe.mazeapplication.controller;

import ec.edu.espe.mazeapplication.model.CommonDoor;
import ec.edu.espe.mazeapplication.model.ExitDoor;
import ec.edu.espe.mazeapplication.model.Maze;
import ec.edu.espe.mazeapplication.model.Room;
import ec.edu.espe.mazeapplication.model.StartDoor;
import ec.edu.espe.mazeapplication.model.Wall;
import java.util.Random;
import java.util.Stack;

public class RandomMazeGenerator implements MazeGenerator {

    private Maze maze;
    private final Random random = new Random();
    private boolean[][] visited;

    public void setMaze(Maze maze) {
        this.maze = maze;
    }

    public Maze getMaze() {
        return maze;
    }

    @Override
    public Maze generateMaze() {
        if (maze == null) {
            return null;
        }
        createRooms();
        generateUniquePath();
        return maze;
    }

    @Override
    public boolean validateMaze() {
        return maze != null && maze.getRooms() != null;
    }

    @Override
    public void createRooms() {
        for (int i = 0; i < maze.getRows(); i++) {
            for (int j = 0; j < maze.getColumns(); j++) {
                maze.getRooms()[i][j] = new Room(i, j);
            }
        }
    }

    @Override
    public void generateUniquePath() {
        visited = new boolean[maze.getRows()][maze.getColumns()];
        initializeWalls();
        
        Stack<Room> stack = new Stack<>();
        Room start = maze.getRoom(0, 0);
        start.setVisited(true);
        visited[0][0] = true;
        stack.push(start);
        
        while (!stack.isEmpty()) {
            Room current = stack.peek();
            Room next = getRandomUnvisitedNeighbor(current);
            
            if (next != null) {
                removeWallBetween(current, next);
                next.setVisited(true);
                visited[next.getX()][next.getY()] = true;
                stack.push(next);
            } else {
                stack.pop();
            }
        }
        
        placeStartDoor();
        placeExitDoor();
    }
    
    private void initializeWalls() {
        for (int i = 0; i < maze.getRows(); i++) {
            for (int j = 0; j < maze.getColumns(); j++) {
                Room room = maze.getRoom(i, j);
                Wall wall = new Wall(true, true, true, true);
                room.addWall(wall);
            }
        }
    }
    
    private Room getRandomUnvisitedNeighbor(Room room) {
        int x = room.getX();
        int y = room.getY();
        
        java.util.List<Room> neighbors = new java.util.ArrayList<>();
        
        if (x > 0 && !visited[x-1][y]) {
            neighbors.add(maze.getRoom(x-1, y));
        }
        if (x < maze.getRows() - 1 && !visited[x+1][y]) {
            neighbors.add(maze.getRoom(x+1, y));
        }
        if (y > 0 && !visited[x][y-1]) {
            neighbors.add(maze.getRoom(x, y-1));
        }
        if (y < maze.getColumns() - 1 && !visited[x][y+1]) {
            neighbors.add(maze.getRoom(x, y+1));
        }
        
        if (neighbors.isEmpty()) {
            return null;
        }
        
        return neighbors.get(random.nextInt(neighbors.size()));
    }
    
    private void removeWallBetween(Room current, Room next) {
        int x1 = current.getX();
        int y1 = current.getY();
        int x2 = next.getX();
        int y2 = next.getY();
        
        if (x1 == x2) {
            if (y2 > y1) {
                removeWallDirection(current, "east");
                removeWallDirection(next, "west");
            } else {
                removeWallDirection(current, "west");
                removeWallDirection(next, "east");
            }
        } else {
            if (x2 > x1) {
                removeWallDirection(current, "south");
                removeWallDirection(next, "north");
            } else {
                removeWallDirection(current, "north");
                removeWallDirection(next, "south");
            }
        }
        
        current.addDoor(new CommonDoor());
        next.addDoor(new CommonDoor());
    }
    
    private void removeWallDirection(Room room, String direction) {
        Wall[] walls = room.getWalls();
        for (Wall wall : walls) {
            if (wall != null) {
                switch (direction) {
                    case "north": wall.setNorthWall(false); break;
                    case "south": wall.setSouthWall(false); break;
                    case "east": wall.setEastWall(false); break;
                    case "west": wall.setWestWall(false); break;
                }
            }
        }
    }

    private void placeStartDoor() {
        Room start = maze.getRoom(0, 0);
        Wall[] walls = start.getWalls();
        if (walls[0] != null) {
            walls[0].setNorthWall(false);
        }
        start.addDoor(new StartDoor());
    }

    private void placeExitDoor() {
        Room exit = maze.getRoom(maze.getRows() - 1, maze.getColumns() - 1);
        Wall[] walls = exit.getWalls();
        if (walls[0] != null) {
            walls[0].setSouthWall(false);
        }
        exit.addDoor(new ExitDoor());
    }
}