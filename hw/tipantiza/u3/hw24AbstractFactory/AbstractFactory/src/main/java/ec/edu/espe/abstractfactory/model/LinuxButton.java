
package ec.edu.espe.abstractfactory.model;

/**
 *
 * @author Alexander Tipantiza, The Softwarrios, @ESPE
 */

public class LinuxButton extends Button {
    public void paint() {
        System.out.println("I'm a LinuxButton: " + caption);
    }
}
