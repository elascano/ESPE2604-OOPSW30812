package ec.edu.espe.shoppingstore;

import ec.edu.espe.shoppingstore.view.FrmCustomer;
import javax.swing.SwingUtilities;

/**
 *
 * @author Collahuazo Brandon, CodeBros, @ESPE
 */
public class ShoppingStore {
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FrmCustomer frame = new FrmCustomer();
            frame.setVisible(true);
        });
    }
}
