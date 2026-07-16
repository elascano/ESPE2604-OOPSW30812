package ec.edu.espe.abstractfactory.controller;
/**
 *
 * @author Brandon Collahuazo,CodeBros,@ESPE
 */
import ec.edu.espe.abstractfactory.model.*;

public abstract class GUIFactory {

    public abstract Button createButton();

    public abstract Menu createMenu();
}
