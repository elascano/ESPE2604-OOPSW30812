package ec.edu.espe.maze;

import ec.edu.espe.maze.controller.MazeController;
import ec.edu.espe.maze.service.DFSGenerator;
import ec.edu.espe.maze.service.DFSSolver;
import ec.edu.espe.maze.view.ASCIIRenderer;
import ec.edu.espe.maze.view.ImageRenderer;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Maze {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Maze::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
        }

        JFrame frame = new JFrame("Maze Generator & Solver Dashboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 300);
        frame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(15, 15));
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(new Color(24, 24, 27));

        JLabel titleLabel = new JLabel("Maze System (SOLID & MVC)", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        titleLabel.setForeground(new Color(244, 244, 245));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(3, 2, 10, 15));
        formPanel.setBackground(new Color(24, 24, 27));

        JLabel widthLabel = new JLabel("Width:");
        widthLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        widthLabel.setForeground(new Color(212, 212, 216));
        JSpinner widthSpinner = new JSpinner(new SpinnerNumberModel(20, 5, 200, 1));
        widthSpinner.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        JLabel heightLabel = new JLabel("Height:");
        heightLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        heightLabel.setForeground(new Color(212, 212, 216));
        JSpinner heightSpinner = new JSpinner(new SpinnerNumberModel(20, 5, 200, 1));
        heightSpinner.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        JLabel rendererLabel = new JLabel("Renderer:");
        rendererLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        rendererLabel.setForeground(new Color(212, 212, 216));
        String[] renderers = {"Graphical Window", "Console (ASCII)"};
        JComboBox<String> rendererCombo = new JComboBox<>(renderers);
        rendererCombo.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        formPanel.add(widthLabel);
        formPanel.add(widthSpinner);
        formPanel.add(heightLabel);
        formPanel.add(heightSpinner);
        formPanel.add(rendererLabel);
        formPanel.add(rendererCombo);

        mainPanel.add(formPanel, BorderLayout.CENTER);

        JButton runButton = new JButton("Generate & Solve");
        runButton.setFont(new Font("Segoe UI", Font.BOLD, 15));
        runButton.setBackground(new Color(37, 99, 235));
        runButton.setForeground(Color.WHITE);
        runButton.setFocusPainted(false);
        runButton.setPreferredSize(new Dimension(0, 45));

        runButton.addActionListener(e -> {
            int width = (int) widthSpinner.getValue();
            int height = (int) heightSpinner.getValue();
            String selectedRenderer = (String) rendererCombo.getSelectedItem();

            if (width <= 0 || height <= 0) {
                JOptionPane.showMessageDialog(frame, "Dimensions must be positive", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            MazeController controller;
            if ("Graphical Window".equals(selectedRenderer)) {
                controller = new MazeController(new DFSGenerator(), new DFSSolver(), new ImageRenderer());
            } else {
                controller = new MazeController(new DFSGenerator(), new DFSSolver(), new ASCIIRenderer());
            }

            try {
                controller.createAndShowMaze(width, height);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error running maze: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        mainPanel.add(runButton, BorderLayout.SOUTH);
        frame.add(mainPanel);
        frame.setVisible(true);
    }
}
