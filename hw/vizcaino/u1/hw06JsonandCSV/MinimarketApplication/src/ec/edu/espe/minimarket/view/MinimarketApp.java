/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ec.edu.espe.minimarket.view;

import ec.edu.espe.minimarket.model.CashRegister;
import ec.edu.espe.minimarket.model.Product;
import ec.edu.espe.minimarket.model.PromotionalBundle;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Adrian Vizcaino <The Softwarriors at ESPE>
 */
public class MinimarketApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;
        
        do {
            System.out.println("\n      MINIMARKET APPLICATION\n");
            System.out.println("1. Sistema de Alertas de Caducidad");
            System.out.println("2. Sistema de Paquetes Promocionales");
            System.out.println("3. Sistema de Caja Registradora");
            System.out.println("4. Salir\n");
            System.out.print("Seleccione una opcion: ");
            option = scanner.nextInt();
          
            switch(option) {
                case 1:
                    systemExpirationAlerts();
                    break;
                case 2:
                    systemPromotionalBundles();
                    break;
                case 3:
                    systemCashRegister();
                    break;
                case 4:
                    System.out.println("\nGRACIAS POR USAR EL SISTEMA");
                    break;
                default:
                    System.out.println("\nOpcion no valida. Intente de nuevo.");
            }
        } while(option != 4);
    }
    
    public static void systemExpirationAlerts() {
        System.out.println("\n   SISTEMA DE ALERTAS DE CADUCIDAD\n");
        
        List<Product> products = Product.readCSV("data/products.csv");
        
        for (Product product : products) {
            product.calculateAndAssignDiscount();
        }
        
        System.out.println("\nREPORTE DE CADUCIDAD\n");
        for (Product product : products) {
            product.showAlert();
        }
        

        System.out.println("\nGENERANDO ARCHIVO JSON ");
        Product.exportToJSON(products, "data/productos.json");
        
        System.out.println("\nGRACIAS");
    }
    
    public static void systemPromotionalBundles() {
        System.out.println("\n    SISTEMA DE PAQUETES PROMOCIONALES\n");
        
        List<Product> products = Product.readCSV("data/products.csv");
        List<PromotionalBundle> bundles = PromotionalBundle.readCSV("data/promotional_bundles.csv");
        Map<String, Product> productMap = Product.getProductMap(products);
        Map<String, Integer> stockMap = Product.getStockMap(products);
        
        System.out.println("\nValidando Paquetes\n");
        
        for (PromotionalBundle bundle : bundles) {
            bundle.calculateProfitMargin(productMap);
            
            System.out.println("\nPaquete: " + bundle.getName());
            System.out.println("Precio: $" + bundle.getBundlePrice());
            System.out.println("Margen de ganancia: " + String.format("%.2f", bundle.getProfitMargin()) + "%");
            
            if (bundle.hasPositiveProfit() == true) {
                System.out.println("Rentable: Si");
            } else {
                System.out.println("Rentable: No");
            }
            
            if (bundle.hasEnoughStock(stockMap) == true) {
                System.out.println("Stock suficiente: Si");
            } else {
                System.out.println("Stock suficiente: No\n");
            }
        }
        
        System.out.println("\nGENERANDO ARCHIVO JSON");
        PromotionalBundle.exportToJSON(bundles, "data/paquetes.json");
        
        System.out.println("\nGRACIAS");
    }
    
    public static void systemCashRegister() {
        System.out.println("\n    SISTEMA DE CAJA REGISTRADORA\n");
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese el balance inicial de la caja: $");
        double startingBalance = scanner.nextDouble();
        
        System.out.print("Ingrese el total de ventas del dia: $");
        double totalSales = scanner.nextDouble();
        
        System.out.print("Ingrese los retiros de seguridad (si no hay, ingrese 0): $");
        double securityWithdrawals = scanner.nextDouble();
        
        CashRegister cashRegister = new CashRegister(startingBalance, totalSales, securityWithdrawals);
        
        System.out.print("\nIngrese el conteo fisico del dinero en caja: $");
        double physicalCount = scanner.nextDouble();
        
        cashRegister.setPhysicalCount(physicalCount);
        cashRegister.showReport();
        
        System.out.println("\nGENERANDO ARCHIVO JSON");
        cashRegister.exportToJSON("data/caja.json");
        
        System.out.println("\nGRACIAS");
    }
}