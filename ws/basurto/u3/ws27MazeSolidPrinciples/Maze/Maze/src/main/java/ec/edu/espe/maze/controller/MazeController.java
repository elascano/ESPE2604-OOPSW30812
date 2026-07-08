/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.maze.controller;

import ec.edu.espe.maze.model.Maze;
import ec.edu.espe.maze.view.MazeView;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class MazeController {
  private Maze model;
    private MazeView view;

    public MazeController(Maze model, MazeView view) {
        this.model = model;
        this.view = view;
    }

    public void startApplication() {
        view.showMessage("--- Generating Maze (MVC Structure) ---");
        model.generateMaze();
        view.displayMaze(model, null); // Displays empty maze

        view.showMessage("\n--- Solving Maze (Route marked with '*') ---");
        List<int[]> solution = model.solve();
        view.displayMaze(model, solution); // Displays solved maze
    }

    // MAIN ENTRY POINT
    public static void main(String[] args) {
        // Initialize MVC Components
        Maze theModel = new Maze(6, 10);
        MazeView theView = new MazeView();
        
        // Controller binds Model and View together
        MazeController theController = new MazeController(theModel, theView);
        
        // Execute App
        theController.startApplication();
    }  
}
