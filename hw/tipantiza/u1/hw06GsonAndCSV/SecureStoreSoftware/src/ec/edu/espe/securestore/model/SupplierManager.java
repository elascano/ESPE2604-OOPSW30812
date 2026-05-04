/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.securestore.model;

/**
 *
 * @author Alexander Tipantiza, The Softwarrios, @ESPE
 */
public class SupplierManager {
    private int id;
    private String supplierName;
    private String contactEmail;

    public SupplierManager(int id, String supplierName, String contactEmail) {
        this.id = id;
        this.supplierName = supplierName;
        this.contactEmail = contactEmail;
    }

    @Override
    public String toString() {
        return "SupplierManager{" + "id=" + id + ", supplierName=" + supplierName + ", contactEmail=" + contactEmail + '}';
    }

    public int getId() {
        return id;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getContactEmail() {
        return contactEmail;
    }
    
}
