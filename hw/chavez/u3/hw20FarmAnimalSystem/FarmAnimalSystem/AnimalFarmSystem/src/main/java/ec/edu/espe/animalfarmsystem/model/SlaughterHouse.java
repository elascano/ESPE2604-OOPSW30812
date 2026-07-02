/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.animalfarmsystem.model;

/**
 *
 * @author Odalys Chavez , CodeBreakers, @ESPE
 */
public class SlaughterHouse {
    private int id;
    private String name;
    private String address;
    private String cellphoneNumber;

    public SlaughterHouse(int id, String name, String address, String cellphoneNumber) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.cellphoneNumber = cellphoneNumber;
    }

    @Override
    public String toString() {
        return "SlaugterHouse{" + "id=" + id + ", name=" + name + ", address=" + address + ", cellphoneNumber=" + cellphoneNumber + '}';
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
