/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.safestore.model;

/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Reservation {
    private int reservationId;
    private int customerId;
    private String customerName;
    private String customerPhone;
    private List<ReservationItem> items;
    private LocalDateTime reservationDate;
    private LocalDateTime expiryDate;
    private String status;
    private String notes;
    
    public Reservation() {
        this.items = new ArrayList<>();
        this.reservationDate = LocalDateTime.now();
        this.expiryDate = LocalDateTime.now().plusDays(2);
        this.status = "active";
    }
    
    public Reservation(int reservationId, int customerId, String customerName, String customerPhone, LocalDateTime expiryDate) {
        this.reservationId = reservationId;
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.expiryDate = expiryDate;
        this.items = new ArrayList<>();
        this.reservationDate = LocalDateTime.now();
        this.status = "active";
        this.notes = "";
    }
    
    public int getReservationId() { return reservationId; }
    public void setReservationId(int reservationId) { this.reservationId = reservationId; }
    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public String getCustomerPhone() { return customerPhone; }
    public void setCustomerPhone(String customerPhone) { this.customerPhone = customerPhone; }
    public List<ReservationItem> getItems() { return items; }
    public void setItems(List<ReservationItem> items) { this.items = items; }
    public LocalDateTime getReservationDate() { return reservationDate; }
    public void setReservationDate(LocalDateTime reservationDate) { this.reservationDate = reservationDate; }
    public LocalDateTime getExpiryDate() { return expiryDate; }
    public void setExpiryDate(LocalDateTime expiryDate) { this.expiryDate = expiryDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
    
    public void addItem(ReservationItem item) {
        items.add(item);
    }
    
    public double getTotalValue() {
        return items.stream().mapToDouble(ReservationItem::getTotalPrice).sum();
    }
    
    public boolean isExpired() {
        return LocalDateTime.now().isAfter(expiryDate);
    }
    
    @Override
    public String toString() {
        return "Reservation{reservationId=" + reservationId + ", customerName=" + customerName + ", status=" + status + "}";
    }
}
