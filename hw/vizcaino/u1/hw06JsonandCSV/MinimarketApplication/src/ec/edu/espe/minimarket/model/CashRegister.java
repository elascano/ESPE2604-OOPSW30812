/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.minimarket.model;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Adrian Vizcaino <The Softwarriors at ESPE>
 */
public class CashRegister {
    private double startingBalance;
    private double totalSales;
    private double securityWithdrawals;
    private double expectedBalance;
    private double physicalCount;
    private double discrepancy;
    
    public CashRegister(double startingBalance, double totalSales, double securityWithdrawals) {
        this.startingBalance = startingBalance;
        this.totalSales = totalSales;
        this.securityWithdrawals = securityWithdrawals;
        this.expectedBalance = startingBalance + totalSales - securityWithdrawals;
        this.physicalCount = 0;
        this.discrepancy = 0;
    }
    
    public double getStartingBalance() {
        return startingBalance;
    }
    
    public double getTotalSales() {
        return totalSales;
    }
    
    public double getSecurityWithdrawals() {
        return securityWithdrawals;
    }
    
    public double getExpectedBalance() {
        return expectedBalance;
    }
    
    public double getPhysicalCount() {
        return physicalCount;
    }
    
    public double getDiscrepancy() {
        return discrepancy;
    }
    
    public void setStartingBalance(double startingBalance) {
        this.startingBalance = startingBalance;
        this.expectedBalance = this.startingBalance + this.totalSales - this.securityWithdrawals;
    }
    
    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
        this.expectedBalance = this.startingBalance + this.totalSales - this.securityWithdrawals;
    }
    
    public void setSecurityWithdrawals(double securityWithdrawals) {
        this.securityWithdrawals = securityWithdrawals;
        this.expectedBalance = this.startingBalance + this.totalSales - this.securityWithdrawals;
    }
    
    public void setPhysicalCount(double physicalCount) {
        this.physicalCount = physicalCount;
        this.discrepancy = this.physicalCount - this.expectedBalance;
    }
    
    public boolean isBalanced() {
        if (discrepancy == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public double getSurplus() {
        if (discrepancy > 0) {
            return discrepancy;
        } else {
            return 0;
        }
    }
    
    public double getShortage() {
        if (discrepancy < 0) {
            return Math.abs(discrepancy);
        } else {
            return 0;
        }
    }
    
    public void showReport() {
        System.out.println("\nCAJA REGISTRADORA\n");
        System.out.println("Balance inicial: $" + startingBalance);
        System.out.println("Total ventas: $" + totalSales);
        System.out.println("Retiros de seguridad: $" + securityWithdrawals);
        System.out.println("Balance esperado: $" + String.format("%.2f", expectedBalance));
        System.out.println("Conteo fisico: $" + String.format("%.2f", physicalCount));
        
        System.out.println("\n VERIFICACION");
        if (isBalanced() == true) {
            System.out.println("CAJA CUADRADA - No hay discrepancias");
        } else if (discrepancy > 0) {
            System.out.println("Sobra $" + String.format("%.2f", getSurplus()));
            System.out.println("Revisar si hubo errores en vueltos o ventas");
        } else {
            System.out.println("Falta $" + String.format("%.2f", getShortage()));
            System.out.println("Revisar posibles robos o errores en ventas");
        }
    }
    
    public void exportToJSON(String filePath) {
        try {
            com.google.gson.Gson gson = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
            FileWriter writer = new FileWriter(filePath);
            gson.toJson(this, writer);
            writer.close();
            System.out.println("Archivo JSON de caja generado: " + filePath);
        } catch (IOException e) {
            System.out.println("Error al generar JSON: " + e.getMessage());
        }
    }
}