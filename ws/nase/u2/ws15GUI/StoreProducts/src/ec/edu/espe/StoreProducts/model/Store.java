/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.StoreProducts.model;
import java.util.ArrayList;
/**
 *
 * @author sbart
 */
public class Store {
    private ArrayList<Product> products;

    public Store() {

        products = new ArrayList<>();
    }

    public void addProduct(Product product) {

        products.add(product);
    }

    public ArrayList<Product> getProducts() {

        return products;
    }

    public int calculateTotalItems() {

        int total = 0;

        for(Product product : products) {

            total += product.getQuantity();
        }

        return total;
    }

    public int getNumberProducts() {

        return products.size();
    }

}
