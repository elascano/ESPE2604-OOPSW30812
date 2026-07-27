/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.hw18farm.model;

/**
 *
 * @author Cristian Palomo, Error 404, @ESPE
 */
public class Food {
     private int id;
    private String typeOfFood;

    public Food(int id, String description) {
        this.id = id;
        this.typeOfFood = description;
    }

    @Override
    public String toString() {
        return id + " - " + typeOfFood;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeOfFood() {
        return typeOfFood;
    }

    public void setTypeOfFood(String typeOfFood) {
        this.typeOfFood = typeOfFood;
    }
}   
