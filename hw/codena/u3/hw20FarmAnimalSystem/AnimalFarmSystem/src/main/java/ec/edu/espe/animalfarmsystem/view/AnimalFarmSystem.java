package ec.edu.espe.animalfarmsystem.view;

import ec.edu.espe.animalfarmsystem.model.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

/**
 *
 * @author Brandon Collahuazo,Polymorphism,ESPE
 */
public class AnimalFarmSystem {

    public static void main(String[] args) {

        System.out.println("\n------PIG-----\n");
        Date date = new Date(110, 10, 6);
        SlaughterHouse slaughterHouse = new SlaughterHouse(1, null, "Av.omg 67", "0991231234");
        Product product = new Product(0, "", "", 0);
        ArrayList<Cut> cuts = new ArrayList();

        Pig pig = new Pig(120, 1, "Tocinito", date, 150, slaughterHouse, product, cuts);
        pig.cut();
        System.out.println(pig.getSlaughterHouse());

        System.out.println("\n--Sending to slaughterHouse--");
        slaughterHouse.setName("Matadero Don PEPE");
        System.out.println(pig.getSlaughterHouse());

        pig.sendToSlaughterHouse(slaughterHouse);
        pig.cut();

        System.out.println("\n--Feed--");
        Food pigFood = new Food(1, "Mixed Feed");
        pig.feed(pigFood);

        System.out.println("\n\n------COW-----\n");

        Cow cow = new Cow(false, 0, 0, "Holstein", date, 0, null, null, null);

        cow.sendToSlaughterHouse(slaughterHouse);
        cow.cut();

        System.out.println("\n--Feed--");
        Food cowFood = new Food(2, "Grass");
        cow.feed(cowFood);

    }
}
