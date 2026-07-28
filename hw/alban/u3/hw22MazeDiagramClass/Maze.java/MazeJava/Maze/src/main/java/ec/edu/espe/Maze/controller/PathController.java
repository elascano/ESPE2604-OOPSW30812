/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.Maze.controller;
import ec.edu.espe.Maze.model.*;
import ec.edu.espe.Maze.view.MazeGUI;
import javax.swing.JOptionPane;

/**
 *
 * @author Angie Nacato, Error 404, @ESPE
 */
public class PathController {
    
    private Maze maze;
    private MazeGUI view;

    public PathController(Maze maze, MazeGUI view) {
        this.maze = maze;
        this.view = view;
    }

    public void movePlayer(String direction) {
        if (maze.getPlayer() != null) {
            maze.getPlayer().move(direction, maze);
            view.render(maze); 
            
            Room current = maze.getPlayer().getCurrentRoom();
            if (current.getX() == maze.getWidth() - 1 && current.getY() == maze.getHeight() - 1) {
                JOptionPane.showMessageDialog(null, "Congratulations! You found the exit!", "Level Complete", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            Maze maze = new Maze(10, 10);
            maze.generate(10, 10);
            
            Room startRoom = maze.getRooms().get(0);
            Player player = new Player(startRoom);
            maze.setPlayer(player);
            
            MazeGUI gui = new MazeGUI();
            PathController controller = new PathController(maze, gui);
            gui.setController(controller); 
            
            gui.render(maze); 
            gui.setVisible(true);             
        });
    }
}