/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeteria.views;

/**
 *
 * @author Mateo Artieda,MKA Programer, @ESPE
 */


import javax.swing.*;
import java.awt.*;

public class CashierWindow extends JFrame {

    public CashierWindow() {
        // Configuración de la ventana principal
        setTitle("Cafeteria Management App");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 1. BARRA DE MENÚ (Top Menu Bar)
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        JMenu menuUsers = new JMenu("Users");
        JMenu menuOrders = new JMenu("Orders");
        JMenu menuAlerts = new JMenu("Alerts");
        JMenu menuHelp = new JMenu("Help");
        
        menuBar.add(menuFile);
        menuBar.add(menuUsers);
        menuBar.add(menuOrders);
        menuBar.add(menuAlerts);
        menuBar.add(menuHelp);
        setJMenuBar(menuBar);

        // 2. PANEL DE PESTAÑAS (Tabbed Pane para CRUD en la esquina superior izquierda)
        JTabbedPane tabbedPane = new JTabbedPane();
        
        // Pestaña principal: "Load Order" (Equivalente a 'Crear')
        JPanel createOrderPanel = createCashierForm();
        
        tabbedPane.addTab("Load Order", createOrderPanel);
        tabbedPane.addTab("View Orders", new JPanel());   // Equivalente a 'Consultar'
        tabbedPane.addTab("Update Order", new JPanel()); // Equivalente a 'Editar'
        tabbedPane.addTab("Cancel Order", new JPanel()); // Equivalente a 'Eliminar'

        // Añadir las pestañas al contenedor principal
        getContentPane().add(tabbedPane, BorderLayout.CENTER);
    }

    // Método que dibuja el formulario principal del cajero
    private JPanel createCashierForm() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(240, 240, 240));

        // TÍTULO CENTRAL
        JLabel lblTitle = new JLabel("New Order Entry", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.PLAIN, 20));
        lblTitle.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        mainPanel.add(lblTitle, BorderLayout.NORTH);

        // FORMULARIO CENTRAL (GridBagLayout para replicar la alineación de tu imagen)
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 10, 8, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Componentes del Formulario
        JLabel lblId = new JLabel("Order ID:", SwingConstants.RIGHT);
        JTextField txtId = new JTextField(25);

        JLabel lblItem = new JLabel("Product/Item:", SwingConstants.RIGHT);
        JTextField txtItem = new JTextField(25);

        JLabel lblQuantity = new JLabel("Quantity:", SwingConstants.RIGHT);
        JSpinner spnQuantity = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));

        JLabel lblType = new JLabel("Order Type:", SwingConstants.RIGHT);
        String[] types = { " - Select Option - ", "Dine In", "Takeaway", "Delivery" };
        JComboBox<String> cmbType = new JComboBox<>(types);

        JLabel lblNotes = new JLabel("Special Instructions:", SwingConstants.RIGHT);
        JTextArea txtNotes = new JTextArea(5, 25);
        txtNotes.setLineWrap(true);
        JScrollPane scrollNotes = new JScrollPane(txtNotes);

        // Posicionar elementos en la cuadrícula (X, Y)
        gbc.gridx = 0; gbc.gridy = 0; formPanel.add(lblId, gbc);
        gbc.gridx = 1; formPanel.add(txtId, gbc);

        gbc.gridx = 0; gbc.gridy = 1; formPanel.add(lblItem, gbc);
        gbc.gridx = 1; formPanel.add(txtItem, gbc);

        gbc.gridx = 0; gbc.gridy = 2; formPanel.add(lblQuantity, gbc);
        gbc.gridx = 1; formPanel.add(spnQuantity, gbc);

        gbc.gridx = 0; gbc.gridy = 3; formPanel.add(lblType, gbc);
        gbc.gridx = 1; formPanel.add(cmbType, gbc);

        gbc.gridx = 0; gbc.gridy = 4; gbc.anchor = GridBagConstraints.NORTH; formPanel.add(lblNotes, gbc);
        gbc.gridx = 1; formPanel.add(scrollNotes, gbc);

        mainPanel.add(formPanel, BorderLayout.CENTER);

        // 3. BOTONES INFERIORES (Save, Clear, Cancel)
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        buttonPanel.setOpaque(false);

        JButton btnSave = new JButton("Save & Print");
        JButton btnClear = new JButton("Clear fields");
        JButton btnCancel = new JButton("Cancel");

        buttonPanel.add(btnSave);
        buttonPanel.add(btnClear);
        buttonPanel.add(btnCancel);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        return mainPanel;
    }

    public static void main(String[] args) {
        // Asegura que la interfaz se ejecute en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            // Intentar usar el estilo nativo del sistema operativo para que se vea limpio
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            new CashierWindow().setVisible(true);
        });
    }
}
