/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.StoreProducts.view;
import ec.edu.espe.StoreProducts.model.JsonManager;
import ec.edu.espe.StoreProducts.model.Product;
import ec.edu.espe.StoreProducts.model.Store;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
/**
 *
 * @author sbart
 */
public class StoreProductsGUI extends JFrame{
    private JComboBox<String> cmbProducts;

    private JTextField txtQuantity;

    private JTable table;

    private DefaultTableModel model;

    private JButton btnAdd;

    private JButton btnCalculate;

    private Store store;

    public StoreProductsGUI() {

        store = new Store();

        setTitle("ONLINE STORE");

        setSize(700, 500);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        // TOP PANEL
        JPanel panelTop = new JPanel();

        panelTop.setLayout(new GridLayout(3,2,10,10));

        // PRODUCTS
        panelTop.add(new JLabel("Select Product"));

        cmbProducts = new JComboBox<>();

        cmbProducts.addItem("Laptop");
        cmbProducts.addItem("Mouse");
        cmbProducts.addItem("Keyboard");
        cmbProducts.addItem("Monitor");
        cmbProducts.addItem("Headphones");

        panelTop.add(cmbProducts);

        // QUANTITY
        panelTop.add(new JLabel("Quantity"));

        txtQuantity = new JTextField();

        panelTop.add(txtQuantity);

        // BUTTONS
        btnAdd = new JButton("🛒 Add");

        btnAdd.setBackground(Color.GREEN);

        btnCalculate = new JButton("🧮 Totals");

        btnCalculate.setBackground(Color.CYAN);

        panelTop.add(btnAdd);

        panelTop.add(btnCalculate);

        add(panelTop, BorderLayout.NORTH);

        // TABLE
        model = new DefaultTableModel();

        model.addColumn("Product");

        model.addColumn("Quantity");

        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);

        // ACTIONS
        btnAdd.addActionListener(e -> addProduct());

        btnCalculate.addActionListener(e -> calculateTotals());

        setVisible(true);
    }

    private void addProduct() {

        try {

            String name = cmbProducts.getSelectedItem().toString();

            int quantity = Integer.parseInt(txtQuantity.getText());

            Product product = new Product(name, quantity);

            store.addProduct(product);

            model.addRow(new Object[]{
                name,
                quantity
            });

            JsonManager.saveProducts(store);

            txtQuantity.setText("");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this,
                    "Enter valid quantity");
        }
    }

    private void calculateTotals() {

        int totalProducts = store.getNumberProducts();

        int totalItems = store.calculateTotalItems();

        JOptionPane.showMessageDialog(this,
                "TOTAL PRODUCTS: " + totalProducts
                + "\nTOTAL ITEMS: " + totalItems);
    }

    public static void main(String[] args) {

        new StoreProductsGUI();
    }
}

