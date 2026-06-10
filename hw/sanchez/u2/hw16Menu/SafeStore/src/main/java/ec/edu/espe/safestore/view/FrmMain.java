package ec.edu.espe.safestore.view;

import ec.edu.espe.safestore.view.panels.*;

public class FrmMain extends javax.swing.JFrame {

    private String userRole;
    private java.awt.CardLayout cardLayout;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JLabel lblUser;

    public FrmMain(String role) {
        this.userRole = role;
        initComponents();
        setTitle("SafeStore System - " + role);
        setLocationRelativeTo(null);
        setupComponents();
    }

    private void setupComponents() {
        getContentPane().removeAll();
        setLayout(new java.awt.BorderLayout());

        createMenuBar();

        cardLayout = new java.awt.CardLayout();
        contentPanel = new javax.swing.JPanel(cardLayout);
        contentPanel.setBackground(new java.awt.Color(240, 240, 240));

        contentPanel.add(createWelcomePanel(), "welcome");
        contentPanel.add(new PnlBackup(),      "backup");
        contentPanel.add(new PnlCash(),        "cash");
        contentPanel.add(new PnlCombo(),       "combo");
        contentPanel.add(new PnlCredit(),      "credit");
        contentPanel.add(new PnlExpiration(),  "expiration");
        contentPanel.add(new PnlReport(),      "report");
        contentPanel.add(new PnlStock(),       "stock");
        contentPanel.add(new PnlUI(),          "ui");
        contentPanel.add(new PnlProduct(),     "product");
        contentPanel.add(new PnlSale(),        "sale");
        contentPanel.add(new PnlSupplier(),    "supplier");
        contentPanel.add(new PnlReservation(), "reservation");
        contentPanel.add(new PnlCloudSync(),   "cloud");

        getContentPane().add(contentPanel, java.awt.BorderLayout.CENTER);

        javax.swing.JPanel statusBar = createStatusBar();
        getContentPane().add(statusBar, java.awt.BorderLayout.SOUTH);

        cardLayout.show(contentPanel, "welcome");

        revalidate();
        repaint();
    }

    private void createMenuBar() {
        javax.swing.JMenuBar menuBar = new javax.swing.JMenuBar();

        // ── Modules menu ──────────────────────────────────────────
        javax.swing.JMenu modulesMenu = new javax.swing.JMenu("Modules");

        String[][] items = {
            {"Backup System",       "backup"},
            {"Cash Control",        "cash"},
            {"Combos",              "combo"},
            {"Credit Management",   "credit"},
            {"Expiration Control",  "expiration"},
            {"Slow Moving Report",  "report"},
            {"Stock Alerts",        "stock"},
            {"Adaptive UI",         "ui"},
            {"Product Management",  "product"},
            {"Sales System",        "sale"},
            {"Supplier Management", "supplier"},
            {"Reservations",        "reservation"},
            {"Cloud Sync",          "cloud"}
        };

        for (String[] item : items) {
            javax.swing.JMenuItem mi = new javax.swing.JMenuItem(item[0]);
            final String panel = item[1];
            mi.addActionListener(e -> cardLayout.show(contentPanel, panel));
            modulesMenu.add(mi);
        }

        // ── Tools menu ────────────────────────────────────────────
        javax.swing.JMenu toolsMenu = new javax.swing.JMenu("Tools");
        javax.swing.JMenuItem shortcutsItem = new javax.swing.JMenuItem("Keyboard Shortcuts");
        shortcutsItem.addActionListener(e -> showShortcuts());
        toolsMenu.add(shortcutsItem);

        // ── Help menu ─────────────────────────────────────────────
        javax.swing.JMenu helpMenu = new javax.swing.JMenu("Help");
        javax.swing.JMenuItem aboutItem = new javax.swing.JMenuItem("About");
        aboutItem.addActionListener(e -> showAboutDialog());
        helpMenu.add(aboutItem);

        // ── File menu ─────────────────────────────────────────────
        javax.swing.JMenu fileMenu = new javax.swing.JMenu("File");
        javax.swing.JMenuItem exitItem = new javax.swing.JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);
        menuBar.add(modulesMenu);
        menuBar.add(toolsMenu);
        menuBar.add(helpMenu);

        setJMenuBar(menuBar);
    }

    private void showShortcuts() {
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
        javax.swing.JOptionPane.showMessageDialog(this, message,
                "Keyboard Shortcuts", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }

    private javax.swing.JPanel createStatusBar() {
        javax.swing.JPanel panel = new javax.swing.JPanel(
                new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        panel.setBackground(new java.awt.Color(220, 220, 220));
        panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));

        lblUser = new javax.swing.JLabel(
                "User: " + userRole + " | SafeStore System | The Softwarriors");
        lblUser.setFont(new java.awt.Font("Arial", 0, 12));
        panel.add(lblUser);
        return panel;
    }

    private javax.swing.JPanel createWelcomePanel() {
        javax.swing.JPanel panel = new javax.swing.JPanel(new java.awt.BorderLayout());
        panel.setBackground(new java.awt.Color(240, 240, 240));

        javax.swing.JLabel title = new javax.swing.JLabel(
                "WELCOME TO SAFESTORE", javax.swing.SwingConstants.CENTER);
        title.setFont(new java.awt.Font("Arial", 1, 28));
        title.setForeground(new java.awt.Color(45, 45, 45));
        title.setBorder(javax.swing.BorderFactory.createEmptyBorder(80, 0, 30, 0));

        javax.swing.JLabel subtitle = new javax.swing.JLabel(
                "Disposable Products Minimarket Management System",
                javax.swing.SwingConstants.CENTER);
        subtitle.setFont(new java.awt.Font("Arial", 0, 16));
        subtitle.setForeground(new java.awt.Color(100, 100, 100));

        javax.swing.JLabel userInfo = new javax.swing.JLabel(
                "Logged in as: " + userRole, javax.swing.SwingConstants.CENTER);
        userInfo.setFont(new java.awt.Font("Arial", 1, 14));
        userInfo.setForeground(new java.awt.Color(52, 152, 219));
        userInfo.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 0, 0, 0));

        javax.swing.JLabel version = new javax.swing.JLabel(
                "Version 2.0 | The Softwarriors", javax.swing.SwingConstants.CENTER);
        version.setFont(new java.awt.Font("Arial", 2, 12));
        version.setForeground(new java.awt.Color(150, 150, 150));
        version.setBorder(javax.swing.BorderFactory.createEmptyBorder(200, 0, 20, 0));

        javax.swing.JPanel centerPanel = new javax.swing.JPanel(new java.awt.GridLayout(4, 1));
        centerPanel.setOpaque(false);
        centerPanel.add(title);
        centerPanel.add(subtitle);
        centerPanel.add(userInfo);
        centerPanel.add(version);

        panel.add(centerPanel, java.awt.BorderLayout.CENTER);
        return panel;
    }

    private void showAboutDialog() {
        String message = "SafeStore System\n\n"
                + "Version: 2.0\n\n"
                + "Developed by: THE SOFTWARRIORS\n\n"
                + "Members:\n"
                + "  - Joel Sanchez\n"
                + "  - Ronald Tipan\n"
                + "  - Adrian Vizcaino\n"
                + "  - Lenin Tipantiza\n\n"
                + "Instructor: Ing. Jorge Edison Lascano, PhD\n"
                + "NRC: 30812\n\n"
                + "Sangolqui - Ecuador 2024";
        javax.swing.JOptionPane.showMessageDialog(this, message,
                "About SafeStore", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(1200, 750);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1200, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );
        pack();
    }// </editor-fold>

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info :
                    javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new FrmLogin().setVisible(true));
    }

    // Variables declaration - do not modify
    
    // End of variables declaration
}