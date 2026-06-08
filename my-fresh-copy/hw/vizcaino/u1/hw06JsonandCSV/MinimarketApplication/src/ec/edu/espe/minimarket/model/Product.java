/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.minimarket.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Adrian Vizcaino <The Softwarriors at ESPE>
 */

public class Product {
    private String id;
    private String name;
    private String expirationDate;
    private int stock;
    private double price;
    private int discount;
    
    public Product(String id, String name, String expirationDate, int stock, double price) {
        this.id = id;
        this.name = name;
        this.expirationDate = expirationDate;
        this.stock = stock;
        this.price = price;
        this.discount = 0;
    }
    
    public String getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getExpirationDate() {
        return expirationDate;
    }
    
    public int getStock() {
        return stock;
    }
    
    public double getPrice() {
        return price;
    }
    
    public int getDiscount() {
        return discount;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
    
    public void setStock(int stock) {
        this.stock = stock;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public void setDiscount(int discount) {
        this.discount = discount;
    }
    
    public double getPriceWithDiscount() {
        return price * (100 - discount) / 100;
    }
    
    public long calculateDaysUntilExpiration() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate expiration = LocalDate.parse(this.expirationDate, formatter);
        return today.until(expiration).getDays();
    }
    
    public void calculateAndAssignDiscount() {
        long days = this.calculateDaysUntilExpiration();
        
        if (days <= 2 && days >= 0) {
            this.discount = 50;
        } else if (days <= 4) {
            this.discount = 25;
        } else if (days <= 7) {
            this.discount = 10;
        } else {
            this.discount = 0;
        }
    }
    
    public static List<Product> readCSV(String filePath) {
        List<Product> products = new ArrayList<>();
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            br.readLine();
            
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                
                String id = data[0];
                String name = data[1];
                String expirationDate = data[2];
                int stock = Integer.parseInt(data[3]);
                double price = Double.parseDouble(data[4]);
                
                Product product = new Product(id, name, expirationDate, stock, price);
                products.add(product);
            }
            br.close();
            System.out.println("Archivo CSV leido correctamente");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo CSV: " + e.getMessage());
        }
        return products;
    }
    
    public void showAlert() {
        long days = this.calculateDaysUntilExpiration();
        
        System.out.println("Producto: " + this.name);
        System.out.println("ID: " + this.id);
        System.out.println("Stock actual: " + this.stock);
        System.out.println("Dias hasta caducar: " + days);
        
        if (days <= 7 && days >= 0) {
            System.out.println("ALERTA Producto proximo a caducar");
            System.out.println("Descuento sugerido: " + this.discount + "%");
            System.out.println("Precio original: $" + this.price);
            System.out.println("Precio con descuento: $" + String.format("%.2f\n", this.getPriceWithDiscount()));
        } else if (days < 0) {
            System.out.println("Producto caducado Retirar del stock inmediatamente\n");
        } else {
            System.out.println("Producto en buen estado\n");
        }
    }
    
    public static Map<String, Product> getProductMap(List<Product> products) {
        Map<String, Product> productMap = new java.util.HashMap<>();
        for (Product p : products) {
            productMap.put(p.getName(), p);
        }
        return productMap;
    }
    
    public static Map<String, Integer> getStockMap(List<Product> products) {
        Map<String, Integer> stockMap = new java.util.HashMap<>();
        for (Product p : products) {
            stockMap.put(p.getName(), p.getStock());
        }
        return stockMap;
    }
    
    public static void exportToJSON(List<Product> products, String filePath) {
        try {
            com.google.gson.Gson gson = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
            FileWriter writer = new FileWriter(filePath);
            gson.toJson(products, writer);
            writer.close();
            System.out.println("Archivo JSON de productos generado: " + filePath);
        } catch (IOException e) {
            System.out.println("Error al generar JSON: " + e.getMessage());
        }
    }
}