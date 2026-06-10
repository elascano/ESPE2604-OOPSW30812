package ec.edu.espe.Billing.model;

import java.util.Scanner;


 // @author Didier Elbay <Code_Bros , @ESPE>

 
public class Product {

    private String id;
    private String name;
    private double unitPrice;
    private int stock;
    private static final double IVA_RATE = 0.15;
    private transient Scanner input = new Scanner(System.in);

    public Product() {
        this.id = null;
        this.name = null;
        this.unitPrice = 0;
        this.stock = 0;
    }

    public Product(String id, String name, double unitPrice, int stock) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
        this.stock = stock;
    }


    public double getPriceWithIva() {
        return unitPrice * (1 + IVA_RATE);
    }


    public double calculateSubtotal(int quantity) {
        return unitPrice * quantity;
    }


    public double calculateTotalWithIva(int quantity) {
        return calculateSubtotal(quantity) * (1 + IVA_RATE);
    }


    public double[] calculateSaleTotals(int quantity) {
        return new double[]{calculateSubtotal(quantity), calculateTotalWithIva(quantity)};
    }


    public boolean reduceStock(int quantity) {
        if (quantity <= stock) {
            stock -= quantity;
            return true;
        } else {
            System.out.println("Error: Stock insuficiente. Solo quedan " + stock + " unidades.");
            return false;
        }
    }

// @author Christopher Lomas <Code_Bros , @ESPE>
    public double calculateInventoryValue() {
        return unitPrice * stock;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void informationEntry() {
        System.out.println("* * * * * * * * * * Ingreso de información del producto * * * * * * * * * * ");
        System.out.print("Ingrese el ID del producto: ");
        id = input.nextLine();
        System.out.print("Ingrese el nombre del producto: ");
        name = input.nextLine();
        System.out.print("Ingrese el precio unitario: ");
        unitPrice = input.nextDouble();
        System.out.print("Ingrese la cantidad en stock: ");
        stock = input.nextInt();
        
    }

    public void showInformation() {
        System.out.println("* * * * * * * * * * * * Información del producto " + id + " * * * * * * * * * * * * ");
        System.out.println("Nombre del producto: " + name);
        System.out.println("ID del producto: " + id);
        System.out.println("Precio unitario: $" + unitPrice);
        System.out.println("Precio de venta (con 15% IVA): $" + getPriceWithIva());
        System.out.println("Stock disponible: " + stock);
        System.out.println("Valor total del inventario: $" + calculateInventoryValue());
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * ");
    }
}
