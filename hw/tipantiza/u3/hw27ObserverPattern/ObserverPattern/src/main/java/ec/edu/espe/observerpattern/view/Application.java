

package ec.edu.espe.observerpattern.view;
import ec.edu.espe.observerpattern.controller.StockController;

/**
 *
 * @author Alexander Tipantiza, The Softwarrios, @ESPE
 */

public class Application {
    public static void main(String[] args) {
        StockController controller = new StockController();
        controller.runSimulation();
    }
}
