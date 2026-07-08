package ec.edu.espe.maze.view;

import ec.edu.espe.maze.model.Cell;
import ec.edu.espe.maze.model.Maze;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MazePanel extends JPanel {
    private final Maze maze;
    private final List<Cell> path;
    private final int cellSize;

    public MazePanel(Maze maze, List<Cell> path, int cellSize) {
        this.maze = maze;
        this.path = path;
        this.cellSize = cellSize;
        int w = maze.getWidth() * cellSize;
        int h = maze.getHeight() * cellSize;
        setPreferredSize(new Dimension(w + cellSize, h + cellSize));
        setBackground(new Color(18, 18, 24));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = maze.getWidth();
        int height = maze.getHeight();
        int margin = cellSize / 2;

        Color wallColor = new Color(74, 85, 104);
        Color pathColor = new Color(239, 68, 68);
        Color entranceColor = new Color(34, 197, 94);
        Color exitColor = new Color(59, 130, 246);
        Color cellBgColor = new Color(30, 41, 59);

        g2d.setColor(cellBgColor);
        g2d.fillRect(margin, margin, width * cellSize, height * cellSize);

        Cell entrance = maze.getEntrance();
        if (entrance != null) {
            g2d.setColor(entranceColor);
            g2d.fillRect(margin + entrance.getX() * cellSize, margin + entrance.getY() * cellSize, cellSize, cellSize);
        }
        Cell exit = maze.getExit();
        if (exit != null) {
            g2d.setColor(exitColor);
            g2d.fillRect(margin + exit.getX() * cellSize, margin + exit.getY() * cellSize, cellSize, cellSize);
        }

        if (path != null && !path.isEmpty()) {
            g2d.setColor(pathColor);
            g2d.setStroke(new BasicStroke(Math.max(2, cellSize / 4.0f), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            
            for (int i = 0; i < path.size() - 1; i++) {
                Cell c1 = path.get(i);
                Cell c2 = path.get(i + 1);
                int x1 = margin + c1.getX() * cellSize + cellSize / 2;
                int y1 = margin + c1.getY() * cellSize + cellSize / 2;
                int x2 = margin + c2.getX() * cellSize + cellSize / 2;
                int y2 = margin + c2.getY() * cellSize + cellSize / 2;
                g2d.drawLine(x1, y1, x2, y2);
            }
        }

        g2d.setColor(wallColor);
        g2d.setStroke(new BasicStroke(Math.max(1, cellSize / 10.0f)));

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Cell cell = maze.getCell(x, y);
                if (cell == null) continue;

                int cx = margin + x * cellSize;
                int cy = margin + y * cellSize;

                if (cell.isWallNorth()) {
                    g2d.drawLine(cx, cy, cx + cellSize, cy);
                }
                if (cell.isWallSouth()) {
                    g2d.drawLine(cx, cy + cellSize, cx + cellSize, cy + cellSize);
                }
                if (cell.isWallEast()) {
                    g2d.drawLine(cx + cellSize, cy, cx + cellSize, cy + cellSize);
                }
                if (cell.isWallWest()) {
                    g2d.drawLine(cx, cy, cx, cy + cellSize);
                }
            }
        }
    }
}
