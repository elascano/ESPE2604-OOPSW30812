package ec.edu.espe.chickencoops.view;

import ec.edu.espe.chickencoops.model.Chicken;
import java.util.Date;


/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
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
        name = "Joel Sanchez";
        color = "Red";
        bornOnDate = new Date(106, 06, 04);
        age = 0;
        isMolting = false;
        
        chickens[1] = new Chicken(id, name, color, bornOnDate, age, isMolting);
        
        id = 3;
        name = "Maria";
        color = "Black";
        bornOnDate = new Date(93, 07, 23);
        age = 0;
        isMolting = false;
        
        chickens[2] = new Chicken(id, name, color, bornOnDate, age, isMolting);
        
        id = 4;
        name = "Juan";
        color = "Blue";
        bornOnDate = new Date(80, 07, 23);
        age = 0;
        isMolting = false;
        
        chickens[3] = new Chicken(id, name, color, bornOnDate, age, isMolting);
        
        id = 5;
        name = "Carlos";
        color = "yellow";
        bornOnDate = new Date(78, 07, 23);
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
