
package ec.edu.espe.AbstractFactory.model;

/**
 *
 * @author Christopher Lomas,<CodeBros,@ESPE>
 */
public class WinButton extends Button {
    @Override
    public String paint() {
        return "I'm a WinButton: " + caption;
    }
}
