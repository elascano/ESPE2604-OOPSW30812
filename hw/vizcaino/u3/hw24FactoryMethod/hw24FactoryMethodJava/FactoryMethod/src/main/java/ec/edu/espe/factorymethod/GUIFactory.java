/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.factorymethod;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */
public abstract class GUIFactory {
    public static GUIFactory getFactory() {
        int sys = readFromConfigFile("OS_TYPE");
        if (sys == 0) {
            return new WinFactory();
        } else {
            return new LinuxFactory();
        }
    }

    private static int readFromConfigFile(String key) {
        return 0; 
    }

    public abstract Button createButton();
    public abstract Menu createMenu();
}