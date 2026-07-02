/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.espe.edu.farmanimalsystem.model;

/**
 *
 * @author Cristian
 */
public class SlaughterHouse {
    private int id;
    private String name;
    private String anddress;
    private String cellPhoneNumber;

    public SlaughterHouse(int id, String name, String anddress, String cellPhoneNumber) {
        this.id = id;
        this.name = name;
        this.anddress = anddress;
        this.cellPhoneNumber = cellPhoneNumber;
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
     * @return the anddress
     */
    public String getAnddress() {
        return anddress;
    }

    /**
     * @param anddress the anddress to set
     */
    public void setAnddress(String anddress) {
        this.anddress = anddress;
    }

    /**
     * @return the cellPhoneNumber
     */
    public String getCellPhoneNumber() {
        return cellPhoneNumber;
    }

    /**
     * @param cellPhoneNumber the cellPhoneNumber to set
     */
    public void setCellPhoneNumber(String cellPhoneNumber) {
        this.cellPhoneNumber = cellPhoneNumber;
    }

    @Override
    public String toString() {
        return "SlaughterHouse{" + "id=" + id + ", name=" + name + ", anddress=" + anddress + ", cellPhoneNumber=" + cellPhoneNumber + '}';
    }
}
