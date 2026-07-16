package ec.edu.espe.abstractfactory.view;

/**
 *
 * @author Brandon Collahuazo,CodeBros,@ESPE
 */
import ec.edu.espe.abstractfactory.controller.*;
import ec.edu.espe.abstractfactory.model.*;

public class ClientApp {

    public static void main(String[] args) {
        GUIFactory[] f = {new WinFactory(), new LinuxFactory(), new MacFactory()};
        String[] n = {"WINDOWS", "LINUX", "macOS"};
        for (int i = 0; i < f.length; i++) {
            
            System.out.println("----- " + n[i] + " -----");
            Button button = f[i].createButton();
            Menu menu = f[i].createMenu();
            
            button .caption = "Play";
            menu.caption = "File";
            
            button .paint();
            menu.paint();
        }
    }
}
