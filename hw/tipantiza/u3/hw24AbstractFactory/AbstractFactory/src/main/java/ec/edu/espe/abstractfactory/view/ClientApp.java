

package ec.edu.espe.abstractfactory.view;
import ec.edu.espe.abstractfactory.model.Button;
import ec.edu.espe.abstractfactory.model.GUIFactory;
import ec.edu.espe.abstractfactory.model.Menu;
import ec.edu.espe.abstractfactory.controller.ConfigReader;

/**
 *
 * @author Alexander Tipantiza, The Softwarrios, @ESPE
 */


public class ClientApp {
    
    public static void main(String[] args) {
        System.out.println("=== Abstract Factory Pattern Demo ===");
        System.out.println("Operating System: " + ConfigReader.getOperatingSystemName());
        System.out.println("----------------------------------------");
        
        GUIFactory aFactory = GUIFactory.getFactory();
        
        Button aButton = aFactory.createButton();
        aButton.caption = "play";
        aButton.paint();
        
        Menu aMenu = aFactory.createMenu();
        aMenu.caption = "Main Menu";
        aMenu.paint();
        
        System.out.println("----------------------------------------");
        
        Button anotherButton = aFactory.createButton();
        anotherButton.caption = "stop";
        anotherButton.paint();
        
        Menu anotherMenu = aFactory.createMenu();
        anotherMenu.caption = "Context Menu";
        anotherMenu.paint();
    }
}
