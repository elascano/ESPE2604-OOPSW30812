package ec.edu.espe.farmsystem.view;

import ec.edu.espe.farmsystem.model.Chicken;
import ec.edu.espe.farmsystem.model.Cow;
import ec.edu.espe.farmsystem.model.Cut;
import ec.edu.espe.farmsystem.model.Pig;
import ec.edu.espe.farmsystem.model.Sheep;
import ec.edu.espe.farmsystem.model.SlaughterHouse;
import java.util.ArrayList;
import java.util.Date;

public class AnimalFarmSystem {

    public static void main(String[] args) {
        System.out.println("ANIMAL FARM SYSTEM\n");
        
        SlaughterHouse slaughterHouse = new SlaughterHouse(1, "Central Slaughterhouse", "123 Main St", "555-1234");
        
        Cow cow1 = new Cow(true, 1, "Holstein", new Date(), 450.0f, null, null, null);
        System.out.println("--- COW 1: DAIRY COW ---");
        System.out.println("ID: " + cow1.getId());
        System.out.println("Breed: " + cow1.getBreed());
        System.out.println("Weight: " + cow1.getWeight() + " kg");
        System.out.println("Producing milk? " + cow1.isProducingMilk());
        System.out.println();
        cow1.produce();
        System.out.println("Product: " + cow1.getProduct());
        System.out.println();
        
        Cow cow2 = new Cow(false, 2, "Angus", new Date(), 520.0f, slaughterHouse, null, null);
        System.out.println("--- COW 2: MEAT COW ---");
        System.out.println("ID: " + cow2.getId());
        System.out.println("Breed: " + cow2.getBreed());
        System.out.println("Weight: " + cow2.getWeight() + " kg");
        System.out.println("Slaughterhouse: " + cow2.getSlaughterHouse().getName());
        System.out.println();
        System.out.println("Cuts");
        ArrayList<Cut> beefCuts = cow2.cut();
        for (Cut cut : beefCuts) {
            System.out.println(cut);
        }
        System.out.println();
        
        Pig pig1 = new Pig(120.0f, 3, "Duroc", new Date(), 80.0f, slaughterHouse, null, null);
        System.out.println("--- PIG 1 ---");
        System.out.println("ID: " + pig1.getId());
        System.out.println("Breed: " + pig1.getBreed());
        System.out.println("Weight: " + pig1.getWeight() + " kg");
        System.out.println("Ideal weight: " + pig1.getIdealWeight() + " kg");
        System.out.println();
        System.out.println("Cuts");
        ArrayList<Cut> porkCuts1 = pig1.cut();
        for (Cut cut : porkCuts1) {
            System.out.println(cut);
        }
        System.out.println();
        
        Pig pig2 = new Pig(110.0f, 4, "Berkshire", new Date(), 95.0f, slaughterHouse, null, null);
        System.out.println("--- PIG 2 ---");
        System.out.println("ID: " + pig2.getId());
        System.out.println("Breed: " + pig2.getBreed());
        System.out.println("Weight: " + pig2.getWeight() + " kg");
        System.out.println("Ideal weight: " + pig2.getIdealWeight() + " kg");
        System.out.println();
        System.out.println("Cuts");
        ArrayList<Cut> porkCuts2 = pig2.cut();
        for (Cut cut : porkCuts2) {
            System.out.println(cut);
        }
        System.out.println();
        
        Chicken chicken = new Chicken(false, 7, 5, "Leghorn", new Date(), 2.5f, slaughterHouse, null, null);
        System.out.println("--- CHICKEN ---");
        System.out.println("ID: " + chicken.getId());
        System.out.println("Breed: " + chicken.getBreed());
        System.out.println("Weight: " + chicken.getWeight() + " kg");
        System.out.println("Is molting? " + chicken.isIsMolting());
        System.out.println("Eggs per week: " + chicken.getNumberOfEggsPerWeek());
        System.out.println();
        chicken.layAnEgg();
        System.out.println("Eggs per week: " + chicken.getNumberOfEggsPerWeek());
        System.out.println();
        chicken.produce();
        System.out.println();
        
        Sheep sheep = new Sheep(new Date(), 3.5f, 6, "Merino", new Date(), 70.0f, slaughterHouse, null, null);
        System.out.println("--- SHEEP ---");
        System.out.println("ID: " + sheep.getId());
        System.out.println("Breed: " + sheep.getBreed());
        System.out.println("Weight: " + sheep.getWeight() + " kg");
        System.out.println("Wool: " + sheep.getKgOfWool() + " kg");
        System.out.println();
        sheep.shear();
        System.out.println();
        sheep.produce();
        System.out.println();

        
        System.out.println("       SYSTEM COMPLETED");
    }
}