/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ec.edu.espe.farm.view;

import ec.edu.espe.farm.controller.FarmAnimalController;
import ec.edu.espe.farm.model.Chicken;
import ec.edu.espe.farm.model.Cow;
import ec.edu.espe.farm.model.FarmAnimal;
import ec.edu.espe.farm.model.Health;
import ec.edu.espe.farm.model.Pig;
import ec.edu.espe.farm.model.Sheep;
import ec.edu.espe.farm.model.Cut;
import ec.edu.espe.farm.contracts.IMeatAnimal;
import com.mongodb.client.MongoCollection;
import utils.MongoConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;

/**
 *
 * @author Brandon Collahuazo
 */
public class FrmAnimalManagement extends javax.swing.JFrame {

    private FarmAnimalController controller = new FarmAnimalController();
    private List<FarmAnimal> animalsList = new ArrayList<>();
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmAnimalManagement.class.getName());

    /**
     * Creates new form FrmFinancialManagement
     */
    public FrmAnimalManagement() {
        initComponents();
        refreshTableData();
        this.setLocationRelativeTo(null);
    }

   private void refreshTableData() {
        animalsList.clear();
        try {
            MongoCollection<Document> collection = MongoConnection.getDatabase().getCollection("farm_animals");
            
            for (Document doc : collection.find()) {
                try {
                    int id = (doc.get("id") instanceof Integer) ? doc.getInteger("id") : Integer.parseInt(doc.get("id").toString());
                    String type = doc.getString("type");
                    String breed = doc.getString("breed");
                    double weightVal = (doc.get("weight") != null) ? ((Number) doc.get("weight")).doubleValue() : 0.0;
                    
                    Date bornOnDate = null;
                    String bornOnStr = doc.getString("bornOn");
                    if (bornOnStr != null && !bornOnStr.isEmpty()) {
                        bornOnDate = dateFormat.parse(bornOnStr);
                    }

                    boolean hasAllVaccines = false;
                    Date lastCheckupDate = new Date(); 

                    String healthStr = doc.getString("health");
                    if (healthStr != null) {
                        
                        hasAllVaccines = healthStr.contains("Vaccines: True");
                        
                        if (healthStr.contains(" | Checkup: ")) {
                            String[] parts = healthStr.split(" \\| Checkup: ");
                            if (parts.length > 1) {
                                lastCheckupDate = dateFormat.parse(parts[1].trim());
                            }
                        }
                    }

                    Health health = new Health(hasAllVaccines, lastCheckupDate); 

                    FarmAnimal animal = null;
                    switch (type) {
                        case "Pig" -> animal = new Pig(id, breed, bornOnDate, (float) weightVal, health, 100.0f);
                        case "Cow" -> animal = new Cow(id, breed, bornOnDate, (float) weightVal, health, true, 10.0f);
                        case "Chicken" -> animal = new Chicken(id, breed, bornOnDate, (float) weightVal, health, false, 5);
                        case "Sheep" -> animal = new Sheep(id, breed, bornOnDate, (float) weightVal, health, new Date());
                    }

                    if (animal != null) {
                        animalsList.add(animal);
                    }
                } catch (Exception e) {
                    System.err.println("Error procesando documento individual: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.err.println("Error de conexión a la base de datos: " + e.getMessage());
        }
        updateTableUI();
    }
    private void updateTableUI() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        
        Date today = new Date();
        
        for (FarmAnimal animal : animalsList) {
            String bornOnStr = (animal.getBornOn() != null) ? dateFormat.format(animal.getBornOn()) : "N/A";
            
            String lastCheckupStr = "N/A";
            String statusStr = "Not Fit";

            if (animal.getHealth() != null) {
                Date checkupDate = animal.getHealth().getLastCheckup();
                if (checkupDate != null) {
                    lastCheckupStr = dateFormat.format(checkupDate);
                    
                   
                    Calendar limitCalendar = Calendar.getInstance();
                    limitCalendar.setTime(today);
                    limitCalendar.add(Calendar.MONTH, -2); 
                    Date completeTwoMonthsAgo = limitCalendar.getTime();

                
                    if (animal.getHealth().isFitForProduction() && !checkupDate.before(completeTwoMonthsAgo)) {
                        statusStr = "Fit";
                    }
                }
            }

            model.addRow(new Object[]{
                animal.getId(), 
                animal.getClass().getSimpleName(), 
                animal.getBreed(), 
                bornOnStr, 
                animal.getWeight(), 
                lastCheckupStr, 
                statusStr
            });
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnMenu = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtAnimalId = new javax.swing.JTextField();
        txtBreed = new javax.swing.JTextField();
        spnWeight = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        chkHasVaccines = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        btnAddAnimal = new javax.swing.JButton();
        btnRegisterCut = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        dcLastCheckup = new com.toedter.calendar.JDateChooser();
        dcBornOn = new com.toedter.calendar.JDateChooser();
        cmbAnimalType = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnMenu.setText("Menu");
        btnMenu.addActionListener(this::btnMenuActionPerformed);

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel1.setText("Animal Registration");

        jLabel2.setText("ID:");

        jLabel3.setText("Breed:");

        jLabel4.setText("Born On:");

        jLabel5.setText("Weight (kg):");

        spnWeight.setModel(new javax.swing.SpinnerNumberModel(10.0d, 10.0d, 1000.0d, 1.0d));

        jLabel6.setText("Data Animal:");

        jLabel7.setText("Health Information:");

        chkHasVaccines.setText("Has All Vaccines?");

        jLabel8.setText("Last Checkup:");

        btnAddAnimal.setText("Add Animal");
        btnAddAnimal.addActionListener(this::btnAddAnimalActionPerformed);

        btnRegisterCut.setText("Register Cut");
        btnRegisterCut.addActionListener(this::btnRegisterCutActionPerformed);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Type", "Breed", "Born On", "Weight (kg)", "Last Checkup", "Health Status"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        cmbAnimalType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pig", "Cow", "Chicken", "Sheep" }));
        cmbAnimalType.addActionListener(this::cmbAnimalTypeActionPerformed);

        jLabel9.setText("Type:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel6))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnAddAnimal)
                                    .addGap(57, 57, 57)
                                    .addComponent(btnRegisterCut)
                                    .addGap(48, 48, 48)
                                    .addComponent(btnMenu))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(dcBornOn, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtBreed, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(txtAnimalId, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(spnWeight, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                                .addComponent(cmbAnimalType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGap(68, 68, 68)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(6, 6, 6)
                                                    .addComponent(dcLastCheckup, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(chkHasVaccines)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(chkHasVaccines)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dcLastCheckup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtAnimalId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtBreed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbAnimalType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(spnWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dcBornOn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddAnimal)
                    .addComponent(btnRegisterCut)
                    .addComponent(btnMenu))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        FrmMain main = new FrmMain();
        main.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMenuActionPerformed

    private void cmbAnimalTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAnimalTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbAnimalTypeActionPerformed

    private void btnAddAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAnimalActionPerformed
        try {
            int id = Integer.parseInt(txtAnimalId.getText());
            String type = cmbAnimalType.getSelectedItem().toString();
            String breed = txtBreed.getText();
            double weight = (double) spnWeight.getValue();

            String bornOnStr = (dcBornOn.getDate() != null) ? dateFormat.format(dcBornOn.getDate()) : dateFormat.format(new Date());
            
            String lastCheckupStr = (dcLastCheckup.getDate() != null) ? dateFormat.format(dcLastCheckup.getDate()) : dateFormat.format(new Date());
            String healthStatus = "Vaccines: " + (chkHasVaccines.isSelected() ? "True" : "False") + " | Checkup: " + lastCheckupStr;

            controller.saveAnimal(type, String.valueOf(id), breed, bornOnStr, weight, healthStatus);

            refreshTableData();
            javax.swing.JOptionPane.showMessageDialog(this, "Animal successfully saved");
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error saving: " + e.getMessage());
        }
           
    }//GEN-LAST:event_btnAddAnimalActionPerformed

    private void btnRegisterCutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterCutActionPerformed
       int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please select an animal from the table");
            return;
        }

        String currentStatus = jTable1.getValueAt(selectedRow, 6).toString();
        int id = (int) jTable1.getValueAt(selectedRow, 0);

        if ("Fit".equals(currentStatus)) {
            FrmAddCut addCut = new FrmAddCut(id, this);
            addCut.setVisible(true);
            this.setVisible(false);
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "The animal does not meet the health status required for slaughter");
        }
    }//GEN-LAST:event_btnRegisterCutActionPerformed
    

    private FarmAnimal getSelectedAnimal() {
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) {
            int id = (int) jTable1.getValueAt(selectedRow, 0);
            for (FarmAnimal animal : animalsList) {
                if (animal.getId() == id) {
                    return animal;
                }
            }
        }
        return null;
    }

    /**
     * @param args the command line arguments
     */
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

        java.awt.EventQueue.invokeLater(() -> new FrmAnimalManagement().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddAnimal;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnRegisterCut;
    private javax.swing.JCheckBox chkHasVaccines;
    private javax.swing.JComboBox<String> cmbAnimalType;
    private com.toedter.calendar.JDateChooser dcBornOn;
    private com.toedter.calendar.JDateChooser dcLastCheckup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JSpinner spnWeight;
    private javax.swing.JTextField txtAnimalId;
    private javax.swing.JTextField txtBreed;
    // End of variables declaration//GEN-END:variables
}
