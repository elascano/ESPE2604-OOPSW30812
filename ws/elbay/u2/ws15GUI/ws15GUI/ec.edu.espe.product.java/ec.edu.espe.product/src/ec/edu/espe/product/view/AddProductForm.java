package ec.edu.espe.product.view;

import ec.edu.espe.product.controller.ProductController;
import ec.edu.espe.product.model.Product;
import javax.swing.*;
import java.awt.GridLayout;

public class AddProductForm extends JFrame {

    private ProductController controller;

    public AddProductForm(ProductController controller) {

        this.controller = controller;

        setTitle("Add Product");
        setSize(300,250);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,2));

        JLabel lblId = new JLabel("ID:");
        JLabel lblName = new JLabel("Name:");
        JLabel lblPrice = new JLabel("Price:");

        JTextField txtId = new JTextField();
        JTextField txtName = new JTextField();
        JTextField txtPrice = new JTextField();

        JButton btnSave = new JButton("Save");

        panel.add(lblId);
        panel.add(txtId);

        panel.add(lblName);
        panel.add(txtName);

        panel.add(lblPrice);
        panel.add(txtPrice);

        panel.add(new JLabel(""));
        panel.add(btnSave);

        add(panel);

        btnSave.addActionListener(e -> {

            String id = txtId.getText();
            String name = txtName.getText();
            double price = Double.parseDouble(txtPrice.getText());

            Product product = new Product(id, name, price);

            controller.addProduct(product);

            JOptionPane.showMessageDialog(null,
                    "Product Saved");

            dispose();
        });
    }
}