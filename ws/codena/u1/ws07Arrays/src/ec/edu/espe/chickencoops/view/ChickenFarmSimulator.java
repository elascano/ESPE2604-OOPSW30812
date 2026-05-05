package ec.edu.espe.chickencoops.view;

import ec.edu.espe.chickencoops.model.Chicken;
import java.util.Date;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
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
        name = "Daniel Codena";
        color = "Red";
        bornOnDate = new Date(106, 04, 15);
        age = 0;
        isMolting = false;
        
        chickens[1] = new Chicken(id, name, color, bornOnDate, age, isMolting);

        
        
        id = 3;
        name = "Juan Lopez";
        color = "Blue";
        bornOnDate = new Date(107, 05, 10);
        age = 0;
        isMolting = false;
        
        chickens[2] = new Chicken(id, name, color, bornOnDate, age, isMolting);
        
        id = 4;
        name = "Jose";
        color = "Violet";
        bornOnDate = new Date(106, 02, 10);
        age = 0;
        isMolting = true;
        chickens[3] = new Chicken(id, name, color, bornOnDate, age, isMolting);
        
        id = 5;
        name = "Pepito Perez";
        color = "Red";
        bornOnDate = new Date(108, 00, 12);
        age = 0;
        isMolting = true;
        chickens[4] = new Chicken(id, name, color, bornOnDate, age, isMolting);
        
        System.out.println("QUIZ 2026-04-26 Daniel Codena");
        for(int i = 0; i < 5; i++){
            chickens[i].setId(i+1);
            System.out.println("chicken [" + (i+1) + "]--> " + chickens[i]);
        }
        
        
    }
}

