
package ec.edu.espe.templatemethod.view;
import ec.edu.espe.templatemethod.controller.BeverageController;

/**
 *
 * @author Alexander Tipantiza, The Softwarrios, @ESPE
 */

public class BeverageTest {
    public static void main(String[] args) {
        BeverageController controller = new BeverageController();
        controller.prepareAllBeverages();
    }
}
