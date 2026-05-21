/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.Storeproducts.model;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
/**
 *
 * @author LABS-ESPE
 */
public class ProductManager {
    
    private ArrayList<Product> products;

    public ProductManager() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void saveToJson(String fileName) {

        Gson gson = new Gson();

        try (FileWriter writer = new FileWriter(fileName)) {

            gson.toJson(products, writer);

            System.out.println("Products saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }

    public void readFromJson(String fileName) {

        Gson gson = new Gson();

        try (FileReader reader = new FileReader(fileName)) {

            products = gson.fromJson(
                    reader,
                    new TypeToken<ArrayList<Product>>(){}.getType()
            );

            System.out.println("Products loaded successfully.");

        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }

   
    public int calculateTotalProducts() {

        int total = 0;

        for (Product product : products) {
            total += product.getQuantity();
        }

        return total;
    }

 
    public void showProductsTable() {

    System.out.println("\n__________________________________");
    System.out.println("         STORE PRODUCTS");
    System.out.println("__________________________________");

    System.out.printf("%-20s %-10s\n", "PRODUCT", "QUANTITY");

    System.out.println("__________________________________");

    int total = 0;

    for (Product product : products) {

        System.out.printf(
                "%-20s %-10d\n",
                product.getName(),
                product.getQuantity()
        );

        total += product.getQuantity();
    }

    System.out.println("__________________________________");
    System.out.println("TOTAL PRODUCTS IN STORE: " + total);
}
}
