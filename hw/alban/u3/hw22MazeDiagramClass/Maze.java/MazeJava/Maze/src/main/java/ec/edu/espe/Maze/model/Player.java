/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.Maze.model;

/**
 *
 * @author Angie Nacato, Error 404, @ESPE
 */
public class Player {
    private Room currentRoom;

    public Player(Room startingRoom) {
        this.currentRoom = startingRoom;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void move(String direction, Maze maze) {
        int cx = currentRoom.getX();
        int cy = currentRoom.getY();

        if (direction.equals("North") && !maze.hasHorizontalWall(cx, cy)) {
            cy -= 1;
        } else if (direction.equals("South") && !maze.hasHorizontalWall(cx, cy + 1)) {
            cy += 1;
        } else if (direction.equals("West") && !maze.hasVerticalWall(cx, cy)) {
            cx -= 1;
        } else if (direction.equals("East") && !maze.hasVerticalWall(cx + 1, cy)) {
            cx += 1;
        }

        for (Room r : maze.getRooms()) {
            if (r.getX() == cx && r.getY() == cy) {
                this.currentRoom = r;
                break;
            }
        }
    }
}
