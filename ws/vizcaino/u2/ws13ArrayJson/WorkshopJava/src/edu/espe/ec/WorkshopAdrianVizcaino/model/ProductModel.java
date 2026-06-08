/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.espe.ec.WorkshopAdrianVizcaino.model;

/**
 *
 * @author Adrian Vizcaino <The-Softwarrios at ESPE>
 */

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class ProductModel {

    private ArrayList<Product> products;

    public ProductModel() {

        products = loadProducts();
    }

    public void addProduct(Product p) {

        products.add(p);
        saveProducts();
    }

    public ArrayList<Product> getProducts() {

        return products;
    }

    public int totalProducts() {

        int total = 0;

        for (Product p : products) {

            total += p.getQuantity();
        }

        return total;
    }

    public void deleteProduct(int id) {

        Product productToRemove = null;

        for (Product p : products) {

            if (p.getId() == id) {

                productToRemove = p;
                break;
            }
        }

        if (productToRemove != null) {

            products.remove(productToRemove);
            saveProducts();

            System.out.println("Product deleted");
        } else {

            System.out.println("Product not found");
        }
    }

    public void saveProducts() {

        Gson gson = new Gson();

        try {

            FileWriter writer =
                    new FileWriter("products.json");

            gson.toJson(products, writer);

            writer.close();

        } catch (Exception e) {

            System.out.println("Error saving JSON");
        }
    }

    public ArrayList<Product> loadProducts() {

        Gson gson = new Gson();

        try {

            FileReader reader =
                    new FileReader("products.json");

            Type type =
                    new TypeToken<ArrayList<Product>>(){}.getType();

            ArrayList<Product> list =
                    gson.fromJson(reader, type);

            reader.close();

            return list;

        } catch (Exception e) {

            return new ArrayList<>();
        }
    }
}