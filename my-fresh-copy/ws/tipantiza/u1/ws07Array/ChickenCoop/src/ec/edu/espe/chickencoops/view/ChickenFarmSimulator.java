
package ec.edu.espe.chickencoops.view;

import ec.edu.espe.chickencoops.model.Chicken;
import java.util.Date;

/**
 *
 * @author Alexander Tipantiza, The Softwarrios, @ESPE
 */
public class ChickenFarmSimulator {
     public static void main(String[] args) {
        int id;
        String name;
        String color;
        Date bornOnDate;
        int age;
        boolean isMolting;

        Chicken chickens[];
        chickens = new Chicken[5];

        
        id = 1;
        name = "Lucy";
        color = "brown and white";
        bornOnDate = new Date();
        age = 0;
        isMolting = false;
        chickens[0] = new Chicken(id, name, color, bornOnDate, age, isMolting);

        
        id = 2;
        name = "Alexander Tipantiza";
        color = "black";
        bornOnDate = new Date(106, 0, 28);
        age = 0;
        isMolting = false;
        chickens[1] = new Chicken(id, name, color, bornOnDate, age, isMolting);

        
        id = 3;
        name = "Jhonatan";
        
        color = "white";
        bornOnDate = new Date(123, 4, 15);
        age = 1;
        isMolting = true;
        chickens[2] = new Chicken(id, name, color, bornOnDate, age, isMolting);

        
        id = 4;
        name = "Pancracio";
        color = "yellow";
        bornOnDate = new Date(124, 2, 10);
        age = 0;
        isMolting = false;
        chickens[3] = new Chicken(id, name, color, bornOnDate, age, isMolting);

        
        id = 5;
        name = "Turuleca";
        color = "spotted";
        bornOnDate = new Date(122, 8, 20);
        age = 2;
        isMolting = true;
        chickens[4] = new Chicken(id, name, color, bornOnDate, age, isMolting);

        System.out.println("QUIS 2026-04-26 Edison Lascano");
        
        for (int i = 0; i < 5; i++) {
            
            System.out.println("name --> " + chickens[i].getName());
            
            System.out.println("chicken [" + (i + 1) + "] --> " + chickens[i]);
        }
    }
    
}
