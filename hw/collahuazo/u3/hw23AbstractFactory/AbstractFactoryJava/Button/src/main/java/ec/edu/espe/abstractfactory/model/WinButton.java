package ec.edu.espe.abstractfactory.model;
/**
 *
 * @author Brandon Collahuazo,CodeBros,@ESPE
 */
public class WinButton extends Button {

    public void paint() {
        System.out.println("I'm a WinButton: " + caption);
    }
}
