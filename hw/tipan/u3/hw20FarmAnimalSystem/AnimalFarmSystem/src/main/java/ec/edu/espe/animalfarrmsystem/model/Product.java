/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.animalfarrmsystem.model;

/**
 *
 * @author Ronald Tipan, The_Softwarriors ,@ESPE
 */
public class Product {
    private int id;
    private String description;
    private String unit;
    private float quantity;

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", description=" + description + ", unit=" + unit + ", quantity=" + quantity + '}';
    }

    
    public Product(int id, String description, String unit, float quantity) {
        this.id = id;
        this.description = description;
        this.unit = unit;
        this.quantity = quantity;
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
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public Product(int id, String description) {
        this.id = id;
        this.description = description;
    }

    /**
     * @return the unit
     */
    public String getUnit() {
        return unit;
    }

    /**
     * @param unit the unit to set
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * @return the quantity
     */
    public float getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

}
