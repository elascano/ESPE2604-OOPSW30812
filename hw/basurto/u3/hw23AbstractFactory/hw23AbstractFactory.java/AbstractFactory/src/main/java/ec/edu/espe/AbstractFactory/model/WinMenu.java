
package ec.edu.espe.AbstractFactory.model;

/**
 *
 *@author Esteban Basurto,CodeBreakers,@ESPE
 */
public class WinMenu extends Menu {
    @Override
    public String paint() {
        return "I'm a WinMenu: " + caption;
    }
}
