/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package espe.edu.ec.Observer;

import espe.edu.ec.Obvserver.controller.StockController;
import espe.edu.ec.Obvserver.view.Console;

/**
 *
 * @author Jennyfer Nase
 */
public class Application {
    public static void main(String[] args) {
        Console view = new Console();
        StockController controller = new StockController(view);
                controller.startSimulation();
    }
}