/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */

public class CreditManagement {
    private static final String CREDITS_FILE = "credits.json";
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static List<CreditAccount> accounts = new ArrayList<>();
    
    static {
        loadFromFile();
    }
    
    public static class CreditAccount {
        private int customerId;
        private String customerName;
        private double creditLimit;
        private double currentDebt;
        private List<Transaction> transactions;
        private boolean isBlocked;
        
        public CreditAccount() {
            this.transactions = new ArrayList<>();
            this.isBlocked = false;
        }
        
        public CreditAccount(int customerId, String customerName, double creditLimit) {
            this.customerId = customerId;
            this.customerName = customerName;
            this.creditLimit = creditLimit;
            this.currentDebt = 0;
            this.transactions = new ArrayList<>();
            this.isBlocked = false;
        }
        
        public int getCustomerId() { return customerId; }
        public void setCustomerId(int customerId) { this.customerId = customerId; }
        public String getCustomerName() { return customerName; }
        public void setCustomerName(String customerName) { this.customerName = customerName; }
        public double getCreditLimit() { return creditLimit; }
        public void setCreditLimit(double creditLimit) { this.creditLimit = creditLimit; }
        public double getCurrentDebt() { return currentDebt; }
        public void setCurrentDebt(double currentDebt) { this.currentDebt = currentDebt; }
        public List<Transaction> getTransactions() { return transactions; }
        public void setTransactions(List<Transaction> transactions) { this.transactions = transactions; }
        public boolean isBlocked() { return isBlocked; }
        public void setBlocked(boolean blocked) { isBlocked = blocked; }
        
        public boolean addDebt(double amount, String description) {
            if (isBlocked) {
                System.out.println("Account blocked. Cannot add debt.");
                return false;
            }
            if (currentDebt + amount > creditLimit) {
                System.out.printf("Credit limit exceeded. Limit: $%.2f, Current debt: $%.2f\n", creditLimit, currentDebt);
                return false;
            }
            currentDebt += amount;
            transactions.add(new Transaction(amount, description, "DEBT", new Date()));
            System.out.printf("Debt added: $%.2f (%s). New debt: $%.2f\n", amount, description, currentDebt);
            return true;
        }
        
        public boolean makePayment(double amount, String description) {
            if (amount > currentDebt) {
                System.out.println("Payment exceeds current debt");
                return false;
            }
            currentDebt -= amount;
            transactions.add(new Transaction(amount, description, "PAYMENT", new Date()));
            System.out.printf("Payment recorded: $%.2f (%s). Remaining debt: $%.2f\n", amount, description, currentDebt);
            return true;
        }
        
        @Override
        public String toString() {
            return String.format("ID:%d | %s | Limit:$%.2f | Debt:$%.2f | %s",
                customerId, customerName, creditLimit, currentDebt, isBlocked ? "BLOCKED" : "Active");
        }
    }
    
    public static class Transaction {
        private double amount;
        private String description;
        private String type;
        private Date date;
        
        public Transaction() {}
        
        public Transaction(double amount, String description, String type, Date date) {
            this.amount = amount;
            this.description = description;
            this.type = type;
            this.date = date;
        }
        
        public double getAmount() { return amount; }
        public void setAmount(double amount) { this.amount = amount; }
        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }
        public String getType() { return type; }
        public void setType(String type) { this.type = type; }
        public Date getDate() { return date; }
        public void setDate(Date date) { this.date = date; }
        
        @Override
        public String toString() {
            return String.format("%s | %s | $%.2f | %s", date, type, amount, description);
        }
    }
    
    public static void createAccount(CreditAccount account) {
        accounts.add(account);
        saveToFile();
    }
    
    public static CreditAccount findAccountById(int id) {
        return accounts.stream().filter(a -> a.getCustomerId() == id).findFirst().orElse(null);
    }
    
    public static List<CreditAccount> getAllAccounts() {
        return new ArrayList<>(accounts);
    }
    
    public static void saveToFile() {
        try {
            String json = gson.toJson(accounts);
            java.nio.file.Files.write(java.nio.file.Paths.get(CREDITS_FILE), json.getBytes());
        } catch (Exception e) {
            System.out.println("Error saving credits: " + e.getMessage());
        }
    }
    
    private static void loadFromFile() {
        try {
            File file = new File(CREDITS_FILE);
            if (file.exists()) {
                String content = new String(java.nio.file.Files.readAllBytes(file.toPath()));
                Type type = new TypeToken<ArrayList<CreditAccount>>(){}.getType();
                List<CreditAccount> loaded = gson.fromJson(content, type);
                if (loaded != null) {
                    accounts = loaded;
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading credits: " + e.getMessage());
        }
    }
}
