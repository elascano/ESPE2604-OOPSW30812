package ec.edu.espe.strategypattern.view;

import ec.edu.espe.strategypattern.controller.SortService;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Alexander Tipantiza, CodeBreakers, @ESPE
 */

public class SortApp extends JFrame {
    private JTextField inputDataField;
    private JTextArea displayArea;
    private JButton processButton;
    private SortService sortService;

    public SortApp() {
        initComponents();
    }

    private void initComponents() {
        sortService = new SortService();

        setTitle("Strategy Pattern Manager - Alexander Tipantiza");
        setSize(520, 380);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(12, 12));

        JPanel headerPanel = new JPanel(new BorderLayout(8, 8));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(12, 12, 0, 12));

        JLabel inputLabel = new JLabel("Enter numbers separated by commas:");
        inputDataField = new JTextField("5,3,8,1,2"); // Valores de ejemplo
        processButton = new JButton("Sort & Save to Cloud");

        headerPanel.add(inputLabel, BorderLayout.NORTH);
        headerPanel.add(inputDataField, BorderLayout.CENTER);
        headerPanel.add(processButton, BorderLayout.EAST);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Monospaced", Font.PLAIN, 12));

        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(0, 12, 12, 12),
                BorderFactory.createTitledBorder("Processing Results")
        ));

        add(headerPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        processButton.addActionListener(e -> handleSortAction());
    }

    private void handleSortAction() {
        try {
            String summary = sortService.executeSortOperation(inputDataField.getText());
            displayArea.setText(summary + "\n\n[Status]: Data synchronized with MongoDB Atlas successfully!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Format error: Please enter valid integers.\nExample: 5,3,8,1,2", "Validation Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            displayArea.setText("Error: " + ex.getMessage() + "\n\n[Status]: Check console for details.");
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Operation Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace(); // Para debugging
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SortApp().setVisible(true));
    }
}