/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.oppconceptszoo.model;

/**
 *
 * @author Odalys Chavez , CodeBreakers, @ESPE
 */
public class Cut {

    private int id;
    private String description;
    private String procedure;
    private float weight;

    public Cut(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public Cut(int id, String description, String procedure, float weight) {
        this.id = id;
        this.description = description;
        this.procedure = procedure;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Cut{" + "id=" + id
                + ", description=" + description
                + ", procedure=" + procedure
                + ", weight=" + weight + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
    
}
