package ec.edu.espe.EmployeeSalary.view;

import ec.edu.espe.EmployeeSalary.model.Employee;
import ec.edu.espe.EmployeeSalary.model.EmployeeModel;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeView extends JFrame {
    private JTextField txtId, txtName, txtClockIn, txtClockOut, txtRole, txtSalary;
    private JButton btnRegister;
    private JTable table;
    private DefaultTableModel tableModel;
    private JLabel lblTotalBudget;
    
    private EmployeeModel model;

    public EmployeeView() {
       
        model = new EmployeeModel();
        model.loadFromFile();

      
        setTitle("Employee Payroll & Registration");
        setSize(750, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

     
        JPanel formPanel = new JPanel(new GridLayout(7, 2, 5, 5));
        formPanel.setBorder(BorderFactory.createTitledBorder("Employee Registration Form"));

        formPanel.add(new JLabel("Employee ID (Alphanumeric):"));
        txtId = new JTextField();
        formPanel.add(txtId);

        formPanel.add(new JLabel("Full Name:"));
        txtName = new JTextField();
        formPanel.add(txtName);

        formPanel.add(new JLabel("Clock-In Time (HH:MM):"));
        txtClockIn = new JTextField();
        formPanel.add(txtClockIn);

        formPanel.add(new JLabel("Clock-Out Time (HH:MM):"));
        txtClockOut = new JTextField();
        formPanel.add(txtClockOut);

        formPanel.add(new JLabel("Role / Position:"));
        txtRole = new JTextField();
        formPanel.add(txtRole);

        formPanel.add(new JLabel("Salary ($):"));
        txtSalary = new JTextField();
        formPanel.add(txtSalary);

        btnRegister = new JButton("Register Employee");
        btnRegister.setBackground(new Color(40, 167, 69));
        btnRegister.setForeground(Color.WHITE);
        formPanel.add(btnRegister);

        
        add(formPanel, BorderLayout.NORTH);

      
        String[] columns = {"ID", "Name", "Clock-In", "Clock-Out", "Role", "Salary"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        
      
        add(scrollPane, BorderLayout.CENTER);

       
        JPanel totalPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        totalPanel.setBackground(new Color(226, 227, 229));
        lblTotalBudget = new JLabel("TOTAL BUDGET REQUIRED: $0.00");
        lblTotalBudget.setFont(new Font("Arial", Font.BOLD, 14));
        totalPanel.add(lblTotalBudget);
        
     
        add(totalPanel, BorderLayout.SOUTH);

      
        updateUI();

        
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleRegistration();
            }
        });
    }


    public void updateUI() {
        tableModel.setRowCount(0); 
        for (Employee emp : model.getEmployees()) {
            tableModel.addRow(new Object[]{
                emp.getId(),
                emp.getName(),
                emp.getClockIn(),
                emp.getClockOut(),
                emp.getRole(),
                String.format("$%.2f", emp.getSalary())
            });
        }
        lblTotalBudget.setText(String.format("TOTAL BUDGET REQUIRED: $%.2f", model.calculateTotalSalaries()));
    }

    private void handleRegistration() {
        String id = txtId.getText().trim();
        String name = txtName.getText().trim();
        String clockIn = txtClockIn.getText().trim();
        String clockOut = txtClockOut.getText().trim();
        String role = txtRole.getText().trim();
        String salaryStr = txtSalary.getText().trim();

        if (id.isEmpty() || name.isEmpty() || clockIn.isEmpty() || clockOut.isEmpty() || role.isEmpty() || salaryStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required.");
            return;
        }

        double salary;
        try {
            salary = Double.parseDouble(salaryStr);
            if (salary < 0) {
                JOptionPane.showMessageDialog(this, "Please enter a valid positive salary amount.");
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Salary must be a valid numeric value.");
            return;
        }

        model.addEmployee(id, name, clockIn, clockOut, role, salary);

        if (model.saveToFile()) {
            JOptionPane.showMessageDialog(this, "Employee saved successfully to JSON!");
            txtId.setText("");
            txtName.setText("");
            txtClockIn.setText("");
            txtClockOut.setText("");
            txtRole.setText("");
            txtSalary.setText("");
            updateUI();
        } else {
            JOptionPane.showMessageDialog(this, "Error saving employee data.");
        }
    }
}