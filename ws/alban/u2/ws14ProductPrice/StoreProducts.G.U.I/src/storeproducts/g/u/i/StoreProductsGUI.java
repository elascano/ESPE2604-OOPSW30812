package storeproducts.g.u.i;

import javax.swing.SwingUtilities;

public class StoreProductsGUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ProductView view = new ProductView();
            new ProductController(view);
            view.setVisible(true);
        });
    }
}