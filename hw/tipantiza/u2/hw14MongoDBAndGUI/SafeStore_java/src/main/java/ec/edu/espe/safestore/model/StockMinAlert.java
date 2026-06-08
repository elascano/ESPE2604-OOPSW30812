
package ec.edu.espe.safestore.model;
import java.util.Scanner;
/**
 *
 * @author Alexander Tipantiza, The Softwarriors, @ESPE
 */


public class StockMinAlert {
    
    public static void menu(Scanner scanner) {
        System.out.println("\n--- STOCK ALERTS ---");
        System.out.println("1. Configure minimum stock");
        System.out.println("2. Configure maximum stock");
        System.out.println("3. Generate alert");
        System.out.println("4. Record movement");
        System.out.println("5. View current stock");
        System.out.print("Option: ");
        int option = scanner.nextInt();
        
        switch(option) {
            case 1: configureMinimum(); break;
            case 2: configureMaximum(); break;
            case 3: generateAlert(); break;
            case 4: recordMovement(); break;
            case 5: viewCurrentStock(); break;
            default: System.out.println("Invalid option");
        }
    }
    
    private static void configureMinimum() { System.out.println("Minimum stock configured"); }
    private static void configureMaximum() { System.out.println("Maximum stock configured"); }
    private static void generateAlert() { System.out.println("Alert generated"); }
    private static void recordMovement() { System.out.println("Movement recorded"); }
    private static void viewCurrentStock() { System.out.println("Current stock: 100 units"); }
}