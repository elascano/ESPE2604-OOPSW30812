package ec.edu.espe.mazesystem.controller;

import ec.edu.espe.mazesystem.model.AbstractMaze;
import ec.edu.espe.mazesystem.model.Maze;
import ec.edu.espe.mazesystem.renderer.MazeRenderer;
import ec.edu.espe.mazesystem.generator.MazeGenerator;

public class MazeController {
    private AbstractMaze model;
    private MazeRenderer renderer;
    private int currentWidth;
    private int currentHeight;

    public MazeController(MazeRenderer renderer) {
        this.renderer = renderer;
        this.currentWidth = 5;
        this.currentHeight = 5;
        this.model = new Maze(currentWidth, currentHeight, new MazeGenerator());
    }

    public MazeController(AbstractMaze model, MazeRenderer renderer) {
        this.model = model;
        this.renderer = renderer;
        if (model != null) {
            this.currentWidth = model.getWidth();
            this.currentHeight = model.getHeight();
        }
    }

    public void setRenderer(MazeRenderer renderer) {
        this.renderer = renderer;
    }

    public void initMazeGeneration(int width, int height) {
        this.currentWidth = width;
        this.currentHeight = height;
        
        Maze maze = new Maze(width, height, new MazeGenerator());
        maze.generate();
        this.model = maze;
        
        if (renderer != null) {
            renderer.render(maze);
        }
    }

    public void renderMaze() {
        if (renderer != null && model != null) {
            renderer.render(model);
        }
    }

    public AbstractMaze getModel() {
        return model;
    }

    public MazeRenderer getRenderer() {
        return renderer;
    }

    public void setModel(AbstractMaze model) {
        this.model = model;
        if (model != null) {
            this.currentWidth = model.getWidth();
            this.currentHeight = model.getHeight();
        }
    }

    public int getCurrentWidth() {
        return currentWidth;
    }

    public int getCurrentHeight() {
        return currentHeight;
    }
}