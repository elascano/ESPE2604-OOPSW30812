
/**
 *
 * @author Alexander Tipantiza, The Softwarrios, @ESPE
 */
package ec.edu.espe.storeapp.model;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class DataRepository {
    private final String filePath;

    public DataRepository(String filePath) {
        this.filePath = filePath;
        ensureFileExists();
    }

    public List<Product> loadProducts() {
        List<Product> products = new ArrayList<>();
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath))).trim();
            if (content.isEmpty() || content.equals("[]")) return products;

            content = content.replace("[", "").replace("]", "").trim();
            if (content.isEmpty()) return products;

            String[] rawObjects = content.split("\\},\\s*\\{");
            for (String rawObj : rawObjects) {
                products.add(parseProductJson(rawObj));
            }
        } catch (Exception e) {
            return new ArrayList<>();
        }
        return products;
    }

    public void saveProducts(List<Product> products) {
        try (PrintWriter out = new PrintWriter(new FileWriter(filePath))) {
            StringBuilder json = new StringBuilder("[\n");
            for (int i = 0; i < products.size(); i++) {
                Product p = products.get(i);
                json.append("  {\n")
                    .append("    \"id\": ").append(p.getId()).append(",\n")
                    .append("    \"name\": \"").append(p.getName()).append("\",\n")
                    .append("    \"category\": \"").append(p.getCategory()).append("\",\n")
                    .append("    \"price\": ").append(p.getPrice()).append("\n")
                    .append("  }");
                if (i < products.size() - 1) json.append(",");
                json.append("\n");
            }
            json.append("]");
            out.print(json.toString());
        } catch (IOException e) {
            System.err.println("Error saving products: " + e.getMessage());
        }
    }

    private Product parseProductJson(String jsonBlock) {
        jsonBlock = jsonBlock.replace("{", "").replace("}", "").replaceAll("\"", "");
        int id = 0; String name = ""; String category = ""; double price = 0.0;

        for (String pair : jsonBlock.split(",")) {
            String[] keyValue = pair.split(":");
            String key = keyValue[0].trim();
            String value = keyValue[1].trim();

            switch (key) {
                case "id" -> id = Integer.parseInt(value);
                case "name" -> name = value;
                case "category" -> category = value;
                case "price" -> price = Double.parseDouble(value);
            }
        }
        return new Product(id, name, category, price);
    }

    private void ensureFileExists() {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
                saveProducts(new ArrayList<>());
            }
        } catch (IOException e) {
            System.err.println("Database file creation failed: " + e.getMessage());
        }
    }

    
}