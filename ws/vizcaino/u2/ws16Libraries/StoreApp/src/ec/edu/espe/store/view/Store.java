/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.store.view;

import ec.edu.espe.store.model.Product;
import utils.Tax;

/**
 *
 * @author Adrian Vizcaino <The-Softwarrios at ESPE>
 */
public class Store {
    public static void main (String [] args){
    int id;
    String description;
    float price;
    float pvp;
    Product product;
    //TODO read from Keyboard
    
    id = 1;
    description = "computer";
    price = 100;
    
    pvp=Tax.computeTotal(price, 15F);
    
    product = new Product (id, description, price);
    
    System.out.println("Product --->" + product);
    
    Product product2;
    
    id = 2;
    description = "Mouse";
    price = 1000;
    
    pvp=Tax.computeTotal(price, 15F);
    
    product2 = new Product(id, description, price, pvp);
    
    System.out.println("Product2 --->" + product2);
            
    }
} 
