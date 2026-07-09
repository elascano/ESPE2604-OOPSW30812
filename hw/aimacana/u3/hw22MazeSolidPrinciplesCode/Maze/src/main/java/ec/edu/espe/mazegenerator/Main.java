package ec.edu.espe.mazegenerator;

import ec.edu.espe.mazegenerator.view.GUIView;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Lanzamos la Interfaz Grafica
        SwingUtilities.invokeLater(() -> {
            GUIView view = new GUIView();
            view.setVisible(true);
        });
    }
}
