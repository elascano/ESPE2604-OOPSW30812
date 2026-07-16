
package ec.edu.espe.AbstractFactory.model;

/**
 *
 * @author Angie Ñacato, Error 404, @ESPE
 */
public class WinMenu extends Menu {
    @Override
    public String paint() {
        return "I'm a WinMenu: " + caption;
    }
}
