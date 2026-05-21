package ec.edu.espe.productpomds.view;

import ec.edu.espe.productpomds.controller.ProductController;
import ec.edu.espe.productpomds.model.Product;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

/**
 * Package:     ec.edu.espe.productpomds.view
 * Class:       ProductView
 * Description: Swing GUI for Product POMDS
 */
public class ProductView extends JFrame {

    // ── Controller ─────────────────────────────────────────────
    private final ProductController controller = new ProductController();

    // ── Colors ─────────────────────────────────────────────────
    private static final Color BG_DARK    = new Color(13, 15, 20);
    private static final Color BG_SURFACE = new Color(22, 25, 32);
    private static final Color BG_CARD    = new Color(28, 32, 48);
    private static final Color ACCENT     = new Color(91, 141, 238);
    private static final Color ACCENT2    = new Color(238, 91, 155);
    private static final Color GREEN      = new Color(61, 214, 140);
    private static final Color RED        = new Color(238, 91, 91);
    private static final Color TEXT       = new Color(232, 236, 244);
    private static final Color MUTED      = new Color(122, 132, 160);
    private static final Color BORDER     = new Color(39, 45, 61);

    // ── Table ──────────────────────────────────────────────────
    private JTable           table;
    private DefaultTableModel tableModel;

    // ── Form fields ────────────────────────────────────────────
    private JTextField  txtName, txtDescription, txtPrice, txtStock, txtSearch;
    private JComboBox<String> cmbCategory, cmbFilter;
    private JLabel      lblStatus;
    private JButton     btnCreate, btnUpdate, btnDelete, btnClear, btnSearch;

    // ── Selected product ID ────────────────────────────────────
    private int selectedId = -1;

    public ProductView() {
        initComponents();
        refreshTable();
    }

    // ── UI Setup ───────────────────────────────────────────────
    private void initComponents() {
        setTitle("Product POMDS  —  ec.edu.espe.productpomds");
        setSize(1050, 660);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(BG_DARK);
        setLayout(new BorderLayout(0, 0));

        add(buildHeader(),     BorderLayout.NORTH);
        add(buildLeftPanel(),  BorderLayout.WEST);
        add(buildMainPanel(),  BorderLayout.CENTER);
        add(buildStatusBar(),  BorderLayout.SOUTH);

        setupListeners();
    }

    // ── Header ─────────────────────────────────────────────────
    private JPanel buildHeader() {
        JPanel header = new JPanel(new FlowLayout(FlowLayout.LEFT, 16, 10));
        header.setBackground(BG_SURFACE);
        header.setBorder(new MatteBorder(0, 0, 1, 0, BORDER));

        JLabel logo = new JLabel("P");
        logo.setFont(new Font("SansSerif", Font.BOLD, 16));
        logo.setForeground(Color.WHITE);
        logo.setOpaque(true);
        logo.setBackground(ACCENT);
        logo.setPreferredSize(new Dimension(34, 34));
        logo.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel title = new JLabel("Product POMDS");
        title.setFont(new Font("SansSerif", Font.BOLD, 14));
        title.setForeground(TEXT);

        JLabel pkg = new JLabel("ec.edu.espe.productpomds");
        pkg.setFont(new Font("Monospaced", Font.PLAIN, 11));
        pkg.setForeground(MUTED);

        header.add(logo);
        header.add(title);
        header.add(pkg);
        return header;
    }

    // ── Left panel (form) ──────────────────────────────────────
    private JPanel buildLeftPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(BG_SURFACE);
        panel.setBorder(new CompoundBorder(
            new MatteBorder(0, 0, 0, 1, BORDER),
            new EmptyBorder(16, 16, 16, 16)
        ));
        panel.setPreferredSize(new Dimension(270, 0));

        panel.add(sectionLabel("PRODUCT FORM"));
        panel.add(Box.createVerticalStrut(10));

        // Name — letters only
        panel.add(fieldLabel("Name  (letters only)"));
        txtName = styledField();
        txtName.setDocument(new LettersOnlyDocument());
        panel.add(txtName);
        panel.add(Box.createVerticalStrut(8));

        // Description
        panel.add(fieldLabel("Description"));
        txtDescription = styledField();
        txtDescription.setDocument(new LettersOnlyDocument());
        panel.add(txtDescription);
        panel.add(Box.createVerticalStrut(8));

        // Category combobox
        panel.add(fieldLabel("Category"));
        String[] defaultCats = {"Electronics","Peripherals","Stationery","Clothing","Food","Other"};
        cmbCategory = styledCombo(defaultCats);
        panel.add(cmbCategory);
        panel.add(Box.createVerticalStrut(8));

        // Price — numbers only
        panel.add(fieldLabel("Price ($)  (numbers only)"));
        txtPrice = styledField();
        txtPrice.setDocument(new NumbersOnlyDocument(true));
        panel.add(txtPrice);
        panel.add(Box.createVerticalStrut(8));

        // Stock — integers only
        panel.add(fieldLabel("Stock  (numbers only)"));
        txtStock = styledField();
        txtStock.setDocument(new NumbersOnlyDocument(false));
        panel.add(txtStock);
        panel.add(Box.createVerticalStrut(16));

        // Buttons
        btnCreate = accentButton("➕  Create", ACCENT);
        btnUpdate = accentButton("✏  Update", new Color(80, 160, 100));
        btnDelete = accentButton("🗑  Delete", RED);
        btnClear  = ghostButton("Clear");

        btnCreate.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnUpdate.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnDelete.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnClear .setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(btnCreate);
        panel.add(Box.createVerticalStrut(6));
        panel.add(btnUpdate);
        panel.add(Box.createVerticalStrut(6));
        panel.add(btnDelete);
        panel.add(Box.createVerticalStrut(6));
        panel.add(btnClear);

        return panel;
    }

    // ── Main panel (table + search) ────────────────────────────
    private JPanel buildMainPanel() {
        JPanel panel = new JPanel(new BorderLayout(0, 12));
        panel.setBackground(BG_DARK);
        panel.setBorder(new EmptyBorder(16, 16, 16, 16));

        // Top: search + filter
        JPanel topBar = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
        topBar.setBackground(BG_DARK);

        txtSearch = styledField();
        txtSearch.setPreferredSize(new Dimension(220, 32));
        txtSearch.putClientProperty("JTextField.placeholderText", "Search by name...");

        String[] filterOpts = {"All categories","Electronics","Peripherals","Stationery","Clothing","Food","Other"};
        cmbFilter = styledCombo(filterOpts);
        cmbFilter.setPreferredSize(new Dimension(170, 32));

        btnSearch = accentButton("🔍  Search", ACCENT);
        btnSearch.setPreferredSize(new Dimension(110, 32));

        topBar.add(new JLabel("  ") {{setForeground(MUTED);}});
        topBar.add(styledLabel("Search:"));
        topBar.add(txtSearch);
        topBar.add(styledLabel("  Category:"));
        topBar.add(cmbFilter);
        topBar.add(btnSearch);

        panel.add(topBar, BorderLayout.NORTH);

        // Table
        String[] cols = {"ID","Name","Description","Category","Price ($)","Stock"};
        tableModel = new DefaultTableModel(cols, 0) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        table = new JTable(tableModel);
        styleTable();

        JScrollPane scroll = new JScrollPane(table);
        scroll.setBackground(BG_CARD);
        scroll.getViewport().setBackground(BG_CARD);
        scroll.setBorder(new LineBorder(BORDER, 1));
        panel.add(scroll, BorderLayout.CENTER);

        return panel;
    }

    // ── Status bar ─────────────────────────────────────────────
    private JPanel buildStatusBar() {
        JPanel bar = new JPanel(new BorderLayout());
        bar.setBackground(BG_SURFACE);
        bar.setBorder(new CompoundBorder(
            new MatteBorder(1, 0, 0, 0, BORDER),
            new EmptyBorder(5, 16, 5, 16)
        ));
        lblStatus = new JLabel("Ready — select a row to edit or delete.");
        lblStatus.setFont(new Font("Monospaced", Font.PLAIN, 11));
        lblStatus.setForeground(MUTED);
        bar.add(lblStatus, BorderLayout.WEST);
        return bar;
    }

    // ── Table styling ──────────────────────────────────────────
    private void styleTable() {
        table.setBackground(BG_CARD);
        table.setForeground(TEXT);
        table.setGridColor(BORDER);
        table.setRowHeight(36);
        table.setFont(new Font("SansSerif", Font.PLAIN, 13));
        table.setSelectionBackground(new Color(91, 141, 238, 60));
        table.setSelectionForeground(TEXT);
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(false);
        table.setIntercellSpacing(new Dimension(0, 1));
        table.getTableHeader().setBackground(BG_SURFACE);
        table.getTableHeader().setForeground(MUTED);
        table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 11));
        table.getTableHeader().setBorder(new MatteBorder(0, 0, 1, 0, BORDER));

        // Column widths
        int[] widths = {40, 160, 200, 110, 80, 60};
        for (int i = 0; i < widths.length; i++)
            table.getColumnModel().getColumn(i).setPreferredWidth(widths[i]);

        // Price column green renderer
        table.getColumnModel().getColumn(4).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable t, Object v, boolean sel, boolean foc, int r, int c) {
                super.getTableCellRendererComponent(t, v, sel, foc, r, c);
                setForeground(sel ? TEXT : GREEN);
                setBackground(sel ? new Color(91,141,238,60) : BG_CARD);
                setFont(new Font("Monospaced", Font.PLAIN, 13));
                return this;
            }
        });

        // ID column centered
        DefaultTableCellRenderer center = new DefaultTableCellRenderer();
        center.setHorizontalAlignment(SwingConstants.CENTER);
        center.setBackground(BG_CARD);
        center.setForeground(MUTED);
        table.getColumnModel().getColumn(0).setCellRenderer(center);
    }

    // ── Listeners ──────────────────────────────────────────────
    private void setupListeners() {
        btnCreate.addActionListener(e -> onCreateProduct());
        btnUpdate.addActionListener(e -> onUpdateProduct());
        btnDelete.addActionListener(e -> onDeleteProduct());
        btnClear .addActionListener(e -> clearForm());
        btnSearch.addActionListener(e -> onSearch());
        txtSearch.addActionListener(e -> onSearch());

        // cmbFilter live filter
        cmbFilter.addActionListener(e -> onSearch());

        // Table row selection → fill form
        table.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && table.getSelectedRow() >= 0) {
                int row = table.getSelectedRow();
                selectedId = (int) tableModel.getValueAt(row, 0);
                txtName       .setText((String) tableModel.getValueAt(row, 1));
                txtDescription.setText((String) tableModel.getValueAt(row, 2));
                cmbCategory.setSelectedItem(tableModel.getValueAt(row, 3));
                txtPrice.setText(tableModel.getValueAt(row, 4).toString().replace("$","").trim());
                txtStock.setText(tableModel.getValueAt(row, 5).toString());
                setStatus("Selected: [" + selectedId + "] " + tableModel.getValueAt(row, 1), ACCENT);
            }
        });
    }

    // ── CRUD Handlers ──────────────────────────────────────────
    private void onCreateProduct() {
        if (!validateForm()) return;
        boolean ok = controller.createProduct(
            txtName.getText(),
            txtDescription.getText(),
            Double.parseDouble(txtPrice.getText()),
            Integer.parseInt(txtStock.getText()),
            (String) cmbCategory.getSelectedItem()
        );
        if (ok) { setStatus("✔  Product created successfully.", GREEN); clearForm(); refreshTable(); }
        else      setStatus("✘  Error creating product.", RED);
    }

    private void onUpdateProduct() {
        if (selectedId < 0) { setStatus("⚠  Select a product from the table first.", RED); return; }
        if (!validateForm()) return;
        boolean ok = controller.updateProduct(
            selectedId,
            txtName.getText(),
            txtDescription.getText(),
            Double.parseDouble(txtPrice.getText()),
            Integer.parseInt(txtStock.getText()),
            (String) cmbCategory.getSelectedItem()
        );
        if (ok) { setStatus("✔  Product updated successfully.", GREEN); clearForm(); refreshTable(); }
        else      setStatus("✘  Product not found.", RED);
    }

    private void onDeleteProduct() {
        if (selectedId < 0) { setStatus("⚠  Select a product from the table first.", RED); return; }
        int confirm = JOptionPane.showConfirmDialog(this,
            "Delete product [" + selectedId + "] " + txtName.getText() + "?",
            "Confirm Delete", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (confirm == JOptionPane.YES_OPTION) {
            boolean ok = controller.deleteProduct(selectedId);
            if (ok) { setStatus("✔  Product deleted.", GREEN); clearForm(); refreshTable(); }
            else      setStatus("✘  Product not found.", RED);
        }
    }

    private void onSearch() {
        String query    = txtSearch.getText().trim().toLowerCase();
        String catFilter = (String) cmbFilter.getSelectedItem();
        tableModel.setRowCount(0);
        List<Product> products = controller.listProducts();
        for (Product p : products) {
            boolean matchName = query.isEmpty() || p.getName().toLowerCase().contains(query)
                             || p.getDescription().toLowerCase().contains(query);
            boolean matchCat  = catFilter.equals("All categories") || p.getCategory().equals(catFilter);
            if (matchName && matchCat)
                tableModel.addRow(new Object[]{
                    p.getId(), p.getName(), p.getDescription(),
                    p.getCategory(), String.format("$%.2f", p.getPrice()), p.getStock()
                });
        }
        setStatus("Showing " + tableModel.getRowCount() + " product(s).", MUTED);
    }

    // ── Helpers ────────────────────────────────────────────────
    public void refreshTable() {
        tableModel.setRowCount(0);
        for (Product p : controller.listProducts()) {
            tableModel.addRow(new Object[]{
                p.getId(), p.getName(), p.getDescription(),
                p.getCategory(), String.format("$%.2f", p.getPrice()), p.getStock()
            });
        }
        setStatus("Total products: " + tableModel.getRowCount(), MUTED);
    }

    private boolean validateForm() {
        if (txtName.getText().trim().isEmpty()) {
            setStatus("✘  Name is required.", RED); txtName.requestFocus(); return false;
        }
        if (txtPrice.getText().trim().isEmpty()) {
            setStatus("✘  Price is required.", RED); txtPrice.requestFocus(); return false;
        }
        try { double p = Double.parseDouble(txtPrice.getText());
            if (p <= 0) { setStatus("✘  Price must be > 0.", RED); return false; }
        } catch (NumberFormatException ex) { setStatus("✘  Invalid price.", RED); return false; }

        if (txtStock.getText().trim().isEmpty()) {
            setStatus("✘  Stock is required.", RED); txtStock.requestFocus(); return false;
        }
        return true;
    }

    private void clearForm() {
        txtName.setText(""); txtDescription.setText("");
        txtPrice.setText(""); txtStock.setText("");
        cmbCategory.setSelectedIndex(0);
        selectedId = -1;
        table.clearSelection();
        setStatus("Form cleared.", MUTED);
    }

    private void setStatus(String msg, Color color) {
        lblStatus.setText(msg);
        lblStatus.setForeground(color);
    }

    // ── Widget factories ───────────────────────────────────────
    private JTextField styledField() {
        JTextField f = new JTextField();
        f.setBackground(BG_CARD);
        f.setForeground(TEXT);
        f.setCaretColor(TEXT);
        f.setBorder(new CompoundBorder(
            new LineBorder(BORDER, 1, true),
            new EmptyBorder(4, 8, 4, 8)
        ));
        f.setFont(new Font("Monospaced", Font.PLAIN, 13));
        f.setMaximumSize(new Dimension(Integer.MAX_VALUE, 32));
        f.setPreferredSize(new Dimension(238, 32));
        return f;
    }

    private <T> JComboBox<T> styledCombo(T[] items) {
        JComboBox<T> c = new JComboBox<>(items);
        c.setBackground(BG_CARD);
        c.setForeground(TEXT);
        c.setFont(new Font("SansSerif", Font.PLAIN, 13));
        c.setMaximumSize(new Dimension(Integer.MAX_VALUE, 32));
        c.setPreferredSize(new Dimension(238, 32));
        return c;
    }

    private JButton accentButton(String text, Color bg) {
        JButton btn = new JButton(text);
        btn.setBackground(bg);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setFont(new Font("SansSerif", Font.BOLD, 13));
        btn.setMaximumSize(new Dimension(Integer.MAX_VALUE, 36));
        btn.setPreferredSize(new Dimension(238, 36));
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return btn;
    }

    private JButton ghostButton(String text) {
        JButton btn = new JButton(text);
        btn.setBackground(BG_CARD);
        btn.setForeground(MUTED);
        btn.setFocusPainted(false);
        btn.setBorder(new LineBorder(BORDER, 1));
        btn.setFont(new Font("SansSerif", Font.PLAIN, 13));
        btn.setMaximumSize(new Dimension(Integer.MAX_VALUE, 32));
        btn.setPreferredSize(new Dimension(238, 32));
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return btn;
    }

    private JLabel fieldLabel(String text) {
        JLabel l = new JLabel(text);
        l.setForeground(MUTED);
        l.setFont(new Font("SansSerif", Font.BOLD, 11));
        l.setAlignmentX(Component.LEFT_ALIGNMENT);
        return l;
    }

    private JLabel sectionLabel(String text) {
        JLabel l = new JLabel(text);
        l.setForeground(ACCENT);
        l.setFont(new Font("Monospaced", Font.BOLD, 11));
        l.setAlignmentX(Component.LEFT_ALIGNMENT);
        return l;
    }

    private JLabel styledLabel(String text) {
        JLabel l = new JLabel(text);
        l.setForeground(MUTED);
        l.setFont(new Font("SansSerif", Font.PLAIN, 12));
        return l;
    }

    // ── Custom Documents (validation) ──────────────────────────

    /** Allows only letters, spaces, hyphens and dots */
    static class LettersOnlyDocument extends javax.swing.text.PlainDocument {
        @Override
        public void insertString(int offset, String str, javax.swing.text.AttributeSet a)
                throws javax.swing.text.BadLocationException {
            if (str == null) return;
            String filtered = str.replaceAll("[^a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\\s\\-\\.]", "");
            super.insertString(offset, filtered, a);
        }
    }

    /** Allows only digits (and optionally a single decimal point) */
    static class NumbersOnlyDocument extends javax.swing.text.PlainDocument {
        private final boolean allowDecimal;
        NumbersOnlyDocument(boolean allowDecimal) { this.allowDecimal = allowDecimal; }

        @Override
        public void insertString(int offset, String str, javax.swing.text.AttributeSet a)
                throws javax.swing.text.BadLocationException {
            if (str == null) return;
            StringBuilder sb = new StringBuilder();
            for (char ch : str.toCharArray()) {
                if (Character.isDigit(ch)) { sb.append(ch); }
                else if (allowDecimal && ch == '.' && !getText(0, getLength()).contains(".")) {
                    sb.append(ch);
                }
            }
            super.insertString(offset, sb.toString(), a);
        }
    }
}
