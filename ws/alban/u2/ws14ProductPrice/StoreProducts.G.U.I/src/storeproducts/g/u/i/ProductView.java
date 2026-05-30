package storeproducts.g.u.i;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class ProductView extends JFrame {
    private final JTable productTable;
    private final DefaultTableModel tableModel;
    private final JTextField nameField;
    private final JTextField priceField;
    private final JTextField quantityField;
    private final JButton addButton;
    private final JButton processButton;
    private final JTextArea receiptArea;

    public ProductView() {
        setTitle("Garden Supply Store - POS System");
        setSize(750, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel inputPanel = new JPanel(new GridLayout(2, 4, 10, 5));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Add New Item"));
        
        inputPanel.add(new JLabel("Product Name:"));
        inputPanel.add(new JLabel("Price ($):"));
        inputPanel.add(new JLabel("Quantity:"));
        inputPanel.add(new JLabel("")); 

        nameField = new JTextField();
        priceField = new JTextField();
        quantityField = new JTextField();
        addButton = new JButton("Add to Cart");

        inputPanel.add(nameField);
        inputPanel.add(priceField);
        inputPanel.add(quantityField);
        inputPanel.add(addButton);
        add(inputPanel, BorderLayout.NORTH);

        String[] columns = {"Product Name", "Price", "Quantity", "Subtotal"};
        tableModel = new DefaultTableModel(columns, 0);
        productTable = new JTable(tableModel);
        add(new JScrollPane(productTable), BorderLayout.CENTER);

        JPanel rightPanel = new JPanel(new BorderLayout(5, 5));
        rightPanel.setPreferredSize(new Dimension(280, 0));
        rightPanel.setBorder(BorderFactory.createTitledBorder("Receipt / Invoice"));

        receiptArea = new JTextArea();
        receiptArea.setEditable(false);
        receiptArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        rightPanel.add(new JScrollPane(receiptArea), BorderLayout.CENTER);

        processButton = new JButton("Process Sale & Save JSON");
        rightPanel.add(processButton, BorderLayout.SOUTH);
        add(rightPanel, BorderLayout.EAST);
    }

    public String getProductName() { return nameField.getText(); }
    public String getProductPrice() { return priceField.getText(); }
    public String getProductQuantity() { return quantityField.getText(); }

    public void addProductToTable(String name, double price, int qty, double subtotal) {
        tableModel.addRow(new Object[]{name, String.format("$%.2f", price), qty, String.format("$%.2f", subtotal)});
    }

    public void clearInputFields() {
        nameField.setText("");
        priceField.setText("");
        quantityField.setText("");
    }

    public void updateReceiptDisplay(String receiptText) {
        receiptArea.setText(receiptText);
    }

    public void displayMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public void setListeners(ActionListener addListener, ActionListener processListener) {
        addButton.addActionListener(addListener);
        processButton.addActionListener(processListener);
    }
}