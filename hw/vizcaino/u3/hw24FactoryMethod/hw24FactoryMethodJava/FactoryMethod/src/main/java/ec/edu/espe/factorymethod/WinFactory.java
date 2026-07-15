/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.factorymethod;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */
public class WinFactory extends GUIFactory {
    public Button createButton() {
        return new WinButton();
    }
    public Menu createMenu() {
        return new WinMenu();
    }
}