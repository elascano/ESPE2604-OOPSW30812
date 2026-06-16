/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.fromumltocode.view;

import ec.edu.espe.fromumltocode.controller.MainController;

/**
 *
 * @author Adrian Vizcaino <The-Softwarrios at ESPE>
 */


public class Main {
    public static void main(String[] args) {

        ConsoleView view = new ConsoleView();
        MainController controller = new MainController(view);

        controller.run();
    }
}
