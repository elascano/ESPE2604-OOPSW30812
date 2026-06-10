package ec.edu.espe.Billing.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ec.edu.espe.Billing.model.Customer;
import ec.edu.espe.Billing.model.Product;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * 
 *
 * @author Christopher Lomas
 */
public class InvoiceController {

    private static final String PRODUCT_JSON = "product.json";
    private static final String CUSTOMER_JSON = "customer.json";

    public static void saveInventory(ArrayList<Product> inventory) {
        saveAsJSON(inventory, PRODUCT_JSON);
    }

    public static ArrayList<Product> loadInventory() {
        return loadFromJSON(new TypeToken<ArrayList<Product>>() {}.getType(), PRODUCT_JSON);
    }

    public static void saveCustomers(ArrayList<Customer> customers) {
        saveAsJSON(customers, CUSTOMER_JSON);
    }

    public static ArrayList<Customer> loadCustomers() {
        return loadFromJSON(new TypeToken<ArrayList<Customer>>() {}.getType(), CUSTOMER_JSON);
    }

    private static <T> void saveAsJSON(ArrayList<T> list, String fileName) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(fileName)) {
            gson.toJson(list, writer);
        } catch (IOException e) {
            System.err.println("Error al guardar " + fileName + ": " + e.getMessage());
        }
    }

    private static <T> ArrayList<T> loadFromJSON(Type type, String fileName) {
        Gson gson = new Gson();
        try (Reader reader = new FileReader(fileName)) {
            ArrayList<T> list = gson.fromJson(reader, type);
            return list != null ? list : new ArrayList<>();
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
}
