package ec.edu.espe.mazesystem.view;  
import ec.edu.espe.mazesystem.controller.MazeController;
import ec.edu.espe.mazesystem.model.Room;
import ec.edu.espe.mazesystem.renderer.ImageMazeRenderer;
import ec.edu.espe.mazesystem.renderer.MazePrinter;

import javax.swing.*;
import java.awt.*;

public class MazeView extends JFrame {
    private MazeController controller;
    
    private JTextField widthField;
    private JTextField heightField;
    private JButton generateButton;
    private JButton printButton;
    private JButton imageButton;
    private JTextArea outputArea;
    private JPanel mazePanel;

    public MazeView() {
        initUI();
        initController();
    }

    private void initUI() {
        setTitle("Maze Generator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        setSize(800, 600);
        setLocationRelativeTo(null);

        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        controlPanel.setBorder(BorderFactory.createTitledBorder("Maze Controls"));

        controlPanel.add(new JLabel("Width:"));
        widthField = new JTextField("5", 5);
        controlPanel.add(widthField);

        controlPanel.add(new JLabel("Height:"));
        heightField = new JTextField("5", 5);
        controlPanel.add(heightField);

        generateButton = new JButton("Generate Maze");
        generateButton.addActionListener(e -> handleGenerateMaze());
        controlPanel.add(generateButton);

        printButton = new JButton("Print to Console");
        printButton.addActionListener(e -> handlePrintMaze());
        controlPanel.add(printButton);

        imageButton = new JButton("Save as Image");
        imageButton.addActionListener(e -> handleSaveImage());
        controlPanel.add(imageButton);

        add(controlPanel, BorderLayout.NORTH);

        mazePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawMaze(g);
            }
        };
        mazePanel.setPreferredSize(new Dimension(400, 400));
        mazePanel.setBackground(Color.WHITE);
        mazePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(mazePanel, BorderLayout.CENTER);

        outputArea = new JTextArea(5, 40);
        outputArea.setEditable(false);
        outputArea.setBackground(Color.BLACK);
        outputArea.setForeground(Color.GREEN);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Console Output"));
        add(scrollPane, BorderLayout.SOUTH);

        generateButton.setEnabled(true);
        printButton.setEnabled(false);
        imageButton.setEnabled(false);
    }

    private void initController() {
        MazePrinter printer = new MazePrinter();
        this.controller = new MazeController(printer);
    }

    private void handleGenerateMaze() {
        try {
            int width = Integer.parseInt(widthField.getText().trim());
            int height = Integer.parseInt(heightField.getText().trim());

            if (width < 2 || height < 2) {
                JOptionPane.showMessageDialog(this, 
                    "Width and height must be at least 2!", 
                    "Invalid Input", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            controller.initMazeGeneration(width, height);
            mazePanel.repaint();
            
            printButton.setEnabled(true);
            imageButton.setEnabled(true);
            
            outputArea.append("\n✓ Maze generated: " + width + "x" + height + "\n");
            outputArea.append("  Entrance at (0,0), Exit at (" + (width-1) + "," + (height-1) + ")\n");
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, 
                "Please enter valid integer values!", 
                "Invalid Input", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    private void handlePrintMaze() {
        MazePrinter printer = new MazePrinter();
        controller.setRenderer(printer);
        
        outputArea.append("\n=== Console Maze Output ===\n");
        controller.renderMaze();
        outputArea.append("Done!\n");
    }

    private void handleSaveImage() {
        try {
            String format = JOptionPane.showInputDialog(this, 
                "Enter image format (png/jpg):", 
                "Image Format", 
                JOptionPane.QUESTION_MESSAGE);
            
            if (format != null && !format.trim().isEmpty()) {
                format = format.trim().toLowerCase();
                if (!format.equals("png") && !format.equals("jpg")) {
                    format = "png";
                }
                
                ImageMazeRenderer imageRenderer = new ImageMazeRenderer(format);
                controller.setRenderer(imageRenderer);
                controller.renderMaze();
                
                outputArea.append("\n✓ Image saved as maze." + format + "\n");
                outputArea.append("  Format: " + format.toUpperCase() + "\n");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, 
                "Error saving image: " + ex.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    private void drawMaze(Graphics g) {
        if (controller == null || controller.getModel() == null) {
            g.setColor(Color.GRAY);
            g.drawString("No maze generated", 50, 50);
            return;
        }
        
        int width = controller.getModel().getWidth();
        int height = controller.getModel().getHeight();
        
        if (width == 0 || height == 0) {
            g.setColor(Color.GRAY);
            g.drawString("Invalid maze dimensions", 50, 50);
            return;
        }
        
        int panelWidth = mazePanel.getWidth();
        int panelHeight = mazePanel.getHeight();
        int cellSize = Math.min(panelWidth / width, panelHeight / height);
        cellSize = Math.min(cellSize, 60);
        
        int offsetX = (panelWidth - (cellSize * width)) / 2;
        int offsetY = (panelHeight - (cellSize * height)) / 2;
        
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Room room = controller.getModel().getRoom(x, y);
                int xPos = offsetX + x * cellSize;
                int yPos = offsetY + y * cellSize;
                
                if (room != null) {
                    if (room.isEntrance()) {
                        g.setColor(Color.GREEN);
                    } else if (room.isExit()) {
                        g.setColor(Color.RED);
                    } else {
                        g.setColor(Color.LIGHT_GRAY);
                    }
                    g.fillRect(xPos + 1, yPos + 1, cellSize - 2, cellSize - 2);
                    
                    g.setColor(Color.BLACK);
                    g.setFont(new Font("Arial", Font.BOLD, 10));
                    if (room.isEntrance()) {
                        g.drawString("S", xPos + cellSize/2 - 4, yPos + cellSize/2 + 4);
                    } else if (room.isExit()) {
                        g.drawString("E", xPos + cellSize/2 - 4, yPos + cellSize/2 + 4);
                    }
                } else {
                    g.setColor(Color.GRAY);
                    g.fillRect(xPos + 1, yPos + 1, cellSize - 2, cellSize - 2);
                }
                
                g.setColor(Color.BLACK);
                g.drawRect(xPos, yPos, cellSize, cellSize);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MazeView().setVisible(true);
        });
    }
}