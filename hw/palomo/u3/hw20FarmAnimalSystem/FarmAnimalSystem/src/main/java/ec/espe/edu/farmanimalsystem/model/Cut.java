/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.espe.edu.farmanimalsystem.model;

/**
 *
 * @author Cristian
 */
public class Cut {
    private int id;
    private String description;
    private String Procedure;
    private float weight;

    public Cut(int id, String description, String Procedure, float weight) {
        this.id = id;
        this.description = description;
        this.Procedure = Procedure;
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
     * @return the Procedure
     */
    public String getProcedure() {
        return Procedure;
    }

    /**
     * @param Procedure the Procedure to set
     */
    public void setProcedure(String Procedure) {
        this.Procedure = Procedure;
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

    @Override
    public String toString() {
        return "Cut{" + "id=" + id + ", description=" + description + ", Procedure=" + Procedure + ", weight=" + weight + '}';
    }    
}
