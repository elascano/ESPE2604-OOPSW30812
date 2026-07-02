/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.animalfarmsystem.model;

/**
 *
 * @author Esteban Basurto, CodeBreakers, @ESPE
 */
public class Product {
    private int id;
    private String description;
    private String quantify;
    private String unit;

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", description=" + description + ", quantify=" + quantify + ", unit=" + unit + '}';
    }

    public Product(int id, String description, String quantify, String unit) {
        this.id = id;
        this.description = description;
        this.quantify = quantify;
        this.unit = unit;
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
     * @return the quantify
     */
    public String getQuantify() {
        return quantify;
    }

    /**
     * @param quantify the quantify to set
     */
    public void setQuantify(String quantify) {
        this.quantify = quantify;
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
    
}