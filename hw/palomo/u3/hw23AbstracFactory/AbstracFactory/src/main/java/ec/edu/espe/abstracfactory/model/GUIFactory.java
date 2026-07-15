/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.espe.abstracfactory.model;

/**
 *
 * @author Cristian
 */
public interface GUIFactory {
    Button createButton();
    Menu createMenu();
    
    static GUIFactory getFactory(String os){
        if(os == null){
            throw new IllegalArgumentException("The operating system cannot be null.");
        }
        switch(os.trim().toLowerCase()){
            case "windows":
                return new WinFactory();
            case "linux":
                return new LinuxFactory();
            default:
                throw new IllegalArgumentException("Unsupported operating system: " + os);
        }
    }
}
