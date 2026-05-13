/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.securestore.model;
import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Alexander Tipantiza, The Softwarrios, @ESPE
 */
public class FileManager {
    
     // -------- CSV --------
    public static void saveProductCSV(Product product) {
        try (FileWriter writer = new FileWriter("products.csv", true)) {

            writer.append(product.getId() + "," +
                          product.getName() + "," +
                          product.getStock() + "," +
                          product.getPrice() + "\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveCustomerCSV(CustomerAnalytics customer) {
        try (FileWriter writer = new FileWriter("customers.csv", true)) {

            writer.append(customer.getId() + "," +
                          customer.getCustomerName() + "," +
                          customer.getPurchaseCategory() + "\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveSupplierCSV(SupplierManager supplier) {
        try (FileWriter writer = new FileWriter("suppliers.csv", true)) {

            writer.append(supplier.getId() + "," +
                          supplier.getSupplierName() + "," +
                          supplier.getContactEmail() + "\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // -------- JSON --------
    public static void saveProductJSON(Product product) {
        Gson gson = new Gson();
        List<Product> products = new ArrayList<>();

        try {
            File file = new File("products.json");

            if (file.exists()) {
                FileReader reader = new FileReader(file);
                Type listType = new TypeToken<List<Product>>(){}.getType();
                products = gson.fromJson(reader, listType);
                reader.close();

                if (products == null) products = new ArrayList<>();
            }

            products.add(product);

            FileWriter writer = new FileWriter("products.json");
            gson.toJson(products, writer);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveCustomerJSON(CustomerAnalytics customer) {
        Gson gson = new Gson();
        List<CustomerAnalytics> customers = new ArrayList<>();

        try {
            File file = new File("customers.json");

            if (file.exists()) {
                FileReader reader = new FileReader(file);
                Type listType = new TypeToken<List<CustomerAnalytics>>(){}.getType();
                customers = gson.fromJson(reader, listType);
                reader.close();

                if (customers == null) customers = new ArrayList<>();
            }

            customers.add(customer);

            FileWriter writer = new FileWriter("customers.json");
            gson.toJson(customers, writer);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveSupplierJSON(SupplierManager supplier) {
        Gson gson = new Gson();
        List<SupplierManager> suppliers = new ArrayList<>();

        try {
            File file = new File("suppliers.json");

            if (file.exists()) {
                FileReader reader = new FileReader(file);
                Type listType = new TypeToken<List<SupplierManager>>(){}.getType();
                suppliers = gson.fromJson(reader, listType);
                reader.close();

                if (suppliers == null) suppliers = new ArrayList<>();
            }

            suppliers.add(supplier);

            FileWriter writer = new FileWriter("suppliers.json");
            gson.toJson(suppliers, writer);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
