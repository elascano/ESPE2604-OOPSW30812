/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espe.animalfarrmsystem.view;

import ec.edu.espe.animalfarrmsystem.model.Pig;
import ec.edu.espe.animalfarrmsystem.model.*;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Mateo Artieda, MKA programmers ,@ESPE
 */
public class AnimalFarmSystem {

    public static void main(String[] args) {

        Food food = new Food(1, "Corn");

        SlaughterHouse slaughterHouse = new SlaughterHouse(
                1,
                "ESPE Slaughter House",
                "Sangolqui",
                "0999999999"
        );

        Product pork = new Product(1, "Pork", "kg", 0);

        Product milk = new Product(2, "Milk", "liters", 20);

        ArrayList<Cut> cuts = new ArrayList<>();

        Pig pig = new Pig(
                100,
                1,
                "Yorkshire",
                new Date(),
                105,
                slaughterHouse,
                pork,
                cuts
        );

        Cow cow = new Cow(
                20,
                95,
                2,
                "Holstein",
                new Date(),
                500,
                null,
                milk,
                new ArrayList<>()
        );

        System.out.println("========== PIG ==========");
        pig.feed(food);
        pig.sendToSlaughterHouse(slaughterHouse);
        pig.cut();

        System.out.println("Ready for slaughter? "
                + pig.isReadyForSlaughter());

        System.out.println();

        System.out.println("========== COW ==========");
        cow.feed(food);
        System.out.println(cow.produce());
        cow.measureQuantity("liters", 20);

    }

}