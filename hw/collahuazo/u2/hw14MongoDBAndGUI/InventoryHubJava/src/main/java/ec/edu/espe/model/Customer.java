/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.model;

import org.bson.Document;

/**
 *
 * @author Brandon Collahuazo,CodeBros,@ESPE
 */
public class Customer {

    private int ruc;
    private String name;
    private String address;
    private String gmailCustomer;

    public Customer(int ruc, String name, String address, String gmailCustomer) {
        this.ruc = ruc;
        this.name = name;
        this.address = address;
        this.gmailCustomer = gmailCustomer;
    }
    
    /**
     * @return the ruc
     */
    public int getRuc() {
        return ruc;
    }

    /**
     * @param ruc the ruc to set
     */
    public void setRuc(int ruc) {
        this.ruc = ruc;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the gmailCustomer
     */
    public String getGmailCustomer() {
        return gmailCustomer;
    }

    /**
     * @param gmailCustomer the gmailCustomer to set
     */
    public void setGmailCustomer(String gmailCustomer) {
        this.gmailCustomer = gmailCustomer;
    }
    
    public Document toDocument() {
        return new Document("ruc", this.ruc)
                .append("name", this.name)
                .append("address", this.address)
                .append("gmailCustomer", this.gmailCustomer);
    }
}
