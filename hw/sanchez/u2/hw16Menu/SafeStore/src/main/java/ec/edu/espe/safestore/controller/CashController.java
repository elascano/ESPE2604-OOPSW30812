/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.safestore.controller;

/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */

public class CashController {
    private double currentBalance;
    private boolean isOpen;
    
    public CashController() {
        this.currentBalance = 0;
        this.isOpen = false;
    }
    
    public boolean openCash(double initialAmount) {
        if (initialAmount < 0) {
            return false;
        }
        currentBalance = initialAmount;
        isOpen = true;
        return true;
    }
    
    public boolean closeCash(double physicalCount) {
        if (!isOpen) {
            return false;
        }
        isOpen = false;
        currentBalance = 0;
        return true;
    }
    
    public double calculateDifference(double physicalCount) {
        return physicalCount - currentBalance;
    }
    
    public boolean addIncome(double amount, String description) {
        if (!isOpen || amount < 0) {
            return false;
        }
        currentBalance += amount;
        return true;
    }
    
    public boolean addExpense(double amount, String description) {
        if (!isOpen || amount < 0 || amount > currentBalance) {
            return false;
        }
        currentBalance -= amount;
        return true;
    }
    
    public double getCurrentBalance() {
        return currentBalance;
    }
    
    public boolean isOpen() {
        return isOpen;
    }
}
