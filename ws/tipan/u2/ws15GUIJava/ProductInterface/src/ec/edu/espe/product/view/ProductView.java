/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.product.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author ronal
 */
public class ProductView extends JFrame {
    
    public JLabel lblName;
    public JLabel lblPrice;
    public JLabel lblQuantity;
    public JLabel lblTotal;

    public JTextField txtName;
    public JTextField txtPrice;
    public JTextField txtQuantity;

    public JButton btnAdd;
    public JButton btnCalculate;
    
    public ProductView() {

        setTitle("Product System");

        setSize(700, 500);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setLayout(null);
        
        lblName = new JLabel("Product:");
        lblName.setBounds(50, 50, 100, 30);
        add(lblName);

        txtName = new JTextField();
        txtName.setBounds(150, 50, 200, 30);
        add(txtName);

        lblPrice = new JLabel("Price:");
        lblPrice.setBounds(50, 100, 100, 30);
        add(lblPrice);

        txtPrice = new JTextField();
        txtPrice.setBounds(150, 100, 200, 30);
        add(txtPrice);

        lblQuantity = new JLabel("Quantity:");
        lblQuantity.setBounds(50, 150, 100, 30);
        add(lblQuantity);

        txtQuantity = new JTextField();
        txtQuantity.setBounds(150, 150, 200, 30);
        add(txtQuantity);

        btnAdd = new JButton("Add Product");
        btnAdd.setBounds(50, 230, 140, 40);
        add(btnAdd);

        btnCalculate = new JButton("Calculate Total");
        btnCalculate.setBounds(210, 230, 160, 40);
        add(btnCalculate);

        lblTotal = new JLabel("Total: $0");
        lblTotal.setBounds(50, 300, 300, 40);
        add(lblTotal);
    }
}