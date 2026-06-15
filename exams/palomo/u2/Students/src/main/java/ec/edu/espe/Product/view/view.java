/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.Product.view;
import java.util.List;
import ec.edu.espe.Product.model;
/**
 *
 * @author Cristian Palmo,Error 404 @ESPE
 */
public class ProductFormView {

    public void printHeader() {
        System.out.println("========================================================");
        System.out.println("          SISTEMA DE GESTIÓN DE PRODUCTOS - ACME        ");
        System.out.println("========================================================\n");
    }

    public void printSection(String title) {
        System.out.println(">>> " + title + " <<<");
    }

    // Diseñado para la opción de "Listar Todo" (Student 2)
    public void displayProductTable(List<Product> products) {
        if (products.isEmpty()) {
            System.out.println("No hay productos registrados en el inventario.");
            return;
        }
        System.out.println("--------------------------------------------------------------------------------");
        System.out.printf("%-10s %-25s %-15s %-10s %-15s\n", "ID", "DESCRIPCIÓN", "PRECIO UNIT.", "STOCK", "VALOR TOTAL");
        System.out.println("--------------------------------------------------------------------------------");
        for (Product p : products) {
            System.out.printf("%-10s %-25s $%-14.2f %-10d $%-14.2f\n", 
                    p.getId(), p.getName(), p.getUnitPrice(), p.getQuantity(), p.calculateInventoryValue());
        }
        System.out.println("--------------------------------------------------------------------------------\n");
    }

    // Diseñado para la opción de "Buscar por ID" (Student 3)
    public void displaySingleProduct(Product p) {
        if (p == null) {
            System.out.println("[Error] Producto no encontrado.\n");
            return;
        }
        System.out.println("Detalles del Producto Encontrado:");
        System.out.println(" -> ID: " + p.getId());
        System.out.println(" -> Descripción: " + p.getName());
        System.out.println(" -> Precio Unitario: $" + p.getUnitPrice());
        System.out.println(" -> Cantidad en Stock: " + p.getQuantity());
        System.out.println(" -> Valor en Inventario: $" + p.calculateInventoryValue() + "\n");
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
