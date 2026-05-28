package ec.edu.espe.ProductPriceJava.view;
import ec.edu.espe.ProductPriceJava.controller.ProductController;
import ec.edu.espe.ProductPriceJava.model.ProductModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 *
 * @author Angie Nacato, Error 404, @ESPE
 */
public class ProductPrice extends JFrame {
    private JTextField txtCustomerName, txtCustomerId, txtCustomerPhone;
    private JComboBox<String> comboProducts;
    private JButton btnAdd, btnCheckout, btnClear, btnExit;
    private JTable tableCart;
    private DefaultTableModel tableModel;
    private JLabel lblSubtotal, lblVat, lblTotal;

    public ProductPrice() {
        setTitle("Product Management & Checkout System - ESPE");
        setSize(750, 680);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout(10, 10));

        JLabel lblTitle = new JLabel("PRODUCT MANAGEMENT SYSTEM", JLabel.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitle.setBorder(BorderFactory.createEmptyBorder(10, 0, 5, 0));
        add(lblTitle, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));

        JPanel customerPanel = new JPanel(new GridLayout(3, 1, 5, 8));
        customerPanel.setBorder(BorderFactory.createTitledBorder(" Customer Information "));
        customerPanel.setMaximumSize(new Dimension(710, 120));

        txtCustomerName = createPlaceholderTextField("Customer Name");
        txtCustomerId = createPlaceholderTextField("Customer ID / ID Card");
        txtCustomerPhone = createPlaceholderTextField("Phone Number");

        customerPanel.add(txtCustomerName);
        customerPanel.add(txtCustomerId);
        customerPanel.add(txtCustomerPhone);
        centerPanel.add(customerPanel);
        centerPanel.add(Box.createVerticalStrut(10));

        JPanel catalogPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        catalogPanel.setBorder(BorderFactory.createTitledBorder(" Select Products from Catalog "));
        catalogPanel.setMaximumSize(new Dimension(710, 65));
        
        catalogPanel.add(new JLabel("Product:"));
        comboProducts = new JComboBox<>();
        comboProducts.setPreferredSize(new Dimension(300, 25));
        catalogPanel.add(comboProducts);

        btnAdd = new JButton("Add to Cart");
        catalogPanel.add(btnAdd);
        centerPanel.add(catalogPanel);
        centerPanel.add(Box.createVerticalStrut(10));

        JPanel cartPanel = new JPanel(new BorderLayout());
        cartPanel.setBorder(BorderFactory.createTitledBorder(" Shopping Cart Summary "));
        cartPanel.setPreferredSize(new Dimension(710, 220));

        String[] columns = {"Product Name", "Base Price", "VAT (15%)", "Total Price"};
        tableModel = new DefaultTableModel(columns, 0);
        tableCart = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tableCart);
        cartPanel.add(scrollPane, BorderLayout.CENTER);
        centerPanel.add(cartPanel);

        add(centerPanel, BorderLayout.CENTER);

        JPanel southPanel = new JPanel(new BorderLayout());
        southPanel.setBorder(BorderFactory.createEmptyBorder(5, 20, 15, 20));

        JPanel totalsPanel = new JPanel(new GridLayout(3, 1, 5, 2));
        lblSubtotal = new JLabel("Subtotal: $0.00", JLabel.RIGHT);
        lblVat = new JLabel("Total VAT (15%): $0.00", JLabel.RIGHT);
        lblTotal = new JLabel("Net Total to Pay: $0.00", JLabel.RIGHT);
        lblTotal.setFont(new Font("Arial", Font.BOLD, 14));
        lblTotal.setForeground(new Color(34, 139, 34)); // Verde
        
        totalsPanel.add(lblSubtotal);
        totalsPanel.add(lblVat);
        totalsPanel.add(lblTotal);
        southPanel.add(totalsPanel, BorderLayout.NORTH);

        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 10));
        footerPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        
        btnClear = new JButton("Clear Cart");
        btnCheckout = new JButton("Confirm Purchase / Checkout");
        btnCheckout.setFont(new Font("Arial", Font.BOLD, 11));
        btnExit = new JButton("Exit Program");
        
        footerPanel.add(btnClear);
        footerPanel.add(btnCheckout);
        footerPanel.add(btnExit);
        southPanel.add(footerPanel, BorderLayout.SOUTH);

        add(southPanel, BorderLayout.SOUTH);
    }

    private JTextField createPlaceholderTextField(String placeholder) {
        JTextField textField = new JTextField(placeholder);
        textField.setFont(new Font("Arial", Font.PLAIN, 12));
        textField.setForeground(Color.GRAY);
        textField.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setForeground(Color.GRAY);
                    textField.setText(placeholder);
                }
            }
        });
        return textField;
    }

    public String getCustomerName() { return txtCustomerName.getText().trim(); }
    public String getCustomerId() { return txtCustomerId.getText().trim(); }
    public String getCustomerPhone() { return txtCustomerPhone.getText().trim(); }
    public int getSelectedProductIndex() { return comboProducts.getSelectedIndex(); }

    public void setCatalogOptions(String[] options) {
        comboProducts.setModel(new DefaultComboBoxModel<>(options));
    }

    public void addRowToTable(Object[] rowData) { tableModel.addRow(rowData); }
    public void clearTable() { tableModel.setRowCount(0); }
    
    public void clearCustomerFields() {
        txtCustomerName.setText("Customer Name"); txtCustomerName.setForeground(Color.GRAY);
        txtCustomerId.setText("Customer ID / ID Card"); txtCustomerId.setForeground(Color.GRAY);
        txtCustomerPhone.setText("Phone Number"); txtCustomerPhone.setForeground(Color.GRAY);
    }

    public void updateTotals(double subtotal, double vat, double total) {
        lblSubtotal.setText(String.format("Subtotal: $%.2f", subtotal));
        lblVat.setText(String.format("Total VAT (15%%): $%.2f", vat));
        lblTotal.setText(String.format("Net Total to Pay: $%.2f", total));
    }

    public void addAddProductListener(ActionListener listener) { btnAdd.addActionListener(listener); }
    public void addCheckoutListener(ActionListener listener) { btnCheckout.addActionListener(listener); }
    public void addClearCartListener(ActionListener listener) { btnClear.addActionListener(listener); }
    public void addExitListener(ActionListener listener) { btnExit.addActionListener(listener); }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            ProductModel model = new ProductModel();
            ProductPrice view = new ProductPrice();
            new ProductController(model, view);
            view.setVisible(true);
        });
    }
}