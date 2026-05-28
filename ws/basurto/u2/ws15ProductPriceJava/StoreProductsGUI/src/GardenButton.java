package storeproducts.g.u.i;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Cursor;

public class GardenButton extends JButton {
    
    public GardenButton(String text) {
        super(text);
        // Estilo personalizado para los botones de la tienda
        setFont(new Font("Arial", Font.BOLD, 12));
        setBackground(new Color(230, 245, 230)); // Fondo verde suave
        setForeground(new Color(30, 70, 30));     // Texto verde oscuro
        setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cursor de mano
    }
}