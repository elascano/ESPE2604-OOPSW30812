
package ec.edu.espe.AbstractFactory.model;

/**
 *
 * @author Esteban Basurto,CodeBreakers,@ESPE
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
