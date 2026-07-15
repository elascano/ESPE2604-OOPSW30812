import controller.CalculatorController;
import model.USTax;
import view.CalculatorView;
/**
 *
 * @author Angie Ñacato, Error 404, @ESPE
 * 
 * 
 */
public class calculator {
    public static void main(String args[]) {
        USTax tax = USTax.getInstance();
        tax.salesTotal();
        tax = new USTax();
        CalculatorView view = new CalculatorView();
        CalculatorController controller = new CalculatorController(view);

        controller.runInteractiveCalculation();
    }
}