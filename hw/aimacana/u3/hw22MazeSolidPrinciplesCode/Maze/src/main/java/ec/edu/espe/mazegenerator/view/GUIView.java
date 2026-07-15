package ec.edu.espe.mazegenerator.view;

import com.formdev.flatlaf.FlatDarkLaf;
import ec.edu.espe.mazegenerator.controller.MazeController;
import ec.edu.espe.mazegenerator.model.BacktrackingMazeGenerator;
import ec.edu.espe.mazegenerator.model.Direction;
import ec.edu.espe.mazegenerator.model.Maze;
import ec.edu.espe.mazegenerator.model.Room;
import java.util.List;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GUIView extends JFrame implements IMazeView {
    
    // Paleta de colores extraída de Open Design (Tailwind colors)
    private final Color bg = new Color(15, 23, 42); // #0f172a
    private final Color surface = new Color(30, 41, 59); // #1e293b
    private final Color borderCol = new Color(51, 65, 85); // #334155
    private final Color textCol = new Color(248, 250, 252); // #f8fafc
    private final Color textMuted = new Color(148, 163, 184); // #94a3b8
    private final Color accent = new Color(99, 102, 241); // #6366f1
    private final Color startColor = new Color(16, 185, 129); // #10b981
    private final Color endColor = new Color(239, 68, 68); // #ef4444

    private JTextField widthField;
    private JTextField heightField;
    private JTextArea asciiArea;
    private JPanel imagePanel;
    private BufferedImage currentMazeImage;
    private MazeController controller;

    public GUIView() {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }

        setTitle("Maze Generator - Open Design UI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1100, 700);
        setLocationRelativeTo(null);
        
        // Contenedor principal con fondo oscuro
        JPanel mainContent = new JPanel(new BorderLayout());
        mainContent.setBackground(bg);
        setContentPane(mainContent);
        
        // --- BARRA LATERAL (SIDEBAR) ---
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setPreferredSize(new Dimension(280, 0));
        sidebar.setBackground(surface);
        sidebar.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, borderCol));
        sidebar.setBorder(new CompoundBorder(
            BorderFactory.createMatteBorder(0, 0, 0, 1, borderCol),
            new EmptyBorder(24, 24, 24, 24)
        ));

        JLabel titleLabel = new JLabel("MazeGen Pro");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        titleLabel.setForeground(accent);
        titleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        widthField = createStyledTextField("15");
        heightField = createStyledTextField("15");

        JButton generateButton = new JButton("Generate Maze");
        generateButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        generateButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        generateButton.setBackground(accent);
        generateButton.setForeground(Color.WHITE);
        generateButton.setFocusPainted(false);
        generateButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        generateButton.setBorder(new EmptyBorder(12, 15, 12, 15));
        generateButton.setMaximumSize(new Dimension(250, 45));
        
        generateButton.addActionListener(e -> {
            try {
                int w = Integer.parseInt(widthField.getText());
                int h = Integer.parseInt(heightField.getText());
                if (w > 100) w = 100; // Limite de seguridad UI
                if (h > 100) h = 100;
                
                if(controller == null) {
                     controller = new MazeController(new BacktrackingMazeGenerator(), this);
                }
                controller.createAndRenderMaze(w, h);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Valores inválidos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        sidebar.add(titleLabel);
        sidebar.add(Box.createRigidArea(new Dimension(0, 30)));
        sidebar.add(createStyledLabel("Width (N)"));
        sidebar.add(Box.createRigidArea(new Dimension(0, 8)));
        sidebar.add(widthField);
        sidebar.add(Box.createRigidArea(new Dimension(0, 20)));
        sidebar.add(createStyledLabel("Height (M)"));
        sidebar.add(Box.createRigidArea(new Dimension(0, 8)));
        sidebar.add(heightField);
        sidebar.add(Box.createRigidArea(new Dimension(0, 30)));
        sidebar.add(generateButton);

        // --- ÁREA CENTRAL (MAIN AREA) ---
        JPanel mainArea = new JPanel(new GridLayout(1, 2, 20, 0));
        mainArea.setBackground(bg);
        mainArea.setBorder(new EmptyBorder(20, 20, 20, 20));

        // Panel de Imagen
        JPanel imgContainer = createStyledPanel("Graphical View");
        imagePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (currentMazeImage != null) {
                    // Calculo para centrar y escalar la imagen
                    int w = currentMazeImage.getWidth();
                    int h = currentMazeImage.getHeight();
                    int pw = getWidth();
                    int ph = getHeight();
                    double scale = Math.min(1.0 * pw / w, 1.0 * ph / h);
                    int nw = (int)(w * scale);
                    int nh = (int)(h * scale);
                    int nx = (pw - nw) / 2;
                    int ny = (ph - nh) / 2;
                    g.drawImage(currentMazeImage, nx, ny, nw, nh, null);
                }
            }
        };
        imagePanel.setBackground(bg);
        imgContainer.add(imagePanel, BorderLayout.CENTER);

        // Panel ASCII
        JPanel asciiContainer = createStyledPanel("ASCII Output");
        asciiArea = new JTextArea();
        asciiArea.setEditable(false);
        asciiArea.setFont(new Font("Consolas", Font.PLAIN, 14));
        asciiArea.setBackground(bg);
        asciiArea.setForeground(textMuted);
        
        JScrollPane scrollAscii = new JScrollPane(asciiArea);
        scrollAscii.setBorder(BorderFactory.createEmptyBorder());
        scrollAscii.getViewport().setBackground(bg);
        asciiContainer.add(scrollAscii, BorderLayout.CENTER);

        mainArea.add(imgContainer);
        mainArea.add(asciiContainer);

        mainContent.add(sidebar, BorderLayout.WEST);
        mainContent.add(mainArea, BorderLayout.CENTER);
    }

    private JLabel createStyledLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", Font.BOLD, 12));
        label.setForeground(textMuted);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        return label;
    }

    private JTextField createStyledTextField(String defaultText) {
        JTextField field = new JTextField(defaultText);
        field.setMaximumSize(new Dimension(250, 35));
        field.setBackground(bg);
        field.setForeground(textCol);
        field.setCaretColor(textCol);
        field.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(borderCol, 1, true),
            new EmptyBorder(5, 10, 5, 10)
        ));
        field.setAlignmentX(Component.LEFT_ALIGNMENT);
        return field;
    }

    private JPanel createStyledPanel(String title) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(surface);
        panel.setBorder(new LineBorder(borderCol, 1, true));
        
        JLabel titleLabel = new JLabel("  " + title);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        titleLabel.setForeground(textMuted);
        titleLabel.setOpaque(true);
        titleLabel.setBackground(new Color(25, 35, 50));
        titleLabel.setPreferredSize(new Dimension(0, 40));
        titleLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, borderCol));
        
        panel.add(titleLabel, BorderLayout.NORTH);
        return panel;
    }

    @Override
    public void render(Maze maze, List<Room> solution) {
        // 1. Renderizar ASCII (Igual lógica de paredes)
        StringBuilder sb = new StringBuilder();
        int width = maze.getWidth();
        int height = maze.getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Room room = maze.getRoom(x, y);
                sb.append("+");
                sb.append((room.hasDoor(Direction.NORTH) || (room.isEntrance() && y == 0)) ? "   " : "---");
            }
            sb.append("+\n");

            for (int x = 0; x < width; x++) {
                Room room = maze.getRoom(x, y);
                sb.append((room.hasDoor(Direction.WEST)) ? " " : "|");
                if (room.isEntrance()) sb.append(" S ");
                else if (room.isExit()) sb.append(" E ");
                else if (solution != null && solution.contains(room)) sb.append(" · ");
                else sb.append("   ");
            }
            Room lastRoom = maze.getRoom(width - 1, y);
            sb.append("|\n");
        }

        for (int x = 0; x < width; x++) {
            Room room = maze.getRoom(x, height - 1);
            sb.append("+");
            sb.append((room.hasDoor(Direction.SOUTH) || (room.isExit() && x == width - 1)) ? "   " : "---");
        }
        sb.append("+\n");
        
        asciiArea.setText(sb.toString());

        // 2. Renderizar Imagen 2D basada en los estilos de Open Design
        int cellSize = Math.min(32, Math.max(12, 600 / Math.max(width, height)));
        int pxWidth = width * cellSize;
        int pxHeight = height * cellSize;
        currentMazeImage = new BufferedImage(pxWidth + 1, pxHeight + 1, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = currentMazeImage.createGraphics();
        
        g.setColor(bg); // Fondo canvas
        g.fillRect(0, 0, pxWidth + 1, pxHeight + 1);
        
        // Puntos de inicio y fin (Fondos sutiles)
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Room room = maze.getRoom(x, y);
                int px = x * cellSize;
                int py = y * cellSize;
                if (room.isEntrance()) {
                    g.setColor(new Color(16, 185, 129, 40)); // Verde con alpha
                    g.fillRect(px, py, cellSize, cellSize);
                } else if (room.isExit()) {
                    g.setColor(new Color(239, 68, 68, 40)); // Rojo con alpha
                    g.fillRect(px, py, cellSize, cellSize);
                }
            }
        }

        // Paredes
        g.setColor(new Color(100, 116, 139)); // Slate border color from OD
        g.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Room room = maze.getRoom(x, y);
                int px = x * cellSize;
                int py = y * cellSize;

                if (!room.hasDoor(Direction.NORTH) && !(room.isEntrance() && y == 0)) g.drawLine(px, py, px + cellSize, py);
                if (!room.hasDoor(Direction.WEST)) g.drawLine(px, py, px, py + cellSize);
                if (x == width - 1) g.drawLine(px + cellSize, py, px + cellSize, py + cellSize);
                if (y == height - 1 && !(room.isExit() && x == width - 1)) g.drawLine(px, py + cellSize, px + cellSize, py + cellSize);
                
                // Letras S y E
                g.setFont(new Font("Segoe UI", Font.BOLD, (int)(cellSize * 0.55)));
                FontMetrics fm = g.getFontMetrics();
                if (room.isEntrance()) {
                    g.setColor(startColor);
                    g.drawString("S", px + (cellSize - fm.stringWidth("S"))/2, py + (cellSize + fm.getAscent())/2 - 2);
                    g.setColor(new Color(100, 116, 139));
                } else if (room.isExit()) {
                    g.setColor(endColor);
                    g.drawString("E", px + (cellSize - fm.stringWidth("E"))/2, py + (cellSize + fm.getAscent())/2 - 2);
                    g.setColor(new Color(100, 116, 139));
                }
            }
        }
        // Dibujar solucion
        if (solution != null && solution.size() > 1) {
            g.setColor(new Color(234, 179, 8)); // Yellow path
            g.setStroke(new BasicStroke(Math.max(2, cellSize / 5.0f), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            
            int[] xPoints = new int[solution.size()];
            int[] yPoints = new int[solution.size()];
            for (int i = 0; i < solution.size(); i++) {
                Room r = solution.get(i);
                xPoints[i] = r.getX() * cellSize + cellSize / 2;
                yPoints[i] = r.getY() * cellSize + cellSize / 2;
            }
            g.drawPolyline(xPoints, yPoints, solution.size());
        }

        g.dispose();
        
        imagePanel.repaint();
    }
}
