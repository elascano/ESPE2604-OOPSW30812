package ec.edu.espe.librarysystem.view;

import javax.swing.JFrame;
/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */
public class FrmMain extends JFrame {

    public FrmMain() {

        setTitle("Library System");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(new BookPanel());

        setVisible(true);
    }

    public static void main(String[] args) {

        new FrmMain();
    }
}
