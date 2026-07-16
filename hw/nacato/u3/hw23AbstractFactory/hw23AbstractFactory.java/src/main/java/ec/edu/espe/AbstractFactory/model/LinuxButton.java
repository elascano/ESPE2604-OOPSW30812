
package ec.edu.espe.AbstractFactory.model;

/**
 *
 * @author Angie Ñacato, Error 404, @ESPE
 */
public class LinuxButton extends Button {
    @Override
    public String paint() {
        return "I'm a LinuxButton: " + caption;
    }
}
