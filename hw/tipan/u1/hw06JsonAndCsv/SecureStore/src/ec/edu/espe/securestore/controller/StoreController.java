/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.securestore.controller;

import ec.edu.espe.securestore.model.Product;
import ec.edu.espe.securestore.model.Sell;
import ec.edu.espe.securestore.model.Credit;

/**
 *
 * @author ronal
 */
public class StoreController {

    public static Product createProduct(int id, String name, double price) {
        return new Product(id, name, price);
    }

    public static Sell createSell(int id, Product product, int quantity) {
        return new Sell(id, product, quantity);
    }

    public static Credit createCredit(String clientName, double amount) {
        return new Credit(clientName, amount);
    }
} 