package ec.edu.espe.abstractfactory.controller;
/**
 *
 * @author Brandon Collahuazo,CodeBros,@ESPE
 */
import ec.edu.espe.abstractfactory.model.*;

public class MacFactory extends GUIFactory {

    public Button createButton() {
        return new MacButton();
    }

    public Menu createMenu() {
        return new MacMenu();
    }
}
