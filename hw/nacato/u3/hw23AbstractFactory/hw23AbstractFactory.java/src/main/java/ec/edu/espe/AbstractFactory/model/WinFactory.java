
package ec.edu.espe.AbstractFactory.model;

/**
 *
 * @author Angie Ñacato, Error 404, @ESPE
 */
public class WinFactory extends GUIFactory {
    @Override
    public Button createButton() {
        return new WinButton();
    }
    @Override
    public Menu createMenu() {
        return new WinMenu();
    }
}
