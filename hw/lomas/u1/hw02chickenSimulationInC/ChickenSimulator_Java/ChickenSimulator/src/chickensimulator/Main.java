
package chickensimulator;
import java.util.Scanner;

public class Main {
    static String name = "Lucy";
    static String color = "Brown and White";
    static int age = 2;
    static boolean isMolting = false;
    static int eggCounter = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("1. cluck\n2. wander\n3. eat\n4. drink\n5. poop\n6. lay an egg\n7. show state\n0. exit");
            System.out.print("Select behavior: ");
            option = scanner.nextInt();

            switch (option) {
                case 1 -> System.out.println(name + ": Cluck cluck!");
                case 2 -> System.out.println(name + " is wandering around.");
                case 3 -> System.out.println(name + " is eating.");
                case 4 -> System.out.println(name + " is drinking.");
                case 5 -> System.out.println(name + " did poop.");
                case 6 -> {
                    eggCounter++;
                    System.out.println(name + " laid an egg! Total: " + eggCounter);
                }
                case 7 -> showState();
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid option.");
            }
        } while (option != 0);
    }

    static void showState() {
        System.out.println("\n--- Chicken State ---");
        System.out.println("Name: " + name);
        System.out.println("Color: " + color);
        System.out.println("Age: " + age + " years old");
        System.out.println("Molting: " + (isMolting ? "Yes" : "No"));
        System.out.println("Eggs: " + eggCounter);
        System.out.println("---------------------\n");
    }
}