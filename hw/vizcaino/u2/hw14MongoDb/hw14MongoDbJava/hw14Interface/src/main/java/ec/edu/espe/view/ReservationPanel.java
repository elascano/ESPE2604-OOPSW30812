/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.view;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */
import ec.edu.espe.model.Reservation;
import ec.edu.espe.model.dao.ReservationDAO;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ReservationPanel extends JPanel {

    private JTextField txtId;
    private JTextField txtCustomerName;
    private JTextField txtPhone;
    private JTextField txtStatus;

    private JTable table;
    private DefaultTableModel model;

    private ReservationDAO dao;

    public ReservationPanel() {

        dao = new ReservationDAO();

        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));

        inputPanel.add(new JLabel("ID"));
        txtId = new JTextField();
        inputPanel.add(txtId);

        inputPanel.add(new JLabel("Customer Name"));
        txtCustomerName = new JTextField();
        inputPanel.add(txtCustomerName);

        inputPanel.add(new JLabel("Phone"));
        txtPhone = new JTextField();
        inputPanel.add(txtPhone);

        inputPanel.add(new JLabel("Status"));
        txtStatus = new JTextField();
        inputPanel.add(txtStatus);

        add(inputPanel, BorderLayout.NORTH);

        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Customer Name");
        model.addColumn("Phone");
        model.addColumn("Status");

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

        btnAdd.addActionListener(e -> addReservation());
        btnDelete.addActionListener(e -> deleteReservation());
        btnRefresh.addActionListener(e -> loadData());

        loadData();
    }

    private void addReservation() {

        try {

            Reservation reservation = new Reservation(
                    Integer.parseInt(txtId.getText()),
                    txtCustomerName.getText(),
                    txtPhone.getText(),
                    txtStatus.getText()
            );

            dao.save(reservation);
            loadData();
            clearFields();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void deleteReservation() {

        int row = table.getSelectedRow();

        if (row >= 0) {

            int id = Integer.parseInt(model.getValueAt(row, 0).toString());

            dao.delete(id);
            loadData();
        }
    }

    private void loadData() {

        model.setRowCount(0);

        List<Reservation> reservations = dao.findAll();

        for (Reservation r : reservations) {

            model.addRow(new Object[]{
                    r.getId(),
                    r.getCustomerName(),
                    r.getPhone(),
                    r.getStatus()
            });
        }
    }

    private void clearFields() {

        txtId.setText("");
        txtCustomerName.setText("");
        txtPhone.setText("");
        txtStatus.setText("");
    }
}