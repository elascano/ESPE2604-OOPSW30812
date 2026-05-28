package ec.edu.espe.ProductPriceJava.model;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Angie Nacato, Error 404, @ESPE
 */
public class ProductModel {
    private final String jsonFile;
    private final double vatPercentage;
    private final Gson gson;

    public ProductModel() {
        this.jsonFile = "products.json";
        this.vatPercentage = 0.15;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.verifyOrCreateCatalog();
    }

    public final void verifyOrCreateCatalog() {
        File file = new File(jsonFile);
        if (!file.exists()) {
            List<Product> defaultItems = new ArrayList<>();
            defaultItems.add(new Product(1, "Laptop", 850.00));
            defaultItems.add(new Product(2, "Desktop PC", 1200.00));
            defaultItems.add(new Product(3, "Optical Mouse", 25.50));
            defaultItems.add(new Product(4, "16GB RAM Stick", 65.00));
            defaultItems.add(new Product(5, "24-inch Monitor", 180.00));
            saveCatalog(defaultItems);
        }
    }

    public void saveCatalog(List<Product> productList) {
        try (FileWriter writer = new FileWriter(jsonFile)) {
            gson.toJson(productList, writer);
        } catch (IOException e) {
            System.err.println("Error saving catalog: " + e.getMessage());
        }
    }

    public List<Product> readCatalog() {
        File file = new File(jsonFile);
        if (!file.exists()) return new ArrayList<>();
        
        try (FileReader reader = new FileReader(file)) {
            Type listType = new TypeToken<ArrayList<Product>>(){}.getType();
            List<Product> catalog = gson.fromJson(reader, listType);
            return catalog != null ? catalog : new ArrayList<>();
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    public double[] calculateItemValues(double basePrice) {
        double vat = basePrice * this.vatPercentage;
        double total = basePrice + vat;
        return new double[]{
            Math.round(vat * 100.0) / 100.0, 
            Math.round(total * 100.0) / 100.0
        };
    }

    public double[] calculateListTotals(List<Product> chosenProducts) {
        double subtotalAcumulado = 0.0;
        double vatAcumulado = 0.0;
        double totalAcumulado = 0.0;

        for (Product p : chosenProducts) {
            subtotalAcumulado += p.getPrice();
            vatAcumulado += p.getVat();
            totalAcumulado += p.getTotal();
        }

        double finalSubtotal = Math.round(subtotalAcumulado * 100.0) / 100.0;
        double finalVat = Math.round(vatAcumulado * 100.0) / 100.0;
        double finalTotal = Math.round(totalAcumulado * 100.0) / 100.0;

        return new double[]{finalSubtotal, finalVat, finalTotal};
    }
}
