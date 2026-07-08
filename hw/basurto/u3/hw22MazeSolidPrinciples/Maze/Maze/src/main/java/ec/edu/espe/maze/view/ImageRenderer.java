package ec.edu.espe.maze.view;

import ec.edu.espe.maze.model.Cell;
import ec.edu.espe.maze.model.Maze;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ImageRenderer extends BaseRenderer {
    private final int CELL_SIZE_PX;

    public ImageRenderer() {
        this.CELL_SIZE_PX = 20;
    }

    public ImageRenderer(int cellSize) {
        this.CELL_SIZE_PX = cellSize;
    }

    @Override
    public void draw(Maze maze, List<Cell> path) {
        super.draw(maze, path);

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Maze Visualizer");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            
            int calculatedCellSize = CELL_SIZE_PX;
            if (maze.getWidth() > 100 || maze.getHeight() > 100) {
                calculatedCellSize = Math.max(4, 800 / Math.max(maze.getWidth(), maze.getHeight()));
            }

            MazePanel panel = new MazePanel(maze, path, calculatedCellSize);
            JScrollPane scrollPane = new JScrollPane(panel);
            scrollPane.setPreferredSize(new Dimension(850, 850));
            frame.add(scrollPane);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
