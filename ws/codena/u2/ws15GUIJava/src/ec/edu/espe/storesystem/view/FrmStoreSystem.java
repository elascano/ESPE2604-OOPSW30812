// FrmStoreSystem.java
package ec.edu.espe.storesystem.view;

import ec.edu.espe.storesystem.controller.ProductController;
import ec.edu.espe.storesystem.model.Product;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class FrmStoreSystem extends JFrame {

    ProductController controller = new ProductController();

    JLabel lblName;
    JLabel lblId;
    JLabel lblPrice;
    JLabel lblWeight;

    JTextField txtName;
    JTextField txtId;

    JComboBox<String> cmbPrice;

    JSlider sldWeight;

    JButton btnSave;
    JButton btnShowProducts;

    JTable tblProducts;

    JScrollPane scrollPane;

    public FrmStoreSystem() {

        initComponents();
    }

    private void initComponents() {

        // MENU

        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("Menu");

        JMenuItem menuAdd = new JMenuItem("Add Product");
        JMenuItem menuShow = new JMenuItem("Show Products");
        JMenuItem menuExit = new JMenuItem("Exit");

        menu.add(menuAdd);
        menu.add(menuShow);
        menu.add(menuExit);

        menuBar.add(menu);

        setJMenuBar(menuBar);

        // LABELS

        lblName = new JLabel("Product Name:");
        lblId = new JLabel("ID:");
        lblPrice = new JLabel("Price:");
        lblWeight = new JLabel("Weight (lb):");

        // TEXTFIELDS

        txtName = new JTextField();
        txtId = new JTextField();

        // COMBOBOX

        cmbPrice = new JComboBox<>();

        cmbPrice.addItem("5");
        cmbPrice.addItem("10");
        cmbPrice.addItem("20");
        cmbPrice.addItem("50");

        // SLIDER

        sldWeight = new JSlider(1, 100, 1);

        sldWeight.setMajorTickSpacing(10);
        sldWeight.setPaintTicks(true);
        sldWeight.setPaintLabels(true);

        // BUTTONS

        btnSave = new JButton("Save Product");
        btnShowProducts = new JButton("Show Products");

        // TABLE

        tblProducts = new JTable();

        scrollPane = new JScrollPane(tblProducts);

        // WINDOW

        setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // POSITIONS

        lblName.setBounds(20, 20, 120, 25);
        txtName.setBounds(150, 20, 180, 25);

        lblId.setBounds(20, 60, 120, 25);
        txtId.setBounds(150, 60, 180, 25);

        lblPrice.setBounds(20, 100, 120, 25);
        cmbPrice.setBounds(150, 100, 180, 25);

        lblWeight.setBounds(20, 140, 120, 25);
        sldWeight.setBounds(150, 140, 250, 50);

        btnSave.setBounds(120, 220, 150, 35);
        btnShowProducts.setBounds(300, 220, 150, 35);

        scrollPane.setBounds(20, 280, 540, 200);

        // ADD COMPONENTS

        add(lblName);
        add(txtName);

        add(lblId);
        add(txtId);

        add(lblPrice);
        add(cmbPrice);

        add(lblWeight);
        add(sldWeight);

        add(btnSave);
        add(btnShowProducts);

        add(scrollPane);

        // FRAME CONFIGURATION

        setSize(620, 550);

        setLocationRelativeTo(null);

        // SAVE BUTTON

        btnSave.addActionListener(e -> saveProduct());

        // SHOW BUTTON

        btnShowProducts.addActionListener(e -> showProducts());

        // MENU SHOW

        menuShow.addActionListener(e -> showProducts());

        // MENU EXIT

        menuExit.addActionListener(e -> System.exit(0));

        // MENU ADD

        menuAdd.addActionListener(e ->
                JOptionPane.showMessageDialog(
                        this,
                        "Enter product information"));
    }

    // SAVE PRODUCT METHOD

    private void saveProduct() {

        try {

            String name = txtName.getText();

            int id = Integer.parseInt(txtId.getText());

            double price =
                    Double.parseDouble(
                            cmbPrice.getSelectedItem().toString());

            double weight = sldWeight.getValue();

            Product product =
                    new Product(name, id, price, weight);

            controller.saveProduct(product);

            JOptionPane.showMessageDialog(
                    this,
                    "Product saved!");

            txtName.setText("");
            txtId.setText("");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid data!");
        }
    }

    // SHOW PRODUCTS METHOD

    private void showProducts() {

        List<Product> products =
                controller.readProducts();

        DefaultTableModel model =
                new DefaultTableModel();

        model.addColumn("Name");
        model.addColumn("ID");
        model.addColumn("Price");
        model.addColumn("Weight (lb)");
        model.addColumn("Weight (kg)");

        for (Product product : products) {

            model.addRow(new Object[]{

                    product.getName(),
                    product.getId(),
                    product.getPrice(),
                    product.getWeightPounds(),
                    String.format("%.2f",
                            product.getWeightKg())
            });
        }

        tblProducts.setModel(model);
    }
}