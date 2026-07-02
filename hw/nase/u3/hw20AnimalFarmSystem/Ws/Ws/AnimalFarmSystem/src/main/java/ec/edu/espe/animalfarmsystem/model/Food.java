/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.animalfarmsystem.model;

/**
 *
 * @author LABS-ESPE
 */
public class Food {
    private int id;
    private String desription;

    @Override
    public String toString() {
        return "Food{" + "id=" + id + ", desription=" + desription + '}';
    }

    public Food(int id, String desription) {
        this.id = id;
        this.desription = desription;
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
     * @return the desription
     */
    public String getDesription() {
        return desription;
    }

    /**
     * @param desription the desription to set
     */
    public void setDesription(String desription) {
        this.desription = desription;
    }
    
}
