/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.Billing.model;

/**
 *
 * @author Didier Elbay  <Code_Bros , @ESPE>
 */
public class Company {
    private String companyName,companyId,companyAdress;

    public Company() {
        this.companyName = null;
        this.companyId = null;
        this.companyAdress = null;
    }

    public Company(String companyName, String companyId, String companyAdress) {
        this.companyName = companyName;
        this.companyId = companyId;
        this.companyAdress = companyAdress;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyAdress() {
        return companyAdress;
    }

    public void setCompanyAdress(String companyAdress) {
        this.companyAdress = companyAdress;
    }
    
    
    
    
}
