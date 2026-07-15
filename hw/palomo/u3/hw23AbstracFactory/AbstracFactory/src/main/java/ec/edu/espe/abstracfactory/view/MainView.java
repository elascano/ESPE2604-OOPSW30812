/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.abstracfactory.view;

import java.util.Scanner;
import ec.edu.espe.abstracfactory.model.GUIFactory;
import ec.edu.espe.abstracfactory.controller.ClientApp;

/**
 *
 * @author Cristian Palomo, Error 404, @ESPE
 */
public class MainView {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Abstract Factory - GUI Multiplataforma ===");
        System.out.print("Ingrese el sistema operativo (windows/linux): ");
        String os = sc.nextLine();

        try {
            GUIFactory factory = GUIFactory.getFactory(os);

            ClientApp app = new ClientApp(factory);
            app.createInterface();
            app.renderInterface();

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
