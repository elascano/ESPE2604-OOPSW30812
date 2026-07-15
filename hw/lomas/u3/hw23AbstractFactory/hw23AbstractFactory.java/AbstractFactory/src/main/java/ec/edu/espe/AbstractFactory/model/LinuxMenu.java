
package ec.edu.espe.AbstractFactory.model;

/**
 *
 * @author Christopher Lomas,<CodeBros,@ESPE>
 */
public class LinuxMenu extends Menu {
    @Override
    public String paint() {
        return "I'm a LinuxMenu: " + caption;
    }
}
