
package ec.edu.espe.abstractfactory.model;

/**
 *
 * @author Alexander Tipantiza, The Softwarrios, @ESPE
 */

public class WinButton extends Button {
    public void paint() {
        System.out.println("I'm a WnButton: " + caption);
    }
}
