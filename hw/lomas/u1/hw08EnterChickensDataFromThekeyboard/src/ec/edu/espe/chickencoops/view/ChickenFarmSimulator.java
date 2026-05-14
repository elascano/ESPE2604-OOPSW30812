package ec.edu.espe.chickencoops.view;

import ec.edu.espe.chickencoops.model.Chicken;
import java.util.Date;
import java.util.Scanner;

//@author Christopher Lomas,<CodeBros,@ESPE>
public class ChickenFarmSimulator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Chicken[] chickens = new Chicken[5]; 
        int count = 0;

      
        String option;
        do {
            System.out.println("Enter data for chicken " + (count + 1));
            System.out.print("ID: ");
            int id = sc.nextInt(); sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Color: ");
            String color = sc.nextLine();
            System.out.print("Age: ");
            int age = sc.nextInt();
            System.out.print("Is Molting? (true/false): ");
            boolean isMolting = sc.nextBoolean(); sc.nextLine();

           
            chickens[count] = new Chicken(id, name, color, new Date(), age, isMolting);
            count++;

            System.out.print("Do you want to enter another chicken? (s/n): ");
            option = sc.nextLine();

        } while (option.equalsIgnoreCase("s") && count < 5);

        
        
        if (count < 5) {
            chickens[count] = new Chicken(1, "Lucy", "brown and white", new Date(), 0, false);
            count++;
        }
        if (count < 5) {
            
            chickens[count] = new Chicken(2, "Christopher Lomas", "Red", new Date(), 0, false);
            count++;
        }
        if (count < 5) {
            chickens[count] = new Chicken(3, "Andres Lomas", "White", new Date(), 0, true);
            count++;
        }
        if (count < 5) {
            chickens[count] = new Chicken(4, "Jonathan Lomas", "Yellow", new Date(), 0, true);
            count++;
        }

        
        System.out.println("Quiz 26-4-2026 CHRISTOPHER LOMAS");
        
        for (int i = 0; i < count; i++) {
            if (chickens[i] != null) {
               
                chickens[i].setId(i + 1); 
                System.out.println("name--->" + chickens[i].getName());
                System.out.println("chicken [" + (i + 1) + "]" + chickens[i]);
            }
        }
    }
}
