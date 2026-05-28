package ec.edu.espe.productpomds;

import ec.edu.espe.productpomds.view.ProductView;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * Package:     ec.edu.espe.productpomds
 * Class:       MainApp
 * Description: Entry point for Product POMDS
 */
public class MainApp {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> {
            ProductView view = new ProductView();
            view.setVisible(true);
        });
    }
}
