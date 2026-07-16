/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.abstracfactory.controller;

import ec.edu.espe.abstracfactory.model.GUIFactory;
import ec.edu.espe.abstracfactory.model.Button;
import ec.edu.espe.abstracfactory.model.Menu;

/**
 *
 * @author Cristian Palomo, Error 404, @ESPE
 */
public class ClientApp {
    
    private final GUIFactory factory;
    private Button button;
    private Menu menu;
    
    public ClientApp(GUIFactory factory){
        this.factory = factory;
    }
    
    public  void createInterface(){
        this.button = factory.createButton();
        this.menu = factory.createMenu();
    }
    
    public void renderInterface(){
        if(button == null || menu == null){
            throw new IllegalStateException("You must call createInterface() before rendering.");
        }
        button.paint();
        menu.paint();
    }
    
    public Button getButton(){
        return button;
    }
    
    public Menu getMenu() {
        return menu;
    }
}
