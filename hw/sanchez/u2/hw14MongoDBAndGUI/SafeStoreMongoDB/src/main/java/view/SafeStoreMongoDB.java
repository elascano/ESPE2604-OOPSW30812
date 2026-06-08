
package view;

import model.*;
import org.bson.Document;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.List;

/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */


public class SafeStoreMongoDB extends JFrame {
    private JTabbedPane tabbedPane;
    private JTable productsTable, creditsTable;
    private DefaultTableModel productsModel, creditsModel;
    private JPanel productsPanel, creditsPanel, expirationPanel;
    private JButton btnAddProduct, btnEditProduct, btnDeleteProduct, btnRefreshProduct;
    private JButton btnAddCredit, btnEditCredit, btnDeleteCredit, btnRefreshCredit;
    private JButton btnSyncToCloud, btnSyncFromCloud;
    private JTextField searchField;
    private JLabel statusLabel;
    
    public SafeStoreMongoDB() {
        initComponents();
        loadProductsFromLocal();
        loadCreditsFromLocal();
        MongoDBConnection.connect();
        updateStatus("Connected to MongoDB Atlas");
    }
    
    private void initComponents() {
        setTitle("SafeStore - Inventory & Credit Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1400, 800);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(1200, 600));
        
        getContentPane().setBackground(new Color(240, 240, 245));
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(240, 240, 245));
        
        mainPanel.add(createTopBar(), BorderLayout.NORTH);
        mainPanel.add(createTabbedPane(), BorderLayout.CENTER);
        mainPanel.add(createStatusBar(), BorderLayout.SOUTH);
        
        add(mainPanel);
    }
    
    private JPanel createTopBar() {
        JPanel topBar = new JPanel(new BorderLayout());
        topBar.setBackground(new Color(33, 150, 243));
        topBar.setPreferredSize(new Dimension(0, 70));
        
        JPanel logoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 15));
        logoPanel.setBackground(new Color(33, 150, 243));
        
        JLabel logoLabel = new JLabel("SafeStore");
        logoLabel.setFont(new Font("Arial", Font.BOLD, 22));
        logoLabel.setForeground(Color.WHITE);
        logoPanel.add(logoLabel);
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 15));
        buttonPanel.setBackground(new Color(33, 150, 243));
        
        JButton btnProducts = createNavButton("PRODUCTS");
        JButton btnCredits = createNavButton("CREDITS");
        JButton btnExpiration = createNavButton("EXPIRATION");
        
        buttonPanel.add(btnProducts);
        buttonPanel.add(btnCredits);
        buttonPanel.add(btnExpiration);
        
        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 15));
        rightPanel.setBackground(new Color(33, 150, 243));
        
        btnSyncToCloud = createActionButton("UPLOAD TO CLOUD", new Color(76, 175, 80));
        btnSyncFromCloud = createActionButton("DOWNLOAD FROM CLOUD", new Color(255, 152, 0));
        JButton btnExit = createActionButton("EXIT", new Color(244, 67, 54));
        
        rightPanel.add(btnSyncToCloud);
        rightPanel.add(btnSyncFromCloud);
        rightPanel.add(btnExit);
        
        topBar.add(logoPanel, BorderLayout.WEST);
        topBar.add(buttonPanel, BorderLayout.CENTER);
        topBar.add(rightPanel, BorderLayout.EAST);
        
        btnProducts.addActionListener(e -> tabbedPane.setSelectedIndex(0));
        btnCredits.addActionListener(e -> tabbedPane.setSelectedIndex(1));
        btnExpiration.addActionListener(e -> tabbedPane.setSelectedIndex(2));
        btnExit.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                MongoDBConnection.close();
                System.exit(0);
            }
        });
        btnSyncToCloud.addActionListener(e -> syncLocalToCloud());
        btnSyncFromCloud.addActionListener(e -> syncCloudToLocal());
        
        return topBar;
    }
    
    private JButton createNavButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 13));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(25, 118, 210));
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setPreferredSize(new Dimension(120, 38));
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(21, 101, 192));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(25, 118, 210));
            }
        });
        return button;
    }
    
    private JButton createActionButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 11));
        button.setForeground(Color.WHITE);
        button.setBackground(color);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setPreferredSize(new Dimension(140, 35));
        return button;
    }
    
    private JButton createCrudButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.setForeground(Color.WHITE);
        button.setBackground(color);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setPreferredSize(new Dimension(130, 32));
        return button;
    }
    
    private JTabbedPane createTabbedPane() {
        tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font("Arial", Font.BOLD, 13));
        tabbedPane.setBackground(new Color(240, 240, 245));
        
        tabbedPane.addTab("Products", createProductsPanel());
        tabbedPane.addTab("Credits", createCreditsPanel());
        tabbedPane.addTab("Expiration Control", createExpirationPanel());
        
        return tabbedPane;
    }
    
    private JPanel createProductsPanel() {
        productsPanel = new JPanel(new BorderLayout(10, 10));
        productsPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        productsPanel.setBackground(new Color(240, 240, 245));
        
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        searchPanel.setBackground(new Color(240, 240, 245));
        searchPanel.add(new JLabel("Search:"));
        searchField = new JTextField(20);
        searchPanel.add(searchField);
        JButton btnSearch = new JButton("Search");
        btnSearch.setBackground(new Color(33, 150, 243));
        btnSearch.setForeground(Color.WHITE);
        searchPanel.add(btnSearch);
        
        String[] columns = {"ID", "Name", "Wholesale($)", "Retail($)", "Stock", "Min Stock", "Expiry Date"};
        productsModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        productsTable = new JTable(productsModel);
        productsTable.setRowHeight(28);
        productsTable.setFont(new Font("Arial", Font.PLAIN, 12));
        productsTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        productsTable.getTableHeader().setBackground(new Color(33, 150, 243));
        productsTable.getTableHeader().setForeground(Color.WHITE);
        productsTable.setSelectionBackground(new Color(187, 222, 251));
        
        JScrollPane scrollPane = new JScrollPane(productsTable);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Products List"));
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        buttonPanel.setBackground(new Color(240, 240, 245));
        buttonPanel.setBorder(new TitledBorder("Actions"));
        
        btnAddProduct = createCrudButton("Add Product", new Color(76, 175, 80));
        btnEditProduct = createCrudButton("Edit Product", new Color(255, 193, 7));
        btnDeleteProduct = createCrudButton("Delete Product", new Color(244, 67, 54));
        btnRefreshProduct = createCrudButton("Refresh", new Color(33, 150, 243));
        
        buttonPanel.add(btnAddProduct);
        buttonPanel.add(btnEditProduct);
        buttonPanel.add(btnDeleteProduct);
        buttonPanel.add(btnRefreshProduct);
        
        productsPanel.add(searchPanel, BorderLayout.NORTH);
        productsPanel.add(scrollPane, BorderLayout.CENTER);
        productsPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        btnAddProduct.addActionListener(e -> showAddProductDialog());
        btnEditProduct.addActionListener(e -> showEditProductDialog());
        btnDeleteProduct.addActionListener(e -> deleteSelectedProduct());
        btnRefreshProduct.addActionListener(e -> loadProductsFromLocal());
        btnSearch.addActionListener(e -> searchProducts(searchField.getText()));
        
        return productsPanel;
    }
    
    private JPanel createCreditsPanel() {
        creditsPanel = new JPanel(new BorderLayout(10, 10));
        creditsPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        creditsPanel.setBackground(new Color(240, 240, 245));
        
        String[] columns = {"Customer ID", "Name", "Limit($)", "Debt($)", "Available($)", "Status"};
        creditsModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        creditsTable = new JTable(creditsModel);
        creditsTable.setRowHeight(28);
        creditsTable.setFont(new Font("Arial", Font.PLAIN, 12));
        creditsTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        creditsTable.getTableHeader().setBackground(new Color(33, 150, 243));
        creditsTable.getTableHeader().setForeground(Color.WHITE);
        
        JScrollPane scrollPane = new JScrollPane(creditsTable);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Credit Accounts"));
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        buttonPanel.setBackground(new Color(240, 240, 245));
        buttonPanel.setBorder(new TitledBorder("Actions"));
        
        btnAddCredit = createCrudButton("Add Credit", new Color(76, 175, 80));
        btnEditCredit = createCrudButton("Edit Credit", new Color(255, 193, 7));
        btnDeleteCredit = createCrudButton("Delete Credit", new Color(244, 67, 54));
        btnRefreshCredit = createCrudButton("Refresh", new Color(33, 150, 243));
        
        buttonPanel.add(btnAddCredit);
        buttonPanel.add(btnEditCredit);
        buttonPanel.add(btnDeleteCredit);
        buttonPanel.add(btnRefreshCredit);
        
        creditsPanel.add(scrollPane, BorderLayout.CENTER);
        creditsPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        btnAddCredit.addActionListener(e -> showAddCreditDialog());
        btnEditCredit.addActionListener(e -> showEditCreditDialog());
        btnDeleteCredit.addActionListener(e -> deleteSelectedCredit());
        btnRefreshCredit.addActionListener(e -> loadCreditsFromLocal());
        
        return creditsPanel;
    }
    
    private JPanel createExpirationPanel() {
        expirationPanel = new JPanel(new BorderLayout(15, 15));
        expirationPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        expirationPanel.setBackground(new Color(240, 240, 245));
        
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(240, 240, 245));
        
        JLabel titleLabel = new JLabel("EXPIRATION CONTROL SYSTEM");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setForeground(new Color(244, 67, 54));
        headerPanel.add(titleLabel, BorderLayout.WEST);
        
        JButton btnCheckExpiry = new JButton("Check Expiry Dates");
        btnCheckExpiry.setBackground(new Color(33, 150, 243));
        btnCheckExpiry.setForeground(Color.WHITE);
        btnCheckExpiry.setFont(new Font("Arial", Font.BOLD, 12));
        headerPanel.add(btnCheckExpiry, BorderLayout.EAST);
        
        JTextArea alertArea = new JTextArea();
        alertArea.setEditable(false);
        alertArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        alertArea.setBackground(new Color(255, 255, 255));
        alertArea.setBorder(BorderFactory.createTitledBorder("Active Alerts"));
        
        JScrollPane scrollPane = new JScrollPane(alertArea);
        
        JPanel infoPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        infoPanel.setBackground(new Color(240, 240, 245));
        infoPanel.setBorder(BorderFactory.createTitledBorder("Statistics"));
        
        JLabel totalProductsLabel = new JLabel("Total Products: 0");
        JLabel expiringSoonLabel = new JLabel("Expiring Soon: 0");
        JLabel expiredLabel = new JLabel("Expired: 0");
        
        infoPanel.add(totalProductsLabel);
        infoPanel.add(expiringSoonLabel);
        infoPanel.add(expiredLabel);
        
        expirationPanel.add(headerPanel, BorderLayout.NORTH);
        expirationPanel.add(scrollPane, BorderLayout.CENTER);
        expirationPanel.add(infoPanel, BorderLayout.SOUTH);
        
        btnCheckExpiry.addActionListener(e -> {
            List<ProductManagement.Product> products = ProductManagement.getAllProducts();
            List<ExpirationControl.ExpirationAlert> alerts = ExpirationControl.generateAlerts(products);
            ExpirationControl.sendNotifications();
            
            alertArea.setText("");
            if (alerts.isEmpty()) {
                alertArea.setText("No products are expiring in the next 30 days");
            } else {
                StringBuilder sb = new StringBuilder();
                for (ExpirationControl.ExpirationAlert alert : alerts) {
                    sb.append("Product: ").append(alert.getProductName())
                      .append(" | Expires in: ").append(alert.getDaysUntilExpiry())
                      .append(" days | Date: ").append(alert.getExpiryDate()).append("\n");
                }
                alertArea.setText(sb.toString());
            }
            
            totalProductsLabel.setText("Total Products: " + products.size());
            long expiring = alerts.stream().filter(a -> a.getDaysUntilExpiry() <= 30 && a.getDaysUntilExpiry() > 0).count();
            expiringSoonLabel.setText("Expiring Soon: " + expiring);
        });
        
        return expirationPanel;
    }
    
    private JPanel createStatusBar() {
        JPanel statusBar = new JPanel(new BorderLayout());
        statusBar.setBackground(new Color(33, 33, 33));
        statusBar.setPreferredSize(new Dimension(0, 30));
        
        statusLabel = new JLabel(" Ready");
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 11));
        statusLabel.setForeground(Color.WHITE);
        statusBar.add(statusLabel, BorderLayout.WEST);
        
        JLabel timeLabel = new JLabel(new java.util.Date().toString());
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 11));
        timeLabel.setForeground(Color.WHITE);
        statusBar.add(timeLabel, BorderLayout.EAST);
        
        new Timer(1000, e -> timeLabel.setText(new java.util.Date().toString())).start();
        
        return statusBar;
    }
    
    private void updateStatus(String message) {
        statusLabel.setText(" " + message);
    }
    
    private void loadProductsFromLocal() {
        productsModel.setRowCount(0);
        List<ProductManagement.Product> products = ProductManagement.getAllProducts();
        for (ProductManagement.Product p : products) {
            productsModel.addRow(new Object[]{
                    p.getId(),
                    p.getName(),
                    p.getWholesalePrice(),
                    p.getRetailPrice(),
                    p.getStock(),
                    p.getMinStock(),
                    p.getExpiryDate()
            });
        }
        updateStatus("Loaded " + products.size() + " products from local storage");
    }
    
    private void loadCreditsFromLocal() {
        creditsModel.setRowCount(0);
        List<CreditManagement.CreditAccount> accounts = CreditManagement.getAllAccounts();
        for (CreditManagement.CreditAccount acc : accounts) {
            double available = acc.getCreditLimit() - acc.getCurrentDebt();
            creditsModel.addRow(new Object[]{
                    acc.getCustomerId(),
                    acc.getCustomerName(),
                    acc.getCreditLimit(),
                    acc.getCurrentDebt(),
                    available,
                    acc.isBlocked() ? "BLOCKED" : "Active"
            });
        }
        updateStatus("Loaded " + accounts.size() + " credit accounts from local storage");
    }
    
    private void searchProducts(String query) {
        if (query == null || query.trim().isEmpty()) {
            loadProductsFromLocal();
            return;
        }
        
        productsModel.setRowCount(0);
        List<ProductManagement.Product> products = ProductManagement.getAllProducts();
        for (ProductManagement.Product p : products) {
            if (String.valueOf(p.getId()).contains(query) || 
                p.getName().toLowerCase().contains(query.toLowerCase())) {
                productsModel.addRow(new Object[]{
                        p.getId(),
                        p.getName(),
                        p.getWholesalePrice(),
                        p.getRetailPrice(),
                        p.getStock(),
                        p.getMinStock(),
                        p.getExpiryDate()
                });
            }
        }
        updateStatus("Found " + productsModel.getRowCount() + " products matching search");
    }
    
    private void showAddProductDialog() {
        JDialog dialog = new JDialog(this, "Add Product", true);
        dialog.setSize(450, 500);
        dialog.setLocationRelativeTo(this);
        
        JPanel panel = new JPanel(new GridLayout(8, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JTextField txtId = new JTextField();
        JTextField txtName = new JTextField();
        JTextField txtWholesale = new JTextField();
        JTextField txtRetail = new JTextField();
        JTextField txtStock = new JTextField();
        JTextField txtMinStock = new JTextField();
        JTextField txtExpiry = new JTextField();
        
        panel.add(new JLabel("ID:"));
        panel.add(txtId);
        panel.add(new JLabel("Name:"));
        panel.add(txtName);
        panel.add(new JLabel("Wholesale Price (12+ units):"));
        panel.add(txtWholesale);
        panel.add(new JLabel("Retail Price:"));
        panel.add(txtRetail);
        panel.add(new JLabel("Stock:"));
        panel.add(txtStock);
        panel.add(new JLabel("Min Stock:"));
        panel.add(txtMinStock);
        panel.add(new JLabel("Expiry Date (YYYY-MM-DD):"));
        panel.add(txtExpiry);
        
        JButton btnSave = new JButton("Save");
        JButton btnCancel = new JButton("Cancel");
        btnSave.setBackground(new Color(76, 175, 80));
        btnSave.setForeground(Color.WHITE);
        
        btnSave.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtId.getText());
                if (ProductManagement.findById(id) != null) {
                    JOptionPane.showMessageDialog(dialog, "Product with this ID already exists");
                    return;
                }
                
                ProductManagement.Product product = new ProductManagement.Product(
                        id,
                        txtName.getText(),
                        Double.parseDouble(txtWholesale.getText()),
                        Double.parseDouble(txtRetail.getText()),
                        Integer.parseInt(txtStock.getText()),
                        Integer.parseInt(txtMinStock.getText()),
                        txtExpiry.getText()
                );
                ProductManagement.addProduct(product);
                loadProductsFromLocal();
                JOptionPane.showMessageDialog(dialog, "Product added successfully");
                dialog.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(dialog, "Error: " + ex.getMessage());
            }
        });
        
        btnCancel.addActionListener(e -> dialog.dispose());
        
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(btnSave);
        buttonPanel.add(btnCancel);
        
        dialog.setLayout(new BorderLayout());
        dialog.add(panel, BorderLayout.CENTER);
        dialog.add(buttonPanel, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }
    
    private void showEditProductDialog() {
        int selectedRow = productsTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Select a product to edit");
            return;
        }
        
        int id = (int) productsModel.getValueAt(selectedRow, 0);
        ProductManagement.Product product = ProductManagement.findById(id);
        
        if (product == null) return;
        
        JDialog dialog = new JDialog(this, "Edit Product", true);
        dialog.setSize(450, 480);
        dialog.setLocationRelativeTo(this);
        
        JPanel panel = new JPanel(new GridLayout(7, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JTextField txtName = new JTextField(product.getName());
        JTextField txtWholesale = new JTextField(String.valueOf(product.getWholesalePrice()));
        JTextField txtRetail = new JTextField(String.valueOf(product.getRetailPrice()));
        JTextField txtStock = new JTextField(String.valueOf(product.getStock()));
        JTextField txtMinStock = new JTextField(String.valueOf(product.getMinStock()));
        JTextField txtExpiry = new JTextField(product.getExpiryDate());
        
        panel.add(new JLabel("Name:"));
        panel.add(txtName);
        panel.add(new JLabel("Wholesale Price:"));
        panel.add(txtWholesale);
        panel.add(new JLabel("Retail Price:"));
        panel.add(txtRetail);
        panel.add(new JLabel("Stock:"));
        panel.add(txtStock);
        panel.add(new JLabel("Min Stock:"));
        panel.add(txtMinStock);
        panel.add(new JLabel("Expiry Date:"));
        panel.add(txtExpiry);
        
        JButton btnSave = new JButton("Update");
        JButton btnCancel = new JButton("Cancel");
        btnSave.setBackground(new Color(255, 193, 7));
        btnSave.setForeground(Color.WHITE);
        
        btnSave.addActionListener(e -> {
            try {
                product.setName(txtName.getText());
                product.setWholesalePrice(Double.parseDouble(txtWholesale.getText()));
                product.setRetailPrice(Double.parseDouble(txtRetail.getText()));
                product.setStock(Integer.parseInt(txtStock.getText()));
                product.setMinStock(Integer.parseInt(txtMinStock.getText()));
                product.setExpiryDate(txtExpiry.getText());
                ProductManagement.saveToFile();
                loadProductsFromLocal();
                JOptionPane.showMessageDialog(dialog, "Product updated successfully");
                dialog.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(dialog, "Error: " + ex.getMessage());
            }
        });
        
        btnCancel.addActionListener(e -> dialog.dispose());
        
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(btnSave);
        buttonPanel.add(btnCancel);
        
        dialog.setLayout(new BorderLayout());
        dialog.add(panel, BorderLayout.CENTER);
        dialog.add(buttonPanel, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }
    
    private void deleteSelectedProduct() {
        int selectedRow = productsTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Select a product to delete");
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this product?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            int id = (int) productsModel.getValueAt(selectedRow, 0);
            ProductManagement.deleteProduct(id);
            loadProductsFromLocal();
            JOptionPane.showMessageDialog(this, "Product deleted successfully");
        }
    }
    
    private void showAddCreditDialog() {
        JDialog dialog = new JDialog(this, "Add Credit Account", true);
        dialog.setSize(400, 350);
        dialog.setLocationRelativeTo(this);
        
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JTextField txtId = new JTextField();
        JTextField txtName = new JTextField();
        JTextField txtLimit = new JTextField();
        
        panel.add(new JLabel("Customer ID:"));
        panel.add(txtId);
        panel.add(new JLabel("Customer Name:"));
        panel.add(txtName);
        panel.add(new JLabel("Credit Limit:"));
        panel.add(txtLimit);
        
        JButton btnSave = new JButton("Save");
        JButton btnCancel = new JButton("Cancel");
        btnSave.setBackground(new Color(76, 175, 80));
        btnSave.setForeground(Color.WHITE);
        
        btnSave.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtId.getText());
                if (CreditManagement.findAccountById(id) != null) {
                    JOptionPane.showMessageDialog(dialog, "Credit account already exists for this ID");
                    return;
                }
                
                CreditManagement.CreditAccount account = new CreditManagement.CreditAccount(
                        id,
                        txtName.getText(),
                        Double.parseDouble(txtLimit.getText())
                );
                CreditManagement.createAccount(account);
                loadCreditsFromLocal();
                JOptionPane.showMessageDialog(dialog, "Credit account added successfully");
                dialog.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(dialog, "Error: " + ex.getMessage());
            }
        });
        
        btnCancel.addActionListener(e -> dialog.dispose());
        
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(btnSave);
        buttonPanel.add(btnCancel);
        
        dialog.setLayout(new BorderLayout());
        dialog.add(panel, BorderLayout.CENTER);
        dialog.add(buttonPanel, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }
    
    private void showEditCreditDialog() {
        int selectedRow = creditsTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Select a credit account to edit");
            return;
        }
        
        int id = (int) creditsModel.getValueAt(selectedRow, 0);
        CreditManagement.CreditAccount account = CreditManagement.findAccountById(id);
        
        if (account == null) return;
        
        JDialog dialog = new JDialog(this, "Edit Credit Account", true);
        dialog.setSize(400, 350);
        dialog.setLocationRelativeTo(this);
        
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JTextField txtName = new JTextField(account.getCustomerName());
        JTextField txtLimit = new JTextField(String.valueOf(account.getCreditLimit()));
        JCheckBox chkBlocked = new JCheckBox("Blocked", account.isBlocked());
        
        panel.add(new JLabel("Name:"));
        panel.add(txtName);
        panel.add(new JLabel("Credit Limit:"));
        panel.add(txtLimit);
        panel.add(new JLabel("Status:"));
        panel.add(chkBlocked);
        
        JButton btnSave = new JButton("Update");
        JButton btnCancel = new JButton("Cancel");
        btnSave.setBackground(new Color(255, 193, 7));
        btnSave.setForeground(Color.WHITE);
        
        btnSave.addActionListener(e -> {
            try {
                account.setCustomerName(txtName.getText());
                account.setCreditLimit(Double.parseDouble(txtLimit.getText()));
                account.setBlocked(chkBlocked.isSelected());
                CreditManagement.saveToFile();
                loadCreditsFromLocal();
                JOptionPane.showMessageDialog(dialog, "Credit account updated successfully");
                dialog.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(dialog, "Error: " + ex.getMessage());
            }
        });
        
        btnCancel.addActionListener(e -> dialog.dispose());
        
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(btnSave);
        buttonPanel.add(btnCancel);
        
        dialog.setLayout(new BorderLayout());
        dialog.add(panel, BorderLayout.CENTER);
        dialog.add(buttonPanel, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }
    
    private void deleteSelectedCredit() {
        int selectedRow = creditsTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Select a credit account to delete");
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this credit account?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            int id = (int) creditsModel.getValueAt(selectedRow, 0);
            CreditManagement.CreditAccount account = CreditManagement.findAccountById(id);
            if (account != null) {
                CreditManagement.getAllAccounts().remove(account);
                CreditManagement.saveToFile();
                loadCreditsFromLocal();
                JOptionPane.showMessageDialog(this, "Credit account deleted successfully");
            }
        }
    }
    
    private void syncLocalToCloud() {
        int confirm = JOptionPane.showConfirmDialog(this, 
            "Upload local data (JSON) to MongoDB Atlas?\nThis will overwrite cloud data.",
            "Confirm Sync", JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            MongoDBConnection.syncFromLocalToCloud();
            updateStatus("Data uploaded to cloud successfully");
            JOptionPane.showMessageDialog(this, "Data uploaded to cloud successfully");
        }
    }
    
    private void syncCloudToLocal() {
        int confirm = JOptionPane.showConfirmDialog(this,
            "Download data from MongoDB Atlas to local JSON?\nThis will overwrite local data.",
            "Confirm Sync", JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            MongoDBConnection.syncFromCloudToLocal();
            loadProductsFromLocal();
            loadCreditsFromLocal();
            updateStatus("Data downloaded from cloud successfully");
            JOptionPane.showMessageDialog(this, "Data downloaded from cloud successfully");
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            new SafeStoreMongoDB().setVisible(true);
        });
    }
}