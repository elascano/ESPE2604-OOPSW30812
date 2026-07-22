/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.clientapp.model;

/**
 *
 * @author Odalys Chavez, CodeBreakers, @ESPE
 */
public abstract class GUIFactory {
    public static GUIFactory getFactory() {

        String osName = System.getProperty("os.name");

        if (osName.startsWith("Windows"))
            return new WinFactory();
        else
            return new LinuxFactory();
    }

    public abstract Button createButton();
    public abstract Menu createMenu();
    
}
