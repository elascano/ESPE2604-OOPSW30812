/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.animalfarmsystema.model;

/**
 *
 * @author Collahuazo Brandon,CodeBros,@ESPE
 */
public class Cut {
    private int id;
    private String description;
    private String producer;
    private float weight;

    @Override
    public String toString() {
        return "Cut{" + "id=" + id + ", description=" + description + ", producer=" + producer + ", weight=" + weight + '}';
    }
    
    public Cut(int id, String description, String producer, float weight) {
        this.id = id;
        this.description = description;
        this.producer = producer;
        this.weight = weight;
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
     * @return the producer
     */
    public String getProducer() {
        return producer;
    }

    /**
     * @param producer the producer to set
     */
    public void setProducer(String producer) {
        this.producer = producer;
    }

    /**
     * @return the weight
     */
    public float getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(float weight) {
        this.weight = weight;
    }
    
    
}
