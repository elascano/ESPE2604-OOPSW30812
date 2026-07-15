/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ec.espe.AbstractFactory.view;

import edu.ec.espe.AbstractFactory.model.Button;
import edu.ec.espe.AbstractFactory.model.Menu;

/**
 *
 * @author Jennyfer Nase
 */
public class Console {
   public void renderButton(Button button) {
        button.paint();
    }
    public void renderMenu(Menu menu) {
        menu.paint();
    }
    public void displayMessage(String message) {
        System.out.println(message);
    }
}
