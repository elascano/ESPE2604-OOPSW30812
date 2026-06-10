/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.safestore.controller;

/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ec.edu.espe.safestore.model.CreditAccount;
import ec.edu.espe.safestore.model.Transaction;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CreditController {
    
    private static final String FILE_NAME = "credits.json";
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private List<CreditAccount> accounts;
    
    public CreditController() {
        accounts = new ArrayList<>();
        loadFromFile();
    }
    
    private void loadFromFile() {
        try {
            File file = new File(FILE_NAME);
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
    
    private void saveToFile() {
        try {
            String json = gson.toJson(accounts);
            java.nio.file.Files.write(java.nio.file.Paths.get(FILE_NAME), json.getBytes());
        } catch (Exception e) {
            System.out.println("Error saving credits: " + e.getMessage());
        }
    }
    
    public boolean addAccount(CreditAccount account) {
        if (findByCustomerId(account.getCustomerId()) != null) {
            return false;
        }
        accounts.add(account);
        saveToFile();
        return true;
    }
    
    public CreditAccount findByCustomerId(int customerId) {
        for (CreditAccount a : accounts) {
            if (a.getCustomerId() == customerId) {
                return a;
            }
        }
        return null;
    }
    
    public List<CreditAccount> getAllAccounts() {
        return new ArrayList<>(accounts);
    }
    
    public boolean addDebt(int customerId, double amount, String description) {
        CreditAccount account = findByCustomerId(customerId);
        if (account == null || account.isBlocked()) {
            return false;
        }
        
        if (account.getCurrentDebt() + amount > account.getCreditLimit()) {
            return false;
        }
        
        Transaction transaction = new Transaction(amount, description, "DEBT", new Date());
        account.addTransaction(transaction);
        saveToFile();
        return true;
    }
    
    public boolean makePayment(int customerId, double amount, String description) {
        CreditAccount account = findByCustomerId(customerId);
        if (account == null) {
            return false;
        }
        
        if (amount > account.getCurrentDebt()) {
            return false;
        }
        
        Transaction transaction = new Transaction(amount, description, "PAYMENT", new Date());
        account.addTransaction(transaction);
        saveToFile();
        return true;
    }
    
    public boolean blockAccount(int customerId) {
        CreditAccount account = findByCustomerId(customerId);
        if (account == null) {
            return false;
        }
        account.setBlocked(true);
        saveToFile();
        return true;
    }
    
    public boolean unblockAccount(int customerId) {
        CreditAccount account = findByCustomerId(customerId);
        if (account == null) {
            return false;
        }
        account.setBlocked(false);
        saveToFile();
        return true;
    }
    
    public List<Transaction> getTransactions(int customerId) {
        CreditAccount account = findByCustomerId(customerId);
        if (account == null) {
            return new ArrayList<>();
        }
        return account.getTransactions();
    }
}
