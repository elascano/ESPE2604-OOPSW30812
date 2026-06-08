/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.chikenSimulation.view;
import ec.edu.espe.chikenSimulation.model.Chicken; 
import java.util.Scanner;
/**
 *
 * @author sbart
 */


public class ChickenSimulation {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Chicken chicken = new Chicken(); // Creamos la gallina

        System.out.println("Chicken Facts");
        System.out.print("Enter Chicken Name: ");
        chicken.name = input.next();
        System.out.print("Enter age (months): ");
        chicken.ageInMonths = input.nextInt();

        cluck(chicken);
        
        System.out.println("My Chicken is ---->" + chicken.toString());
    }

    public static void cluck(Chicken c) {
        System.out.println("\n[" + c.name + "] says: CLUCK CLUCK CLUCK!");
    }
    
    
}