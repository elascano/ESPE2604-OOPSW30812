package ec.edu.espe.mazesystem.renderer;  
import ec.edu.espe.mazesystem.model.AbstractMaze;
import ec.edu.espe.mazesystem.model.Room;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageMazeRenderer implements MazeRenderer {
    private String fileFormat;

    public ImageMazeRenderer(String fileFormat) {
        this.fileFormat = fileFormat;
    }

    @Override
    public void render(AbstractMaze maze) {
        int cellSize = 30;
        int width = maze.getWidth() * cellSize;
        int height = maze.getHeight() * cellSize;

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();

        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, width, height);

        for (int y = 0; y < maze.getHeight(); y++) {
            for (int x = 0; x < maze.getWidth(); x++) {
                Room room = maze.getRoom(x, y);
                int xPos = x * cellSize;
                int yPos = y * cellSize;

                if (room != null) {
                    if (room.isEntrance()) {
                        g2d.setColor(Color.GREEN);
                    } else if (room.isExit()) {
                        g2d.setColor(Color.RED);
                    } else {
                        g2d.setColor(Color.LIGHT_GRAY);
                    }
                    g2d.fillRect(xPos, yPos, cellSize, cellSize);
                    g2d.setColor(Color.BLACK);
                    g2d.drawRect(xPos, yPos, cellSize, cellSize);
                }
            }
        }

        g2d.dispose();

        try {
            File outputFile = new File("maze." + fileFormat);
            ImageIO.write(image, fileFormat, outputFile);
            System.out.println("Maze image saved as: " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}