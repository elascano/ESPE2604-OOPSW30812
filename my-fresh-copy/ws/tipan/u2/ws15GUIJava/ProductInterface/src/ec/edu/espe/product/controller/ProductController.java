/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.product.controller;

import ec.edu.espe.product.view.ProductView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ronal
 */
public class ProductController {

    ProductView view;

    public ProductController(ProductView view) {

        this.view = view;

        this.view.btnAdd.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String product =
                        view.txtName.getText();

                double price =
                        Double.parseDouble(
                                view.txtPrice.getText()
                        );

                int quantity =
                        Integer.parseInt(
                                view.txtQuantity.getText()
                        );

                double total = price * quantity;

                view.lblTotal.setText(
                        "Total: $" + total
                );
            }
        });
    }
}