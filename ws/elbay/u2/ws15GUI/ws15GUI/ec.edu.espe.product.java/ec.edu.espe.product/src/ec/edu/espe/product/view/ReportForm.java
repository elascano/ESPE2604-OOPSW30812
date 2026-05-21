package ec.edu.espe.product.view;

import ec.edu.espe.product.controller.ProductController;
import ec.edu.espe.product.model.Product;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;

public class ReportForm extends JFrame {

    private ProductController controller;

    public ReportForm(ProductController controller) {

        this.controller = controller;

        setTitle("Products Report");
        setSize(500,400);
        setLocationRelativeTo(null);

        String[] columns = {
            "ID",
            "NAME",
            "PRICE"
        };

        DefaultTableModel model =
                new DefaultTableModel(columns,0);

        JTable table = new JTable(model);

        for(Product product : controller.getProducts()) {

            Object[] row = {
                product.getId(),
                product.getName(),
                product.getPrice()
            };

            model.addRow(row);
        }

        JScrollPane scrollPane =
                new JScrollPane(table);

        JButton btnDelete =
                new JButton("Delete Selected Product");

        add(scrollPane, BorderLayout.CENTER);
        add(btnDelete, BorderLayout.SOUTH);

        btnDelete.addActionListener(e -> {

            int selectedRow = table.getSelectedRow();

            if(selectedRow != -1) {

                String id =
                        table.getValueAt(selectedRow,0)
                        .toString();

                controller.deleteProduct(id);

                model.removeRow(selectedRow);

                JOptionPane.showMessageDialog(null,
                        "Product Deleted");
            }
        });
    }
}