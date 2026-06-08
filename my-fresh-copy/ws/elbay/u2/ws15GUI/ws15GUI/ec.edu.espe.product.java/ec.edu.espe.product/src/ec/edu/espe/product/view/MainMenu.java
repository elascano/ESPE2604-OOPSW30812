package ec.edu.espe.product.view;

import ec.edu.espe.product.controller.ProductController;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class MainMenu extends JFrame {

    private ProductController controller;

    public MainMenu() {

        controller = new ProductController();

        setTitle("Product System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,1));

        JButton btnAdd = new JButton("Add Product");
        JButton btnReport = new JButton("View Report");
        JButton btnExit = new JButton("Exit");

        panel.add(btnAdd);
        panel.add(btnReport);
        panel.add(btnExit);

        add(panel);

        btnAdd.addActionListener(e -> {
            AddProductForm form = new AddProductForm(controller);
            form.setVisible(true);
        });

        btnReport.addActionListener(e -> {
            ReportForm report = new ReportForm(controller);
            report.setVisible(true);
        });

        btnExit.addActionListener(e -> {
            System.exit(0);
        });
    }

    public static void main(String[] args) {

        MainMenu menu = new MainMenu();
        menu.setVisible(true);
    }
}