/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.abstractfactory.model;

/**
 *
 * @author Alexander Tipantiza, The Softwarrios, @ESPE
 */

public class LinuxFactory extends GUIFactory {
    public Button createButton() {
        return new LinuxButton();
    }
    
    public Menu createMenu() {
        return new LinuxMenu();
    }
}
