package ec.edu.espe.mazesystem.model;

import ec.edu.espe.mazesystem.generator.MazeGeneratorAlgorithm;
import ec.edu.espe.mazesystem.generator.MazeGenerator;

public class Maze extends AbstractMaze {
    private MazeGeneratorAlgorithm generator;

    public Maze(int width, int height, MazeGeneratorAlgorithm generator) {
        super(width, height);  
        this.generator = generator;
    }

    public Maze(int width, int height) {
        super(width, height);
        this.generator = new MazeGenerator();  
    }

    public Maze() {
        super(5, 5);
        this.generator = new MazeGenerator();
    }

    @Override
    public void generate() {
        if (generator != null) {
            generator.generateMaze(this);
        }
    }

    public void setGenerator(MazeGeneratorAlgorithm generator) {
        this.generator = generator;
    }

    public MazeGeneratorAlgorithm getGenerator() {
        return generator;
    }
}