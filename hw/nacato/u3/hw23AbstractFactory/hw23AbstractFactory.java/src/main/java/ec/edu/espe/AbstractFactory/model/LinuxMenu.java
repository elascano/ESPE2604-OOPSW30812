
package ec.edu.espe.AbstractFactory.model;

/**
 *
 * @author Angie Ñacato, Error 404, @ESPE
 */
public class LinuxMenu extends Menu {
    @Override
    public String paint() {
        return "I'm a LinuxMenu: " + caption;
    }
}
