/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.clientapp.controller;

import ec.edu.espe.clientapp.model.*;

/**
 *
 * @author Odalys Chavez, CodeBreakers, @ESPE
 */
public class GUIController {
     public void start() {

        GUIFactory factory = GUIFactory.getFactory();

        Button button = factory.createButton();
        button.caption = "Play";
        button.paint();

        Menu menu =factory.createMenu();
        menu.caption = "File";
        menu.paint();
    }
    
}
