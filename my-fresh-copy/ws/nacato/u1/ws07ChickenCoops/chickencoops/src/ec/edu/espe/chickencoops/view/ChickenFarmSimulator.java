package ec.edu.espe.chickencoops.view;

import ec.edu.espe.chickencoops.model.Chicken;
import java.util.Date;
/**
 *
 * @author Angie Nacato, Error 404, @ESPE
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
        color = "brown and white";
        bornOnDate = new Date();
        age = 0;
        isMolting = false;

        Chicken chicken;
        Chicken chickens[];
        
        chickens = new Chicken[5];
        
        chickens[0] = new Chicken(id, name, color, bornOnDate, age, isMolting);
        
        id = 2;
        name = "Angie Nacato";
        color = "Black";
        bornOnDate = new Date(106, 11, 16);
        age = 0;
        isMolting = false;
        
        chickens[1] = new Chicken(id, name, color, bornOnDate, age, isMolting);

        
        
        id = 3;
        name = "Donald";
        color = "Yellow";
        bornOnDate = new Date(107, 8, 15);
        age = 0;
        isMolting = true;
        
        chickens[2] = new Chicken(id, name, color, bornOnDate, age, isMolting);
        
        id = 4;
        name = "Coco";
        color = "White";
        bornOnDate = new Date(107, 2, 20);
        age = 0;
        isMolting = true;
        chickens[3] = new Chicken(id, name, color, bornOnDate, age, isMolting);
        
        id = 5;
        name = "Tory";
        color = "Green";
        bornOnDate = new Date(113, 4, 27);
        age = 0;
        isMolting = true;
        chickens[4] = new Chicken(id, name, color, bornOnDate, age, isMolting);
        
        System.out.println("QUIZ 2026-04-26 Angie Nacato");
        for(int i = 0; i < 5; i++){
            chickens[i].setId(i+1);
            System.out.println("chicken [" + (i+1) + "]--> " + chickens[i]);
        }
    }
}