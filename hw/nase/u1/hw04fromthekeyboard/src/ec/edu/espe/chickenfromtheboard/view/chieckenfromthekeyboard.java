package ec.edu.espe.chickencoops.view;
/**
 *
 * @author Jennyfer Nase
 */
import ec.edu.espe.chickencoops.model.Chicken;
import java.util.Date;
import java.util.Scanner;


public class chieckenfromthekeyboard { 
    public static void main (String [] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        int id = 0;
        String name = "";
        String color = ""; 
        Date bornOnDate = new Date();
        int age = 0; 
        boolean isMolting = false;
        
        Chicken chickens[] = new Chicken[5];
        int count = 0;
        String response = "no";
        
        System.out.println("--- Jennyfer Nase ---");

        do {
            System.out.println("\n Chicken #" + (count + 1));
            
            System.out.print("ID: ");
            id = scanner.nextInt();
            scanner.nextLine(); 

            System.out.print("Name: ");
            name = scanner.nextLine();

            System.out.print("Color: ");
            color = scanner.nextLine();
            
            System.out.print("Age: ");
            age = scanner.nextInt(); 
            scanner.nextLine(); 

            System.out.print("isMolting (true/false): ");
            isMolting = scanner.nextBoolean();
            scanner.nextLine(); 

            bornOnDate = new Date();

            chickens[count] = new Chicken(id, name, color, bornOnDate, age, isMolting);
            count++;

            if (count < 5) {
                System.out.print("Do you want to enter another one? (yes/no): ");
                response = scanner.nextLine();
            } else {
                response = "no";
            }

        } while (response.equalsIgnoreCase("yes") && count < 5);

        System.out.println("\n--- FINAL RESULTS ---");
        for (int i = 0; i < count; i++) {
            System.out.println(chickens[i]);
        }
    }
}