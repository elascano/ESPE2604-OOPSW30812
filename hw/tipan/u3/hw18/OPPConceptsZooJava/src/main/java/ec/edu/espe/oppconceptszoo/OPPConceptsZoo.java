package ec.edu.espe.oppconceptszoo;

import ec.edu.espe.oppconcetszoo.model.Chicken;
import ec.edu.espe.oppconcetszoo.model.Cow;
import ec.edu.espe.oppconcetszoo.model.Date;
import ec.edu.espe.oppconcetszoo.model.FarmAnimal;
import ec.edu.espe.oppconcetszoo.model.Pig;
import ec.edu.espe.oppconcetszoo.model.Sheep;
import java.util.Scanner;

public class OPPConceptsZoo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("===== FARM SYSTEM =====");

        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Breed: ");
        String breed = scanner.nextLine();

        System.out.print("Weight: ");
        float weight = scanner.nextFloat();

        scanner.nextLine();

        System.out.println("Choose animal:");
        System.out.println("1. Cow");
        System.out.println("2. Pig");
        System.out.println("3. Chicken");
        System.out.println("4. Sheep");

        int option = scanner.nextInt();

        FarmAnimal animal = null;

        switch (option) {

            case 1:
                animal = new Cow(id, breed, new Date(), weight);
                break;

            case 2:
                animal = new Pig(id, breed, new Date(), weight);
                break;

            case 3:
                animal = new Chicken(id, breed, new Date(), weight);
                break;

            case 4:
                animal = new Sheep(id, breed, new Date(), weight);
                break;

            default:
                System.out.println("Invalid option");
                return;
        }

        animal.born();

        System.out.println("\nBusiness Rules");

        System.out.println("Young Animal: " + animal.isYoungAnimal());

        System.out.println("Ready for Sale: " + animal.isReadyForSale());

        System.out.println("Needs More Food: " + animal.needsMoreFood());

    }

}