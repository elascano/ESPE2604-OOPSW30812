
package ec.edu.espe.AbstractFactory.controller;
import ec.edu.espe.AbstractFactory.model.Button;
import ec.edu.espe.AbstractFactory.model.GUIFactory;
import ec.edu.espe.AbstractFactory.model.Menu;

/**
 *
 * @author Esteban Basurto,CodeBreakers,@ESPE
 */
public class WidgetController {
    public String generateWidgets() {
        GUIFactory aFactory = GUIFactory.getFactory();
        
        Button aButton = aFactory.createButton();
        aButton.caption = "Play";
        
        Menu aMenu = aFactory.createMenu();
        aMenu.caption = "File";
        
        return aButton.paint() + "\n" + aMenu.paint();
    }
}
