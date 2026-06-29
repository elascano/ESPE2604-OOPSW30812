/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.view;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */

import ec.edu.espe.mongo.MongoDBConnection;
import org.bson.Document;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StreamingPlatformView extends JFrame {

    private JTextField txtName;
    private JTextField txtPlan;
    private JLabel lblName;
    private JLabel lblPlan;

    private JTable table;
    private MongoDBConnection mongo;

    public StreamingPlatformView() {

        mongo = new MongoDBConnection();

        setTitle("Streaming Platform");
        setSize(520, 420);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        lblName = new JLabel("Name:");
        lblPlan = new JLabel("Plan:");

        txtName = new JTextField();
        txtPlan = new JTextField();

        JButton btnSave = new JButton("Create");
        JButton btnLoad = new JButton("Load");
        JButton btnUpdate = new JButton("Update");
        JButton btnDelete = new JButton("Delete");

        table = new JTable(new DefaultTableModel(new String[]{"Name", "Plan"}, 0));

        lblName.setBounds(20, 0, 100, 20);
        txtName.setBounds(20, 20, 150, 30);

        lblPlan.setBounds(200, 0, 100, 20);
        txtPlan.setBounds(200, 20, 150, 30);

        btnSave.setBounds(20, 60, 100, 30);
        btnLoad.setBounds(130, 60, 100, 30);
        btnUpdate.setBounds(240, 60, 100, 30);
        btnDelete.setBounds(350, 60, 100, 30);

        table.setBounds(20, 120, 450, 220);

        add(lblName);
        add(lblPlan);
        add(txtName);
        add(txtPlan);

        add(btnSave);
        add(btnLoad);
        add(btnUpdate);
        add(btnDelete);

        add(table);

        btnSave.addActionListener(e -> {

            new Thread(() -> {
                mongo.insertUser(txtName.getText(), txtPlan.getText());
                System.out.println("Saved");
            }).start();

        });

        btnUpdate.addActionListener(e -> {

            new Thread(() -> {
                mongo.updateUser(txtName.getText(), txtPlan.getText());
            }).start();

        });

        btnDelete.addActionListener(e -> {

            new Thread(() -> {
                mongo.deleteUser(txtName.getText());
            }).start();

        });

        btnLoad.addActionListener(e -> new Thread(this::load).start());
    }

    private void load() {

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        for (Document d : mongo.getAllUsers()) {
            model.addRow(new Object[]{
                    d.getString("name"),
                    d.getString("plan")
            });
        }
    }
}