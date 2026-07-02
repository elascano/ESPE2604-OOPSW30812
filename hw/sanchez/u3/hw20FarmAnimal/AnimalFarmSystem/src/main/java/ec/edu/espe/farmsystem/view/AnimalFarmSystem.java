/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espe.farmsystem.view;

import ec.edu.espe.farmsystem.model.Cow;
import ec.edu.espe.farmsystem.model.Cut;
import ec.edu.espe.farmsystem.model.Pig;
import ec.edu.espe.farmsystem.model.SlaughterHouse;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Joel Sanchez, The_Softwarriors ,@ESPE
 */
public class AnimalFarmSystem {

    public static void main(String[] args) {
        System.out.println("Farm Animal\n");
        
        SlaughterHouse slaughterHouse = new SlaughterHouse(1, "Central Slaughterhouse", "Sangolqui", "0979495674");
        
        Pig pig1 = new Pig(120.0f, 1, "Duroc", new Date(), 80.0f, slaughterHouse, null, null);
        System.out.println("\nPIG 1\n");
        System.out.println("ID: " + pig1.getId());
        System.out.println("Breed: " + pig1.getBreed());
        System.out.println("Weight: " + pig1.getWeight() + " kg");
        System.out.println("Ideal weight: " + pig1.getIdealWeight() + " kg");
        System.out.println("Age: " + pig1.getAgeInMonths() + " months");
        System.out.println("Slaughterhouse: " + pig1.getSlaughterHouse().getName());
        
        System.out.println("Cuts");
        ArrayList<Cut> cuts = pig1.cut();
        for (Cut cut : cuts) {
            System.out.println(cut);
        }
        
        Pig pig2 = new Pig(110.0f, 2, "Berkshire", new Date(), 95.0f, slaughterHouse, null, null);
        System.out.println("\nPIG 2\n");
        System.out.println("ID: " + pig2.getId());
        System.out.println("Breed: " + pig2.getBreed());
        System.out.println("Weight: " + pig2.getWeight() + " kg");
        System.out.println("Ideal weight: " + pig2.getIdealWeight() + " kg");
        System.out.println("Age: " + pig2.getAgeInMonths() + " months");
        System.out.println("Slaughterhouse: " + pig2.getSlaughterHouse().getName());
        
        System.out.println("Cuts");
        ArrayList<Cut> cuts2 = pig2.cut();
        for (Cut cut : cuts2) {
            System.out.println(cut);
        }
        
        Cow cow1 = new Cow(true, 1, "Angus", new Date(), 520.0f, slaughterHouse, null, null);
        System.out.println("\nCOW 1\n");
        System.out.println("ID: " + cow1.getId());
        System.out.println("Breed: " + cow1.getBreed());
        System.out.println("Weight: " + cow1.getWeight() + " kg");
        System.out.println("Age: " + cow1.getAgeInMonths() + " months");
        System.out.println("Producing milk? " + cow1.isProducingMilk());
        System.out.println();
        
        cow1.produce();
        System.out.println("Product: " + cow1.getProduct());
        System.out.println();
        
        
        Cow cow2 = new Cow(false, 2, "Hereford", new Date(), 480.0f, slaughterHouse, null, null);
        System.out.println("\nCOW 2\n");
        System.out.println("ID: " + cow2.getId());
        System.out.println("Breed: " + cow2.getBreed());
        System.out.println("Weight: " + cow2.getWeight() + " kg");
        System.out.println("Age: " + cow2.getAgeInMonths() + " months");
        System.out.println("Producing milk? " + cow2.isProducingMilk());
        cow2.produce();
        System.out.println("Slaughterhouse: " + cow2.getSlaughterHouse().getName());
        
        System.out.println("Cuts");
        ArrayList<Cut> cuts4 = cow2.cut();
        for (Cut cut : cuts4) {
            System.out.println(cut);
        }
    
    }
}    
