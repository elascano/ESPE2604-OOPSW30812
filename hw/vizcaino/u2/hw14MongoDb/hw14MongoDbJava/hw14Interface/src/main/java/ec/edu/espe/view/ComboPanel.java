/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.view;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */


import ec.edu.espe.model.Combo;
import ec.edu.espe.model.dao.ComboDAO;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ComboPanel extends JPanel {

    private JTextField txtId;
    private JTextField txtName;
    private JTextField txtDescription;
    private JTextField txtPrice;

    private JTable table;
    private DefaultTableModel model;

    private ComboDAO dao;

    public ComboPanel() {

        dao = new ComboDAO();

        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));

        inputPanel.add(new JLabel("ID"));
        txtId = new JTextField();
        inputPanel.add(txtId);

        inputPanel.add(new JLabel("Name"));
        txtName = new JTextField();
        inputPanel.add(txtName);

        inputPanel.add(new JLabel("Description"));
        txtDescription = new JTextField();
        inputPanel.add(txtDescription);

        inputPanel.add(new JLabel("Price"));
        txtPrice = new JTextField();
        inputPanel.add(txtPrice);

        add(inputPanel, BorderLayout.NORTH);

        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Description");
        model.addColumn("Price");

        table = new JTable(model);

        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();

        JButton btnAdd = new JButton("Add");
        JButton btnDelete = new JButton("Delete");
        JButton btnRefresh = new JButton("Refresh");

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnRefresh);

        add(buttonPanel, BorderLayout.SOUTH);

        btnAdd.addActionListener(e -> addCombo());
        btnDelete.addActionListener(e -> deleteCombo());
        btnRefresh.addActionListener(e -> loadData());

        loadData();
    }

    private void addCombo() {

        try {

            Combo combo = new Combo(
                    Integer.parseInt(txtId.getText()),
                    txtName.getText(),
                    txtDescription.getText(),
                    Double.parseDouble(txtPrice.getText())
            );

            dao.save(combo);
            loadData();
            clearFields();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void deleteCombo() {

        int row = table.getSelectedRow();

        if (row >= 0) {

            int id = Integer.parseInt(model.getValueAt(row, 0).toString());

            dao.delete(id);
            loadData();
        }
    }

    private void loadData() {

        model.setRowCount(0);

        List<Combo> combos = dao.findAll();

        for (Combo c : combos) {

            model.addRow(new Object[]{
                    c.getId(),
                    c.getName(),
                    c.getDescription(),
                    c.getPrice()
            });
        }
    }

    private void clearFields() {

        txtId.setText("");
        txtName.setText("");
        txtDescription.setText("");
        txtPrice.setText("");
    }
}