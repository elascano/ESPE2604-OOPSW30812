/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.product.model;

import ec.edu.espe.product.view.ProductView;
import ec.edu.espe.product.controller.ProductController;

/**
 *
 * @author ronal
 */
public class ProductModel {

    public static void main(String[] args) {

        ProductView view = new ProductView();

        ProductController controller =
                new ProductController(view);

        view.setVisible(true);
    }
}