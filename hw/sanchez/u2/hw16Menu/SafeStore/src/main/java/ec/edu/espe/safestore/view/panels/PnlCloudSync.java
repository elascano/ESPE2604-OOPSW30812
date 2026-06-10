package ec.edu.espe.safestore.view.panels;

import ec.edu.espe.safestore.controller.CloudSyncController;
import javax.swing.JOptionPane;

/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */
public class PnlCloudSync extends javax.swing.JPanel {

    private CloudSyncController cloudSyncController;

    public PnlCloudSync() {
        cloudSyncController = new CloudSyncController();
        initComponents();
        outputArea.setText("Press 'Connect' to start\n");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblStatus = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnConnect = new javax.swing.JButton();
        btnDisconnect = new javax.swing.JButton();
        btnUpload = new javax.swing.JButton();
        btnDownload = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        outputArea = new javax.swing.JTextArea();

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cloud Synchronization");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Connection Status"));
        jPanel1.setLayout(new java.awt.GridLayout(3, 1, 10, 10));

        lblStatus.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblStatus.setText("Status: Disconnected");
        jPanel1.add(lblStatus);

        jLabel3.setText("Database: safestore (MongoDB Atlas)");
        jPanel1.add(jLabel3);

        jLabel4.setText("Cluster: cluster0.aex8od4.mongodb.net");
        jPanel1.add(jLabel4);

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 50, 30, 50));
        jPanel2.setLayout(new java.awt.GridLayout(2, 2, 15, 15));

        btnConnect.setText("Connect");
        btnConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnectActionPerformed(evt);
            }
        });
        jPanel2.add(btnConnect);

        btnDisconnect.setText("Disconnect");
        btnDisconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisconnectActionPerformed(evt);
            }
        });
        jPanel2.add(btnDisconnect);

        btnUpload.setText("Upload to Cloud");
        btnUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadActionPerformed(evt);
            }
        });
        jPanel2.add(btnUpload);

        btnDownload.setText("Download from Cloud");
        btnDownload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDownloadActionPerformed(evt);
            }
        });
        jPanel2.add(btnDownload);

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
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void updateStatus() {
        if (cloudSyncController.isConnected()) {          // ← FIX 1
            lblStatus.setText("Status: Connected");
            lblStatus.setForeground(new java.awt.Color(0, 150, 0));
        } else {
            lblStatus.setText("Status: Disconnected");
            lblStatus.setForeground(java.awt.Color.RED);
        }
    }

    private void btnConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnectActionPerformed
        if (cloudSyncController.connect()) {
            updateStatus();
            outputArea.append("Connected to MongoDB Atlas\n");
            JOptionPane.showMessageDialog(this, "Connected!");
        } else {
            outputArea.append("Connection error\n");
            JOptionPane.showMessageDialog(this, "Connection error");
        }
    }//GEN-LAST:event_btnConnectActionPerformed

    private void btnDisconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisconnectActionPerformed
        cloudSyncController.disconnect();
        updateStatus();
        outputArea.append("Disconnected\n");
        JOptionPane.showMessageDialog(this, "Disconnected");
    }//GEN-LAST:event_btnDisconnectActionPerformed

    private void btnUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadActionPerformed
        if (!cloudSyncController.isConnected()) {         // ← FIX 2
            JOptionPane.showMessageDialog(this, "Connect first");
            return;
        }
        outputArea.append("Uploading data...\n");
        cloudSyncController.uploadAll();
        outputArea.append("Upload completed\n");
        JOptionPane.showMessageDialog(this, "Data uploaded!");
    }//GEN-LAST:event_btnUploadActionPerformed

    private void btnDownloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDownloadActionPerformed
        if (!cloudSyncController.isConnected()) {         // ← FIX 3
            JOptionPane.showMessageDialog(this, "Connect first");
            return;
        }
        outputArea.append("Downloading data...\n");
        cloudSyncController.downloadAll();
        outputArea.append("Download completed\n");

        java.awt.Component parent = getParent();
        if (parent instanceof javax.swing.JPanel) {
            for (java.awt.Component comp : ((javax.swing.JPanel) parent).getComponents()) {
                if (comp instanceof PnlProduct) {
                    ((PnlProduct) comp).loadProductTable();
                }
            }
        }

        JOptionPane.showMessageDialog(this, "Data downloaded!");
    }//GEN-LAST:event_btnDownloadActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConnect;
    private javax.swing.JButton btnDisconnect;
    private javax.swing.JButton btnDownload;
    private javax.swing.JButton btnUpload;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JTextArea outputArea;
    // End of variables declaration//GEN-END:variables
}