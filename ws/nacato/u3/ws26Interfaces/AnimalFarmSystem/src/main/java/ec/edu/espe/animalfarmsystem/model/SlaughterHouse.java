/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.animalfarmsystem.model;

/**
 *
 * @author Cristian Palmo,Error 404 @ESPE
 */
public class SlaughterHouse {
    private int id;
    private String name;
    private String address;
    private String cellphonenumber;

    @Override
    public String toString() {
        return "SlaughterHouse{" + "id=" + id + ", name=" + name + ", address=" + address + ", cellphonenumber=" + cellphonenumber + '}';
    }

    public SlaughterHouse(int id, String name, String address, String cellphonenumber) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.cellphonenumber = cellphonenumber;
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
     * @return the cellphonenumber
     */
    public String getCellphonenumber() {
        return cellphonenumber;
    }

    /**
     * @param cellphonenumber the cellphonenumber to set
     */
    public void setCellphonenumber(String cellphonenumber) {
        this.cellphonenumber = cellphonenumber;
    }
    
}
