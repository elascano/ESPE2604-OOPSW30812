
package ec.edu.espe.abstractfactory.model;
import ec.edu.espe.abstractfactory.controller.ConfigReader;
/**
 *
 * @author Alexander Tipantiza, The Softwarrios, @ESPE
 */

public abstract class GUIFactory {
    
    public static GUIFactory getFactory() {
        int sys = ConfigReader.getOSType();
        if (sys == 0) {
            return new WinFactory();
        } else if (sys == 2) {
            return new MacFactory();
        } else {
            return new LinuxFactory();
        }
    }
    
    public abstract Button createButton();
    public abstract Menu createMenu();
}