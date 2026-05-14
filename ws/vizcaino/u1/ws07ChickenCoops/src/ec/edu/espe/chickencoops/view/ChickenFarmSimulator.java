package ec.edu.espe.chickencoops.view;

import ec.edu.espe.chickencoops.model.Chicken;
import java.util.Date;


/**
 *
 * @author Adrian Vizcaino, The Softwarriors, @ESPE
 */

public class ChickenFarmSimulator {
    public static void main(String[] args) {
        
        int id;
        String name;
        String color;
        Date bornOnDate;
        int age;
        boolean isMolting;
        
        id = 1;
        name = "Lucy";
        color = "Brown and white";
        bornOnDate = new Date();
        age = 0;
        isMolting = false;
        
        Chicken chicken;
        Chicken chickens[];
        
        chickens = new Chicken[5];
        
        chickens[0] = new Chicken(id, name, color, bornOnDate, age, isMolting);
        
        id = 2;
        name = "Adrian Vizcaino";
        color = "Red";
        bornOnDate = new Date(2006, 05, 02);
        age = 0;
        isMolting = false;
        
        chickens[1] = new Chicken(id, name, color, bornOnDate, age, isMolting);
        
        id = 3;
        name = "Juan";
        color = "Black";
        bornOnDate = new Date(94, 05, 10);
        age = 0;
        isMolting = false;
        
        chickens[2] = new Chicken(id, name, color, bornOnDate, age, isMolting);
        
        id = 4;
        name = "Julian";
        color = "Blue";
        bornOnDate = new Date(85, 10, 29);
        age = 0;
        isMolting = false;
        
        chickens[3] = new Chicken(id, name, color, bornOnDate, age, isMolting);
        
        id = 5;
        name = "Marcelo";
        color = "yellow";
        bornOnDate = new Date(89, 07, 28);
        age = 0;
        isMolting = false;
        
        chickens[4] = new Chicken(id, name, color, bornOnDate, age, isMolting);
        
        System.out.println("QUIZ 2026-04-26 Joel Sanchez");
        
        for(int i = 0; i < 5; i++){
            chickens[i].setId(i + 1);
            System.out.println("name --> " + chickens[i].getName());
            System.out.println("chicken [" + (i + 1) + "]" + chickens[i]);
        } 
        
    }
}
