package ec.edu.espe.productweight.controller;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ec.edu.espe.productweight.model.Product;
import ec.edu.espe.productweight.view.ProductView;


import java.io.FileReader;
import java.io.FileWriter;

import java.lang.reflect.Type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductController {

    private ProductView view;

    private List<Product> products;

    private final String filePath =
            "data/products.json";

    public ProductController(ProductView view) {

        this.view = view;

        products = new ArrayList<>();
    }

    public void addProduct(
            String name,
            double weightPounds
    ) {

        Product product =
                new Product(
                        name,
                        weightPounds
                );

        products.add(product);
    }

    public void saveProductsToJSON() {

        try {

            Gson gson =
                    new GsonBuilder()
                            .setPrettyPrinting()
                            .create();

            FileWriter writer =
                    new FileWriter(filePath);

            gson.toJson(products, writer);

            writer.close();

            view.showMessage(
                    "\nProducts saved successfully."
            );

        } catch (Exception e) {

            view.showMessage(
                    "\nError saving JSON file."
            );
        }
    }

    public void readProductsAndConvert() {

        try {

            Gson gson = new Gson();

            FileReader reader =
                    new FileReader(filePath);

            Type listType =
                    new TypeToken<
                            List<Product>>() {
                    }.getType();

            List<Product> products =
                    gson.fromJson(
                            reader,
                            listType
                    );

            reader.close();

            List<Map<String, Object>>
                    convertedProducts =
                    new ArrayList<>();

            for (Product product : products) {

                double kilograms =
                        product.getWeightPounds()
                                * 0.453592;

                Map<String, Object> data =
                        new HashMap<>();

                data.put(
                        "name",
                        product.getName()
                );

                data.put(
                        "weightKilograms",
                        kilograms
                );

                convertedProducts.add(data);
            }

            view.showProducts(
                    convertedProducts
            );

        } catch (Exception e) {

            view.showMessage(
                    "\nError reading JSON file."
            );
        }
    }
}