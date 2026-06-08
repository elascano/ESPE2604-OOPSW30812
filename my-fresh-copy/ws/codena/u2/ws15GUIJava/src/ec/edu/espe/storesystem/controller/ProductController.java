// ProductController.java
package ec.edu.espe.storesystem.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ec.edu.espe.storesystem.model.Product;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ProductController {

    private static final String FILE_NAME = "products.json";

    // SAVE PRODUCTS

    public void saveProduct(Product product) {

        Gson gson = new Gson();

        List<Product> products = readProducts();

        products.add(product);

        try (FileWriter writer = new FileWriter(FILE_NAME)) {

            gson.toJson(products, writer);

        } catch (IOException e) {

            System.out.println("Error saving file");
        }
    }

    // READ PRODUCTS

    public List<Product> readProducts() {

        Gson gson = new Gson();

        try {

            FileReader reader = new FileReader(FILE_NAME);

            Type productListType =
                    new TypeToken<ArrayList<Product>>() {}.getType();

            List<Product> products =
                    gson.fromJson(reader, productListType);

            reader.close();

            if (products == null) {
                return new ArrayList<>();
            }

            return products;

        } catch (IOException e) {

            return new ArrayList<>();
        }
    }
}