package ec.edu.espe.chickencoops.view;

import ec.edu.espe.chickencoops.model.Chicken;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

/**
 *
 * @author Edison Lascano SoftCrafters DCCO ESPE
 */
public class ChickenFarmSimulator {

    public static void main(String[] args) {
        int id;
        String name;
        String color;
        Date bornOnDate;
        int age;
        boolean isMolting;

        //TODO input from keyboard
        //TODO do-while to enter as many chickens as the user wants
        
        id = 1;
        name = "Lucy";
        color = "brown and white";
        bornOnDate = new Date();
        age = 0;
        isMolting = false;

        Chicken chicken;
        Chicken chickens[];
        
        chickens = new Chicken[5];
        
        chickens[0] = new Chicken(id, name, color, bornOnDate, age, isMolting); 
        
        id = 2;
        name = "Edison Lascano";
        color = "Red";
        bornOnDate = new Date(70, 11, 17);
        age = 0;
        isMolting = false;

        chickens[1] = new Chicken(id, name, color, bornOnDate, age, isMolting); 

        id = 3;
        name = "Jorge Lascano";
        color = "Black";
        bornOnDate = new Date(93, 07, 23);
        age = 0;
        isMolting = true;
        
        chickens[2] = new Chicken(id, name, color, bornOnDate, age, isMolting); 
        chickens[3] = new Chicken(id, name, color, bornOnDate, age, isMolting); 
        chickens[4] = new Chicken(id, name, color, bornOnDate, age, isMolting); 

        
        System.out.println("QUIZ 2026-04-26 Edison Lascano");
        for(int i = 0; i < 5 ; i++){
            chickens[i].setId(i+1);
            //System.out.println("name --> " + chickens[i].getName());
            System.out.println("chicken [" + (i+1) + "]" + chickens[i]);
        }
        
    }
}
