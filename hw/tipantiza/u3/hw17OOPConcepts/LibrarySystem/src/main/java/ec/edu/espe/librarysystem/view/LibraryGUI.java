
package ec.edu.espe.librarysystem.view;
import ec.edu.espe.librarysystem.controller.LibraryController;
import ec.edu.espe.librarysystem.model.Book;
import ec.edu.espe.librarysystem.model.Loan;
import ec.edu.espe.librarysystem.model.User;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.UUID;

/**
 *
 * @author Alexander Tipantiza, The Softwarrios, @ESPE
 */

public class LibraryGUI extends JFrame {
    private final LibraryController controller;
    private DefaultTableModel bookTableModel;
    private DefaultTableModel userTableModel;
    private DefaultTableModel loanTableModel;
    private JTable bookTable;
    private JTable userTable;
    private JTable loanTable;

    public LibraryGUI() {
        this.controller = new LibraryController();
        initializeComponents();
        loadData();
        setVisible(true);
    }

    private void initializeComponents() {
        setTitle("Library Management System - ESPE");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        createMenuBar();
        
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Books", createBooksPanel());
        tabbedPane.addTab("Users", createUsersPanel());
        tabbedPane.addTab("Loans", createLoansPanel());
        tabbedPane.addTab("Statistics", createStatisticsPanel());

        add(tabbedPane, BorderLayout.CENTER);
    }

    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(this, 
                "Are you sure you want to exit?", 
                "Confirm Exit", 
                JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
        fileMenu.add(exitItem);
        
        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.addActionListener(e -> showAboutDialog());
        helpMenu.add(aboutItem);
        
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);
    }

    private JPanel createBooksPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        String[] columns = {"ID", "Title", "Author", "ISBN", "Year", "Available", "Category"};
        bookTableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        bookTable = new JTable(bookTableModel);
        bookTable.setFont(new Font("Arial", Font.PLAIN, 12));
        bookTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        bookTable.setRowHeight(25);
        
        JScrollPane scrollPane = new JScrollPane(bookTable);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Book Catalog"));
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.setBackground(new Color(240, 240, 240));
        
        JButton addButton = createButton("Add Book", new Color(46, 204, 113));
        addButton.addActionListener(e -> showAddBookDialog());
        
        JButton deleteButton = createButton("Delete", new Color(231, 76, 60));
        deleteButton.addActionListener(e -> deleteBook());
        
        JButton refreshButton = createButton("Refresh", new Color(52, 152, 219));
        refreshButton.addActionListener(e -> loadBooks());

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(refreshButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createUsersPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        String[] columns = {"ID", "First Name", "Last Name", "Email", "Type", "Active Loans"};
        userTableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        userTable = new JTable(userTableModel);
        userTable.setFont(new Font("Arial", Font.PLAIN, 12));
        userTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        userTable.setRowHeight(25);
        
        JScrollPane scrollPane = new JScrollPane(userTable);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Registered Users"));
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.setBackground(new Color(240, 240, 240));
        
        JButton addButton = createButton("Add User", new Color(46, 204, 113));
        addButton.addActionListener(e -> showAddUserDialog());
        
        JButton deleteButton = createButton("Delete", new Color(231, 76, 60));
        deleteButton.addActionListener(e -> deleteUser());
        
        JButton refreshButton = createButton("Refresh", new Color(52, 152, 219));
        refreshButton.addActionListener(e -> loadUsers());

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(refreshButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createLoansPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        String[] columns = {"ID", "User ID", "Book ID", "Loan Date", "Status", "Fine"};
        loanTableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        loanTable = new JTable(loanTableModel);
        loanTable.setFont(new Font("Arial", Font.PLAIN, 12));
        loanTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        loanTable.setRowHeight(25);
        
        JScrollPane scrollPane = new JScrollPane(loanTable);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Loan History"));
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel operationPanel = createLoanOperationsPanel();
        panel.add(operationPanel, BorderLayout.NORTH);

        return panel;
    }

    private JPanel createLoanOperationsPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Loan Operations"));
        panel.setBackground(new Color(248, 249, 250));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel userIdLabel = new JLabel("User ID:");
        JTextField userIdField = new JTextField(15);
        JLabel bookIdLabel = new JLabel("Book ID:");
        JTextField bookIdField = new JTextField(15);
        
        JButton createLoanButton = createButton("Create Loan", new Color(46, 204, 113));
        createLoanButton.addActionListener(e -> {
            try {
                String userId = userIdField.getText().trim();
                String bookId = bookIdField.getText().trim();
                
                if (userId.isEmpty() || bookId.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please enter both IDs");
                    return;
                }
                
                controller.createLoan(userId, bookId);
                JOptionPane.showMessageDialog(this, "Loan created successfully");
                clearFields(userIdField, bookIdField);
                loadLoans();
                loadBooks();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        JButton returnButton = createButton("Return Book", new Color(52, 152, 219));
        returnButton.addActionListener(e -> {
            String loanId = JOptionPane.showInputDialog(this, "Enter Loan ID to return:");
            if (loanId != null && !loanId.trim().isEmpty()) {
                try {
                    controller.returnLoan(loanId.trim());
                    JOptionPane.showMessageDialog(this, "Book returned successfully");
                    loadLoans();
                    loadBooks();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
                }
            }
        });

        JButton refreshButton = createButton("Refresh", new Color(241, 196, 15));
        refreshButton.addActionListener(e -> loadLoans());

        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(userIdLabel, gbc);
        gbc.gridx = 1;
        panel.add(userIdField, gbc);
        gbc.gridx = 2;
        panel.add(bookIdLabel, gbc);
        gbc.gridx = 3;
        panel.add(bookIdField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.CENTER;
        JPanel buttonSubPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        buttonSubPanel.setBackground(new Color(248, 249, 250));
        buttonSubPanel.add(createLoanButton);
        buttonSubPanel.add(returnButton);
        buttonSubPanel.add(refreshButton);
        panel.add(buttonSubPanel, gbc);

        return panel;
    }

    private JPanel createStatisticsPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 20, 15, 20);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel totalBooksLabel = new JLabel("Total Books: " + controller.getTotalBooks());
        totalBooksLabel.setFont(new Font("Arial", Font.BOLD, 14));
        
        JLabel availableBooksLabel = new JLabel("Available Books: " + controller.getAvailableBooksCount());
        availableBooksLabel.setFont(new Font("Arial", Font.BOLD, 14));
        
        JLabel totalUsersLabel = new JLabel("Total Users: " + controller.getTotalUsers());
        totalUsersLabel.setFont(new Font("Arial", Font.BOLD, 14));
        
        JLabel activeLoansLabel = new JLabel("Active Loans: " + controller.getActiveLoansCount());
        activeLoansLabel.setFont(new Font("Arial", Font.BOLD, 14));

        JButton refreshButton = createButton("Refresh Statistics", new Color(52, 152, 219));
        refreshButton.addActionListener(e -> {
            totalBooksLabel.setText("Total Books: " + controller.getTotalBooks());
            availableBooksLabel.setText("Available Books: " + controller.getAvailableBooksCount());
            totalUsersLabel.setText("Total Users: " + controller.getTotalUsers());
            activeLoansLabel.setText("Active Loans: " + controller.getActiveLoansCount());
        });

        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(totalBooksLabel, gbc);
        gbc.gridy = 1;
        panel.add(availableBooksLabel, gbc);
        gbc.gridy = 2;
        panel.add(totalUsersLabel, gbc);
        gbc.gridy = 3;
        panel.add(activeLoansLabel, gbc);
        gbc.gridy = 4;
        panel.add(refreshButton, gbc);

        return panel;
    }

    private JButton createButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }

    private void showAddBookDialog() {
        JDialog dialog = new JDialog(this, "Add Book", true);
        dialog.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JTextField titleField = new JTextField(20);
        JTextField authorField = new JTextField(20);
        JTextField isbnField = new JTextField(20);
        JTextField yearField = new JTextField(20);
        JTextField categoryField = new JTextField(20);

        addFormField(dialog, gbc, "Title:", titleField, 0);
        addFormField(dialog, gbc, "Author:", authorField, 1);
        addFormField(dialog, gbc, "ISBN:", isbnField, 2);
        addFormField(dialog, gbc, "Year:", yearField, 3);
        addFormField(dialog, gbc, "Category:", categoryField, 4);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> {
            try {
                Book book = new Book(
                    UUID.randomUUID().toString(),
                    titleField.getText(),
                    authorField.getText(),
                    isbnField.getText(),
                    Integer.parseInt(yearField.getText()),
                    categoryField.getText()
                );
                controller.add(book);
                loadBooks();
                dialog.dispose();
                JOptionPane.showMessageDialog(this, "Book added successfully");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(dialog, "Error: " + ex.getMessage());
            }
        });

        gbc.gridx = 0; gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        dialog.add(saveButton, gbc);

        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    private void showAddUserDialog() {
        JDialog dialog = new JDialog(this, "Add User", true);
        dialog.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JTextField firstNameField = new JTextField(20);
        JTextField lastNameField = new JTextField(20);
        JTextField emailField = new JTextField(20);
        JComboBox<String> typeCombo = new JComboBox<>(new String[]{"STUDENT", "PROFESSOR", "RESEARCHER"});

        addFormField(dialog, gbc, "First Name:", firstNameField, 0);
        addFormField(dialog, gbc, "Last Name:", lastNameField, 1);
        addFormField(dialog, gbc, "Email:", emailField, 2);
        
        gbc.gridx = 0; gbc.gridy = 3;
        dialog.add(new JLabel("Type:"), gbc);
        gbc.gridx = 1;
        dialog.add(typeCombo, gbc);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> {
            try {
                User user = new User(
                    UUID.randomUUID().toString(),
                    firstNameField.getText(),
                    lastNameField.getText(),
                    emailField.getText(),
                    (String) typeCombo.getSelectedItem()
                );
                controller.addUser(user);
                loadUsers();
                dialog.dispose();
                JOptionPane.showMessageDialog(this, "User added successfully");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(dialog, "Error: " + ex.getMessage());
            }
        });

        gbc.gridx = 0; gbc.gridy = 4;
        gbc.gridwidth = 2;
        dialog.add(saveButton, gbc);

        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    private void addFormField(JDialog dialog, GridBagConstraints gbc, String label, JComponent field, int row) {
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        dialog.add(new JLabel(label), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        dialog.add(field, gbc);
    }

    private void deleteBook() {
        int row = bookTable.getSelectedRow();
        if (row >= 0) {
            String id = (String) bookTableModel.getValueAt(row, 0);
            int confirm = JOptionPane.showConfirmDialog(this, 
                "Delete this book?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                controller.remove(id);
                loadBooks();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Select a book to delete");
        }
    }

    private void deleteUser() {
        int row = userTable.getSelectedRow();
        if (row >= 0) {
            String id = (String) userTableModel.getValueAt(row, 0);
            int confirm = JOptionPane.showConfirmDialog(this, 
                "Delete this user?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                controller.removeUser(id);
                loadUsers();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Select a user to delete");
        }
    }

    private void clearFields(JTextField... fields) {
        for (JTextField field : fields) {
            field.setText("");
        }
    }

    private void showAboutDialog() {
        JOptionPane.showMessageDialog(this, 
            "Library Management System\n" +
            "Version: 1.0\n" +
            "Developed for ESPE\n" +
            "2024 All Rights Reserved",
            "About",
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    private void loadBooks() {
        bookTableModel.setRowCount(0);
        for (Book book : controller.findAll()) {
            bookTableModel.addRow(new Object[]{
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getIsbn(),
                book.getPublicationYear(),
                book.isAvailable() ? "Available" : "Borrowed",
                book.getCategory()
            });
        }
    }

    private void loadUsers() {
        userTableModel.setRowCount(0);
        for (User user : controller.findAllUsers()) {
            userTableModel.addRow(new Object[]{
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getUserType(),
                user.getActiveLoans()
            });
        }
    }

    private void loadLoans() {
        loanTableModel.setRowCount(0);
        for (Loan loan : controller.findAllLoans()) {
            loanTableModel.addRow(new Object[]{
                loan.getId(),
                loan.getUserId(),
                loan.getBookId(),
                loan.getLoanDate(),
                loan.getStatus(),
                "$" + String.format("%.2f", loan.getFine())
            });
        }
    }

    private void loadData() {
        loadBooks();
        loadUsers();
        loadLoans();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            new LibraryGUI();
        });
    }
}
