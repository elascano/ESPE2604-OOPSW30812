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
import ec.edu.espe.safestore.model.Reservation;
import ec.edu.espe.safestore.model.ReservationItem;
import ec.edu.espe.safestore.model.Product;
import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ReservationController {
    
    private static final String FILE_NAME = "reservations.json";
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private List<Reservation> reservations;
    private ProductController productController;
    
    public ReservationController() {
        reservations = new ArrayList<>();
        productController = new ProductController();
        loadFromFile();
        checkExpiredReservations();
    }
    
    private void loadFromFile() {
        try {
            File file = new File(FILE_NAME);
            if (file.exists()) {
                String content = new String(java.nio.file.Files.readAllBytes(file.toPath()));
                Type type = new TypeToken<ArrayList<Reservation>>(){}.getType();
                List<Reservation> loaded = gson.fromJson(content, type);
                if (loaded != null) {
                    reservations = loaded;
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading reservations: " + e.getMessage());
        }
    }
    
    private void saveToFile() {
        try {
            String json = gson.toJson(reservations);
            java.nio.file.Files.write(java.nio.file.Paths.get(FILE_NAME), json.getBytes());
        } catch (Exception e) {
            System.out.println("Error saving reservations: " + e.getMessage());
        }
    }
    
    public boolean addReservation(Reservation reservation) {
        reservations.add(reservation);
        saveToFile();
        return true;
    }
    
    public Reservation findById(int id) {
        for (Reservation r : reservations) {
            if (r.getReservationId() == id) {
                return r;
            }
        }
        return null;
    }
    
    public List<Reservation> getActiveReservations() {
        List<Reservation> active = new ArrayList<>();
        for (Reservation r : reservations) {
            if ("active".equals(r.getStatus())) {
                active.add(r);
            }
        }
        return active;
    }
    
    public List<Reservation> getAllReservations() {
        return new ArrayList<>(reservations);
    }
    
    public boolean addProductToReservation(int reservationId, int productId, int quantity) {
        Reservation reservation = findById(reservationId);
        if (reservation == null || !"active".equals(reservation.getStatus())) {
            return false;
        }
        
        Product product = productController.findById(productId);
        if (product == null || quantity > product.getStock()) {
            return false;
        }
        
        ReservationItem item = new ReservationItem(productId, product.getName(), quantity, product.getRetailPrice());
        reservation.addItem(item);
        
        productController.updateStock(productId, product.getStock() - quantity);
        saveToFile();
        return true;
    }
    
    public boolean completeReservation(int reservationId) {
        Reservation reservation = findById(reservationId);
        if (reservation == null || !"active".equals(reservation.getStatus())) {
            return false;
        }
        reservation.setStatus("completed");
        saveToFile();
        return true;
    }
    
    public boolean cancelReservation(int reservationId) {
        Reservation reservation = findById(reservationId);
        if (reservation == null || !"active".equals(reservation.getStatus())) {
            return false;
        }
        
        for (ReservationItem item : reservation.getItems()) {
            Product product = productController.findById(item.getProductId());
            if (product != null) {
                productController.updateStock(item.getProductId(), product.getStock() + item.getQuantity());
            }
        }
        
        reservation.setStatus("cancelled");
        saveToFile();
        return true;
    }
    
    public boolean extendReservation(int reservationId, int extraDays) {
        Reservation reservation = findById(reservationId);
        if (reservation == null || !"active".equals(reservation.getStatus())) {
            return false;
        }
        
        LocalDateTime newExpiry = reservation.getExpiryDate().plusDays(extraDays);
        reservation.setExpiryDate(newExpiry);
        saveToFile();
        return true;
    }
    
    private void checkExpiredReservations() {
        boolean changed = false;
        for (Reservation r : reservations) {
            if ("active".equals(r.getStatus()) && r.isExpired()) {
                r.setStatus("expired");
                changed = true;
            }
        }
        if (changed) {
            saveToFile();
        }
    }
}