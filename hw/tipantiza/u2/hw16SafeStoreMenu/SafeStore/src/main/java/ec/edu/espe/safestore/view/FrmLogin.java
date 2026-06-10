
package ec.edu.espe.safestore.view;

import ec.edu.espe.safestore.controller.AuthController;

/**
 *
 * @author Alexander Tipantiza, The Softwarriors, @ESPE
 */
public class FrmLogin extends javax.swing.JFrame {

    private AuthController authController;

    public FrmLogin() {
        authController = new AuthController();
        initComponents();
        setTitle("SafeStore - Login");
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titlePanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        subTitleLabel = new javax.swing.JLabel();
        formPanel = new javax.swing.JPanel();
        lblUser = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblPass = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        lblRole = new javax.swing.JLabel();
        cbRole = new javax.swing.JComboBox<>();
        btnLogin = new javax.swing.JButton();
        lblStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        titlePanel.setBackground(java.awt.Color.WHITE);
        titlePanel.setPreferredSize(new java.awt.Dimension(450, 80));

        titleLabel.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        titleLabel.setForeground(java.awt.Color.BLACK);
        titleLabel.setText("SAFESTORE SYSTEM");

        subTitleLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        subTitleLabel.setForeground(java.awt.Color.BLACK);
        subTitleLabel.setText("The Softwarriors");

        javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subTitleLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        titlePanelLayout.setVerticalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleLabel)
                    .addComponent(subTitleLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        formPanel.setBackground(java.awt.Color.WHITE);
        formPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 30, 30, 30));

        lblUser.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblUser.setForeground(java.awt.Color.BLACK);
        lblUser.setText("Username:");

        txtUsername.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtUsername.setPreferredSize(new java.awt.Dimension(200, 30));

        lblPass.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblPass.setForeground(java.awt.Color.BLACK);
        lblPass.setText("Password:");

        txtPassword.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtPassword.setPreferredSize(new java.awt.Dimension(200, 30));

        lblRole.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblRole.setForeground(java.awt.Color.BLACK);
        lblRole.setText("User Role:");

        cbRole.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manager", "Cashier" }));
        cbRole.setPreferredSize(new java.awt.Dimension(200, 30));

        btnLogin.setBackground(java.awt.Color.WHITE);
        btnLogin.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnLogin.setForeground(java.awt.Color.BLACK);
        btnLogin.setText("Login");
        btnLogin.setPreferredSize(new java.awt.Dimension(150, 40));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        lblStatus.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        lblStatus.setForeground(new java.awt.Color(255, 0, 0));
        lblStatus.setText(" ");

        javax.swing.GroupLayout formPanelLayout = new javax.swing.GroupLayout(formPanel);
        formPanel.setLayout(formPanelLayout);
        formPanelLayout.setHorizontalGroup(
            formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUser)
                    .addComponent(lblPass)
                    .addComponent(lblRole))
                .addGap(18, 18, 18)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.CENTER, formPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStatus))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        formPanelLayout.setVerticalGroup(
            formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUser)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPass)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRole)
                    .addComponent(cbRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblStatus)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(titlePanel, java.awt.BorderLayout.NORTH);
        getContentPane().add(formPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        String username = txtUsername.getText().trim();
        String password = new String(txtPassword.getPassword());
        String role = (String) cbRole.getSelectedItem();

        if (username.isEmpty() || password.isEmpty()) {
            lblStatus.setText("Please fill all fields");
            return;
        }

        if (authController.authenticate(username, password, role)) {
            lblStatus.setText("");
            dispose();
            new FrmMain(role).setVisible(true);
        } else {
            lblStatus.setText("Invalid username or password");
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JComboBox<String> cbRole;
    private javax.swing.JPanel formPanel;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblRole;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel subTitleLabel;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}