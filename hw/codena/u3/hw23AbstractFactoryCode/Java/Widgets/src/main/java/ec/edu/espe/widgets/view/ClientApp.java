/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.widgets.view;

import ec.edu.espe.widgets.model.Button;
import ec.edu.espe.widgets.model.GUIFactory;
import ec.edu.espe.widgets.model.Menu;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class ClientApp {

    public static void main(String[] args) {
        GUIFactory factory = GUIFactory.getFactory();

        Button button = factory.createButton();
        Menu menu = factory.createMenu();

        button.setCaption("Play");
        menu.setCaption("Configuration");

        button.paint();
        menu.paint();
    }
}
