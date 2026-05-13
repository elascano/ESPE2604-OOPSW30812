/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.minimarket.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */
public class PromotionalBundle {
    private String bundleId;
    private String name;
    private String product1;
    private int quantity1;
    private String product2;
    private int quantity2;
    private String product3;
    private int quantity3;
    private double bundlePrice;
    private double profitMargin;
    
    public PromotionalBundle(String bundleId, String name, String product1, int quantity1,
                             String product2, int quantity2, String product3, int quantity3, double bundlePrice) {
        this.bundleId = bundleId;
        this.name = name;
        this.product1 = product1;
        this.quantity1 = quantity1;
        this.product2 = product2;
        this.quantity2 = quantity2;
        this.product3 = product3;
        this.quantity3 = quantity3;
        this.bundlePrice = bundlePrice;
        this.profitMargin = 0;
    }
    
    public String getBundleId() {
        return bundleId;
    }
    
    public String getName() {
        return name;
    }
    
    public String getProduct1() {
        return product1;
    }
    
    public int getQuantity1() {
        return quantity1;
    }
    
    public String getProduct2() {
        return product2;
    }
    
    public int getQuantity2() {
        return quantity2;
    }
    
    public String getProduct3() {
        return product3;
    }
    
    public int getQuantity3() {
        return quantity3;
    }
    
    public double getBundlePrice() {
        return bundlePrice;
    }
    
    public double getProfitMargin() {
        return profitMargin;
    }
    
    public void setBundleId(String bundleId) {
        this.bundleId = bundleId;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setBundlePrice(double bundlePrice) {
        this.bundlePrice = bundlePrice;
    }
    
    public void setProfitMargin(double profitMargin) {
        this.profitMargin = profitMargin;
    }
    
    public static List<PromotionalBundle> readCSV(String filePath) {
        List<PromotionalBundle> bundles = new ArrayList<>();
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            br.readLine();
            
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                
                String bundleId = data[0];
                String name = data[1];
                String product1 = data[2];
                int quantity1 = Integer.parseInt(data[3]);
                String product2 = data[4];
                int quantity2 = Integer.parseInt(data[5]);
                String product3 = data[6];
                int quantity3 = Integer.parseInt(data[7]);
                double bundlePrice = Double.parseDouble(data[8]);
                
                PromotionalBundle bundle = new PromotionalBundle(bundleId, name, product1, quantity1,
                                                                 product2, quantity2, product3, quantity3, bundlePrice);
                bundles.add(bundle);
            }
            br.close();
            System.out.println("Archivo de paquetes leido correctamente");
        } catch (IOException e) {
            System.out.println("Error al leer paquetes: " + e.getMessage());
        }
        return bundles;
    }
    
    public double calculateCostPrice(Map<String, Product> productMap) {
        double totalCost = 0;
        
        totalCost = totalCost + getProductCost(product1, quantity1, productMap);
        totalCost = totalCost + getProductCost(product2, quantity2, productMap);
        totalCost = totalCost + getProductCost(product3, quantity3, productMap);
        
        return totalCost;
    }
    
    private double getProductCost(String productName, int quantity, Map<String, Product> productMap) {
        if (productName == null || productName.equals("0") || quantity == 0) {
            return 0;
        }
        
        for (Product p : productMap.values()) {
            if (p.getName().equalsIgnoreCase(productName)) {
                return p.getPrice() * quantity;
            }
        }
        return 0;
    }
    
    public void calculateProfitMargin(Map<String, Product> productMap) {
        double totalCost = this.calculateCostPrice(productMap);
        this.profitMargin = ((this.bundlePrice - totalCost) / this.bundlePrice) * 100;
    }
    
    public boolean hasPositiveProfit() {
        if (profitMargin > 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean hasEnoughStock(Map<String, Integer> stockMap) {
        if (stockMap.containsKey(product1) && stockMap.get(product1) < quantity1) {
            return false;
        }
        if (stockMap.containsKey(product2) && stockMap.get(product2) < quantity2) {
            return false;
        }
        if (stockMap.containsKey(product3) && stockMap.get(product3) < quantity3) {
            return false;
        }
        return true;
    }
    
    public static void exportToJSON(List<PromotionalBundle> bundles, String filePath) {
        try {
            com.google.gson.Gson gson = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
            FileWriter writer = new FileWriter(filePath);
            gson.toJson(bundles, writer);
            writer.close();
            System.out.println("Archivo JSON de paquetes generado: " + filePath);
        } catch (IOException e) {
            System.out.println("Error al generar JSON: " + e.getMessage());
        }
    }
}