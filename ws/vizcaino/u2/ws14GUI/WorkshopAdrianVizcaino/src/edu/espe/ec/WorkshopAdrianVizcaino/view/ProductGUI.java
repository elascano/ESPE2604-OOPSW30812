/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.espe.ec.WorkshopAdrianVizcaino.view;

/**
 *
 * @author Adrian Vizcaino <The-Softwarrios at ESPE>
 */
import edu.espe.ec.WorkshopAdrianVizcaino.model.Product;
import edu.espe.ec.WorkshopAdrianVizcaino.model.ProductModel;

import javax.swing.*;
import java.awt.*;

public class ProductGUI extends JFrame {

    private ProductModel model;

    private JSpinner spnId;
    private JTextField txtName;
    private JSpinner spnQuantity;
    private JSpinner spnPrice;
    private JTextField txtBrand;

    private JTextArea txtArea;

    private JButton btnAdd;
    private JButton btnShow;
    private JButton btnTotal;
    private JButton btnDelete;
    private JButton btnEdit;

    public ProductGUI() {

        model = new ProductModel();

        setTitle("Product System");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
    }

    public void initComponents() {

        JPanel panel = new JPanel();

        panel.setLayout(
                new GridLayout(8, 2, 10, 10));


        panel.add(new JLabel("ID:"));

        spnId = new JSpinner(
                new SpinnerNumberModel(
                        1, 1, 9999, 1));

        panel.add(spnId);


        panel.add(new JLabel("Name:"));

        txtName = new JTextField();

        panel.add(txtName);


        panel.add(new JLabel("Quantity:"));

        spnQuantity = new JSpinner(
                new SpinnerNumberModel(
                        1, 1, 1000, 1));

        panel.add(spnQuantity);


        panel.add(new JLabel("Price ($):"));

        spnPrice = new JSpinner(
                new SpinnerNumberModel(
                        1.0, 0.0, 100000.0, 0.5));

        panel.add(spnPrice);


        panel.add(new JLabel("Brand:"));

        txtBrand = new JTextField();

        panel.add(txtBrand);


        btnAdd = new JButton("Add Product");

        btnShow = new JButton("Show Products");

        btnEdit = new JButton("Edit Product");

        btnDelete = new JButton("Delete Product");

        btnTotal = new JButton("Total Quantity");

        panel.add(btnAdd);
        panel.add(btnShow);

        panel.add(btnEdit);
        panel.add(btnDelete);

        txtArea = new JTextArea();

        txtArea.setEditable(false);

        JScrollPane scroll =
                new JScrollPane(txtArea);

        setLayout(new BorderLayout());

        add(panel, BorderLayout.NORTH);

        add(scroll, BorderLayout.CENTER);

        add(btnTotal, BorderLayout.SOUTH);


        btnAdd.addActionListener(
                e -> addProduct());

        btnShow.addActionListener(
                e -> showProducts());

        btnEdit.addActionListener(
                e -> editProduct());

        btnDelete.addActionListener(
                e -> deleteProduct());

        btnTotal.addActionListener(e ->

                JOptionPane.showMessageDialog(
                        this,
                        "Total Quantity: " +
                                model.totalProducts()));
    }

    public void addProduct() {

        int id =
                (Integer) spnId.getValue();

        String name =
                txtName.getText();

        int quantity =
                (Integer) spnQuantity.getValue();

        double price =
                (Double) spnPrice.getValue();

        String brand =
                txtBrand.getText();

        Product p =
                new Product(id,
                        name,
                        quantity,
                        price,
                        brand);

        model.addProduct(p);

        JOptionPane.showMessageDialog(
                this,
                "Product Added");

        clearFields();
    }

    public void showProducts() {

        txtArea.setText("");

        for(Product p : model.getProducts()) {

            txtArea.append(p + "\n");
        }
    }

    public void editProduct() {

        int id =
                (Integer) spnId.getValue();

        String name =
                txtName.getText();

        int quantity =
                (Integer) spnQuantity.getValue();

        double price =
                (Double) spnPrice.getValue();

        String brand =
                txtBrand.getText();

        model.editProduct(
                id,
                name,
                quantity,
                price,
                brand);

        JOptionPane.showMessageDialog(
                this,
                "Product Edited");

        showProducts();
    }

    public void deleteProduct() {

        int id =
                (Integer) spnId.getValue();

        model.deleteProduct(id);

        JOptionPane.showMessageDialog(
                this,
                "Product Deleted");

        showProducts();
    }

    public void clearFields() {

        txtName.setText("");

        txtBrand.setText("");

        spnId.setValue(1);

        spnQuantity.setValue(1);

        spnPrice.setValue(1.0);
    }
}