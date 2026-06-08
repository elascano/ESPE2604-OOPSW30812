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
public class ChickenFarm {
     private String name;
     private ChickenCoop coops[];

    public ChickenFarm(String name, ChickenCoop[] coops) {
        this.name = name;
        this.coops = coops;
    }

    @Override
    public String toString() {
        return "ChickenFarm{" + "name=" + name + ", coops=" + Arrays.toString(coops) + '}';
    }
     
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the coops
     */
    public ChickenCoop[] getCoops() {
        return coops;
    }

    /**
     * @param coops the coops to set
     */
    public void setCoops(ChickenCoop[] coops) {
        this.coops = coops;
    }
    
    public void add(ChickenCoop coop){}
    public void remove(int coopId){}
    public void resetIteration(){}
    public ChickenCoop next(){
        return null;
    }
}
