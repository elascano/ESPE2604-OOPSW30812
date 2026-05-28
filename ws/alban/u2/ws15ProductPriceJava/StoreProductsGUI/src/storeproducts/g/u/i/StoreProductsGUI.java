package storeproducts.g.u.i;

import javax.swing.SwingUtilities;

public class StoreProductsGUI {
    public static void main(String[] args) {
        // Hilo seguro para iniciar interfaces gráficas Swing de Java
        SwingUtilities.invokeLater(() -> {
            ProductView view = new ProductView();
            view.setVisible(true);
        });
    }
}