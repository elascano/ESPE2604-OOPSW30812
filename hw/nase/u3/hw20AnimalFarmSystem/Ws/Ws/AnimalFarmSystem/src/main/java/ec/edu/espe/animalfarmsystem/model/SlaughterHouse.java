/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.animalfarmsystem.model;

/**
 *
 * @author LABS-ESPE
 */
public class SlaughterHouse {
    private int id;
    private String name;
    private String address;
    private String cellAphoneNumbers;

    @Override
    public String toString() {
        return "SlaughterHouse{" + "id=" + id + ", name=" + name + ", address=" + address + ", cellAphoneNumbers=" + cellAphoneNumbers + '}';
    }

    public SlaughterHouse(int id, String name, String address, String cellAphoneNumbers) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.cellAphoneNumbers = cellAphoneNumbers;
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
     * @return the cellAphoneNumbers
     */
    public String getCellAphoneNumbers() {
        return cellAphoneNumbers;
    }

    /**
     * @param cellAphoneNumbers the cellAphoneNumbers to set
     */
    public void setCellAphoneNumbers(String cellAphoneNumbers) {
        this.cellAphoneNumbers = cellAphoneNumbers;
    }
    
}
