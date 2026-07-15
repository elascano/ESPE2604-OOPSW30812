/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.abstractfactory;

/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */
public abstract class GUIFactory {

    public static GUIFactory getFactory(String os) {

        switch (os.toLowerCase()) {
            case "windows":
                return new WinFactory();

            case "linux":
                return new LinuxFactory();

            case "macos":
                return new MacFactory();

            default:
                throw new IllegalArgumentException("Unsupported OS");
        }
    }

    public abstract Button createButton();

    public abstract Menu createMenu();
}
