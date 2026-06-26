/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.oppconceptszoo.model;

import java.util.Date;

/**
 *
 * @author Esteban Basurto , CodeBreakers, @ESPE
 */
public abstract class FarmAnimal {
    int id; String breed;
    Date bornOn;
    float weight;
    public int getAgeInMOnths(){
        //algorithm to compute the months based on the boron date
        return 1;   
    }
    public abstract void feed(Food food);
}
