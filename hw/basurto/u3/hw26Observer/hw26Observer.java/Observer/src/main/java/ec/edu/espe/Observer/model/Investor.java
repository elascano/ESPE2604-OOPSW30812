
package ec.edu.espe.Observer.model;
import ec.edu.espe.Observer.view.StockView;
/**
 *
 * @author Esteban Basurto, CodeBreakers, @ESPE
 */
public class Investor implements IInvestor {
    private String name;
    private String observerState;
    private Stock stock;

    public Investor(String name) {
        this.name = name;
    }

    @Override
    public void update(Stock stock, Object args) {
        this.stock = stock;
        StockView.printNotification(name, stock, args);
    }
}
