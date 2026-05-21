package ec.edu.espe.productpomds.controller;

import ec.edu.espe.productpomds.model.Product;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Package:     ec.edu.espe.productpomds.controller
 * Class:       ProductController
 * Description: Business logic and JSON file persistence (no external dependencies)
 */
public class ProductController {

    private static final String DB_PATH = "data/products.json";

    // ── Persistence ───────────────────────────────────────────

    private List<Product> loadData() {
        List<Product> list = new ArrayList<>();
        try {
            File f = new File(DB_PATH);
            if (!f.exists()) { saveData(list); return list; }
            String raw = new String(Files.readAllBytes(f.toPath())).trim();
            if (raw.equals("[]") || raw.isEmpty()) return list;

            // Simple JSON array parser
            raw = raw.substring(1, raw.length() - 1).trim(); // remove [ ]
            for (String obj : splitObjects(raw)) {
                obj = obj.trim();
                if (obj.isEmpty()) continue;
                list.add(new Product(
                    parseInt(getField(obj, "id")),
                    getField(obj, "name"),
                    getField(obj, "description"),
                    parseDouble(getField(obj, "price")),
                    parseInt(getField(obj, "stock")),
                    getField(obj, "category")
                ));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    private void saveData(List<Product> products) {
        try {
            new File("data").mkdirs();
            StringBuilder sb = new StringBuilder("[\n");
            for (int i = 0; i < products.size(); i++) {
                Product p = products.get(i);
                sb.append("  {\n");
                sb.append("    \"id\": ").append(p.getId()).append(",\n");
                sb.append("    \"name\": \"").append(escape(p.getName())).append("\",\n");
                sb.append("    \"description\": \"").append(escape(p.getDescription())).append("\",\n");
                sb.append("    \"price\": ").append(p.getPrice()).append(",\n");
                sb.append("    \"stock\": ").append(p.getStock()).append(",\n");
                sb.append("    \"category\": \"").append(escape(p.getCategory())).append("\"\n");
                sb.append("  }");
                if (i < products.size() - 1) sb.append(",");
                sb.append("\n");
            }
            sb.append("]");
            Files.write(Paths.get(DB_PATH), sb.toString().getBytes());
        } catch (Exception e) { e.printStackTrace(); }
    }

    // ── JSON helpers ──────────────────────────────────────────

    private String getField(String obj, String key) {
        String search = "\"" + key + "\"";
        int ki = obj.indexOf(search);
        if (ki < 0) return "";
        int colon = obj.indexOf(":", ki + search.length());
        if (colon < 0) return "";
        String rest = obj.substring(colon + 1).trim();
        if (rest.startsWith("\"")) {
            int end = rest.indexOf("\"", 1);
            return end < 0 ? "" : rest.substring(1, end);
        } else {
            int end = rest.indexOf(",");
            int end2 = rest.indexOf("}");
            if (end < 0) end = end2;
            else if (end2 >= 0) end = Math.min(end, end2);
            return end < 0 ? rest.trim() : rest.substring(0, end).trim();
        }
    }

    private List<String> splitObjects(String raw) {
        List<String> objs = new ArrayList<>();
        int depth = 0, start = -1;
        for (int i = 0; i < raw.length(); i++) {
            char c = raw.charAt(i);
            if (c == '{') { if (depth == 0) start = i; depth++; }
            else if (c == '}') { depth--; if (depth == 0 && start >= 0) objs.add(raw.substring(start, i + 1)); }
        }
        return objs;
    }

    private String escape(String s) { return s == null ? "" : s.replace("\\","\\\\").replace("\"","\\\""); }
    private int    parseInt(String s)    { try { return Integer.parseInt(s.trim()); } catch(Exception e){ return 0; } }
    private double parseDouble(String s) { try { return Double.parseDouble(s.trim()); } catch(Exception e){ return 0.0; } }

    private int generateId(List<Product> products) {
        return products.stream().mapToInt(Product::getId).max().orElse(0) + 1;
    }

    // ── CRUD ──────────────────────────────────────────────────

    public boolean createProduct(String name, String description, double price, int stock, String category) {
        if (name == null || name.trim().isEmpty()) return false;
        if (price <= 0 || stock < 0) return false;
        List<Product> products = loadData();
        products.add(new Product(generateId(products), name.trim(), description.trim(), price, stock, category.trim()));
        saveData(products);
        return true;
    }

    public List<Product> listProducts() { return loadData(); }

    public Product findById(int id) {
        return loadData().stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    public boolean updateProduct(int id, String name, String description, double price, int stock, String category) {
        List<Product> products = loadData();
        for (Product p : products) {
            if (p.getId() == id) {
                if (name        != null && !name.isEmpty())     p.setName(name.trim());
                if (description != null)                        p.setDescription(description.trim());
                if (price > 0)                                  p.setPrice(price);
                if (stock >= 0)                                 p.setStock(stock);
                if (category    != null && !category.isEmpty()) p.setCategory(category.trim());
                saveData(products);
                return true;
            }
        }
        return false;
    }

    public boolean deleteProduct(int id) {
        List<Product> products = loadData();
        boolean removed = products.removeIf(p -> p.getId() == id);
        if (removed) saveData(products);
        return removed;
    }

    public List<Product> findByCategory(String category) {
        List<Product> result = new ArrayList<>();
        for (Product p : loadData())
            if (p.getCategory().toLowerCase().contains(category.toLowerCase()))
                result.add(p);
        return result;
    }
}
