/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.Maze.view;
import ec.edu.espe.Maze.model.Maze;

/**
 *
 * @author Angie Nacato, Error 404, @ESPE
 */
public class ASCIIPrinter implements MazeRenderer {
    @Override
    public void render(Maze maze) {
        System.out.println("Renderizando laberinto en consola [" + maze.getWidth() + "x" + maze.getHeight() + "]");
    }
}