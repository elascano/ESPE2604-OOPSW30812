/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ec.espe.AbstractFactory.controller;

import edu.ec.espe.AbstractFactory.model.Button;
import edu.ec.espe.AbstractFactory.model.GUIFactory;
import edu.ec.espe.AbstractFactory.model.Menu;
import edu.ec.espe.AbstractFactory.view.Console;

/**
 *
 * @author Jennyfer Nase
 */
public class ClientAppController {
    public static void main(String[] args) {
        Console view = new Console();
        
        GUIFactory aFactory = GUIFactory.getFactory();
        
        Button aButton = aFactory.createButton();
        aButton.caption = "Play";
        view.renderButton(aButton);
        
        Menu aMenu = aFactory.createMenu();
        aMenu.caption = "File";
        view.renderMenu(aMenu);
    }
}