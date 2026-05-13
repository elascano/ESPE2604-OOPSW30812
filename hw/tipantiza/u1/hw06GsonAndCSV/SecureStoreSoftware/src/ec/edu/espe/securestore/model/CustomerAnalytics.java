/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.securestore.model;

/**
 *
 * @author Alexander Tipantiza, The Softwarrios, @ESPE
 */
public class CustomerAnalytics {
     private int id;
    private String customerName;
    private String purchaseCategory;

    public CustomerAnalytics(int id, String customerName, String purchaseCategory) {
        this.id = id;
        this.customerName = customerName;
        this.purchaseCategory = purchaseCategory;
    }

    @Override
    public String toString() {
        return "CustomerAnalytics{" + "id=" + id + ", customerName=" + customerName + ", purchaseCategory=" + purchaseCategory + '}';
    }

    public int getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getPurchaseCategory() {
        return purchaseCategory;
    }
    
}
