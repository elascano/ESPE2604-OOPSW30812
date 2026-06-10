
package ec.edu.espe.safestore.view.panels;

import javax.swing.JOptionPane;

/**
 *
 * @author Alexander Tipantiza, The Softwarriors, @ESPE
 */
public class PnlBackup extends javax.swing.JPanel {

    public PnlBackup() {
        initComponents();
        outputArea.setText("Backup System Ready\n");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtBackupName = new javax.swing.JTextField();
        btnCreate = new javax.swing.JButton();
        btnRestore = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpload = new javax.swing.JButton();
        btnDownload = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        outputArea = new javax.swing.JTextArea();

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Backup System");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Create Backup"));

        jLabel2.setText("Backup Name:");

        txtBackupName.setColumns(20);

        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBackupName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCreate)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBackupName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCreate))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnRestore.setText("Restore");
        btnRestore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestoreActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpload.setText("Upload Cloud");
        btnUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadActionPerformed(evt);
            }
        });

        btnDownload.setText("Download Cloud");
        btnDownload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDownloadActionPerformed(evt);
            }
        });

        btnView.setText("View Backups");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

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
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRestore)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpload)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDownload)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnView)
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRestore)
                    .addComponent(btnDelete)
                    .addComponent(btnUpload)
                    .addComponent(btnDownload)
                    .addComponent(btnView))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addContainerGap())
        );
    }//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        String name = txtBackupName.getText().trim();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter a backup name");
            return;
        }
        outputArea.append("Backup created: " + name + "\n");
        JOptionPane.showMessageDialog(this, "Backup created!");
        txtBackupName.setText("");
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnRestoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestoreActionPerformed
        outputArea.append("Backup restored\n");
        JOptionPane.showMessageDialog(this, "Backup restored!");
    }//GEN-LAST:event_btnRestoreActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        outputArea.append("Backup deleted\n");
        JOptionPane.showMessageDialog(this, "Backup deleted!");
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadActionPerformed
        outputArea.append("Uploading to cloud...\n");
        JOptionPane.showMessageDialog(this, "Backup uploaded to cloud!");
    }//GEN-LAST:event_btnUploadActionPerformed

    private void btnDownloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDownloadActionPerformed
        outputArea.append("Downloading from cloud...\n");
        JOptionPane.showMessageDialog(this, "Backup downloaded from cloud!");
    }//GEN-LAST:event_btnDownloadActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        outputArea.append("Backup list displayed\n");
        JOptionPane.showMessageDialog(this, "Check console for backup list");
    }//GEN-LAST:event_btnViewActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDownload;
    private javax.swing.JButton btnRestore;
    private javax.swing.JButton btnUpload;
    private javax.swing.JButton btnView;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea outputArea;
    private javax.swing.JTextField txtBackupName;
    // End of variables declaration//GEN-END:variables
}