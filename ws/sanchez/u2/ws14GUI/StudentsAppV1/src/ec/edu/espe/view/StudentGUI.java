/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.view;

/**
 *
 * @author Joel Sanchez <The_Softwarriors at ESPE>
 */

import ec.edu.espe.model.Student;
import ec.edu.espe.model.JsonManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class StudentGUI extends JFrame {

    private JTextField txtIdNumber, txtName, txtAge;
    private JTextField txtGrade;
    private JComboBox<String> cmbCareer;

    private JTable table;
    private DefaultTableModel model;

    private JsonManager manager;

    public StudentGUI() {

        manager = new JsonManager();

        setTitle("Student Management System");
        setSize(950, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel form = new JPanel(new GridLayout(7, 2, 10, 10));
        form.setBorder(BorderFactory.createTitledBorder("Student Entry"));

        txtIdNumber = new JTextField();
        txtName = new JTextField();
        txtAge = new JTextField();
        txtGrade = new JTextField();

        cmbCareer = new JComboBox<>(new String[]{
                "Software Engineering",
                "Computer Science",
                "Business",
                "Medicine"
        });

        form.add(new JLabel("ID Number"));
        form.add(txtIdNumber);

        form.add(new JLabel("Name"));
        form.add(txtName);

        form.add(new JLabel("Age"));
        form.add(txtAge);

        form.add(new JLabel("Career"));
        form.add(cmbCareer);

        form.add(new JLabel("Grades (comma separated)"));
        form.add(txtGrade);

        JButton btnAdd = new JButton("Add Student");
        JButton btnClear = new JButton("Clear");

        form.add(btnAdd);
        form.add(btnClear);

        add(form, BorderLayout.WEST);

        model = new DefaultTableModel();

        model.addColumn("ID Number");
        model.addColumn("Name");
        model.addColumn("Age");
        model.addColumn("Career");
        model.addColumn("GPA");

        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        loadTable();

        btnAdd.addActionListener(e -> addStudent());
        btnClear.addActionListener(e -> clearFields());
    }

    private void addStudent() {

        try {

            String idNumber = txtIdNumber.getText().trim();
            String name = txtName.getText().trim();
            int age = Integer.parseInt(txtAge.getText().trim());

            String career = cmbCareer.getSelectedItem().toString();

            String[] gradeArray = txtGrade.getText().split(",");
            ArrayList<Double> grades = new ArrayList<>();

            for (String g : gradeArray) {

                double value = Double.parseDouble(g.trim());

                if (value < 0 || value > 20) {
                    throw new IllegalArgumentException("Grades must be 0-20");
                }

                grades.add(value);
            }

            if (idNumber.isEmpty() || name.isEmpty() || grades.isEmpty()) {
                throw new IllegalArgumentException("Fields cannot be empty");
            }

            Student student = new Student(idNumber, name, age, career, grades);

            manager.addStudent(student);

            loadTable();
            clearFields();

            JOptionPane.showMessageDialog(this,
                    "Student added successfully");

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(this,
                    "Invalid age numeric format");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this,
                    e.getMessage());
        }
    }

    private void loadTable() {

        model.setRowCount(0);

        for (Student s : manager.getStudents()) {

            model.addRow(new Object[]{
                    s.getIdNumber(),
                    s.getName(),
                    s.getAge(),
                    s.getCareer(),
                    String.format("%.2f", s.calculateGPA())
            });
        }
    }

    private void clearFields() {

        txtIdNumber.setText("");
        txtName.setText("");
        txtAge.setText("");
        txtGrade.setText("");
        cmbCareer.setSelectedIndex(0);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new StudentGUI().setVisible(true);
        });
    }
}