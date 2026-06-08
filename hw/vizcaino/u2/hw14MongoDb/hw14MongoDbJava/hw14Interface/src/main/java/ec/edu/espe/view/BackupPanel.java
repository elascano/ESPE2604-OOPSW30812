/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.view;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */


import ec.edu.espe.model.dao.BackupDAO;
import ec.edu.espe.model.Backup;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class BackupPanel extends JPanel {

    private JTextField txtId;
    private JTextField txtFileName;
    private JTextField txtStatus;
    private JTextField txtDate;

    private JTable table;
    private DefaultTableModel model;

    private BackupDAO dao;

    public BackupPanel() {

        dao = new BackupDAO();

        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));

        inputPanel.add(new JLabel("ID"));
        txtId = new JTextField();
        inputPanel.add(txtId);

        inputPanel.add(new JLabel("File Name"));
        txtFileName = new JTextField();
        inputPanel.add(txtFileName);

        inputPanel.add(new JLabel("Status"));
        txtStatus = new JTextField();
        inputPanel.add(txtStatus);

        inputPanel.add(new JLabel("Date"));
        txtDate = new JTextField();
        inputPanel.add(txtDate);

        add(inputPanel, BorderLayout.NORTH);

        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("File Name");
        model.addColumn("Status");
        model.addColumn("Date");

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

        btnAdd.addActionListener(e -> addBackup());
        btnDelete.addActionListener(e -> deleteBackup());
        btnRefresh.addActionListener(e -> loadData());

        loadData();
    }

    private void addBackup() {

        try {

            Backup backup = new Backup(
                    Integer.parseInt(txtId.getText()),
                    txtFileName.getText(),
                    txtStatus.getText(),
                    txtDate.getText());

            dao.save(backup);

            loadData();

            clearFields();

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());

        }
    }

    private void deleteBackup() {

        int row = table.getSelectedRow();

        if (row >= 0) {

            int id = Integer.parseInt(
                    model.getValueAt(row, 0).toString());

            dao.delete(id);

            loadData();
        }
    }

    private void loadData() {

        model.setRowCount(0);

        List<Backup> backups = dao.findAll();

        for (Backup backup : backups) {

            model.addRow(new Object[]{
                backup.getId(),
                backup.getFileName(),
                backup.getStatus(),
                backup.getDate()
            });
        }
    }

    private void clearFields() {

        txtId.setText("");
        txtFileName.setText("");
        txtStatus.setText("");
        txtDate.setText("");
    }
}