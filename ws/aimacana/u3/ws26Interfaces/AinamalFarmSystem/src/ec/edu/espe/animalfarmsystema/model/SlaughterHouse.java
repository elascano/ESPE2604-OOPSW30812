/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.animalfarmsystema.model;

/**
 *
 * @author Ronald Tipan <The_Softwarrios at ESPE>
 */
public class SlaughterHouse {
    private int id;
    private String names;
    private String address;
    private String cellphoneNumber;

    @Override
    public String toString() {
        return "SlaughterHouse{" + "id=" + id + ", names=" + names + ", address=" + address + ", cellphoneNumber=" + cellphoneNumber + '}';
    }

    public SlaughterHouse(int id, String names, String address, String cellphoneNumber) {
        this.id = id;
        this.names = names;
        this.address = address;
        this.cellphoneNumber = cellphoneNumber;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the names
     */
    public String getNames() {
        return names;
    }

    /**
     * @param names the names to set
     */
    public void setNames(String names) {
        this.names = names;
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
     * @return the cellphoneNumber
     */
    public String getCellphoneNumber() {
        return cellphoneNumber;
    }

    /**
     * @param cellphoneNumber the cellphoneNumber to set
     */
    public void setCellphoneNumber(String cellphoneNumber) {
        this.cellphoneNumber = cellphoneNumber;
    }
    
    
}
