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
public class Cow extends FarmAnimal implements IMeatAnimal{
    private float milkDaily;
    private boolean isProducingMilk;
    private SlaughterHouse slaughterHouse;

    public Cow(float milkDaily, boolean isProducingMilk, SlaughterHouse slaughterHouse, int id, String bread, Date bornOn, float weight, SlaughterHouse slaughterhouse, Product product, ArrayList<Cut> cuts) {
        super(id, bread, bornOn, weight, slaughterhouse, product, cuts);
        this.milkDaily = milkDaily;
        this.isProducingMilk = isProducingMilk;
        this.slaughterHouse = slaughterHouse;
    }

    /**
     * @return the milkDaily
     */
    public float getMilkDaily() {
        return milkDaily;
    }

    /**
     * @param milkDaily the milkDaily to set
     */
    public void setMilkDaily(float milkDaily) {
        this.milkDaily = milkDaily;
    }

    /**
     * @return the isProducingMilk
     */
    public boolean isIsProducingMilk() {
        return isProducingMilk;
    }

    /**
     * @param isProducingMilk the isProducingMilk to set
     */
    public void setIsProducingMilk(boolean isProducingMilk) {
        this.isProducingMilk = isProducingMilk;
    }

    /**
     * @return the slaughterHouse
     */
    public SlaughterHouse getSlaughterHouse() {
        return slaughterHouse;
    }

    /**
     * @param slaughterHouse the slaughterHouse to set
     */
    public void setSlaughterHouse(SlaughterHouse slaughterHouse) {
        this.slaughterHouse = slaughterHouse;
    }

    @Override
    public void feed(Food food) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Cut> cut() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public SlaughterHouse sedToSlaughterHouse(SlaughterHouse slaughterhouse) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
