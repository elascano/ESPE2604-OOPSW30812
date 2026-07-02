/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.espe.edu.farmanimalsystem.view;

import java.time.LocalDate;
import ec.espe.edu.farmanimalsystem.model.Pig;
import ec.espe.edu.farmanimalsystem.model.Cow;

/**
 *
 * @author Cristian
 */
public class FarmAnimalSystem {
    
     public static void main(String[] args) {
        System.out.println("Hello World!");
        
        Pig pig = new Pig(0, 0, breed, LocalDate.MIN, 0, slaughterHouse, product, cut);
        
        Cow cow = new Cow(0, true, 0, breed, LocalDate.MIN, 0, slaughterHouse, product, cut);
    }
}
