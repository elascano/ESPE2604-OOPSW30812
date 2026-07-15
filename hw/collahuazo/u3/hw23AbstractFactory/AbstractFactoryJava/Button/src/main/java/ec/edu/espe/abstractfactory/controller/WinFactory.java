package ec.edu.espe.abstractfactory.controller;
/**
 *
 * @author Brandon Collahuazo,CodeBros,@ESPE
 */
import ec.edu.espe.abstractfactory.model.*;

public class WinFactory extends GUIFactory {

    public Button createButton() {
        return new WinButton();
    }

    public Menu createMenu() {
        return new WinMenu();
    }
}
