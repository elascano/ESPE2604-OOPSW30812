package ec.edu.espe.mazegenerator.view;

import ec.edu.espe.mazegenerator.model.Direction;
import ec.edu.espe.mazegenerator.model.Maze;
import ec.edu.espe.mazegenerator.model.Room;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageMazeView implements IMazeView {
    private final String outputPath;
    private final int cellSize = 40;

    public ImageMazeView(String outputPath) {
        this.outputPath = outputPath;
    }

    @Override
    public void render(Maze maze, java.util.List<Room> solution) {
        int width = maze.getWidth() * cellSize;
        int height = maze.getHeight() * cellSize;
        
        BufferedImage image = new BufferedImage(width + 1, height + 1, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width + 1, height + 1);
        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(2));

        for (int x = 0; x < maze.getWidth(); x++) {
            for (int y = 0; y < maze.getHeight(); y++) {
                Room room = maze.getRoom(x, y);
                int px = x * cellSize;
                int py = y * cellSize;

                if (!room.hasDoor(Direction.NORTH) && !(room.isEntrance() && y == 0)) {
                    g.drawLine(px, py, px + cellSize, py);
                }
                if (!room.hasDoor(Direction.WEST) && !(room.isEntrance() && x == 0)) {
                    g.drawLine(px, py, px, py + cellSize);
                }
                if (x == maze.getWidth() - 1 && !(room.isExit() && y == maze.getHeight() - 1)) {
                    g.drawLine(px + cellSize, py, px + cellSize, py + cellSize);
                }
                if (y == maze.getHeight() - 1 && !(room.isExit() && x == maze.getWidth() - 1)) {
                    g.drawLine(px, py + cellSize, px + cellSize, py + cellSize);
                }
                
                if (room.isEntrance()) {
                    g.setColor(Color.GREEN);
                    g.fillRect(px + 4, py + 4, cellSize - 8, cellSize - 8);
                    g.setColor(Color.BLACK);
                } else if (room.isExit()) {
                    g.setColor(Color.RED);
                    g.fillRect(px + 4, py + 4, cellSize - 8, cellSize - 8);
                    g.setColor(Color.BLACK);
                }
            }
        }
        
        g.dispose();
        
        try {
            ImageIO.write(image, "png", new File(outputPath));
            System.out.println("Imagen del laberinto guardada en: " + new File(outputPath).getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
