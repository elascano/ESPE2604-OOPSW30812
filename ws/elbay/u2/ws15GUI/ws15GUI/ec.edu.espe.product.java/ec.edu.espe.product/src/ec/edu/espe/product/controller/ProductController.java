package ec.edu.espe.product.controller;

import ec.edu.espe.product.model.Product;
import java.util.ArrayList;

public class ProductController {

    private ArrayList<Product> products;

    public ProductController() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void deleteProduct(String id) {

        Product productFound = null;

        for (Product product : products) {

            if (product.getId().equals(id)) {
                productFound = product;
            }
        }

        if (productFound != null) {
            products.remove(productFound);
        }
    }
}