package ec.edu.espe.safestore.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import org.bson.Document;
import ec.edu.espe.safestore.model.MongoDBConnection;

public class MainFrame extends JFrame {
    
    // Panels
    private JTabbedPane tabbedPane;
    
    // Sales components
    private JTable cartTable;
    private DefaultTableModel cartModel;
    private JTextField customerField;
    private JComboBox<String> paymentCombo;
    private JComboBox<String> typeCombo;
    private JComboBox<String> productCombo;
    private JSpinner quantitySpinner;
    private JLabel subtotalLabel;
    private JLabel taxLabel;
    private JLabel totalLabel;
    private JLabel statusLabel;
    private int saleCounter = 1;
    
    // Products components
    private JTable productsTable;
    private DefaultTableModel productsModel;
    private JTextField productSearchField;
    
    // Suppliers components
    private JTable suppliersTable;
    private DefaultTableModel suppliersModel;
    private JTextField supplierSearchField;
    
    // History components
    private JTable historyTable;
    private DefaultTableModel historyModel;
    
    public MainFrame() {
        initialize();
        connectDatabase();
        loadProducts();
        loadSuppliers();
        loadHistory();
        loadProductCombo();
    }
    
    private void initialize() {
        setTitle("SafeStore - Sales System");
        setSize(1300, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
        
        // Tabs
        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("SALES", createSalesPanel());
        tabbedPane.addTab("PRODUCTS", createProductsPanel());
        tabbedPane.addTab("SUPPLIERS", createSuppliersPanel());
        tabbedPane.addTab("HISTORY", createHistoryPanel());
        
        add(tabbedPane);
    }
    
    // ==================== SALES PANEL ====================
    
    private JPanel createSalesPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Customer Info
        JPanel infoPanel = new JPanel(new GridLayout(2, 4, 10, 10));
        infoPanel.setBorder(BorderFactory.createTitledBorder("Customer Information"));
        
        infoPanel.add(new JLabel("Customer Name:"));
        customerField = new JTextField();
        infoPanel.add(customerField);
        
        infoPanel.add(new JLabel("Sale Type:"));
        typeCombo = new JComboBox<>(new String[]{"Retail", "Wholesale"});
        infoPanel.add(typeCombo);
        
        infoPanel.add(new JLabel("Payment Method:"));
        paymentCombo = new JComboBox<>(new String[]{"Cash", "Credit", "Transfer"});
        infoPanel.add(paymentCombo);
        
        JButton startButton = new JButton("Start New Sale");
        infoPanel.add(startButton);
        
        // Add Product
        JPanel addPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        addPanel.setBorder(BorderFactory.createTitledBorder("Add Product"));
        
        addPanel.add(new JLabel("Product:"));
        productCombo = new JComboBox<>();
        productCombo.setPreferredSize(new Dimension(200, 25));
        addPanel.add(productCombo);
        
        addPanel.add(new JLabel("Quantity:"));
        quantitySpinner = new JSpinner(new SpinnerNumberModel(1, 1, 999, 1));
        quantitySpinner.setPreferredSize(new Dimension(70, 25));
        addPanel.add(quantitySpinner);
        
        JButton addButton = new JButton("Add to Cart");
        addPanel.add(addButton);
        
        // Cart Table
        String[] cartColumns = {"ID", "Product", "Quantity", "Price", "Total"};
        cartModel = new DefaultTableModel(cartColumns, 0);
        cartTable = new JTable(cartModel);
        JScrollPane cartScroll = new JScrollPane(cartTable);
        cartScroll.setBorder(BorderFactory.createTitledBorder("Shopping Cart"));
        
        // Totals
        JPanel totalPanel = new JPanel(new GridLayout(1, 4, 10, 10));
        totalPanel.setBorder(BorderFactory.createTitledBorder("Totals"));
        
        subtotalLabel = new JLabel("Subtotal: $0.00");
        taxLabel = new JLabel("IVA (15%): $0.00");
        totalLabel = new JLabel("TOTAL: $0.00");
        statusLabel = new JLabel("Status: Ready");
        
        totalPanel.add(subtotalLabel);
        totalPanel.add(taxLabel);
        totalPanel.add(totalLabel);
        totalPanel.add(statusLabel);
        
        // Buttons
        JPanel actionPanel = new JPanel(new FlowLayout());
        JButton finalizeButton = new JButton("Finalize Sale");
        JButton clearButton = new JButton("Clear Cart");
        actionPanel.add(finalizeButton);
        actionPanel.add(clearButton);
        
        // Layout
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(addPanel, BorderLayout.NORTH);
        centerPanel.add(cartScroll, BorderLayout.CENTER);
        
        JPanel southPanel = new JPanel(new BorderLayout());
        southPanel.add(totalPanel, BorderLayout.NORTH);
        southPanel.add(actionPanel, BorderLayout.SOUTH);
        
        panel.add(infoPanel, BorderLayout.NORTH);
        panel.add(centerPanel, BorderLayout.CENTER);
        panel.add(southPanel, BorderLayout.SOUTH);
        
        // Actions
        startButton.addActionListener(e -> {
            statusLabel.setText("Status: Sale active - " + customerField.getText());
            saleCounter = historyModel.getRowCount() + 1;
        });
        
        addButton.addActionListener(e -> addToCart());
        finalizeButton.addActionListener(e -> finalizeSale());
        clearButton.addActionListener(e -> clearCart());
        
        return panel;
    }
    
    private void addToCart() {
        if (productCombo.getSelectedIndex() <= 0) {
            JOptionPane.showMessageDialog(this, "Select a product");
            return;
        }
        
        String selection = (String) productCombo.getSelectedItem();
        String productName = selection.split(" - ")[0];
        int quantity = (int) quantitySpinner.getValue();
        
        List<Document> products = MongoDBConnection.getAllProducts();
        Document selected = null;
        for (Document p : products) {
            if (productName.equals(p.getString("name"))) {
                selected = p;
                break;
            }
        }
        
        if (selected == null) {
            JOptionPane.showMessageDialog(this, "Product not found");
            return;
        }
        
        String id = selected.getString("productId");
        int stock = selected.getInteger("stock");
        double price = selected.getDouble("retailPrice");
        
        if (quantity > stock) {
            JOptionPane.showMessageDialog(this, "Insufficient stock. Available: " + stock);
            return;
        }
        
        double total = quantity * price;
        cartModel.addRow(new Object[]{id, productName, quantity, "$" + price, "$" + total});
        updateTotals();
    }
    
    private void updateTotals() {
    double subtotal = 0;
    for (int i = 0; i < cartModel.getRowCount(); i++) {
        String value = (String) cartModel.getValueAt(i, 4);
        value = value.replace("$", "").replace(",", ".");
        subtotal += Double.parseDouble(value);
    }
    double tax = subtotal * 0.15;
    double total = subtotal + tax;
    
    subtotalLabel.setText("Subtotal: $" + String.format("%.2f", subtotal).replace(".", ","));
    taxLabel.setText("IVA (15%): $" + String.format("%.2f", tax).replace(".", ","));
    totalLabel.setText("TOTAL: $" + String.format("%.2f", total).replace(".", ","));
}
    
    private void finalizeSale() {
    System.out.println("=== FINALIZE SALE STARTED ===");
    
    if (cartModel.getRowCount() == 0) {
        JOptionPane.showMessageDialog(this, "Cart is empty. Add products first.");
        return;
    }
    
    String customerName = customerField.getText().trim();
    if (customerName.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter customer name");
        return;
    }
    
    int confirm = JOptionPane.showConfirmDialog(this, 
        "Complete sale for " + customerName + "?\n" + totalLabel.getText(),
        "Confirm Sale", JOptionPane.YES_NO_OPTION);
    
    if (confirm == JOptionPane.YES_OPTION) {
        try {
            // CORREGIDO: Reemplazar coma por punto en los números
            String subtotalText = subtotalLabel.getText().replace("Subtotal: $", "").replace(",", ".");
            String taxText = taxLabel.getText().replace("IVA (15%): $", "").replace(",", ".");
            String totalText = totalLabel.getText().replace("TOTAL: $", "").replace(",", ".");
            
            double subtotalValue = Double.parseDouble(subtotalText);
            double taxValue = Double.parseDouble(taxText);
            double totalValue = Double.parseDouble(totalText);
            
            System.out.println("Subtotal: " + subtotalValue);
            System.out.println("Tax: " + taxValue);
            System.out.println("Total: " + totalValue);
            
            Document sale = new Document();
            sale.append("saleId", saleCounter);
            sale.append("customerName", customerName);
            sale.append("date", new Date().toString());
            sale.append("saleType", typeCombo.getSelectedItem().toString());
            sale.append("paymentMethod", paymentCombo.getSelectedItem().toString());
            sale.append("subtotal", subtotalValue);
            sale.append("tax", taxValue);
            sale.append("total", totalValue);
            
            List<Document> items = new ArrayList<>();
            for (int i = 0; i < cartModel.getRowCount(); i++) {
                Document item = new Document();
                item.append("productId", cartModel.getValueAt(i, 0).toString());
                item.append("productName", cartModel.getValueAt(i, 1).toString());
                item.append("quantity", Integer.parseInt(cartModel.getValueAt(i, 2).toString()));
                
                // CORREGIDO: Reemplazar coma por punto en los precios
                String priceStr = cartModel.getValueAt(i, 3).toString().replace("$", "").replace(",", ".");
                item.append("unitPrice", Double.parseDouble(priceStr));
                
                String totalPriceStr = cartModel.getValueAt(i, 4).toString().replace("$", "").replace(",", ".");
                item.append("totalPrice", Double.parseDouble(totalPriceStr));
                
                items.add(item);
            }
            sale.append("items", items);
            
            MongoDBConnection.saveSale(sale);
            
            // Update stock
            for (int i = 0; i < cartModel.getRowCount(); i++) {
                String productId = cartModel.getValueAt(i, 0).toString();
                int sold = Integer.parseInt(cartModel.getValueAt(i, 2).toString());
                
                List<Document> products = MongoDBConnection.getAllProducts();
                for (Document p : products) {
                    if (productId.equals(p.getString("productId"))) {
                        int newStock = p.getInteger("stock") - sold;
                        Document update = new Document()
                            .append("productId", p.getString("productId"))
                            .append("name", p.getString("name"))
                            .append("stock", newStock)
                            .append("retailPrice", p.getDouble("retailPrice"))
                            .append("wholesalePrice", p.getDouble("wholesalePrice"))
                            .append("category", p.getString("category"));
                        MongoDBConnection.updateProduct(p.getObjectId("_id").toString(), update);
                        break;
                    }
                }
            }
            
            JOptionPane.showMessageDialog(this, "✅ Sale saved to MongoDB!\nSale ID: " + saleCounter);
            
            // Clear cart
            cartModel.setRowCount(0);
            customerField.setText("");
            
            subtotalLabel.setText("Subtotal: $0.00");
            taxLabel.setText("IVA (15%): $0.00");
            totalLabel.setText("TOTAL: $0.00");
            statusLabel.setText("Status: Ready");
            
            loadProducts();
            loadProductCombo();
            loadHistory();
            
            saleCounter++;
            
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
}
    
    private void clearCart() {
        cartModel.setRowCount(0);
        subtotalLabel.setText("Subtotal: $0.00");
        taxLabel.setText("IVA (15%): $0.00");
        totalLabel.setText("TOTAL: $0.00");
        statusLabel.setText("Status: Cart cleared");
    }
    
    private void loadProductCombo() {
        productCombo.removeAllItems();
        productCombo.addItem("-- Select Product --");
        
        List<Document> products = MongoDBConnection.getAllProducts();
        for (Document p : products) {
            String name = p.getString("name");
            double price = p.getDouble("retailPrice");
            productCombo.addItem(name + " - $" + price);
        }
    }
    
    // ==================== PRODUCTS PANEL ====================
    
    private JPanel createProductsPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Top Panel
        JPanel topPanel = new JPanel(new BorderLayout());
        
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchPanel.add(new JLabel("Search:"));
        productSearchField = new JTextField(20);
        JButton searchButton = new JButton("Search");
        JButton refreshButton = new JButton("Refresh");
        searchPanel.add(productSearchField);
        searchPanel.add(searchButton);
        searchPanel.add(refreshButton);
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton addButton = new JButton("Add Product");
        JButton editButton = new JButton("Edit");
        JButton deleteButton = new JButton("Delete");
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        
        topPanel.add(searchPanel, BorderLayout.WEST);
        topPanel.add(buttonPanel, BorderLayout.EAST);
        
        // Table
        String[] columns = {"ID", "Name", "Stock", "Retail", "Wholesale", "Category"};
        productsModel = new DefaultTableModel(columns, 0);
        productsTable = new JTable(productsModel);
        JScrollPane scrollPane = new JScrollPane(productsTable);
        
        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        // Actions
        addButton.addActionListener(e -> showAddProductDialog());
        editButton.addActionListener(e -> showEditProductDialog());
        deleteButton.addActionListener(e -> deleteProduct());
        refreshButton.addActionListener(e -> {
            loadProducts();
            loadProductCombo();
        });
        searchButton.addActionListener(e -> searchProducts());
        
        return panel;
    }
    
    private void loadProducts() {
        productsModel.setRowCount(0);
        List<Document> products = MongoDBConnection.getAllProducts();
        
        if (products.isEmpty()) {
            // Only show message, don't auto-save
            productsModel.addRow(new Object[]{"--", "No products yet", 0, "--", "--", "--"});
        } else {
            for (Document p : products) {
                productsModel.addRow(new Object[]{
                    p.getString("productId"),
                    p.getString("name"),
                    p.getInteger("stock"),
                    "$" + p.getDouble("retailPrice"),
                    "$" + p.getDouble("wholesalePrice"),
                    p.getString("category")
                });
            }
        }
    }
    
    private void searchProducts() {
        String term = productSearchField.getText().trim().toLowerCase();
        if (term.isEmpty()) {
            loadProducts();
            return;
        }
        
        productsModel.setRowCount(0);
        List<Document> products = MongoDBConnection.getAllProducts();
        
        for (Document p : products) {
            String name = p.getString("name");
            String id = p.getString("productId");
            if ((name != null && name.toLowerCase().contains(term)) ||
                (id != null && id.toLowerCase().contains(term))) {
                productsModel.addRow(new Object[]{
                    id, name, p.getInteger("stock"),
                    "$" + p.getDouble("retailPrice"),
                    "$" + p.getDouble("wholesalePrice"),
                    p.getString("category")
                });
            }
        }
    }
    
    private void showAddProductDialog() {
        JDialog dialog = new JDialog(this, "Add Product", true);
        dialog.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        
        JTextField idField = new JTextField(15);
        JTextField nameField = new JTextField(15);
        JSpinner stockSpin = new JSpinner(new SpinnerNumberModel(0, 0, 9999, 1));
        JTextField retailField = new JTextField(15);
        JTextField wholesaleField = new JTextField(15);
        JComboBox<String> categoryCombo = new JComboBox<>(new String[]{"Electronics", "Clothing", "Food", "Other"});
        
        gbc.gridx = 0; gbc.gridy = 0;
        dialog.add(new JLabel("ID:"), gbc);
        gbc.gridx = 1;
        dialog.add(idField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        dialog.add(new JLabel("Name:"), gbc);
        gbc.gridx = 1;
        dialog.add(nameField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2;
        dialog.add(new JLabel("Stock:"), gbc);
        gbc.gridx = 1;
        dialog.add(stockSpin, gbc);
        
        gbc.gridx = 0; gbc.gridy = 3;
        dialog.add(new JLabel("Retail Price:"), gbc);
        gbc.gridx = 1;
        dialog.add(retailField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 4;
        dialog.add(new JLabel("Wholesale Price:"), gbc);
        gbc.gridx = 1;
        dialog.add(wholesaleField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 5;
        dialog.add(new JLabel("Category:"), gbc);
        gbc.gridx = 1;
        dialog.add(categoryCombo, gbc);
        
        JButton saveBtn = new JButton("Save");
        JButton cancelBtn = new JButton("Cancel");
        JPanel btnPanel = new JPanel();
        btnPanel.add(saveBtn);
        btnPanel.add(cancelBtn);
        
        gbc.gridx = 0; gbc.gridy = 6;
        gbc.gridwidth = 2;
        dialog.add(btnPanel, gbc);
        
        saveBtn.addActionListener(e -> {
            try {
                Document product = new Document()
                    .append("productId", idField.getText().trim())
                    .append("name", nameField.getText().trim())
                    .append("stock", stockSpin.getValue())
                    .append("retailPrice", Double.parseDouble(retailField.getText().trim()))
                    .append("wholesalePrice", Double.parseDouble(wholesaleField.getText().trim()))
                    .append("category", categoryCombo.getSelectedItem());
                
                MongoDBConnection.saveProduct(product);
                loadProducts();
                loadProductCombo();
                JOptionPane.showMessageDialog(dialog, "Product saved!");
                dialog.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(dialog, "Error: " + ex.getMessage());
            }
        });
        
        cancelBtn.addActionListener(e -> dialog.dispose());
        
        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }
    
    private void showEditProductDialog() {
        int row = productsTable.getSelectedRow();
        if (row == -1 || productsModel.getValueAt(row, 0).equals("--")) {
            JOptionPane.showMessageDialog(this, "Select a product");
            return;
        }
        
        String id = (String) productsModel.getValueAt(row, 0);
        String name = (String) productsModel.getValueAt(row, 1);
        int stock = (int) productsModel.getValueAt(row, 2);
        String retailStr = ((String) productsModel.getValueAt(row, 3)).replace("$", "");
        String wholesaleStr = ((String) productsModel.getValueAt(row, 4)).replace("$", "");
        String category = (String) productsModel.getValueAt(row, 5);
        
        JDialog dialog = new JDialog(this, "Edit Product", true);
        dialog.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        
        JTextField nameField = new JTextField(name, 15);
        JSpinner stockSpin = new JSpinner(new SpinnerNumberModel(stock, 0, 9999, 1));
        JTextField retailField = new JTextField(retailStr, 15);
        JTextField wholesaleField = new JTextField(wholesaleStr, 15);
        JComboBox<String> categoryCombo = new JComboBox<>(new String[]{"Electronics", "Clothing", "Food", "Other"});
        categoryCombo.setSelectedItem(category);
        
        gbc.gridx = 0; gbc.gridy = 0;
        dialog.add(new JLabel("ID:"), gbc);
        gbc.gridx = 1;
        dialog.add(new JLabel(id), gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        dialog.add(new JLabel("Name:"), gbc);
        gbc.gridx = 1;
        dialog.add(nameField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2;
        dialog.add(new JLabel("Stock:"), gbc);
        gbc.gridx = 1;
        dialog.add(stockSpin, gbc);
        
        gbc.gridx = 0; gbc.gridy = 3;
        dialog.add(new JLabel("Retail Price:"), gbc);
        gbc.gridx = 1;
        dialog.add(retailField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 4;
        dialog.add(new JLabel("Wholesale Price:"), gbc);
        gbc.gridx = 1;
        dialog.add(wholesaleField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 5;
        dialog.add(new JLabel("Category:"), gbc);
        gbc.gridx = 1;
        dialog.add(categoryCombo, gbc);
        
        JButton updateBtn = new JButton("Update");
        JButton cancelBtn = new JButton("Cancel");
        JPanel btnPanel = new JPanel();
        btnPanel.add(updateBtn);
        btnPanel.add(cancelBtn);
        
        gbc.gridx = 0; gbc.gridy = 6;
        gbc.gridwidth = 2;
        dialog.add(btnPanel, gbc);
        
        updateBtn.addActionListener(e -> {
            try {
                Document updated = new Document()
                    .append("productId", id)
                    .append("name", nameField.getText().trim())
                    .append("stock", stockSpin.getValue())
                    .append("retailPrice", Double.parseDouble(retailField.getText().trim()))
                    .append("wholesalePrice", Double.parseDouble(wholesaleField.getText().trim()))
                    .append("category", categoryCombo.getSelectedItem());
                
                List<Document> products = MongoDBConnection.getAllProducts();
                for (Document p : products) {
                    if (id.equals(p.getString("productId"))) {
                        MongoDBConnection.updateProduct(p.getObjectId("_id").toString(), updated);
                        break;
                    }
                }
                loadProducts();
                loadProductCombo();
                JOptionPane.showMessageDialog(dialog, "Product updated!");
                dialog.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(dialog, "Error: " + ex.getMessage());
            }
        });
        
        cancelBtn.addActionListener(e -> dialog.dispose());
        
        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }
    
    private void deleteProduct() {
        int row = productsTable.getSelectedRow();
        if (row == -1 || productsModel.getValueAt(row, 0).equals("--")) {
            JOptionPane.showMessageDialog(this, "Select a product");
            return;
        }
        
        String id = (String) productsModel.getValueAt(row, 0);
        String name = (String) productsModel.getValueAt(row, 1);
        
        int confirm = JOptionPane.showConfirmDialog(this, "Delete " + name + "?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            List<Document> products = MongoDBConnection.getAllProducts();
            for (Document p : products) {
                if (id.equals(p.getString("productId"))) {
                    MongoDBConnection.deleteProduct(p.getObjectId("_id").toString());
                    break;
                }
            }
            loadProducts();
            loadProductCombo();
            JOptionPane.showMessageDialog(this, "Product deleted");
        }
    }
    
    // ==================== SUPPLIERS PANEL ====================
    
    private JPanel createSuppliersPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JPanel topPanel = new JPanel(new BorderLayout());
        
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchPanel.add(new JLabel("Search:"));
        supplierSearchField = new JTextField(20);
        JButton searchButton = new JButton("Search");
        JButton refreshButton = new JButton("Refresh");
        searchPanel.add(supplierSearchField);
        searchPanel.add(searchButton);
        searchPanel.add(refreshButton);
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton addButton = new JButton("Add Supplier");
        JButton editButton = new JButton("Edit");
        JButton deleteButton = new JButton("Delete");
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        
        topPanel.add(searchPanel, BorderLayout.WEST);
        topPanel.add(buttonPanel, BorderLayout.EAST);
        
        String[] columns = {"ID", "Name", "Phone", "Email", "Address"};
        suppliersModel = new DefaultTableModel(columns, 0);
        suppliersTable = new JTable(suppliersModel);
        JScrollPane scrollPane = new JScrollPane(suppliersTable);
        
        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        addButton.addActionListener(e -> showAddSupplierDialog());
        editButton.addActionListener(e -> showEditSupplierDialog());
        deleteButton.addActionListener(e -> deleteSupplier());
        refreshButton.addActionListener(e -> loadSuppliers());
        searchButton.addActionListener(e -> searchSuppliers());
        
        return panel;
    }
    
    private void loadSuppliers() {
        suppliersModel.setRowCount(0);
        List<Document> suppliers = MongoDBConnection.getAllSuppliers();
        
        if (suppliers.isEmpty()) {
            suppliersModel.addRow(new Object[]{"--", "No suppliers yet", "--", "--", "--"});
        } else {
            for (Document s : suppliers) {
                suppliersModel.addRow(new Object[]{
                    s.getString("supplierId"),
                    s.getString("name"),
                    s.getString("phone"),
                    s.getString("email"),
                    s.getString("address")
                });
            }
        }
    }
    
    private void searchSuppliers() {
        String term = supplierSearchField.getText().trim().toLowerCase();
        if (term.isEmpty()) {
            loadSuppliers();
            return;
        }
        
        suppliersModel.setRowCount(0);
        List<Document> suppliers = MongoDBConnection.getAllSuppliers();
        
        for (Document s : suppliers) {
            String name = s.getString("name");
            String id = s.getString("supplierId");
            if ((name != null && name.toLowerCase().contains(term)) ||
                (id != null && id.toLowerCase().contains(term))) {
                suppliersModel.addRow(new Object[]{
                    id, name, s.getString("phone"), s.getString("email"), s.getString("address")
                });
            }
        }
    }
    
    private void showAddSupplierDialog() {
        JDialog dialog = new JDialog(this, "Add Supplier", true);
        dialog.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        
        JTextField idField = new JTextField(15);
        JTextField nameField = new JTextField(15);
        JTextField phoneField = new JTextField(15);
        JTextField emailField = new JTextField(15);
        JTextField addressField = new JTextField(15);
        
        gbc.gridx = 0; gbc.gridy = 0;
        dialog.add(new JLabel("ID:"), gbc);
        gbc.gridx = 1;
        dialog.add(idField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        dialog.add(new JLabel("Name:"), gbc);
        gbc.gridx = 1;
        dialog.add(nameField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2;
        dialog.add(new JLabel("Phone:"), gbc);
        gbc.gridx = 1;
        dialog.add(phoneField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 3;
        dialog.add(new JLabel("Email:"), gbc);
        gbc.gridx = 1;
        dialog.add(emailField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 4;
        dialog.add(new JLabel("Address:"), gbc);
        gbc.gridx = 1;
        dialog.add(addressField, gbc);
        
        JButton saveBtn = new JButton("Save");
        JButton cancelBtn = new JButton("Cancel");
        JPanel btnPanel = new JPanel();
        btnPanel.add(saveBtn);
        btnPanel.add(cancelBtn);
        
        gbc.gridx = 0; gbc.gridy = 5;
        gbc.gridwidth = 2;
        dialog.add(btnPanel, gbc);
        
        saveBtn.addActionListener(e -> {
            Document supplier = new Document()
                .append("supplierId", idField.getText().trim())
                .append("name", nameField.getText().trim())
                .append("phone", phoneField.getText().trim())
                .append("email", emailField.getText().trim())
                .append("address", addressField.getText().trim());
            
            MongoDBConnection.saveSupplier(supplier);
            loadSuppliers();
            JOptionPane.showMessageDialog(dialog, "Supplier saved to MongoDB!");
            dialog.dispose();
        });
        
        cancelBtn.addActionListener(e -> dialog.dispose());
        
        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }
    
    private void showEditSupplierDialog() {
        int row = suppliersTable.getSelectedRow();
        if (row == -1 || suppliersModel.getValueAt(row, 0).equals("--")) {
            JOptionPane.showMessageDialog(this, "Select a supplier");
            return;
        }
        
        String id = (String) suppliersModel.getValueAt(row, 0);
        String name = (String) suppliersModel.getValueAt(row, 1);
        String phone = (String) suppliersModel.getValueAt(row, 2);
        String email = (String) suppliersModel.getValueAt(row, 3);
        String address = (String) suppliersModel.getValueAt(row, 4);
        
        JDialog dialog = new JDialog(this, "Edit Supplier", true);
        dialog.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        
        JTextField nameField = new JTextField(name, 15);
        JTextField phoneField = new JTextField(phone, 15);
        JTextField emailField = new JTextField(email, 15);
        JTextField addressField = new JTextField(address, 15);
        
        gbc.gridx = 0; gbc.gridy = 0;
        dialog.add(new JLabel("ID:"), gbc);
        gbc.gridx = 1;
        dialog.add(new JLabel(id), gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        dialog.add(new JLabel("Name:"), gbc);
        gbc.gridx = 1;
        dialog.add(nameField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2;
        dialog.add(new JLabel("Phone:"), gbc);
        gbc.gridx = 1;
        dialog.add(phoneField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 3;
        dialog.add(new JLabel("Email:"), gbc);
        gbc.gridx = 1;
        dialog.add(emailField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 4;
        dialog.add(new JLabel("Address:"), gbc);
        gbc.gridx = 1;
        dialog.add(addressField, gbc);
        
        JButton updateBtn = new JButton("Update");
        JButton cancelBtn = new JButton("Cancel");
        JPanel btnPanel = new JPanel();
        btnPanel.add(updateBtn);
        btnPanel.add(cancelBtn);
        
        gbc.gridx = 0; gbc.gridy = 5;
        gbc.gridwidth = 2;
        dialog.add(btnPanel, gbc);
        
        updateBtn.addActionListener(e -> {
            Document updated = new Document()
                .append("supplierId", id)
                .append("name", nameField.getText().trim())
                .append("phone", phoneField.getText().trim())
                .append("email", emailField.getText().trim())
                .append("address", addressField.getText().trim());
            
            List<Document> suppliers = MongoDBConnection.getAllSuppliers();
            for (Document s : suppliers) {
                if (id.equals(s.getString("supplierId"))) {
                    MongoDBConnection.updateSupplier(s.getObjectId("_id").toString(), updated);
                    break;
                }
            }
            loadSuppliers();
            JOptionPane.showMessageDialog(dialog, "Supplier updated!");
            dialog.dispose();
        });
        
        cancelBtn.addActionListener(e -> dialog.dispose());
        
        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }
    
    private void deleteSupplier() {
        int row = suppliersTable.getSelectedRow();
        if (row == -1 || suppliersModel.getValueAt(row, 0).equals("--")) {
            JOptionPane.showMessageDialog(this, "Select a supplier");
            return;
        }
        
        String id = (String) suppliersModel.getValueAt(row, 0);
        String name = (String) suppliersModel.getValueAt(row, 1);
        
        int confirm = JOptionPane.showConfirmDialog(this, "Delete " + name + "?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            List<Document> suppliers = MongoDBConnection.getAllSuppliers();
            for (Document s : suppliers) {
                if (id.equals(s.getString("supplierId"))) {
                    MongoDBConnection.deleteSupplier(s.getObjectId("_id").toString());
                    break;
                }
            }
            loadSuppliers();
            JOptionPane.showMessageDialog(this, "Supplier deleted");
        }
    }
    
    // ==================== HISTORY PANEL ====================
    
    private JPanel createHistoryPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton refreshButton = new JButton("Refresh");
        topPanel.add(refreshButton);
        
        String[] columns = {"ID", "Date", "Customer", "Payment", "Total"};
        historyModel = new DefaultTableModel(columns, 0);
        historyTable = new JTable(historyModel);
        JScrollPane scrollPane = new JScrollPane(historyTable);
        
        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        refreshButton.addActionListener(e -> loadHistory());
        
        return panel;
    }
    
    private void loadHistory() {
    historyModel.setRowCount(0);
    List<Document> sales = MongoDBConnection.getAllSales();
    
    System.out.println("=== LOADING HISTORY ===");
    System.out.println("Sales found in MongoDB: " + sales.size());
    
    if (sales.isEmpty()) {
        historyModel.addRow(new Object[]{"--", "No sales yet", "--", "--", "--"});
        System.out.println("No sales found");
    } else {
        for (Document s : sales) {
            // Print to console for debugging
            System.out.println("Sale document: " + s.toJson());
            
            // Get values with correct field names
            Integer saleId = s.getInteger("saleId");
            String date = s.getString("date");
            String customer = s.getString("customerName");  // ← matches "customerName"
            String payment = s.getString("paymentMethod");  // ← matches "paymentMethod"
            Double total = s.getDouble("total");
            
            historyModel.addRow(new Object[]{
                saleId != null ? saleId : "--",
                date != null ? date : "--",
                customer != null ? customer : "--",
                payment != null ? payment : "--",
                total != null ? "$" + String.format("%.2f", total) : "$0.00"
            });
        }
        System.out.println("Loaded " + sales.size() + " sales into table");
    }
}
    
    // ==================== DATABASE ====================
    
    private void connectDatabase() {
        MongoDBConnection.connect();
        if (MongoDBConnection.isConnected()) {
            System.out.println("Database connected");
        } else {
            JOptionPane.showMessageDialog(this, "Database connection failed", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
    }
}