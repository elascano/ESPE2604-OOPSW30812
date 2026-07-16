
package ec.edu.espe.abstractfactory.model;

/**
 *
 * @author Alexander Tipantiza, The Softwarrios, @ESPE
 */

public class MacFactory extends GUIFactory {
    public Button createButton() {
        return new MacButton();
    }
    
    public Menu createMenu() {
        return new MacMenu();
    }
}
