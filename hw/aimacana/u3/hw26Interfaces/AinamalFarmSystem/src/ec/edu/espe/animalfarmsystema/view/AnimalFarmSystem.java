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
 * @author Ronald Tipan <The_Softwarrios at ESPE>
 */
public class AnimalFarmSystem {
    
    public static void main(String[] args) {
        SlaughterHouse slaughterHouse = new SlaughterHouse(1, "Los Andes", "Quito", "0999999999");
        Product product = new Product(1, "Meat", "kg", 50.5f);
        ArrayList<Cut> cuts = new ArrayList<>();
        
        Pig pig = new Pig(100.0f, 1, "Landrace", new Date(), 80.5f, slaughterHouse, product, cuts);
        Cow cow = new Cow(15.5f, 20.0f, 2, "Holstein", new Date(), 400.0f, slaughterHouse, product, cuts);
        
        System.out.println("Pig ---> " + pig);
        System.out.println("Cow ---> " + cow);
    }
}
