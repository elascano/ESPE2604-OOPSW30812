package ec.edu.espe.strategy.view;

import ec.edu.espe.strategy.controller.SortController;
import ec.edu.espe.strategy.model.SortingRecord;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class SortView extends JFrame {
    private final SortController controller;

    private JTextField txtInputNumbers;
    private JButton btnSort;
    private JButton btnClear;
    private JButton btnReloadHistory;

    private JLabel lblUnsortedResult;
    private JLabel lblSizeResult;
    private JLabel lblAlgorithmResult;
    private JLabel lblSortedResult;
    private JLabel lblStatus;

    private JTable tableHistory;
    private DefaultTableModel tableModel;

    public SortView() {
        this.controller = new SortController();
        initComponents();
        loadHistoryData();
    }

    private void initComponents() {
        setTitle("Sorting Application - Strategy Pattern");
        setSize(780, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(new EmptyBorder(15, 15, 15, 15));

        JPanel topPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        
        JPanel inputRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        JLabel lblInput = new JLabel("Enter numbers separated by commas:");
        lblInput.setFont(new Font("SansSerif", Font.BOLD, 13));
        txtInputNumbers = new JTextField(25);
        txtInputNumbers.setFont(new Font("SansSerif", Font.PLAIN, 13));

        btnSort = new JButton("Sort & Save");
        btnClear = new JButton("Clear");

        inputRow.add(lblInput);
        inputRow.add(txtInputNumbers);
        inputRow.add(btnSort);
        inputRow.add(btnClear);

        JPanel rulesRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        JLabel lblRules = new JLabel("Rules: BubbleSort (Size 2-6) | InsertionSort (Size 7-10) | QuickSort (Size > 10)");
        lblRules.setFont(new Font("SansSerif", Font.ITALIC, 11));
        lblRules.setForeground(Color.GRAY);
        rulesRow.add(lblRules);

        topPanel.add(inputRow);
        topPanel.add(rulesRow);

        mainPanel.add(topPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridLayout(5, 1, 5, 5));
        centerPanel.setBorder(BorderFactory.createTitledBorder("Results"));

        lblUnsortedResult = new JLabel("Unsorted Array: -");
        lblSizeResult = new JLabel("Size: -");
        lblAlgorithmResult = new JLabel("Chosen Algorithm: -");
        lblSortedResult = new JLabel("Sorted Array: -");
        lblStatus = new JLabel("Database Status: Ready");

        Font labelFont = new Font("SansSerif", Font.PLAIN, 13);
        lblUnsortedResult.setFont(labelFont);
        lblSizeResult.setFont(labelFont);
        lblAlgorithmResult.setFont(new Font("SansSerif", Font.BOLD, 13));
        lblAlgorithmResult.setForeground(new Color(180, 40, 40));
        lblSortedResult.setFont(new Font("SansSerif", Font.BOLD, 13));
        lblSortedResult.setForeground(new Color(0, 120, 50));
        lblStatus.setFont(new Font("SansSerif", Font.ITALIC, 12));

        centerPanel.add(lblUnsortedResult);
        centerPanel.add(lblSizeResult);
        centerPanel.add(lblAlgorithmResult);
        centerPanel.add(lblSortedResult);
        centerPanel.add(lblStatus);

        mainPanel.add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout(5, 5));
        bottomPanel.setPreferredSize(new Dimension(740, 220));

        JPanel historyHeader = new JPanel(new BorderLayout());
        JLabel lblHistoryTitle = new JLabel("MongoDB Collection History (strategyArtieda.arrayMateo):");
        lblHistoryTitle.setFont(new Font("SansSerif", Font.BOLD, 12));

        btnReloadHistory = new JButton("Refresh History");

        historyHeader.add(lblHistoryTitle, BorderLayout.WEST);
        historyHeader.add(btnReloadHistory, BorderLayout.EAST);

        bottomPanel.add(historyHeader, BorderLayout.NORTH);

        String[] columns = {"Unsorted Array", "Size", "Algorithm", "Sorted Array"};
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableHistory = new JTable(tableModel);
        tableHistory.setRowHeight(22);

        JScrollPane scrollPane = new JScrollPane(tableHistory);
        bottomPanel.add(scrollPane, BorderLayout.CENTER);

        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(mainPanel);

        btnSort.addActionListener(e -> executeSort());
        btnClear.addActionListener(e -> clearFields());
        btnReloadHistory.addActionListener(e -> loadHistoryData());
    }

    private void executeSort() {
        String input = txtInputNumbers.getText();
        try {
            SortingRecord record = controller.processAndSort(input);

            lblUnsortedResult.setText("Unsorted Array: " + record.getUnsorted());
            lblSizeResult.setText("Size: " + record.getSize());
            lblAlgorithmResult.setText("Chosen Algorithm: " + record.getSortAlgorithm());
            lblSortedResult.setText("Sorted Array: " + record.getSorted());
            lblStatus.setText("Database Status: Successfully saved to MongoDB (arrayMateo)");

            tableModel.insertRow(0, new Object[]{
                    record.getUnsorted(),
                    record.getSize(),
                    record.getSortAlgorithm(),
                    record.getSorted()
            });

            JOptionPane.showMessageDialog(this,
                    "Array sorted successfully using " + record.getSortAlgorithm() + "!",
                    "Success", JOptionPane.INFORMATION_MESSAGE);

        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Validation Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "System Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        txtInputNumbers.setText("");
        lblUnsortedResult.setText("Unsorted Array: -");
        lblSizeResult.setText("Size: -");
        lblAlgorithmResult.setText("Chosen Algorithm: -");
        lblSortedResult.setText("Sorted Array: -");
        lblStatus.setText("Database Status: Ready");
    }

    private void loadHistoryData() {
        tableModel.setRowCount(0);
        SwingWorker<List<SortingRecord>, Void> worker = new SwingWorker<>() {
            @Override
            protected List<SortingRecord> doInBackground() {
                return controller.fetchHistory();
            }

            @Override
            protected void done() {
                try {
                    List<SortingRecord> records = get();
                    for (SortingRecord record : records) {
                        tableModel.addRow(new Object[]{
                                record.getUnsorted(),
                                record.getSize(),
                                record.getSortAlgorithm(),
                                record.getSorted()
                        });
                    }
                } catch (Exception e) {
                    System.err.println("Could not load history: " + e.getMessage());
                }
            }
        };
        worker.execute();
    }

    public static void display() {
        SwingUtilities.invokeLater(() -> {
            SortView view = new SortView();
            view.setVisible(true);
        });
    }
}
