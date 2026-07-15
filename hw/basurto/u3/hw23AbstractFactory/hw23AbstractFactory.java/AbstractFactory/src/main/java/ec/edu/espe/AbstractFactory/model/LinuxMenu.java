
package ec.edu.espe.AbstractFactory.model;

/**
 *
 * @author Esteban Basurto,CodeBreakers,@ESPE
 */
public class LinuxMenu extends Menu {
    @Override
    public String paint() {
        return "I'm a LinuxMenu: " + caption;
    }
}
