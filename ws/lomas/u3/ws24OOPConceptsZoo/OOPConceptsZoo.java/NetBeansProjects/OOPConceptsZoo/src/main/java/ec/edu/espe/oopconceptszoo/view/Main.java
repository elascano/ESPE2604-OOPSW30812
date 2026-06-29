package ec.edu.espe.oopconceptszoo.view;

import ec.edu.espe.oopconceptszoo.model.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Date today = new Date();

        System.out.println("--- Register Food ---");
        System.out.print("Enter food ID: ");
        int foodId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter food description: ");
        String foodDescription = scanner.nextLine();
        Food food = new Food(foodId, foodDescription);

        System.out.println("\n--- Register Slaughterhouse ---");
        System.out.print("Enter slaughterhouse description: ");
        String slaughterHouseDescription = scanner.nextLine();
        SlaughterHouse slaughterHouse = new SlaughterHouse(slaughterHouseDescription);

        System.out.println("\n--- Register Chicken ---");
        System.out.print("Enter chicken ID: ");
        int chickenId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter chicken breed: ");
        String chickenBreed = scanner.nextLine();
        System.out.print("Enter chicken weight: ");
        float chickenWeight = scanner.nextFloat();
        System.out.print("Is the chicken molting? (true/false): ");
        boolean isMolting = scanner.nextBoolean();
        System.out.print("Enter number of eggs per week: ");
        int eggsPerWeek = scanner.nextInt();
        scanner.nextLine();
        Chicken chicken = new Chicken(chickenId, chickenBreed, today, chickenWeight, isMolting, eggsPerWeek);

        System.out.println("\n--- Register Cow ---");
        System.out.print("Enter cow ID: ");
        int cowId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter cow breed: ");
        String cowBreed = scanner.nextLine();
        System.out.print("Enter cow weight: ");
        float cowWeight = scanner.nextFloat();
        System.out.print("Is the cow producing milk? (true/false): ");
        boolean isProducingMilk = scanner.nextBoolean();
        System.out.print("Enter milk liters: ");
        float milkLiters = scanner.nextFloat();
        scanner.nextLine();
        Cow cow = new Cow(cowId, cowBreed, today, cowWeight, isProducingMilk, milkLiters);

        System.out.println("\n--- Register Pig ---");
        System.out.print("Enter pig ID: ");
        int pigId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter pig breed: ");
        String pigBreed = scanner.nextLine();
        System.out.print("Enter pig weight: ");
        float pigWeight = scanner.nextFloat();
        System.out.print("Enter pig ideal weight: ");
        float pigIdealWeight = scanner.nextFloat();
        scanner.nextLine();
        Pig pig = new Pig(pigId, pigBreed, today, pigWeight, pigIdealWeight);

        System.out.println("\n--- Register Sheep ---");
        System.out.print("Enter sheep ID: ");
        int sheepId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter sheep breed: ");
        String sheepBreed = scanner.nextLine();
        System.out.print("Enter sheep weight: ");
        float sheepWeight = scanner.nextFloat();
        scanner.nextLine();
        Sheep sheep = new Sheep(sheepId, sheepBreed, today, sheepWeight, today);

        System.out.println("\n--- Execution Outputs ---");
        chicken.feed(food);
        chicken.layAnEgg();

        System.out.println("Cow producing milk: " + cow.isProducingMilk() + " (" + cow.milk() + "L)");
        cow.sendToSlaughterHouse(slaughterHouse);
        
        ArrayList<Cut> cowCuts = cow.cut();
        for (Cut cut : cowCuts) {
            System.out.println("Obtained Cut: " + cut.getDescription() + " - Weight: " + cut.getWeight() + "kg");
        }

        pig.sendToButcher();
        
        scanner.close();
    }
}