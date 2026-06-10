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
public class Supplier {

    private String ruc;
    private String companyName;
    private String address;
    private String phone;
    private String email;

    public Supplier(String ruc, String companyName, String address, String phone, String email) {
        this.ruc = ruc;
        this.companyName = companyName;
        this.address = address;
        setPhone(phone);
        this.email = email;
    }

    /**
     * @return the ruc
     */
    public String getRuc() {
        return ruc;
    }

    /**
     * @param ruc the ruc to set
     */
    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    /**
     * @return the companyName
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param companyName the companyName to set
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) {
            throw new IllegalArgumentException("The phone number must be exactly 10 digits.");
        }
        this.phone = phone;

    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public Document toDocument() {
        return new Document("ruc", this.ruc)
                .append("companyName", this.companyName)
                .append("address", this.address)
                .append("phone", this.phone)
                .append("email", this.email);
    }
}
