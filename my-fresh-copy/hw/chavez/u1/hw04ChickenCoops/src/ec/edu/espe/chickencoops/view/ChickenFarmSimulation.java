/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package ec.edu.espe.chickencoops.view;
/*
 *
 * @author Odalys Chavez, CodeBreakers, @ESPE
 */
import ec.edu.espe.chickencoops.model.Chicken;
import java.util.ArrayList; 
import java.util.Date;
import java.util.Scanner;

public class ChickenFarmSimulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Chicken> chickens = new ArrayList<>();
        char response;

        

        do {
            System.out.println("\n** ENTER CHICKEN DATA **");
            System.out.print("Id: ");
            int id = scanner.nextInt();
            scanner.nextLine(); 

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Color: ");
            String color = scanner.nextLine();

            System.out.print("Year of birth: ");
            int year = scanner.nextInt();
            System.out.print("Month : ");
            int month = scanner.nextInt();
            System.out.print("Day: ");
            int day = scanner.nextInt();

            Date bornOnDate = new Date(year - 1900, month - 1, day);

            System.out.print("Age: ");
            int age = scanner.nextInt();

            System.out.print("Is molting? (true/false): ");
            boolean isMolting = scanner.nextBoolean();

            
            chickens.add(new Chicken(id, name, color, bornOnDate, age, isMolting));

            System.out.print("Do you want to add another chicken? (y/n): ");
            response = scanner.next().toLowerCase().charAt(0);

        } while (response == 'y');

        System.out.println("\n** CHICKENS LIST THE REGISTERED **");
        for (int i = 0; i < chickens.size(); i++) {
            System.out.println("name-->"+ chickens.get(i).getName());
            System.out.println("Chicken [" + (i + 1) + "] --> " + chickens.get(i));
        }
        
        
    }
}
