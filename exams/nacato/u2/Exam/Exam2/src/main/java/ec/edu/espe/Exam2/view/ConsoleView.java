/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.Exam2.view;
import ec.edu.espe.Exam2.controller.DiagramController;
import java.util.Scanner;

/**
 *
 * @author Angie Ñacato, Error 404, @ESPE
 */

public class ConsoleView {
    public static void main(String[] args) {
        DiagramController controller = new DiagramController();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("     SISTEMA DE DEMOSTRACION DE DIAGRAMA    ");
            System.out.println("1. Instanciar y Mostrar Objetos del Diagrama");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opcion: ");
            
            while (!scanner.hasNextInt()) {
                System.out.print("Por favor, ingrese un numero valido: ");
                scanner.next();
            }
            option = scanner.nextInt();

            if (option == 1) {
                System.out.println("\n--- GENERANDO E INSTANCIANDO OBJETOS ---");
                controller.runDemonstration();
            }
        } while (option != 2);

        System.out.println("Programa finalizado con exito.");
        scanner.close();
    }
}