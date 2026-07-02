/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.animalfarmsystem.model;

import ec.edu.espe.animalfarmsystem.controller.IMeatAnimal;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Esteban Basurto, CodeBreakers, @ESPE
 */
public abstract class Pig extends FarmAnimal implements IMeatAnimal {
    private float idealWeigth;
    private SlaughterHouse slaughterHouse;

    @Override
    public void feed(Food food) {
        System.out.println( "Feeding THE PIG with food -->" + food + "in a bowl and water");
        
    }

    public Pig(float idealWeigth, int id, String bread, Date bornOn, float weight, SlaughterHouse slaughterhouse, Product product, ArrayList<Cut> cuts) {
        super(id, bread, bornOn, weight, slaughterhouse, product, cuts);
        this.idealWeigth = idealWeigth;
    }

    /**
     * @return the idealWeigth
     */
    public float getIdealWeigth() {
        return idealWeigth;
    }

    /**
     * @param idealWeigth the idealWeigth to set
     */
    public void setIdealWeigth(float idealWeigth) {
        this.idealWeigth = idealWeigth;
    }

    @Override
    public ArrayList<Cut> cut() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void sendToSlaughterHouse(SlaughterHouse slaughterHouse) {
        this.slaughterHouse = slaughterHouse;
    }

   
}
