/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.abstractfactory.controller;

import ec.edu.espe.abstractfactory.model.Button;
import ec.edu.espe.abstractfactory.model.GUIFactory;
import ec.edu.espe.abstractfactory.model.Menu;

/**
 *
 * @author Ronald
 */
public class WidgetController {

    public String generateWidgets() {

        GUIFactory factory = GUIFactory.getFactory();

        Button button = factory.createButton();
        button.setCaption("Play");

        Menu menu = factory.createMenu();
        menu.setCaption("File");

        String result = "";

        result += button.paint() + "\n";
        result += menu.paint();

        return result;
    }

}
