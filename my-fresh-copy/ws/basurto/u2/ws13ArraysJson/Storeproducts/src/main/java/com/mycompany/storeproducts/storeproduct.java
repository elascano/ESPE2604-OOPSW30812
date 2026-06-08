/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.storeproducts;

import ec.edu.espe.product.view.ProductView;
import productcontroller.ProductController;

/**
 *
 * @author Esteban Basurto , CodeBreakers, @ESPE
 */
public class storeproduct {
    public static void main(String[] args) {
        // Initialize View and Controller
        ProductView view = new ProductView();
        ProductController controller = new ProductController(view);

        // Simulating adding gardening and plant items to the cart
        controller.addProduct("Snake Plant", 15.50, 2);
        controller.addProduct("Ceramic Pot", 8.25, 3);
        controller.addProduct("Organic Fertilizer", 12.00, 1);
        controller.addProduct("Watering Can", 18.90, 1);
        controller.addProduct("Succulent Mix Soil", 6.50, 4);

        // Process logic and generate JSON output
        controller.processSale();
    }
}
