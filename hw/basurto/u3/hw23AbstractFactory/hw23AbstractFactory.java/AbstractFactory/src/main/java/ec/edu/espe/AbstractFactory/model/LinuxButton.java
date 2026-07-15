
package ec.edu.espe.AbstractFactory.model;

/**
 *
 * @author Esteban Basurto,CodeBreakers,@ESPE
 */
public class LinuxButton extends Button {
    @Override
    public String paint() {
        return "I'm a LinuxButton: " + caption;
    }
}
