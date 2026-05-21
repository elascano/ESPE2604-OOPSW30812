
package ec.edu.espe.virtualstoreapp.view;
/**
 *
 * @author Alexander Tipantiza, The Softwarrios, @ESPE
 */

import ec.edu.espe.virtualstoreapp.data.ProductData;
import ec.edu.espe.virtualstoreapp.data.SaleManager;
import ec.edu.espe.virtualstoreapp.model.CartItem;
import ec.edu.espe.virtualstoreapp.model.Product;
import ec.edu.espe.virtualstoreapp.model.Sale;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class StoreGUI extends JFrame {
    private ArrayList<CartItem> cart = new ArrayList<>();
    private ArrayList<Sale> salesHistory = new ArrayList<>();
    
    // Components
    private JTextField txtCustomerName;
    private JFormattedTextField txtDate;
    private JComboBox<Product> cmbProducts;
    private JSpinner spinnerQuantity;
    private JButton btnAddToCart;
    private JTable cartTable;
    private DefaultTableModel cartTableModel;
    private JLabel lblSubtotal, lblTax, lblTotal;
    private JButton btnCheckout, btnViewHistory;
    
    public StoreGUI() {
        setTitle("🛒 Virtual Store");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        // Load sales history
        salesHistory = SaleManager.loadSales();
        
        // Create UI
        createTopPanel();
        createCenterPanel();
        createBottomPanel();
        
        refreshCartTable();
        updateTotals();
    }
    
    private void createTopPanel() {
        JPanel topPanel = new JPanel(new GridBagLayout());
        topPanel.setBorder(BorderFactory.createTitledBorder("Customer Information"));
        topPanel.setBackground(new Color(102, 126, 234));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        // Customer name
        gbc.gridx = 0; gbc.gridy = 0;
        topPanel.add(new JLabel("Customer Name:"), gbc);
        gbc.gridx = 1;
        txtCustomerName = new JTextField(15);
        txtCustomerName.setToolTipText("Only letters and spaces");
        topPanel.add(txtCustomerName, gbc);
        
        // Date
        gbc.gridx = 2;
        topPanel.add(new JLabel("Date (DD/MM/YYYY):"), gbc);
        gbc.gridx = 3;
        txtDate = new JFormattedTextField(new SimpleDateFormat("dd/MM/yyyy"));
        txtDate.setColumns(10);
        txtDate.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
        topPanel.add(txtDate, gbc);
        
        add(topPanel, BorderLayout.NORTH);
    }
    
    private void createCenterPanel() {
        JPanel centerPanel = new JPanel(new BorderLayout());
        
        // Product selection panel
        JPanel productPanel = new JPanel(new FlowLayout());
        productPanel.setBorder(BorderFactory.createTitledBorder("Add Product"));
        productPanel.setBackground(new Color(118, 75, 162));
        
        productPanel.add(new JLabel("Product:"));
        cmbProducts = new JComboBox<>(ProductData.getProducts().toArray(new Product[0]));
        cmbProducts.setPreferredSize(new Dimension(200, 25));
        productPanel.add(cmbProducts);
        
        productPanel.add(new JLabel("Quantity:"));
        spinnerQuantity = new JSpinner(new SpinnerNumberModel(1, 1, 99, 1));
        productPanel.add(spinnerQuantity);
        
        btnAddToCart = new JButton("➕ Add to Cart");
        btnAddToCart.setBackground(new Color(40, 167, 69));
        btnAddToCart.setForeground(Color.WHITE);
        btnAddToCart.addActionListener(e -> addToCart());
        productPanel.add(btnAddToCart);
        
        centerPanel.add(productPanel, BorderLayout.NORTH);
        
        // Cart table
        String[] columns = {"Product", "Price", "Quantity", "Subtotal"};
        cartTableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };
        cartTable = new JTable(cartTableModel);
        cartTable.setRowHeight(30);
        cartTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int row = cartTable.getSelectedRow();
                if (row >= 0) {
                    showQuantityDialog(row);
                }
            }
        });
        JScrollPane scrollPane = new JScrollPane(cartTable);
        scrollPane.setBorder(BorderFactory.createTitledBorder("🛒 Shopping Cart"));
        centerPanel.add(scrollPane, BorderLayout.CENTER);
        
        add(centerPanel, BorderLayout.CENTER);
    }
    
    private void showQuantityDialog(int row) {
        CartItem item = cart.get(row);
        
        JDialog dialog = new JDialog(this, "Update Quantity", true);
        dialog.setLayout(new GridBagLayout());
        dialog.setSize(300, 150);
        dialog.setLocationRelativeTo(this);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        
        gbc.gridx = 0; gbc.gridy = 0;
        dialog.add(new JLabel("Product: " + item.getName()), gbc);
        
        gbc.gridy = 1;
        dialog.add(new JLabel("Quantity:"), gbc);
        
        gbc.gridx = 1;
        JSpinner spinner = new JSpinner(new SpinnerNumberModel(item.getQuantity(), 1, 99, 1));
        dialog.add(spinner, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.gridwidth = 2;
        JButton btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(e -> {
            int newQty = (int) spinner.getValue();
            if (newQty > 0) {
                item.setQuantity(newQty);
                refreshCartTable();
                updateTotals();
                dialog.dispose();
            }
        });
        dialog.add(btnUpdate, gbc);
        
        dialog.setVisible(true);
    }
    
    private void createBottomPanel() {
        JPanel bottomPanel = new JPanel(new BorderLayout());
        
        // Totals panel
        JPanel totalsPanel = new JPanel(new GridLayout(3, 2, 10, 5));
        totalsPanel.setBorder(BorderFactory.createTitledBorder("Totals"));
        totalsPanel.setBackground(new Color(238, 238, 238));
        
        totalsPanel.add(new JLabel("Subtotal:"));
        lblSubtotal = new JLabel("$0.00");
        lblSubtotal.setFont(new Font("Arial", Font.BOLD, 14));
        totalsPanel.add(lblSubtotal);
        
        totalsPanel.add(new JLabel("Tax (10%):"));
        lblTax = new JLabel("$0.00");
        lblTax.setFont(new Font("Arial", Font.BOLD, 14));
        totalsPanel.add(lblTax);
        
        totalsPanel.add(new JLabel("TOTAL:"));
        lblTotal = new JLabel("$0.00");
        lblTotal.setFont(new Font("Arial", Font.BOLD, 16));
        lblTotal.setForeground(new Color(40, 167, 69));
        totalsPanel.add(lblTotal);
        
        bottomPanel.add(totalsPanel, BorderLayout.WEST);
        
        // Buttons panel
        JPanel buttonsPanel = new JPanel(new FlowLayout());
        btnCheckout = new JButton("💰 Checkout");
        btnCheckout.setBackground(new Color(0, 123, 255));
        btnCheckout.setForeground(Color.WHITE);
        btnCheckout.setFont(new Font("Arial", Font.BOLD, 14));
        btnCheckout.addActionListener(e -> checkout());
        
        btnViewHistory = new JButton("📜 Sales History");
        btnViewHistory.setBackground(new Color(102, 126, 234));
        btnViewHistory.setForeground(Color.WHITE);
        btnViewHistory.addActionListener(e -> showSalesHistory());
        
        buttonsPanel.add(btnCheckout);
        buttonsPanel.add(btnViewHistory);
        
        bottomPanel.add(buttonsPanel, BorderLayout.EAST);
        
        add(bottomPanel, BorderLayout.SOUTH);
    }
    
    private void addToCart() {
        Product selectedProduct = (Product) cmbProducts.getSelectedItem();
        int quantity = (int) spinnerQuantity.getValue();
        
        if (quantity > selectedProduct.getStock()) {
            JOptionPane.showMessageDialog(this, 
                "Insufficient stock! Available: " + selectedProduct.getStock(),
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Check if product already in cart
        CartItem existing = null;
        for (CartItem item : cart) {
            if (item.getName().equals(selectedProduct.getName())) {
                existing = item;
                break;
            }
        }
        
        if (existing != null) {
            int newQty = existing.getQuantity() + quantity;
            if (newQty > selectedProduct.getStock()) {
                JOptionPane.showMessageDialog(this, 
                    "Total would exceed stock! Available: " + selectedProduct.getStock(),
                    "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            existing.setQuantity(newQty);
        } else {
            cart.add(new CartItem(selectedProduct.getName(), selectedProduct.getPrice(), quantity));
        }
        
        // Update stock
        selectedProduct.setStock(selectedProduct.getStock() - quantity);
        
        refreshCartTable();
        updateTotals();
        
        JOptionPane.showMessageDialog(this, 
            "✅ Added " + quantity + " x " + selectedProduct.getName(),
            "Success", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void refreshCartTable() {
        cartTableModel.setRowCount(0);
        for (CartItem item : cart) {
            cartTableModel.addRow(new Object[]{
                item.getName(),
                "$" + item.getPrice(),
                item.getQuantity(),
                "$" + String.format("%.2f", item.getSubtotal())
            });
        }
    }
    
    private void updateTotals() {
        double subtotal = 0;
        for (CartItem item : cart) {
            subtotal += item.getSubtotal();
        }
        double tax = subtotal * 0.10;
        double total = subtotal + tax;
        
        lblSubtotal.setText("$" + String.format("%.2f", subtotal));
        lblTax.setText("$" + String.format("%.2f", tax));
        lblTotal.setText("$" + String.format("%.2f", total));
    }
    
    private void checkout() {
        if (cart.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Cart is empty!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Validate customer name
        String customerName = txtCustomerName.getText().trim();
        if (customerName.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Please enter customer name (letters only)", 
                "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!customerName.matches("[a-zA-ZáéíóúñÑü\\s]+")) {
            JOptionPane.showMessageDialog(this, 
                "Customer name must contain only letters and spaces", 
                "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Validate date
        String dateStr = txtDate.getText();
        if (!dateStr.matches("\\d{2}/\\d{2}/\\d{4}")) {
            JOptionPane.showMessageDialog(this, 
                "Invalid date format! Use DD/MM/YYYY", 
                "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Calculate totals
        double subtotal = 0;
        for (CartItem item : cart) {
            subtotal += item.getSubtotal();
        }
        double tax = subtotal * 0.10;
        double total = subtotal + tax;
        
        // Create sale
        Sale sale = new Sale(customerName, new Date(), new ArrayList<>(cart), subtotal, tax, total);
        salesHistory.add(sale);
        SaleManager.saveSales(salesHistory);
        
        // Show invoice
        showInvoice(sale);
        
        // Clear cart
        cart.clear();
        refreshCartTable();
        updateTotals();
        txtCustomerName.setText("");
    }
    
    private void showInvoice(Sale sale) {
        JDialog invoiceDialog = new JDialog(this, "🧾 INVOICE", true);
        invoiceDialog.setLayout(new BorderLayout());
        invoiceDialog.setSize(500, 500);
        invoiceDialog.setLocationRelativeTo(this);
        
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        
        StringBuilder sb = new StringBuilder();
        sb.append("╔════════════════════════════════════════╗\n");
        sb.append("║            🧾 INVOICE                 ║\n");
        sb.append("╠════════════════════════════════════════╣\n");
        sb.append(String.format("║ Customer: %-30s ║\n", sale.getCustomer()));
        sb.append(String.format("║ Date: %-33s ║\n", new SimpleDateFormat("dd/MM/yyyy").format(sale.getDate())));
        sb.append("╠════════════════════════════════════════╣\n");
        sb.append("║ Products:                              ║\n");
        for (CartItem item : sale.getItems()) {
            sb.append(String.format("║   %-15s x%-2d = $%-8.2f ║\n", 
                item.getName().length() > 15 ? item.getName().substring(0, 12) + "..." : item.getName(),
                item.getQuantity(), item.getSubtotal()));
        }
        sb.append("╠════════════════════════════════════════╣\n");
        sb.append(String.format("║ Subtotal: $%-29.2f ║\n", sale.getSubtotal()));
        sb.append(String.format("║ Tax (10%%):  $%-29.2f ║\n", sale.getTax()));
        sb.append(String.format("║ TOTAL:      $%-29.2f ║\n", sale.getTotal()));
        sb.append("╚════════════════════════════════════════╝\n");
        
        textArea.setText(sb.toString());
        invoiceDialog.add(new JScrollPane(textArea), BorderLayout.CENTER);
        
        JButton btnClose = new JButton("Close");
        btnClose.addActionListener(e -> invoiceDialog.dispose());
        invoiceDialog.add(btnClose, BorderLayout.SOUTH);
        
        invoiceDialog.setVisible(true);
    }
    
    private void showSalesHistory() {
        if (salesHistory.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "No sales registered", "Sales History", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        JDialog historyDialog = new JDialog(this, "📜 Sales History", true);
        historyDialog.setLayout(new BorderLayout());
        historyDialog.setSize(600, 400);
        historyDialog.setLocationRelativeTo(this);
        
        String[] columns = {"#", "Customer", "Date", "Total"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < salesHistory.size(); i++) {
            Sale s = salesHistory.get(i);
            model.addRow(new Object[]{
                i + 1,
                s.getCustomer(),
                sdf.format(s.getDate()),
                "$" + String.format("%.2f", s.getTotal())
            });
        }
        
        JTable table = new JTable(model);
        table.setRowHeight(25);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                if (row >= 0 && e.getClickCount() == 2) {
                    showSaleDetails(salesHistory.get(row));
                }
            }
        });
        
        historyDialog.add(new JScrollPane(table), BorderLayout.CENTER);
        
        JButton btnClose = new JButton("Close");
        btnClose.addActionListener(e -> historyDialog.dispose());
        historyDialog.add(btnClose, BorderLayout.SOUTH);
        
        historyDialog.setVisible(true);
    }
    
    private void showSaleDetails(Sale sale) {
        JDialog detailDialog = new JDialog(this, "Sale Details", true);
        detailDialog.setLayout(new BorderLayout());
        detailDialog.setSize(500, 400);
        detailDialog.setLocationRelativeTo(this);
        
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        
        StringBuilder sb = new StringBuilder();
        sb.append("╔════════════════════════════════════════╗\n");
        sb.append("║           SALE DETAILS                 ║\n");
        sb.append("╠════════════════════════════════════════╣\n");
        sb.append(String.format("║ Customer: %-30s ║\n", sale.getCustomer()));
        sb.append(String.format("║ Date: %-33s ║\n", new SimpleDateFormat("dd/MM/yyyy").format(sale.getDate())));
        sb.append("╠════════════════════════════════════════╣\n");
        sb.append("║ Products:                              ║\n");
        for (CartItem item : sale.getItems()) {
            sb.append(String.format("║   %-15s x%-2d = $%-8.2f ║\n", 
                item.getName().length() > 15 ? item.getName().substring(0, 12) + "..." : item.getName(),
                item.getQuantity(), item.getSubtotal()));
        }
        sb.append("╠════════════════════════════════════════╣\n");
        sb.append(String.format("║ Subtotal: $%-29.2f ║\n", sale.getSubtotal()));
        sb.append(String.format("║ Tax (10%%):  $%-29.2f ║\n", sale.getTax()));
        sb.append(String.format("║ TOTAL:      $%-29.2f ║\n", sale.getTotal()));
        sb.append("╚════════════════════════════════════════╝\n");
        
        textArea.setText(sb.toString());
        detailDialog.add(new JScrollPane(textArea), BorderLayout.CENTER);
        
        JButton btnClose = new JButton("Close");
        btnClose.addActionListener(e -> detailDialog.dispose());
        detailDialog.add(btnClose, BorderLayout.SOUTH);
        
        detailDialog.setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new StoreGUI().setVisible(true);
        });
    }
}