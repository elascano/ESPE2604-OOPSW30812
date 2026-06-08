
package ec.edu.espe.safestore.model;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
/**
 *
 * @author Alexander Tipantiza, The Softwarriors, @ESPE
 */

public class SaleSystem {
    private static final String SALES_FILE = "sales.json";
    private static final String HOLD_FILE = "sales_hold.json";
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static List<Sale> sales = new ArrayList<>();
    private static Sale pendingSale = null;
    
    static {
        loadSales();
        loadHold();
    }
    
    public static class Sale {
        private int saleId;
        private String customerName;
        private LocalDateTime date;
        private List<SaleItem> items;
        private double subtotal;
        private double tax;
        private double total;
        private String paymentMethod;
        private String saleType;
        
        public Sale() {
            this.items = new ArrayList<>();
            this.date = LocalDateTime.now();
        }
        
        public Sale(int saleId, String customerName, String saleType, String paymentMethod) {
            this.saleId = saleId;
            this.customerName = customerName;
            this.saleType = saleType;
            this.paymentMethod = paymentMethod;
            this.items = new ArrayList<>();
            this.date = LocalDateTime.now();
        }
        
        public int getSaleId() { return saleId; }
        public void setSaleId(int saleId) { this.saleId = saleId; }
        public String getCustomerName() { return customerName; }
        public void setCustomerName(String customerName) { this.customerName = customerName; }
        public LocalDateTime getDate() { return date; }
        public void setDate(LocalDateTime date) { this.date = date; }
        public List<SaleItem> getItems() { return items; }
        public void setItems(List<SaleItem> items) { 
            this.items = items;
            calculateTotals();
        }
        public double getSubtotal() { return subtotal; }
        public double getTax() { return tax; }
        public double getTotal() { return total; }
        public String getPaymentMethod() { return paymentMethod; }
        public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
        public String getSaleType() { return saleType; }
        public void setSaleType(String saleType) { this.saleType = saleType; }
        
        public void addItem(SaleItem item) {
            items.add(item);
            calculateTotals();
        }
        
        private void calculateTotals() {
            subtotal = items.stream().mapToDouble(SaleItem::getTotalPrice).sum();
            tax = subtotal * 0.15;
            total = subtotal + tax;
        }
        
        @Override
        public String toString() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            return String.format("Venta #%d | Cliente: %s | Fecha: %s | Total: $%.2f",
                saleId, customerName, date.format(formatter), total);
        }
    }
    
    public static class SaleItem {
        private int productId;
        private String productName;
        private int quantity;
        private double unitPrice;
        private double totalPrice;
        
        public SaleItem() {}
        
        public SaleItem(int productId, String productName, int quantity, double unitPrice) {
            this.productId = productId;
            this.productName = productName;
            this.quantity = quantity;
            this.unitPrice = unitPrice;
            this.totalPrice = quantity * unitPrice;
        }
        
        public int getProductId() { return productId; }
        public void setProductId(int productId) { this.productId = productId; }
        public String getProductName() { return productName; }
        public void setProductName(String productName) { this.productName = productName; }
        public int getQuantity() { return quantity; }
        public void setQuantity(int quantity) { 
            this.quantity = quantity;
            this.totalPrice = this.quantity * this.unitPrice;
        }
        public double getUnitPrice() { return unitPrice; }
        public void setUnitPrice(double unitPrice) { 
            this.unitPrice = unitPrice;
            this.totalPrice = this.quantity * this.unitPrice;
        }
        public double getTotalPrice() { return totalPrice; }
        
        @Override
        public String toString() {
            return String.format("%s x%d = $%.2f", productName, quantity, totalPrice);
        }
    }
    
    public static void menu(Scanner scanner) {
        while (true) {
            System.out.println("\nSISTEMA DE VENTAS");
            System.out.println("1. Nueva venta");
            System.out.println("2. Agregar producto a venta actual");
            System.out.println("3. Finalizar venta");
            System.out.println("4. Poner venta en espera (Hold)");
            System.out.println("5. Recuperar venta en espera");
            System.out.println("6. Ver historial de ventas");
            System.out.println("7. Buscar venta por ID");
            System.out.println("8. Volver");
            System.out.print("Opcion: ");
            
            int opt = scanner.nextInt();
            scanner.nextLine();
            
            switch(opt) {
                case 1: startNewSale(scanner); break;
                case 2: addProductToCurrentSale(scanner); break;
                case 3: finalizeSale(scanner); break;
                case 4: holdCurrentSale(); break;
                case 5: resumeHoldSale(); break;
                case 6: viewSalesHistory(); break;
                case 7: searchSale(scanner); break;
                case 8: return;
                default: System.out.println("Opcion invalida");
            }
        }
    }
    
    private static void startNewSale(Scanner scanner) {
        System.out.print("Nombre del cliente: ");
        String customer = scanner.nextLine();
        System.out.print("Tipo de venta (mayor/menor): ");
        String type = scanner.nextLine().toLowerCase();
        System.out.print("Metodo de pago (cash/credit/mixed): ");
        String payment = scanner.nextLine().toLowerCase();
        
        int newId = sales.size() + 1;
        pendingSale = new Sale(newId, customer, type, payment);
        System.out.println("Nueva venta iniciada - ID: " + newId);
    }
    
    private static void addProductToCurrentSale(Scanner scanner) {
        if (pendingSale == null) {
            System.out.println("No hay una venta activa. Cree una nueva venta primero.");
            return;
        }
        
        System.out.print("ID del producto: ");
        int productId = scanner.nextInt();
        
        ProductManagement.Product product = ProductManagement.findById(productId);
        if (product == null) {
            System.out.println("Producto no encontrado");
            return;
        }
        
        System.out.print("Cantidad: ");
        int quantity = scanner.nextInt();
        
        if (quantity > product.getStock()) {
            System.out.println("Stock insuficiente. Disponible: " + product.getStock());
            return;
        }
        
        double unitPrice = "mayor".equalsIgnoreCase(pendingSale.getSaleType()) && quantity >= 12 
                           ? product.getWholesalePrice() : product.getRetailPrice();
        
        SaleItem item = new SaleItem(productId, product.getName(), quantity, unitPrice);
        pendingSale.addItem(item);
        
        ProductManagement.updateProductStock(productId, product.getStock() - quantity);
        
        System.out.printf("Producto agregado: %d x %s - $%.2f c/u\n", quantity, product.getName(), unitPrice);
        System.out.printf("Subtotal actual: $%.2f\n", pendingSale.getSubtotal());
    }
    
    private static void finalizeSale(Scanner scanner) {
        if (pendingSale == null || pendingSale.getItems().isEmpty()) {
            System.out.println("No hay una venta activa con productos");
            return;
        }
        
        System.out.println("\nRESUMEN DE VENTA");
        System.out.println("Cliente: " + pendingSale.getCustomerName());
        System.out.println("Tipo: " + pendingSale.getSaleType());
        System.out.println("Subtotal: $" + pendingSale.getSubtotal());
        System.out.println("IVA (15%%): $" + pendingSale.getTax());
        System.out.println("TOTAL: $" + pendingSale.getTotal());
        
        System.out.print("\nConfirmar venta? (s/n): ");
        String confirm = scanner.nextLine();
        
        if (confirm.equalsIgnoreCase("s")) {
            sales.add(pendingSale);
            saveSales();
            System.out.println("Venta #" + pendingSale.getSaleId() + " finalizada");
            pendingSale = null;
        } else {
            System.out.println("Venta cancelada");
        }
    }
    
    private static void holdCurrentSale() {
        if (pendingSale == null) {
            System.out.println("No hay una venta activa para poner en espera");
            return;
        }
        
        saveHold();
        System.out.println("Venta puesta en espera. Puede atender al siguiente cliente.");
        pendingSale = null;
    }
    
    private static void resumeHoldSale() {
        loadHold();
        
        if (pendingSale == null) {
            System.out.println("No hay ninguna venta en espera");
            return;
        }
        
        System.out.println("Venta en espera recuperada - ID: " + pendingSale.getSaleId());
        System.out.println("Cliente: " + pendingSale.getCustomerName());
        System.out.println("Productos en carrito: " + pendingSale.getItems().size());
    }
    
    private static void viewSalesHistory() {
        if (sales.isEmpty()) {
            System.out.println("No hay ventas registradas");
            return;
        }
        
        System.out.println("\nHISTORIAL DE VENTAS");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        for (Sale s : sales) {
            System.out.printf("#%d | %s | %s | $%.2f | %s\n", 
                s.getSaleId(), 
                s.getDate().format(formatter),
                s.getCustomerName(),
                s.getTotal(),
                s.getPaymentMethod());
        }
    }
    
    private static void searchSale(Scanner scanner) {
        System.out.print("ID de venta: ");
        int id = scanner.nextInt();
        
        Sale found = sales.stream().filter(s -> s.getSaleId() == id).findFirst().orElse(null);
        if (found == null) {
            System.out.println("Venta no encontrada");
            return;
        }
        
        System.out.println("\nDETALLE DE VENTA #" + found.getSaleId());
        System.out.println("Cliente: " + found.getCustomerName());
        System.out.println("Fecha: " + found.getDate());
        System.out.println("Tipo: " + found.getSaleType());
        System.out.println("Pago: " + found.getPaymentMethod());
        System.out.println("\nProductos:");
        for (SaleItem item : found.getItems()) {
            System.out.printf("  %s x%d = $%.2f\n", item.getProductName(), item.getQuantity(), item.getTotalPrice());
        }
        System.out.printf("\nTOTAL: $%.2f\n", found.getTotal());
    }
    
    private static void loadSales() {
        try {
            File file = new File(SALES_FILE);
            if (file.exists()) {
                String content = new String(java.nio.file.Files.readAllBytes(file.toPath()));
                Type type = new TypeToken<ArrayList<Sale>>(){}.getType();
                List<Sale> loaded = gson.fromJson(content, type);
                if (loaded != null) {
                    sales = loaded;
                }
            }
        } catch (Exception e) {
            System.out.println("Error cargando ventas: " + e.getMessage());
        }
    }
    
    private static void saveSales() {
        try {
            String json = gson.toJson(sales);
            java.nio.file.Files.write(java.nio.file.Paths.get(SALES_FILE), json.getBytes());
        } catch (Exception e) {
            System.out.println("Error guardando ventas: " + e.getMessage());
        }
    }
    
    private static void saveHold() {
        try {
            String json = gson.toJson(pendingSale);
            java.nio.file.Files.write(java.nio.file.Paths.get(HOLD_FILE), json.getBytes());
        } catch (Exception e) {
            System.out.println("Error guardando venta en espera: " + e.getMessage());
        }
    }
    
    private static void loadHold() {
        try {
            File file = new File(HOLD_FILE);
            if (file.exists()) {
                String content = new String(java.nio.file.Files.readAllBytes(file.toPath()));
                pendingSale = gson.fromJson(content, Sale.class);
            }
        } catch (Exception e) {
            System.out.println("Error cargando venta en espera: " + e.getMessage());
        }
    }
}