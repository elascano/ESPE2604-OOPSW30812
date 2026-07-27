/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.animalfarm.model;

/**
 *
 * @author Cristian Palomo, Error 404, @ESPE
 */
public class Cut {
    int id;
    String description;
    String procedure;
    float weight;

    public Cut(int id, String description, String procedure, float weight) {
        this.id = id;
        this.description = description;
        this.procedure = procedure;
        this.weight = weight;
    }

    public int getId() { return id; }
    public String getDescription() { return description; }
    public String getProcedure() { return procedure; }
    public float getWeight() { return weight; }
}
