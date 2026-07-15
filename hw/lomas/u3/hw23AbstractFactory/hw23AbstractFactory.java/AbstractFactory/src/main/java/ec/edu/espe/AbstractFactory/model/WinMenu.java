
package ec.edu.espe.AbstractFactory.model;

/**
 *
 * @author Christopher Lomas,<CodeBros,@ESPE>
 */
public class WinMenu extends Menu {
    @Override
    public String paint() {
        return "I'm a WinMenu: " + caption;
    }
}
