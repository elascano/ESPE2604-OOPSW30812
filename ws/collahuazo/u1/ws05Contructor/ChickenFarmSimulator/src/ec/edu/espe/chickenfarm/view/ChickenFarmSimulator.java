/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ec.edu.espe.chickenfarm.view;
import ec.edu.espe.chickenfarm.model.Chicken;
/**
 *
 * @author Brandon Collahuazo
 */
public class ChickenFarmSimulator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Chicken chicken;
        chicken = new Chicken(1,"Lucy","White and brown",1,true);
        System.out.println("my chicken is ---->" + chicken);
    }
    
}
