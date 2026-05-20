/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.Billing.model;

/**
 *
 * @author Didier Elbay  <Code_Bros , @ESPE>
 */
public class Customer {
    private int ruc;
    private String name;
    private String Andress;
    private String gmailCustomer; 

    public Customer() {
        this.ruc = 0;
        this.name = null;
        this.Andress = null;
        this.gmailCustomer = null;
    }

    public Customer(int ruc, String name, String Andress, String gmailCustomer) {
        this.ruc = ruc;
        this.name = name;
        this.Andress = Andress;
        this.gmailCustomer = gmailCustomer;
    }

    public int getRuc() {
        return ruc;
    }

    public void setRuc(int ruc) {
        this.ruc = ruc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAndress() {
        return Andress;
    }

    public void setAndress(String Andress) {
        this.Andress = Andress;
    }

    public String getGmailCustomer() {
        return gmailCustomer;
    }

    public void setGmailCustomer(String gmailCustomer) {
        this.gmailCustomer = gmailCustomer;
    }
    
    
    
    
    
}
