/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.studentsApp.view;

import ec.edu.espe.studentsApp.model.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 *
 * @author Joel Sanchez <The_Softwarriors at ESPE>
 */

public class StudentsApplication extends JFrame {
    private ArrayList<Student> students;
    private JTable tblStudents;
    private DefaultTableModel tableModel;
    private JTabbedPane tabbedPane;
    private JTextField txtFirstName, txtLastName, txtAge;
    private JComboBox<String> cbSubjects;
    private DefaultListModel<String> subjectListModel;
    private JList<String> subjectList;
    private Map<String, List<Double>> tempSubjectsGrades;
    private JLabel statusBar;

    public StudentsApplication() {
        students = JsonManager.readStudents();
        tempSubjectsGrades = new HashMap<>();
        initUI();
        loadStudentTable();
    }

    private void initUI() {
        setTitle("📚 Student Management System - Decimal Grades Supported");
        setSize(1200, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        add(createMainButtonPanel(), BorderLayout.NORTH);

        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("📋 Student List", createStudentListPanel());
        tabbedPane.addTab("➕ Quick Add", createQuickAddPanel());
        add(tabbedPane, BorderLayout.CENTER);

        statusBar = new JLabel(" Ready | Total students: " + students.size() + " | Accepts integers (15) and decimals (15.5)");
        statusBar.setBorder(new EmptyBorder(5, 10, 5, 10));
        statusBar.setFont(new Font("Arial", Font.PLAIN, 11));
        add(statusBar, BorderLayout.SOUTH);
    }

    private JPanel createMainButtonPanel() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
        mainPanel.setBackground(new Color(240, 248, 255));

        JLabel lblTitle = new JLabel("STUDENT MANAGEMENT SYSTEM", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitle.setForeground(new Color(0, 51, 102));
        mainPanel.add(lblTitle, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 20, 10));
        buttonPanel.setBackground(new Color(240, 248, 255));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(15, 50, 15, 50));

        JButton btnAddMain = createBigButton("➕ ADD STUDENT", "Add a new student", new Color(46, 204, 113), Color.WHITE);
        btnAddMain.addActionListener(e -> {
            tabbedPane.setSelectedIndex(1);
            JOptionPane.showMessageDialog(this, "✅ Complete the form in the 'Quick Add' tab\n\nAdd subjects and grades using the button.\n\n💡 Tip: You can use integers (15) or decimals (15.75)");
        });

        JButton btnReloadMain = createBigButton("🔄 RELOAD DATA", "Reload students from JSON file", new Color(52, 152, 219), Color.WHITE);
        btnReloadMain.addActionListener(e -> reloadData());

        JButton btnAverageMain = createBigButton("📊 SHOW AVERAGES", "View all students' averages", new Color(230, 126, 34), Color.WHITE);
        btnAverageMain.addActionListener(e -> showAverageDialog());

        buttonPanel.add(btnAddMain);
        buttonPanel.add(btnReloadMain);
        buttonPanel.add(btnAverageMain);

        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        JPanel secondaryPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        secondaryPanel.setBackground(new Color(240, 248, 255));
        
        JButton btnExit = new JButton("❌ EXIT");
        btnExit.setFont(new Font("Arial", Font.BOLD, 12));
        btnExit.setBackground(new Color(231, 76, 60));
        btnExit.setForeground(Color.WHITE);
        btnExit.setFocusPainted(false);
        btnExit.addActionListener(e -> System.exit(0));
        
        secondaryPanel.add(btnExit);
        mainPanel.add(secondaryPanel, BorderLayout.SOUTH);

        return mainPanel;
    }

    private JButton createBigButton(String text, String tooltip, Color bgColor, Color fgColor) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setBackground(bgColor);
        button.setForeground(fgColor);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(bgColor.darker(), 2),
            BorderFactory.createEmptyBorder(12, 25, 12, 25)
        ));
        button.setToolTipText(tooltip);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(bgColor.brighter());
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(bgColor);
            }
        });
        
        return button;
    }

    private JPanel createStudentListPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        JButton btnRefresh = new JButton("🔄 Refresh Table");
        btnRefresh.addActionListener(e -> loadStudentTable());
        
        JButton btnDelete = new JButton("🗑️ Delete Selected");
        btnDelete.setBackground(new Color(231, 76, 60));
        btnDelete.setForeground(Color.WHITE);
        btnDelete.addActionListener(e -> deleteSelectedStudent());
        
        controlPanel.add(btnRefresh);
        controlPanel.add(btnDelete);
        panel.add(controlPanel, BorderLayout.NORTH);

        // ✅ Updated column to show subject names
        String[] columns = {"First Name", "Last Name", "Age", "Subjects", "Average"};
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int col) { return false; }
        };
        
        tblStudents = new JTable(tableModel);
        tblStudents.setRowHeight(30);
        tblStudents.setFont(new Font("Arial", Font.PLAIN, 12));
        
        JScrollPane scroll = new JScrollPane(tblStudents);
        panel.add(scroll, BorderLayout.CENTER);
        
        return panel;
    }

    private JPanel createQuickAddPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createTitledBorder("Student Information"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(new JLabel("First Name:"), gbc);
        gbc.gridx = 1;
        txtFirstName = new JTextField(15);
        formPanel.add(txtFirstName, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        formPanel.add(new JLabel("Last Name:"), gbc);
        gbc.gridx = 1;
        txtLastName = new JTextField(15);
        formPanel.add(txtLastName, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        formPanel.add(new JLabel("Age:"), gbc);
        gbc.gridx = 1;
        txtAge = new JTextField(15);
        formPanel.add(txtAge, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        formPanel.add(new JLabel("Select Subject:"), gbc);
        gbc.gridx = 1;
        // ✅ Subjects in ENGLISH
        cbSubjects = new JComboBox<>(new String[]{
            "Mathematics", 
            "Physics", 
            "History", 
            "Programming", 
            "English", 
            "Chemistry", 
            "Biology",
            "Language Arts",
            "Physical Education",
            "Arts"
        });
        formPanel.add(cbSubjects, gbc);

        panel.add(formPanel, BorderLayout.NORTH);

        JPanel subjectsPanel = new JPanel(new BorderLayout(10, 10));
        subjectsPanel.setBorder(BorderFactory.createTitledBorder("Subjects and Grades"));
        
        JButton btnAddSubject = new JButton("➕ ADD SUBJECT WITH GRADES");
        btnAddSubject.setFont(new Font("Arial", Font.BOLD, 14));
        btnAddSubject.setBackground(new Color(46, 204, 113));
        btnAddSubject.setForeground(Color.WHITE);
        btnAddSubject.addActionListener(e -> showAddGradesDialog((String) cbSubjects.getSelectedItem()));
        
        subjectListModel = new DefaultListModel<>();
        subjectList = new JList<>(subjectListModel);
        subjectList.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        
        JButton btnRemoveSubject = new JButton("❌ Remove Selected Subject");
        btnRemoveSubject.addActionListener(e -> {
            int idx = subjectList.getSelectedIndex();
            if (idx != -1) {
                String subject = subjectListModel.remove(idx);
                String subjectName = subject.split(" → ")[0];
                tempSubjectsGrades.remove(subjectName);
                updateStatusMessage("Removed: " + subjectName);
            }
        });
        
        JPanel listButtonPanel = new JPanel(new BorderLayout());
        listButtonPanel.add(new JScrollPane(subjectList), BorderLayout.CENTER);
        listButtonPanel.add(btnRemoveSubject, BorderLayout.SOUTH);
        
        subjectsPanel.add(btnAddSubject, BorderLayout.NORTH);
        subjectsPanel.add(listButtonPanel, BorderLayout.CENTER);
        
        panel.add(subjectsPanel, BorderLayout.CENTER);

        JButton btnSave = new JButton("💾 SAVE STUDENT");
        btnSave.setFont(new Font("Arial", Font.BOLD, 16));
        btnSave.setBackground(new Color(52, 152, 219));
        btnSave.setForeground(Color.WHITE);
        btnSave.setPreferredSize(new Dimension(200, 50));
        btnSave.addActionListener(e -> saveQuickStudent());
        
        JButton btnClear = new JButton("🗑️ Clear Form");
        btnClear.addActionListener(e -> clearQuickForm());
        
        JPanel savePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        savePanel.add(btnSave);
        savePanel.add(btnClear);
        panel.add(savePanel, BorderLayout.SOUTH);
        
        return panel;
    }

    private double parseGrade(String input) throws NumberFormatException {
        if (input == null || input.trim().isEmpty()) {
            throw new NumberFormatException("Empty field");
        }
        
        String normalized = input.trim().replace(',', '.');
        double grade = Double.parseDouble(normalized);
        
        if (grade < 0 || grade > 20) {
            throw new NumberFormatException("Grade out of range (0-20)");
        }
        
        return Math.round(grade * 100.0) / 100.0;
    }

    private void showAddGradesDialog(String subject) {
        JDialog dialog = new JDialog(this, "📝 Enter grades for " + subject, true);
        dialog.setLayout(new GridBagLayout());
        dialog.setSize(550, 420);
        dialog.setLocationRelativeTo(this);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblInstructions = new JLabel("<html>Enter grades for <b>" + subject + "</b><br>Accepts: <b>integers</b> (15) or <b>decimals</b> (15.75)</html>");
        lblInstructions.setForeground(new Color(0, 102, 204));
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.gridwidth = 2;
        dialog.add(lblInstructions, gbc);

        JTextField[] gradeFields = new JTextField[3];
        for (int i = 0; i < 3; i++) {
            gbc.gridwidth = 1;
            gbc.gridx = 0; gbc.gridy = i + 1;
            dialog.add(new JLabel("Grade " + (i + 1) + ":"), gbc);
            gbc.gridx = 1;
            gradeFields[i] = new JTextField(10);
            gradeFields[i].setToolTipText("Example: 15 or 15.75");
            dialog.add(gradeFields[i], gbc);
        }

        JLabel lblMessage = new JLabel(" ");
        lblMessage.setForeground(Color.RED);
        gbc.gridx = 0; gbc.gridy = 4;
        gbc.gridwidth = 2;
        dialog.add(lblMessage, gbc);

        JPanel examplePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        examplePanel.setBorder(BorderFactory.createTitledBorder("Examples"));
        examplePanel.add(new JLabel("✅ 15  |  ✅ 18.5  |  ✅ 20  |  ✅ 7.75  |  ✅ 0"));
        gbc.gridy = 5;
        dialog.add(examplePanel, gbc);

        JButton saveBtn = new JButton("💾 SAVE GRADES");
        saveBtn.setBackground(new Color(46, 204, 113));
        saveBtn.setForeground(Color.WHITE);
        saveBtn.setFont(new Font("Arial", Font.BOLD, 14));
        saveBtn.addActionListener(e -> {
            try {
                List<Double> grades = new ArrayList<>();
                for (JTextField field : gradeFields) {
                    double g = parseGrade(field.getText());
                    grades.add(g);
                }
                tempSubjectsGrades.put(subject, grades);
                subjectListModel.addElement(subject + " → " + grades.toString());
                dialog.dispose();
                updateStatusMessage("✅ Grades saved for " + subject);
                JOptionPane.showMessageDialog(this, "✅ Grades saved for " + subject + "\n\nGrades: " + grades);
            } catch (NumberFormatException ex) {
                lblMessage.setText("❌ " + ex.getMessage() + " | Use: 15 (integer) or 15.5 (decimal)");
                lblMessage.setForeground(Color.RED);
            }
        });
        
        gbc.gridy = 6;
        dialog.add(saveBtn, gbc);
        dialog.setVisible(true);
    }

    private void saveQuickStudent() {
        try {
            String firstName = txtFirstName.getText().trim();
            String lastName = txtLastName.getText().trim();
            if (firstName.isEmpty() || lastName.isEmpty()) {
                JOptionPane.showMessageDialog(this, "❌ Please enter first and last name");
                return;
            }
            
            int age;
            try {
                age = Integer.parseInt(txtAge.getText().trim());
                if (age < 0 || age > 120) {
                    JOptionPane.showMessageDialog(this, "❌ Age must be between 0 and 120");
                    return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "❌ Age must be a valid integer number");
                return;
            }
            
            if (tempSubjectsGrades.isEmpty()) {
                JOptionPane.showMessageDialog(this, "⚠️ Add at least one subject with grades");
                return;
            }
            
            Map<String, ArrayList<Double>> finalGrades = new HashMap<>();
            for (Map.Entry<String, List<Double>> entry : tempSubjectsGrades.entrySet()) {
                finalGrades.put(entry.getKey(), new ArrayList<>(entry.getValue()));
            }
            
            Student s = new Student(firstName, lastName, age, finalGrades);
            students.add(s);
            JsonManager.saveStudents(students);
            loadStudentTable();
            clearQuickForm();
            updateStatusMessage("🎉 Student saved successfully!");
            JOptionPane.showMessageDialog(this, "🎉 Student saved successfully!\n\n" +
                "Name: " + firstName + " " + lastName + "\n" +
                "Subjects: " + finalGrades.size() + "\n" +
                "Overall Average: " + String.format("%.2f", s.getOverallAverage()));
            
            int response = JOptionPane.showConfirmDialog(this, "View in list?", "Success", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                tabbedPane.setSelectedIndex(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "❌ Unexpected error: " + e.getMessage());
        }
    }

    // ✅ MODIFIED: Shows actual subject names in the table
    private void loadStudentTable() {
        tableModel.setRowCount(0);
        for (Student s : students) {
            // Get all subject names
            Set<String> subjectNames = s.getSubjectsGrades().keySet();
            String subjectsDisplay;
            
            if (subjectNames.isEmpty()) {
                subjectsDisplay = "No subjects";
            } else {
                // Join all subject names with commas
                subjectsDisplay = String.join(", ", subjectNames);
            }
            
            Object[] row = {
                s.getFirstName(),
                s.getLastName(),
                s.getAge(),
                subjectsDisplay,  // ✅ Shows actual subject names (e.g., "Mathematics, Physics")
                String.format("%.2f", s.getOverallAverage())
            };
            tableModel.addRow(row);
        }
        updateStatusMessage("Ready | Total students: " + students.size());
    }

    private void deleteSelectedStudent() {
        int row = tblStudents.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a student to delete");
            return;
        }
        
        Student s = students.get(row);
        int confirm = JOptionPane.showConfirmDialog(this, 
            "Delete " + s.getFirstName() + " " + s.getLastName() + "?", 
            "Confirm Deletion", 
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE);
            
        if (confirm == JOptionPane.YES_OPTION) {
            students.remove(row);
            JsonManager.saveStudents(students);
            loadStudentTable();
            updateStatusMessage("🗑️ Student deleted successfully");
            JOptionPane.showMessageDialog(this, "Student deleted!");
        }
    }

    private void showAverageDialog() {
        if (students.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No students registered");
            return;
        }
        
        JDialog avgDialog = new JDialog(this, "📊 Class Averages", true);
        avgDialog.setLayout(new BorderLayout());
        avgDialog.setSize(550, 450);
        avgDialog.setLocationRelativeTo(this);
        
        JTextArea area = new JTextArea();
        area.setEditable(false);
        area.setFont(new Font("Monospaced", Font.PLAIN, 12));
        
        StringBuilder sb = new StringBuilder();
        sb.append("═══════════════════════════════════════════════════════\n");
        sb.append("              CLASS AVERAGES REPORT\n");
        sb.append("═══════════════════════════════════════════════════════\n\n");
        
        double classTotal = 0;
        for (Student s : students) {
            double avg = s.getOverallAverage();
            classTotal += avg;
            sb.append(String.format("📌 %-15s %-15s → %6.2f\n", 
                s.getFirstName(), s.getLastName(), avg));
        }
        
        sb.append("\n═══════════════════════════════════════════════════════\n");
        sb.append(String.format("🏆 CLASS AVERAGE: %.2f\n", classTotal / students.size()));
        sb.append("═══════════════════════════════════════════════════════\n");
        
        area.setText(sb.toString());
        avgDialog.add(new JScrollPane(area), BorderLayout.CENTER);
        
        JButton closeBtn = new JButton("CLOSE");
        closeBtn.addActionListener(e -> avgDialog.dispose());
        JPanel btnPanel = new JPanel();
        btnPanel.add(closeBtn);
        avgDialog.add(btnPanel, BorderLayout.SOUTH);
        
        avgDialog.setVisible(true);
    }

    private void reloadData() {
        students = JsonManager.readStudents();
        loadStudentTable();
        updateStatusMessage("🔄 Data reloaded from JSON file");
        JOptionPane.showMessageDialog(this, "✅ Data reloaded successfully!");
    }

    private void clearQuickForm() {
        txtFirstName.setText("");
        txtLastName.setText("");
        txtAge.setText("");
        tempSubjectsGrades.clear();
        subjectListModel.clear();
        updateStatusMessage("Form cleared");
    }

    private void updateStatusMessage(String message) {
        statusBar.setText(" " + message + " | Total students: " + students.size());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentsApplication().setVisible(true));
    }
}