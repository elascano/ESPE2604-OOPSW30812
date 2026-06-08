/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.*;


/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */

public class ExpirationControl {
    private static List<ExpirationAlert> alerts = new ArrayList<>();
    
    public static class ExpirationAlert {
        private int productId;
        private String productName;
        private String expiryDate;
        private int daysUntilExpiry;
        private boolean notificationSent;
        
        public ExpirationAlert(int productId, String productName, String expiryDate, int daysUntilExpiry) {
            this.productId = productId;
            this.productName = productName;
            this.expiryDate = expiryDate;
            this.daysUntilExpiry = daysUntilExpiry;
            this.notificationSent = false;
        }
        
        public int getProductId() { return productId; }
        public String getProductName() { return productName; }
        public String getExpiryDate() { return expiryDate; }
        public int getDaysUntilExpiry() { return daysUntilExpiry; }
        public boolean isNotificationSent() { return notificationSent; }
        public void setNotificationSent(boolean notificationSent) { this.notificationSent = notificationSent; }
    }
    
    public static List<ExpirationAlert> generateAlerts(List<ProductManagement.Product> products) {
        alerts.clear();
        Date currentDate = new Date();
        
        for (ProductManagement.Product product : products) {
            try {
                String expiryStr = product.getExpiryDate();
                if (expiryStr != null && !expiryStr.isEmpty()) {
                    Date expiryDate = java.text.DateFormat.getDateInstance().parse(expiryStr);
                    long diff = expiryDate.getTime() - currentDate.getTime();
                    int daysUntilExpiry = (int)(diff / (1000 * 60 * 60 * 24));
                    
                    if (daysUntilExpiry <= 30 && daysUntilExpiry >= 0) {
                        alerts.add(new ExpirationAlert(product.getId(), product.getName(), expiryStr, daysUntilExpiry));
                    }
                }
            } catch (Exception e) {
                System.out.println("Error parsing expiry date for product: " + product.getName());
            }
        }
        return alerts;
    }
    
    public static void sendNotifications() {
        for (ExpirationAlert alert : alerts) {
            if (!alert.isNotificationSent()) {
                System.out.println("NOTIFICATION: Product '" + alert.getProductName() + 
                                   "' expires in " + alert.getDaysUntilExpiry() + " days");
                alert.setNotificationSent(true);
            }
        }
    }
    
    public static List<ExpirationAlert> getActiveAlerts() {
        return new ArrayList<>(alerts);
    }
}
