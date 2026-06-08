/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.chickenfarm.model;

import java.util.Arrays;

/**
 *
 * @author Anthony Aimacaña, MKA programer, @ESPE
 */
public class ChickenCoop {
    private int id;
    private Chicken chickens[];

    public ChickenCoop(int id, Chicken[] chickens) {
        this.id = id;
        this.chickens = chickens;
    }

    @Override
    public String toString() {
        return "ChickenCoop{" + "id=" + id + ", chickens=" + Arrays.toString(chickens) + '}';
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
     * @return the chickens
     */
    public Chicken[] getChickens() {
        return chickens;
    }

    /**
     * @param chickens the chickens to set
     */
    public void setChickens(Chicken[] chickens) {
        this.chickens = chickens;
    }
    
    public void add(Chicken chicken){}
    public void remove(int ChickenId){}
    public void resetIteration(){}
    public Chicken next(){
        return null;
    }
}
