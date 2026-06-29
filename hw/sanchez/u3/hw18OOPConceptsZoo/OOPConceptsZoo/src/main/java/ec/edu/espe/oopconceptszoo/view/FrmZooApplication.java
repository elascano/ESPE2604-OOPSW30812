package ec.edu.espe.oopconceptszoo.view;

import ec.edu.espe.oopconceptszoo.controller.AnimalController;
import ec.edu.espe.oopconceptszoo.model.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FrmZooApplication extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger =
        java.util.logging.Logger.getLogger(FrmZooApplication.class.getName());

    private AnimalController controller;
    private DefaultTableModel tableModel;

    public FrmZooApplication() {
        initComponents();
        controller = new AnimalController();
        initBusinessLogic();
        refreshAnimalList();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPane = new javax.swing.JTabbedPane();
        pnlRegister = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblAnimalType = new javax.swing.JLabel();
        cmbAnimalType = new javax.swing.JComboBox<>();
        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lblBreed = new javax.swing.JLabel();
        txtBreed = new javax.swing.JTextField();
        lblBornOn = new javax.swing.JLabel();
        txtBornOn = new javax.swing.JTextField();
        lblWeight = new javax.swing.JLabel();
        txtWeight = new javax.swing.JTextField();
        pnlExtra = new javax.swing.JPanel();
        lblExtra1 = new javax.swing.JLabel();
        txtExtra1 = new javax.swing.JTextField();
        lblExtra2 = new javax.swing.JLabel();
        txtExtra2 = new javax.swing.JTextField();
        btnRegister = new javax.swing.JButton();
        pnlList = new javax.swing.JPanel();
        pnlFilter = new javax.swing.JPanel();
        lblFilter = new javax.swing.JLabel();
        cmbFilter = new javax.swing.JComboBox<>();
        btnFilter = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        scrTable = new javax.swing.JScrollPane();
        tblAnimals = new javax.swing.JTable();
        pnlBusiness = new javax.swing.JPanel();
        pnlButtons = new javax.swing.JPanel();
        btnMilk = new javax.swing.JButton();
        btnEggs = new javax.swing.JButton();
        btnPigs = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        scrResult = new javax.swing.JScrollPane();
        txtBusinessResult = new javax.swing.JTextArea();
        btnClear = new javax.swing.JButton();
        pnlStats = new javax.swing.JPanel();
        btnStats = new javax.swing.JButton();
        scrStats = new javax.swing.JScrollPane();
        txtStats = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("OOP Concepts Zoo - Animal Management System");

        lblTitle.setFont(new java.awt.Font("Arial", 1, 18));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Register New Animal");

        lblAnimalType.setText("Animal Type:");
        lblId.setText("ID:");
        lblBreed.setText("Breed:");
        lblBornOn.setText("Born On (yyyy-MM-dd):");
        lblWeight.setText("Weight (kg):");

        txtBornOn.setToolTipText("Format: yyyy-MM-dd (Example: 2026-01-15)");

        pnlExtra.setBorder(javax.swing.BorderFactory.createTitledBorder("Specific Information"));
        lblExtra1.setText("Field 1:");
        lblExtra2.setText("Field 2:");

        javax.swing.GroupLayout pnlExtraLayout = new javax.swing.GroupLayout(pnlExtra);
        pnlExtra.setLayout(pnlExtraLayout);
        pnlExtraLayout.setHorizontalGroup(
            pnlExtraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlExtraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlExtraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblExtra1)
                    .addComponent(lblExtra2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlExtraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtExtra1)
                    .addComponent(txtExtra2))
                .addContainerGap())
        );
        pnlExtraLayout.setVerticalGroup(
            pnlExtraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlExtraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlExtraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblExtra1)
                    .addComponent(txtExtra1, javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlExtraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblExtra2)
                    .addComponent(txtExtra2, javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnRegister.setText("Register Animal");
        btnRegister.addActionListener(evt -> btnRegisterActionPerformed(evt));

        javax.swing.GroupLayout pnlRegisterLayout = new javax.swing.GroupLayout(pnlRegister);
        pnlRegister.setLayout(pnlRegisterLayout);
        pnlRegisterLayout.setHorizontalGroup(
            pnlRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegisterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlExtra, javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRegister, javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlRegisterLayout.createSequentialGroup()
                        .addGroup(pnlRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAnimalType)
                            .addComponent(lblId)
                            .addComponent(lblBreed)
                            .addComponent(lblBornOn)
                            .addComponent(lblWeight))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbAnimalType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtId)
                            .addComponent(txtBreed)
                            .addComponent(txtBornOn)
                            .addComponent(txtWeight))))
                .addContainerGap())
        );
        pnlRegisterLayout.setVerticalGroup(
            pnlRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegisterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAnimalType)
                    .addComponent(cmbAnimalType, javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBreed)
                    .addComponent(txtBreed, javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBornOn)
                    .addComponent(txtBornOn, javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblWeight)
                    .addComponent(txtWeight, javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlExtra, javax.swing.GroupLayout.PREFERRED_SIZE,
                    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRegister)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Register Animal", pnlRegister);

        pnlFilter.setBorder(javax.swing.BorderFactory.createTitledBorder("Filters and Actions"));
        lblFilter.setText("Filter by type:");
        btnFilter.setText("Filter");
        btnFilter.addActionListener(evt -> btnFilterActionPerformed(evt));
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(evt -> btnRefreshActionPerformed(evt));
        btnDelete.setText("Delete Selected");
        btnDelete.addActionListener(evt -> btnDeleteActionPerformed(evt));

        javax.swing.GroupLayout pnlFilterLayout = new javax.swing.GroupLayout(pnlFilter);
        pnlFilter.setLayout(pnlFilterLayout);
        pnlFilterLayout.setHorizontalGroup(
            pnlFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFilterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFilter)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 120,
                    javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFilter)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRefresh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlFilterLayout.setVerticalGroup(
            pnlFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFilterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFilter)
                    .addComponent(cmbFilter, javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFilter)
                    .addComponent(btnRefresh)
                    .addComponent(btnDelete))
                .addContainerGap())
        );

        tblAnimals.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{}, new String[]{}));
        scrTable.setViewportView(tblAnimals);

        javax.swing.GroupLayout pnlListLayout = new javax.swing.GroupLayout(pnlList);
        pnlList.setLayout(pnlListLayout);
        pnlListLayout.setHorizontalGroup(
            pnlListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlListLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlFilter, javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrTable))
                .addContainerGap())
        );
        pnlListLayout.setVerticalGroup(
            pnlListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlFilter, javax.swing.GroupLayout.PREFERRED_SIZE,
                    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrTable, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbedPane.addTab("List Animals", pnlList);

        pnlButtons.setBorder(javax.swing.BorderFactory.createTitledBorder("Business Operations"));
        btnMilk.setText("1. Calculate Total Milk Production");
        btnMilk.addActionListener(evt -> btnMilkActionPerformed(evt));
        btnEggs.setText("2. Calculate Total Eggs Per Week");
        btnEggs.addActionListener(evt -> btnEggsActionPerformed(evt));
        btnPigs.setText("3. View Pigs Ready for Slaughter");
        btnPigs.addActionListener(evt -> btnPigsActionPerformed(evt));
        btnSearch.setText("4. Search Animal by ID");
        btnSearch.addActionListener(evt -> btnSearchActionPerformed(evt));

        javax.swing.GroupLayout pnlButtonsLayout = new javax.swing.GroupLayout(pnlButtons);
        pnlButtons.setLayout(pnlButtonsLayout);
        pnlButtonsLayout.setHorizontalGroup(
            pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMilk, javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEggs, javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPigs, javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlButtonsLayout.setVerticalGroup(
            pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnMilk)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEggs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPigs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch)
                .addContainerGap())
        );

        txtBusinessResult.setColumns(20);
        txtBusinessResult.setRows(5);
        scrResult.setViewportView(txtBusinessResult);

        btnClear.setText("Clear Results");
        btnClear.addActionListener(evt -> btnClearActionPerformed(evt));

        javax.swing.GroupLayout pnlBusinessLayout = new javax.swing.GroupLayout(pnlBusiness);
        pnlBusiness.setLayout(pnlBusinessLayout);
        pnlBusinessLayout.setHorizontalGroup(
            pnlBusinessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBusinessLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBusinessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlButtons, javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrResult)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                        pnlBusinessLayout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(btnClear)))
                .addContainerGap())
        );
        pnlBusinessLayout.setVerticalGroup(
            pnlBusinessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBusinessLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlButtons, javax.swing.GroupLayout.PREFERRED_SIZE,
                    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrResult, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClear)
                .addContainerGap())
        );

        tabbedPane.addTab("Business Operations", pnlBusiness);

        btnStats.setText("Generate Statistics");
        btnStats.addActionListener(evt -> btnStatsActionPerformed(evt));

        txtStats.setColumns(20);
        txtStats.setRows(5);
        scrStats.setViewportView(txtStats);

        javax.swing.GroupLayout pnlStatsLayout = new javax.swing.GroupLayout(pnlStats);
        pnlStats.setLayout(pnlStatsLayout);
        pnlStatsLayout.setHorizontalGroup(
            pnlStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStatsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrStats)
                    .addGroup(pnlStatsLayout.createSequentialGroup()
                        .addComponent(btnStats)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlStatsLayout.setVerticalGroup(
            pnlStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStatsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnStats)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrStats, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbedPane.addTab("Statistics", pnlStats);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        registerAnimal();
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        filterAnimals();
    }//GEN-LAST:event_btnFilterActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        refreshAnimalList();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        deleteSelectedAnimal();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnMilkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMilkActionPerformed
        calculateMilkProduction();
    }//GEN-LAST:event_btnMilkActionPerformed

    private void btnEggsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEggsActionPerformed
        calculateEggProduction();
    }//GEN-LAST:event_btnEggsActionPerformed

    private void btnPigsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPigsActionPerformed
        showReadyPigs();
    }//GEN-LAST:event_btnPigsActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        searchAnimalById();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtBusinessResult.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnStatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStatsActionPerformed
        txtStats.setText(controller.getZooStatistics());
    }//GEN-LAST:event_btnStatsActionPerformed

    private void initBusinessLogic() {
        tableModel = new DefaultTableModel(
            new String[]{"ID", "Type", "Breed", "Born On", "Weight (kg)", "Age (months)", "Extra Info"}, 0
        ) {
            @Override
            public boolean isCellEditable(int r, int c) { return false; }
        };
        tblAnimals.setModel(tableModel);
        tblAnimals.setRowHeight(25);
        tblAnimals.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));

        cmbAnimalType.setModel(new DefaultComboBoxModel<>(new String[]{"Cow", "Chicken", "Pig", "Sheep"}));
        cmbAnimalType.addActionListener(e -> updateExtraFields());

        cmbFilter.setModel(new DefaultComboBoxModel<>(new String[]{"All", "Cow", "Chicken", "Pig", "Sheep"}));

        txtBusinessResult.setEditable(false);
        txtBusinessResult.setFont(new Font("Monospaced", Font.PLAIN, 12));
        txtBusinessResult.setBackground(new Color(245, 245, 245));

        txtStats.setEditable(false);
        txtStats.setFont(new Font("Monospaced", Font.PLAIN, 14));
        txtStats.setBackground(new Color(245, 245, 245));

        btnRegister.setBackground(new Color(46, 204, 113));
        btnRegister.setForeground(Color.WHITE);
        btnRegister.setFont(new Font("Arial", Font.BOLD, 14));

        updateExtraFields();
    }

    private void updateExtraFields() {
        String type = (String) cmbAnimalType.getSelectedItem();
        switch (type) {
            case "Cow":
                lblExtra1.setText("Produces Milk (true/false):");
                txtExtra1.setToolTipText("true or false");
                lblExtra2.setText("Milk Produced (liters):");
                txtExtra2.setToolTipText("Amount of milk produced");
                lblExtra2.setVisible(true);
                txtExtra2.setVisible(true);
                break;
            case "Chicken":
                lblExtra1.setText("Is Molting (true/false):");
                txtExtra1.setToolTipText("true or false");
                lblExtra2.setText("Eggs Per Week:");
                txtExtra2.setToolTipText("Number of eggs per week");
                lblExtra2.setVisible(true);
                txtExtra2.setVisible(true);
                break;
            case "Pig":
                lblExtra1.setText("Ideal Weight (kg):");
                txtExtra1.setToolTipText("Target weight for slaughter");
                lblExtra2.setText("Ready for Slaughter (true/false):");
                txtExtra2.setToolTipText("true or false");
                lblExtra2.setVisible(true);
                txtExtra2.setVisible(true);
                break;
            case "Sheep":
                lblExtra1.setText("Last Sheering Date (yyyy-MM-dd):");
                txtExtra1.setToolTipText("Format: yyyy-MM-dd");
                lblExtra2.setVisible(false);
                txtExtra2.setVisible(false);
                break;
        }
    }

    private void registerAnimal() {
        try {
            String type = (String) cmbAnimalType.getSelectedItem();
            if (txtId.getText().trim().isEmpty() || txtBreed.getText().trim().isEmpty() ||
                txtBornOn.getText().trim().isEmpty() || txtWeight.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "ID, Breed, Born On and Weight are required",
                    "Incomplete Fields", JOptionPane.WARNING_MESSAGE);
                return;
            }
            int id = Integer.parseInt(txtId.getText().trim());
            String breed = txtBreed.getText().trim();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date bornOn = sdf.parse(txtBornOn.getText().trim());
            float weight = Float.parseFloat(txtWeight.getText().trim());

            if (controller.getAnimalById(id) != null) {
                JOptionPane.showMessageDialog(this, "An animal with ID " + id + " already exists",
                    "Duplicate ID", JOptionPane.WARNING_MESSAGE);
                return;
            }

            FarmAnimal animal = null;
            String f1 = txtExtra1.getText().trim();
            String f2 = txtExtra2.getText().trim();

            switch (type) {
                case "Cow":
                    Cow cow = new Cow(id, breed, bornOn, weight, Boolean.parseBoolean(f1));
                    cow.milk();
                    animal = cow;
                    appendResult("=== COW REGISTERED ===\nID: " + id + " | Breed: " + breed +
                        "\nProduces milk: " + f1 + " | Milk: " + f2 + " L\n");
                    break;
                case "Chicken":
                    Chicken chicken = new Chicken(id, breed, bornOn, weight, Boolean.parseBoolean(f1));
                    chicken.setNumberOfEggsPerWeek(f2.isEmpty() ? 0 : Integer.parseInt(f2));
                    animal = chicken;
                    appendResult("=== CHICKEN REGISTERED ===\nID: " + id + " | Eggs/week: " + f2 + "\n");
                    break;
                case "Pig":
                    Pig pig = new Pig(id, breed, bornOn, weight, f1.isEmpty() ? 0 : Float.parseFloat(f1));
                    animal = pig;
                    appendResult("=== PIG REGISTERED ===\nID: " + id + " | Ideal weight: " + f1 + " kg\n");
                    break;
                case "Sheep":
                    Date lastSheering = f1.isEmpty() ? new Date() : sdf.parse(f1);
                    animal = new Sheep(id, breed, bornOn, weight, lastSheering);
                    appendResult("=== SHEEP REGISTERED ===\nID: " + id + " | Last sheering: " + f1 + "\n");
                    break;
            }

            if (animal != null && controller.registerAnimal(animal)) {
                JOptionPane.showMessageDialog(this,
                    "Animal registered!\nType: " + type + " | ID: " + id,
                    "Success", JOptionPane.INFORMATION_MESSAGE);
                clearFields();
                refreshAnimalList();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Enter valid numeric values",
                "Format Error", JOptionPane.ERROR_MESSAGE);
        } catch (java.text.ParseException e) {
            JOptionPane.showMessageDialog(this, "Date format: yyyy-MM-dd (e.g. 2026-01-15)",
                "Date Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void refreshAnimalList() {
        tableModel.setRowCount(0);
        List<FarmAnimal> animals = controller.getAllAnimals();
        for (FarmAnimal a : animals) addAnimalToTable(a);
        if (animals.isEmpty())
            tableModel.addRow(new Object[]{"--", "No animals", "--", "--", "--", "--", "Register a new animal"});
    }

    private void filterAnimals() {
        String sel = (String) cmbFilter.getSelectedItem();
        if ("All".equals(sel)) { refreshAnimalList(); return; }
        tableModel.setRowCount(0);
        List<FarmAnimal> animals = controller.getAnimalsByType(sel);
        for (FarmAnimal a : animals) addAnimalToTable(a);
        if (animals.isEmpty())
            tableModel.addRow(new Object[]{"--", "No " + sel + "s", "--", "--", "--", "--", "Register one"});
    }

    private void deleteSelectedAnimal() {
        int row = animalTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Select an animal to delete",
                "No Selection", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int id = (int) animalTable.getValueAt(row, 0);
        String type = (String) animalTable.getValueAt(row, 1);
        int confirm = JOptionPane.showConfirmDialog(this,
            "Delete animal?\nID: " + id + " | Type: " + type,
            "Confirm", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            if (controller.deleteAnimal(id)) {
                JOptionPane.showMessageDialog(this, "Deleted successfully", "Deleted", JOptionPane.INFORMATION_MESSAGE);
                refreshAnimalList();
            } else {
                JOptionPane.showMessageDialog(this, "Could not delete", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void addAnimalToTable(FarmAnimal animal) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String extra = "";
        if (animal instanceof Cow) {
            Cow c = (Cow) animal;
            extra = "Milk: " + (c.isProducingMilk() ? "Yes" : "No") + " | " +
                String.format("%.2f", c.getMilkProduced()) + "L";
        } else if (animal instanceof Chicken) {
            Chicken c = (Chicken) animal;
            extra = "Eggs/week: " + c.getNumberOfEggsPerWeek() + (c.isMolting() ? " (Molting)" : "");
        } else if (animal instanceof Pig) {
            Pig p = (Pig) animal;
            extra = "Ideal: " + p.getIdealWeight() + "kg" + (p.isReadyForSlaughter() ? " (Ready!)" : "");
        } else if (animal instanceof Sheep) {
            extra = "Last sheering: " + sdf.format(((Sheep) animal).getLastSheering());
        }
        tableModel.addRow(new Object[]{
            animal.getId(), animal.getClass().getSimpleName(), animal.getBreed(),
            sdf.format(animal.getBornOn()), String.format("%.1f", animal.getWeight()),
            animal.getAgeInMonths(), extra
        });
    }

    private void clearFields() {
        txtId.setText(""); txtBreed.setText(""); txtBornOn.setText("");
        txtWeight.setText(""); txtExtra1.setText(""); txtExtra2.setText("");
        txtId.requestFocus();
    }

    private void calculateMilkProduction() {
        float total = controller.calculateTotalMilkProduction();
        appendResult("=== TOTAL MILK PRODUCTION ===\n" +
            String.format("%.2f", total) + " liters\n");
    }

    private void calculateEggProduction() {
        appendResult("=== TOTAL EGG PRODUCTION ===\n" +
            controller.calculateTotalEggsPerWeek() + " eggs/week\n");
    }

    private void showReadyPigs() {
        List<Pig> pigs = controller.getPigsReadyForSlaughter();
        StringBuilder sb = new StringBuilder("=== PIGS READY FOR SLAUGHTER ===\n");
        if (pigs.isEmpty()) {
            sb.append("None ready.\n");
        } else {
            for (Pig p : pigs)
                sb.append("ID: ").append(p.getId()).append(" | ").append(p.getBreed())
                  .append(" | ").append(p.getWeight()).append("kg / ")
                  .append(p.getIdealWeight()).append("kg\n");
        }
        appendResult(sb.toString());
    }

    private void searchAnimalById() {
        String input = JOptionPane.showInputDialog(this, "Enter animal ID:", "Search", JOptionPane.QUESTION_MESSAGE);
        if (input != null && !input.trim().isEmpty()) {
            try {
                FarmAnimal a = controller.getAnimalById(Integer.parseInt(input.trim()));
                appendResult(a != null
                    ? "=== FOUND ===\n" + a.toString() + "\n"
                    : "=== NOT FOUND ===\nNo animal with ID: " + input.trim() + "\n");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void appendResult(String text) {
        txtBusinessResult.append(text + "---------------------------------------\n\n");
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> new FrmZooApplication().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JPanel pnlRegister;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblAnimalType;
    private javax.swing.JComboBox<String> cmbAnimalType;
    private javax.swing.JLabel lblId;
    private javax.swing.JTextField txtId;
    private javax.swing.JLabel lblBreed;
    private javax.swing.JTextField txtBreed;
    private javax.swing.JLabel lblBornOn;
    private javax.swing.JTextField txtBornOn;
    private javax.swing.JLabel lblWeight;
    private javax.swing.JTextField txtWeight;
    private javax.swing.JPanel pnlExtra;
    private javax.swing.JLabel lblExtra1;
    private javax.swing.JTextField txtExtra1;
    private javax.swing.JLabel lblExtra2;
    private javax.swing.JTextField txtExtra2;
    private javax.swing.JButton btnRegister;
    private javax.swing.JPanel pnlList;
    private javax.swing.JPanel pnlFilter;
    private javax.swing.JLabel lblFilter;
    private javax.swing.JComboBox<String> cmbFilter;
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnDelete;
    private javax.swing.JScrollPane scrTable;
    private javax.swing.JTable tblAnimals;
    private javax.swing.JTable animalTable;
    private javax.swing.JPanel pnlBusiness;
    private javax.swing.JPanel pnlButtons;
    private javax.swing.JButton btnMilk;
    private javax.swing.JButton btnEggs;
    private javax.swing.JButton btnPigs;
    private javax.swing.JButton btnSearch;
    private javax.swing.JScrollPane scrResult;
    private javax.swing.JTextArea txtBusinessResult;
    private javax.swing.JButton btnClear;
    private javax.swing.JPanel pnlStats;
    private javax.swing.JButton btnStats;
    private javax.swing.JScrollPane scrStats;
    private javax.swing.JTextArea txtStats;
    // End of variables declaration//GEN-END:variables
}