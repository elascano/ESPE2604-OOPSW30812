/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.animalfarmsystem.model;

/**
 *
 * @author LABS-ESPE
 */
public class Product {
    private int id;
    private String description;
    private String unit;
    private float quiantity;

    public Product(int id, String description, String unit, float quiantity) {
        this.id = id;
        this.description = description;
        this.unit = unit;
        this.quiantity = quiantity;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", description=" + description + ", unit=" + unit + ", quiantity=" + quiantity + '}';
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
     * @return the quiantity
     */
    public float getQuiantity() {
        return quiantity;
    }

    /**
     * @param quiantity the quiantity to set
     */
    public void setQuiantity(float quiantity) {
        this.quiantity = quiantity;
    }
    
}
