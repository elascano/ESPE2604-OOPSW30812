
package ec.edu.espe.safestore.view.panels;

import javax.swing.JOptionPane;

/**
 *
 * @author Alexander Tipantiza, The Softwarriors, @ESPE
 */
public class PnlUI extends javax.swing.JPanel {

    public PnlUI() {
        initComponents();
        outputArea.setText("UI Adaptive Ready\n");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbTheme = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbFontSize = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbLanguage = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        chkHighContrast = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        chkAnimations = new javax.swing.JCheckBox();
        btnApply = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnShortcuts = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        outputArea = new javax.swing.JTextArea();

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("UI Adaptive");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Interface Configuration"));

        jLabel2.setText("Theme:");
        jLabel3.setText("Font Size:");
        jLabel4.setText("Language:");
        jLabel5.setText("High Contrast:");
        jLabel6.setText("Animations:");

        cbTheme.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Light", "Dark", "System Default" }));
        cbFontSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Small (10px)", "Medium (12px)", "Large (14px)", "Extra Large (16px)" }));
        cbLanguage.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "English", "Spanish", "Portuguese" }));
        chkAnimations.setSelected(true);

        btnApply.setText("Apply Changes");
        btnApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApplyActionPerformed(evt);
            }
        });

        btnReset.setText("Reset to Default");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnShortcuts.setText("Keyboard Shortcuts");
        btnShortcuts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShortcutsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbTheme, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbFontSize, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkHighContrast)
                    .addComponent(chkAnimations))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnApply)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReset)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnShortcuts)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbTheme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbFontSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(chkHighContrast))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(chkAnimations))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnApply)
                    .addComponent(btnReset)
                    .addComponent(btnShortcuts))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        outputArea.setColumns(20);
        outputArea.setRows(5);
        jScrollPane1.setViewportView(outputArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApplyActionPerformed
        outputArea.append("\n=== APPLYING CHANGES ===\n");
        outputArea.append("  Theme: " + cbTheme.getSelectedItem() + "\n");
        outputArea.append("  Font Size: " + cbFontSize.getSelectedItem() + "\n");
        outputArea.append("  Language: " + cbLanguage.getSelectedItem() + "\n");
        outputArea.append("  High Contrast: " + (chkHighContrast.isSelected() ? "ON" : "OFF") + "\n");
        outputArea.append("  Animations: " + (chkAnimations.isSelected() ? "ON" : "OFF") + "\n");
        outputArea.append("Changes applied successfully\n\n");
        JOptionPane.showMessageDialog(this, "UI changes applied!");
    }//GEN-LAST:event_btnApplyActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        cbTheme.setSelectedIndex(0);
        cbFontSize.setSelectedIndex(1);
        cbLanguage.setSelectedIndex(0);
        chkHighContrast.setSelected(false);
        chkAnimations.setSelected(true);
        outputArea.append("\n=== RESET TO DEFAULT ===\n");
        outputArea.append("All settings restored to default\n\n");
        JOptionPane.showMessageDialog(this, "Settings reset to default!");
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnShortcutsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShortcutsActionPerformed
        String message = "KEYBOARD SHORTCUTS\n\n"
                + "Navigation:\n"
                + "  Ctrl+1-9 - Quick access to modules\n"
                + "  F1 - Help\n"
                + "  F5 - Refresh\n\n"
                + "Actions:\n"
                + "  Ctrl+N - New backup\n"
                + "  Ctrl+S - Save data\n"
                + "  Ctrl+E - Export data\n"
                + "  Ctrl+A - Add product\n"
                + "  Ctrl+F - Search\n\n"
                + "General:\n"
                + "  Alt+F4 - Exit\n"
                + "  F11 - Full screen";
        JOptionPane.showMessageDialog(this, message, "Keyboard Shortcuts", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnShortcutsActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApply;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnShortcuts;
    private javax.swing.JComboBox<String> cbFontSize;
    private javax.swing.JComboBox<String> cbLanguage;
    private javax.swing.JComboBox<String> cbTheme;
    private javax.swing.JCheckBox chkAnimations;
    private javax.swing.JCheckBox chkHighContrast;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea outputArea;
    // End of variables declaration//GEN-END:variables
}