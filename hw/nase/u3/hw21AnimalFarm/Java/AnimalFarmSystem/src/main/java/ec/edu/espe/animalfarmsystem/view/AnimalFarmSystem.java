/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.animalfarmsystem.view;

import ec.edu.espe.animalfarmsystem.model.Cow;
import ec.edu.espe.animalfarmsystem.model.Cut;
import ec.edu.espe.animalfarmsystem.model.Pig;
import ec.edu.espe.animalfarmsystem.model.Product;
import ec.edu.espe.animalfarmsystem.model.SlaughterHouse;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Jennyfer Nase
 */
public class AnimalFarmSystem {

    public static void main(String[] args) {
        
        SlaughterHouse slaughterHouseObj = null;
        Product productObj = null;
        ArrayList<Cut> cutsListObj = new ArrayList<>();
        
        Pig pig = new Pig(0, 0, "Duroc", new Date(), 0, slaughterHouseObj, productObj, cutsListObj);
        Cow cow = new Cow(true, 0, 0, "Jenny", new Date(), 0, slaughterHouseObj, productObj, cutsListObj);
        
        System.out.println( "Animal Farm System ");
        System.out.println(pig);
        System.err.println(cow);
     
    }
}