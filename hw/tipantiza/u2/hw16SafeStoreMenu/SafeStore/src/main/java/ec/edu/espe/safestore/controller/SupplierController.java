
package ec.edu.espe.safestore.controller;

/**
 *
 * @author Alexander Tipantiza, The Softwarriors, @ESPE
 */
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ec.edu.espe.safestore.model.Supplier;
import ec.edu.espe.safestore.model.SupplierInvoice;
import ec.edu.espe.safestore.model.InvoiceItem;
import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SupplierController {
    
    private static final String SUPPLIERS_FILE = "suppliers.json";
    private static final String INVOICES_FILE = "invoices.json";
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private List<Supplier> suppliers;
    private List<SupplierInvoice> invoices;
    private Map<String, List<Double>> priceHistory;
    private ProductController productController;
    
    public SupplierController() {
        suppliers = new ArrayList<>();
        invoices = new ArrayList<>();
        priceHistory = new HashMap<>();
        productController = new ProductController();
        loadSuppliers();
        loadInvoices();
    }
    
    private void loadSuppliers() {
        try {
            File file = new File(SUPPLIERS_FILE);
            if (file.exists()) {
                String content = new String(java.nio.file.Files.readAllBytes(file.toPath()));
                Type type = new TypeToken<ArrayList<Supplier>>(){}.getType();
                List<Supplier> loaded = gson.fromJson(content, type);
                if (loaded != null) {
                    suppliers = loaded;
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading suppliers: " + e.getMessage());
        }
    }
    
    private void saveSuppliers() {
        try {
            String json = gson.toJson(suppliers);
            java.nio.file.Files.write(java.nio.file.Paths.get(SUPPLIERS_FILE), json.getBytes());
        } catch (Exception e) {
            System.out.println("Error saving suppliers: " + e.getMessage());
        }
    }
    
    private void loadInvoices() {
        try {
            File file = new File(INVOICES_FILE);
            if (file.exists()) {
                String content = new String(java.nio.file.Files.readAllBytes(file.toPath()));
                Type type = new TypeToken<ArrayList<SupplierInvoice>>(){}.getType();
                List<SupplierInvoice> loaded = gson.fromJson(content, type);
                if (loaded != null) {
                    invoices = loaded;
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading invoices: " + e.getMessage());
        }
    }
    
    private void saveInvoices() {
        try {
            String json = gson.toJson(invoices);
            java.nio.file.Files.write(java.nio.file.Paths.get(INVOICES_FILE), json.getBytes());
        } catch (Exception e) {
            System.out.println("Error saving invoices: " + e.getMessage());
        }
    }
    
    public boolean addSupplier(Supplier supplier) {
        if (findSupplierById(supplier.getId()) != null) {
            return false;
        }
        suppliers.add(supplier);
        saveSuppliers();
        return true;
    }
    
    public Supplier findSupplierById(int id) {
        for (Supplier s : suppliers) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }
    
    public List<Supplier> getAllSuppliers() {
        return new ArrayList<>(suppliers);
    }
    
    public boolean addInvoice(SupplierInvoice invoice) {
        invoices.add(invoice);
        saveInvoices();
        
        Supplier supplier = findSupplierById(invoice.getSupplierId());
        if (supplier != null) {
            supplier.addInvoiceId(invoice.getInvoiceId());
            supplier.setCurrentDebt(supplier.getCurrentDebt() + invoice.getTotal());
            saveSuppliers();
        }
        return true;
    }
    
    public List<SupplierInvoice> getPendingInvoices() {
        List<SupplierInvoice> pending = new ArrayList<>();
        for (SupplierInvoice inv : invoices) {
            if ("pending".equals(inv.getStatus())) {
                pending.add(inv);
            }
        }
        return pending;
    }
    
    public boolean payInvoice(int invoiceId) {
        SupplierInvoice invoice = findInvoiceById(invoiceId);
        if (invoice == null || !"pending".equals(invoice.getStatus())) {
            return false;
        }
        
        invoice.setStatus("paid");
        saveInvoices();
        
        Supplier supplier = findSupplierById(invoice.getSupplierId());
        if (supplier != null) {
            supplier.setCurrentDebt(supplier.getCurrentDebt() - invoice.getTotal());
            saveSuppliers();
        }
        return true;
    }
    
    private SupplierInvoice findInvoiceById(int id) {
        for (SupplierInvoice inv : invoices) {
            if (inv.getInvoiceId() == id) {
                return inv;
            }
        }
        return null;
    }
    
    public List<InvoiceItem> getInvoiceItems(int invoiceId) {
        SupplierInvoice invoice = findInvoiceById(invoiceId);
        if (invoice == null) {
            return new ArrayList<>();
        }
        return invoice.getItems();
    }
}