/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.animalfarmsystema.view;

import ec.edu.espe.animalfarmsystema.model.Cow;
import ec.edu.espe.animalfarmsystema.model.Cut;
import ec.edu.espe.animalfarmsystema.model.Pig;
import ec.edu.espe.animalfarmsystema.model.Product;
import ec.edu.espe.animalfarmsystema.model.SlaughterHouse;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Collahuazo Brandon,CodeBros,@ESPE
 */
public class AnimalFarmSystem {
    
    public static void main(String[] args) {
        SlaughterHouse slaughterHouse = new SlaughterHouse(1, "gotitas del saber", "Av.pollito", "0987654321");
        Product product = null;
        Cut cut = new Cut(1, "Sirloin", "Cut the Inge", 3.2f);
        ArrayList<Cut> cuts = new ArrayList<>();
        cuts.add(cut);
        Pig pig = new Pig(0, 0," Paco", new Date(), 0, slaughterHouse, product, cuts);
        System.out.println("this is my pig:");
        System.out.println(pig);
        
        
        boolean cowGiveMilk = true; 
        Product productCow;
        if (cowGiveMilk) {
            productCow = new Product(1, "Vita", "dairy", 1.0f); 
        } else {
            productCow = null;
        }
        Cow cow = new Cow(cowGiveMilk, 1, "Chebrolet", new Date(), 420.5f, slaughterHouse, productCow, cuts);
        System.out.println(cow);
        System.out.println("quanlity milk: " + cow.milk() + " L.");
    }
    
    
}
