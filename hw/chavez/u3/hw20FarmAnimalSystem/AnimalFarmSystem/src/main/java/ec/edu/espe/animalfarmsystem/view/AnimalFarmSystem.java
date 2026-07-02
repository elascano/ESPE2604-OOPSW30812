/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
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
 * @author Odalys Chavez , CodeBreakers, @ESPE
 */
public class AnimalFarmSystem {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        //String breed = "  ";
        //Date bornOn = new Date();
        SlaughterHouse slaughterHouse = null;
        Product product = null;
        ArrayList<Cut> cuts = new ArrayList<>();
        Pig pig = new Pig(0, 0, "Tamworth", new Date(), 0, slaughterHouse, product, cuts);
        Cow cow =new Cow(true, 0, 0, "Jersey", new Date(), 0, slaughterHouse, product, cuts);
        
        System.out.println(pig);
        System.out.println(cow);
    }
}
