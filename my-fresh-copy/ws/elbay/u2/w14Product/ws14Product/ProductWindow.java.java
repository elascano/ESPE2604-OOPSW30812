import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class InventoryApp extends JFrame {
    private HashMap<String, String> products;
    private DefaultTableModel tableModel;
    private JTextField entryId, entryName, entryDeleteId;
    private JTable table;

    public InventoryApp() {
        products = new HashMap<>();

        setTitle("Product Management");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel panelInputs = new JPanel(new GridBagLayout());
        panelInputs.setBorder(BorderFactory.createTitledBorder(" Register Product "));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0;
        panelInputs.add(new JLabel("Product ID:"), gbc);

        gbc.gridx = 1;
        entryId = new JTextField(8);
        panelInputs.add(entryId, gbc);

        gbc.gridx = 2;
        panelInputs.add(new JLabel("Name:"), gbc);

        gbc.gridx = 3;
        entryName = new JTextField(12);
        panelInputs.add(entryName, gbc);

        gbc.gridx = 4;
        JButton btnSave = new JButton("Save");
        panelInputs.add(btnSave, gbc);

        add(panelInputs, BorderLayout.NORTH);

        String[] columns = {"Product ID", "Product Name"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel panelActions = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelActions.add(new JLabel("ID to Delete:"));
        entryDeleteId = new JTextField(8);
        panelActions.add(entryDeleteId);

        JButton btnDelete = new JButton("Delete by ID");
        panelActions.add(btnDelete);

        add(panelActions, BorderLayout.SOUTH);

        btnSave.addActionListener(e -> addProduct());
        btnDelete.addActionListener(e -> deleteById());
    }

    private void updateTable() {
        tableModel.setRowCount(0);
        for (String id : products.keySet()) {
            tableModel.addRow(new Object[]{id, products.get(id)});
        }
    }

    private void addProduct() {
        String id = entryId.getText().trim();
        String name = entryName.getText().trim();

        if (id.isEmpty() || name.isEmpty()) return;

        if (products.containsKey(id)) return;

        products.put(id, name);
        updateTable();
    }

    private void deleteById() {
        String id = entryDeleteId.getText().trim();
        if (products.containsKey(id)) {
            products.remove(id);
            updateTable();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InventoryApp().setVisible(true));
    }
}
