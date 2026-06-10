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
import ec.edu.espe.safestore.model.Combo;
import ec.edu.espe.safestore.model.ComboItem;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ComboController {
    
    private static final String FILE_NAME = "combos.json";
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private List<Combo> combos;
    private ProductController productController;
    
    public ComboController() {
        combos = new ArrayList<>();
        productController = new ProductController();
        loadFromFile();
    }
    
    private void loadFromFile() {
        try {
            File file = new File(FILE_NAME);
            if (file.exists()) {
                String content = new String(java.nio.file.Files.readAllBytes(file.toPath()));
                Type type = new TypeToken<ArrayList<Combo>>(){}.getType();
                List<Combo> loaded = gson.fromJson(content, type);
                if (loaded != null) {
                    combos = loaded;
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading combos: " + e.getMessage());
        }
    }
    
    private void saveToFile() {
        try {
            String json = gson.toJson(combos);
            java.nio.file.Files.write(java.nio.file.Paths.get(FILE_NAME), json.getBytes());
        } catch (Exception e) {
            System.out.println("Error saving combos: " + e.getMessage());
        }
    }
    
    public boolean addCombo(Combo combo) {
        if (findById(combo.getId()) != null) {
            return false;
        }
        combos.add(combo);
        saveToFile();
        return true;
    }
    
    public boolean updateCombo(Combo combo) {
        Combo existing = findById(combo.getId());
        if (existing == null) {
            return false;
        }
        existing.setName(combo.getName());
        existing.setDescription(combo.getDescription());
        existing.setComboPrice(combo.getComboPrice());
        saveToFile();
        return true;
    }
    
    public boolean deleteCombo(int id) {
        Combo existing = findById(id);
        if (existing == null) {
            return false;
        }
        combos.remove(existing);
        saveToFile();
        return true;
    }
    
    public Combo findById(int id) {
        for (Combo c : combos) {
            if (c.getId() == id) {
                return c;
            }
               }
        return null;
    }
    
    public List<Combo> getAllCombos() {
        return new ArrayList<>(combos);
    }
    
    public boolean addProductToCombo(int comboId, int productId, int quantity) {
        Combo combo = findById(comboId);
        if (combo == null) {
            return false;
        }
        
        ec.edu.espe.safestore.model.Product product = productController.findById(productId);
        if (product == null) {
            return false;
        }
        
        ComboItem item = new ComboItem(productId, product.getName(), product.getRetailPrice(), quantity);
        combo.addItem(item);
        saveToFile();
        return true;
    }
    
    public boolean activateCombo(int id) {
        Combo combo = findById(id);
        if (combo == null) {
            return false;
        }
        combo.setActive(true);
        saveToFile();
        return true;
    }
    
    public boolean deactivateCombo(int id) {
        Combo combo = findById(id);
        if (combo == null) {
            return false;
        }
        combo.setActive(false);
        saveToFile();
        return true;
    }
}
