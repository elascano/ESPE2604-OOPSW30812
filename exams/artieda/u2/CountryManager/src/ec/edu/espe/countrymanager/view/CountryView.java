package ec.edu.espe.countrymanager.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CountryView extends JFrame {
    private JTextField txtId;
    private JTextField txtName;
    private JTextField txtPopulation;
    private JTextField txtArea;

    private JButton btnClear;
    private JButton btnFind;

    private JTable tblCountries;
    private DefaultTableModel tblModel;

    public CountryView() {
        setTitle("ACME Country CRUD Manager (MVC)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }

        JPanel pnlHeader = new JPanel();
        pnlHeader.setBackground(new Color(41, 128, 185));
        pnlHeader.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel lblTitle = new JLabel("Country Information Management System");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTitle.setForeground(Color.WHITE);
        pnlHeader.add(lblTitle);
        add(pnlHeader, BorderLayout.NORTH);

        JPanel pnlMain = new JPanel(new GridLayout(2, 1, 10, 10));
        pnlMain.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JPanel pnlForm = new JPanel(new GridBagLayout());
        pnlForm.setBorder(BorderFactory.createTitledBorder("Country Details (Widgets: JTextField, JButton, JLabel)"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0.1;
        pnlForm.add(new JLabel("Country ID (e.g. ECU):"), gbc);
        gbc.gridx = 1; gbc.gridy = 0; gbc.weightx = 0.6;
        txtId = new JTextField();
        pnlForm.add(txtId, gbc);
        gbc.gridx = 2; gbc.gridy = 0; gbc.weightx = 0.3;
        btnFind = new JButton("Find by ID");
        pnlForm.add(btnFind, gbc);

        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0.1;
        pnlForm.add(new JLabel("Country Name:"), gbc);
        gbc.gridx = 1; gbc.gridy = 1; gbc.weightx = 0.9;
        gbc.gridwidth = 2;
        txtName = new JTextField();
        pnlForm.add(txtName, gbc);

        gbc.gridx = 0; gbc.gridy = 2; gbc.weightx = 0.1;
        gbc.gridwidth = 1;
        pnlForm.add(new JLabel("Population:"), gbc);
        gbc.gridx = 1; gbc.gridy = 2; gbc.weightx = 0.9;
        gbc.gridwidth = 2;
        txtPopulation = new JTextField();
        pnlForm.add(txtPopulation, gbc);

        gbc.gridx = 0; gbc.gridy = 3; gbc.weightx = 0.1;
        gbc.gridwidth = 1;
        pnlForm.add(new JLabel("Area (sq km):"), gbc);
        gbc.gridx = 1; gbc.gridy = 3; gbc.weightx = 0.9;
        gbc.gridwidth = 2;
        txtArea = new JTextField();
        pnlForm.add(txtArea, gbc);

        JPanel pnlButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));
        btnClear = new JButton("Clear Form");

        btnClear.setPreferredSize(new Dimension(100, 30));

        pnlButtons.add(btnClear);

        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 3; gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        pnlForm.add(pnlButtons, gbc);

        pnlMain.add(pnlForm);

        JPanel pnlTable = new JPanel(new BorderLayout());
        pnlTable.setBorder(BorderFactory.createTitledBorder("Countries List (Widgets: JTable, JScrollPane)"));

        String[] columns = {"ID", "Name", "Population", "Area (sq km)", "Pop. Density (people/sq km)"};
        tblModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblCountries = new JTable(tblModel);
        tblCountries.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(tblCountries);
        pnlTable.add(scrollPane, BorderLayout.CENTER);

        pnlMain.add(pnlTable);
        add(pnlMain, BorderLayout.CENTER);

        JPanel pnlFooter = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlFooter.setBorder(BorderFactory.createEtchedBorder());
        JLabel lblStatus = new JLabel("System Ready.");
        pnlFooter.add(lblStatus);
        add(pnlFooter, BorderLayout.SOUTH);

        tblCountries.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = tblCountries.getSelectedRow();
                if (selectedRow != -1) {
                    txtId.setText(tblModel.getValueAt(selectedRow, 0).toString());
                    txtName.setText(tblModel.getValueAt(selectedRow, 1).toString());
                    txtPopulation.setText(tblModel.getValueAt(selectedRow, 2).toString());
                    txtArea.setText(tblModel.getValueAt(selectedRow, 3).toString());
                    txtId.setEditable(false);
                }
            }
        });
    }

    public String getCountryId() { return txtId.getText().trim(); }
    public String getCountryName() { return txtName.getText().trim(); }
    public String getCountryPopulation() { return txtPopulation.getText().trim(); }
    public String getCountryArea() { return txtArea.getText().trim(); }

    public void setCountryId(String id) { txtId.setText(id); }
    public void setCountryName(String name) { txtName.setText(name); }
    public void setCountryPopulation(String pop) { txtPopulation.setText(pop); }
    public void setCountryArea(String area) { txtArea.setText(area); }
    public void setCountryIdEditable(boolean editable) { txtId.setEditable(editable); }

    public JTable getTblCountries() { return tblCountries; }
    public DefaultTableModel getTblModel() { return tblModel; }

    public void clearForm() {
        txtId.setText("");
        txtName.setText("");
        txtPopulation.setText("");
        txtArea.setText("");
        txtId.setEditable(true);
        tblCountries.clearSelection();
    }


    public void addClearListener(ActionListener listener) { btnClear.addActionListener(listener); }
    public void addFindListener(ActionListener listener) { btnFind.addActionListener(listener); }

    public void showMessage(String message, String title, int messageType) {
        JOptionPane.showMessageDialog(this, message, title, messageType);
    }

    public int showConfirm(String message, String title) {
        return JOptionPane.showConfirmDialog(this, message, title, JOptionPane.YES_NO_OPTION);
    }
}
