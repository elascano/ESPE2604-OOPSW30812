package ec.edu.espe.chikencoops.view;

import ec.edu.espe.chikencoops.model.Chiken;
import java.util.Date;
/**
 *
 * @author Didier Elbay  <Code_Bros , @ESPE>
 */
public class ChikenFramSimulator {

    public static void main(String[] args) {
        int id;
        String name, color;
        Date bornOnDate;
        boolean isMolting;
        int age;

        Chiken chickens[] = new Chiken[5];

        
        id = 1;
        name = "Lucy";
        color = "brown and white";
        bornOnDate = new Date();
        age = 1;
        isMolting = false;
        chickens[0] = new Chiken(id, name, color, bornOnDate, isMolting, age);

        id = 2;
        name = "Didier Elbay";
        color = "Red";
        bornOnDate = new Date(99, 11, 1);
        age = 0;
        isMolting = true;
        chickens[1] = new Chiken(id, name, color, bornOnDate, isMolting, age);

        id = 3;
        name = "Jorge Lascano";
        color = "Black";
        bornOnDate = new Date(121, 7, 23);
        age = 2;
        isMolting = false;
        chickens[2] = new Chiken(id, name, color, bornOnDate, isMolting, age);

        id = 4;
        name = "Jose";
        color = "Violet";
        bornOnDate = new Date(106, 2, 10);
        age = 0;
        isMolting = true;
        chickens[3] = new Chiken(id, name, color, bornOnDate, isMolting, age);

        id = 5;
        name = "Pepito Perez";
        color = "Red";
        bornOnDate = new Date(108, 0, 12);
        age = 0;
        isMolting = true;
        chickens[4] = new Chiken(id, name, color, bornOnDate, isMolting, age);

        

        for (int i = 0; i < 5; i++) {
            System.out.println("chicken [" + (i + 1) + "]" + chickens[i]);
        }
    }
}