package ec.edu.espe.abstractfactory.controller;
/**
 *
 * @author Brandon Collahuazo,CodeBros,@ESPE
 */
import ec.edu.espe.abstractfactory.model.*;

public class LinuxFactory extends GUIFactory {

    public Button createButton() {
        return new LinuxButton();
    }

    public Menu createMenu() {
        return new LinuxMenu();
    }
}
