
package ec.edu.espe.safestore.model;
import java.util.Scanner;
/**
 *
 * @author Alexander Tipantiza, The Softwarriors, @ESPE
 */


public class UIAdaptive {
    
    public static void menu(Scanner scanner) {
        System.out.println("\n--- ADAPTIVE UI ---");
        System.out.println("1. Apply theme");
        System.out.println("2. High contrast");
        System.out.println("3. Restore default");
        System.out.println("4. Assign shortcut");
        System.out.println("5. List shortcuts");
        System.out.print("Option: ");
        int option = scanner.nextInt();
        
        switch(option) {
            case 1: applyTheme(); break;
            case 2: highContrast(); break;
            case 3: restoreDefault(); break;
            case 4: assignShortcut(); break;
            case 5: listShortcuts(); break;
            default: System.out.println("Invalid option");
        }
    }
    
    private static void applyTheme() { System.out.println("Theme applied"); }
    private static void highContrast() { System.out.println("High contrast activated"); }
    private static void restoreDefault() { System.out.println("Default values restored"); }
    private static void assignShortcut() { System.out.println("Shortcut assigned"); }
    private static void listShortcuts() { System.out.println("Listing shortcuts"); }
}
