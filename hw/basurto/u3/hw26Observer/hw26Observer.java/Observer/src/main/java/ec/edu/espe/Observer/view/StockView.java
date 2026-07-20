
package ec.edu.espe.Observer.view;
import ec.edu.espe.Observer.model.Stock;
/**
 *
 * @author Esteban Basurto, CodeBreakers, @ESPE
 */
public class StockView {
    public static void printNotification(String investorName, Stock stock, Object args) {
        System.out.println("Notified observer " + investorName);
        if (args instanceof String) {
            System.out.println("The symbol of " + stock.getSymbol() + " changed to: " + args);
        } else if (args instanceof Double) {
            System.out.println("The price of " + stock.getSymbol() + " changed to: " + args);
        }
    }
}
