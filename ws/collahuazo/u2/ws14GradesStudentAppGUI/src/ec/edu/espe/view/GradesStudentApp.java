package ec.edu.espe.view;

import ec.edu.espe.controller.StudentController;
import ec.edu.espe.model.Student;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GradesStudentApp extends JFrame {

    private StudentController controller;

    private JTextField txtId, txtFirstName, txtLastName, txtPhone;
    private JButton btnRegister;

    private JComboBox<String> cmbStudents;
    private JTextField txtGrade1, txtGrade2, txtGrade3;
    private JButton btnSaveGrades;

    private JTable tblReport;
    private DefaultTableModel tableModel;

    public GradesStudentApp() {
        controller = new StudentController();

        setTitle("Student Grades Management System");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.addTab("Register Student", createRegisterPanel());
        tabbedPane.addTab("Input Grades", createGradesPanel());
        tabbedPane.addTab("Grades Report", createReportPanel());

        tabbedPane.addChangeListener(e -> {
            if (tabbedPane.getSelectedIndex() == 1) {
                updateStudentComboBox();
            } else if (tabbedPane.getSelectedIndex() == 2) {
                refreshReportTable();
            }
        });

        add(tabbedPane);
    }

    private JPanel createRegisterPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        txtId = new JTextField(15);
        txtFirstName = new JTextField(15);
        txtLastName = new JTextField(15);
        txtPhone = new JTextField(15);
        btnRegister = new JButton("Register");

        addComponent(panel, new JLabel("Student ID:"), gbc, 0, 0);
        addComponent(panel, txtId, gbc, 1, 0);
        addComponent(panel, new JLabel("First Name:"), gbc, 0, 1);
        addComponent(panel, txtFirstName, gbc, 1, 1);
        addComponent(panel, new JLabel("Last Name:"), gbc, 0, 2);
        addComponent(panel, txtLastName, gbc, 1, 2);
        addComponent(panel, new JLabel("Phone Number:"), gbc, 0, 3);
        addComponent(panel, txtPhone, gbc, 1, 3);

        gbc.gridwidth = 2;
        addComponent(panel, btnRegister, gbc, 0, 4);

        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtId.getText().isEmpty() || txtFirstName.getText().isEmpty()
                        || txtLastName.getText().isEmpty() || txtPhone.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                controller.registerStudent(txtId.getText(), txtFirstName.getText(), txtLastName.getText(), txtPhone.getText());
                JOptionPane.showMessageDialog(null, "Student registered successfully!");

                txtId.setText("");
                txtFirstName.setText("");
                txtLastName.setText("");
                txtPhone.setText("");
            }
        });

        return panel;
    }

    private JPanel createGradesPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        cmbStudents = new JComboBox<>();
        txtGrade1 = new JTextField(5);
        txtGrade2 = new JTextField(5);
        txtGrade3 = new JTextField(5);
        btnSaveGrades = new JButton("Save Grades");

        addComponent(panel, new JLabel("Select Student:"), gbc, 0, 0);
        gbc.gridwidth = 2;
        addComponent(panel, cmbStudents, gbc, 1, 0);
        gbc.gridwidth = 1;

        addComponent(panel, new JLabel("Grade 1:"), gbc, 0, 1);
        addComponent(panel, txtGrade1, gbc, 1, 1);
        addComponent(panel, new JLabel("Grade 2:"), gbc, 0, 2);
        addComponent(panel, txtGrade2, gbc, 1, 2);
        addComponent(panel, new JLabel("Grade 3:"), gbc, 0, 3);
        addComponent(panel, txtGrade3, gbc, 1, 3);

        gbc.gridwidth = 3;
        addComponent(panel, btnSaveGrades, gbc, 0, 4);

        btnSaveGrades.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedItem = (String) cmbStudents.getSelectedItem();
                if (selectedItem == null || selectedItem.startsWith("No students")) {
                    JOptionPane.showMessageDialog(null, "Please select a valid student.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String targetId = selectedItem.split(" - ")[0].replace("ID: ", "").trim();
                ArrayList<Double> gradesList = new ArrayList<>();

                try {
                    gradesList.add(Double.parseDouble(txtGrade1.getText()));
                    gradesList.add(Double.parseDouble(txtGrade2.getText()));
                    gradesList.add(Double.parseDouble(txtGrade3.getText()));

                    if (controller.addGradesToStudent(targetId, gradesList)) {
                        JOptionPane.showMessageDialog(null, "All 3 grades added successfully!");
                        txtGrade1.setText("");
                        txtGrade2.setText("");
                        txtGrade3.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "Grades must be between 0 and 20.", "Validation Error", JOptionPane.WARNING_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter valid numbers for all grades.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        return panel;
    }

    private JPanel createReportPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        String[] columns = {"ID", "First Name", "Last Name", "Grades", "Average", "Status"};
        tableModel = new DefaultTableModel(columns, 0);
        tblReport = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(tblReport);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private void addComponent(JPanel panel, Component comp, GridBagConstraints gbc, int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
        panel.add(comp, gbc);
    }

    private void updateStudentComboBox() {
        cmbStudents.removeAllItems();
        ArrayList<Student> list = controller.getAllStudents();
        if (list.isEmpty()) {
            cmbStudents.addItem("No students registered yet.");
        } else {
            for (Student s : list) {
                cmbStudents.addItem("ID: " + s.getId() + " - " + s.getFirstName() + " " + s.getLastName());
            }
        }
    }

    private void refreshReportTable() {
        tableModel.setRowCount(0);
        ArrayList<Student> list = controller.getAllStudents();

        for (Student s : list) {
            ArrayList<Double> studentGrades = controller.getGradesByStudent(s.getId());
            double avg = controller.calculateAverage(s.getId());
            String status = (avg >= 14.0) ? "Pass" : "No pass";

            Object[] rowData = {
                s.getId(),
                s.getFirstName(),
                s.getLastName(),
                studentGrades.toString(),
                String.format("%.2f", avg),
                status
            };
            tableModel.addRow(rowData);
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new GradesStudentApp().setVisible(true);
        });
    }
}
