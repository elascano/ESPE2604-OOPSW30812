/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.abstracfactory.model;

/**
 *
 * @author Cristian Palomo, Error 404, @ESPE
 */
public class WinFactory implements GUIFactory{
    
    @Override
    public Button createButton() {
        return new WinButton();
    }

    @Override
    public Menu createMenu() {
        return new WinMenu();
    }
}
