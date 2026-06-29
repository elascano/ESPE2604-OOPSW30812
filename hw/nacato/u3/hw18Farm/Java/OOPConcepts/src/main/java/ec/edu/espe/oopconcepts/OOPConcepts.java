/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package ec.edu.espe.oopconcepts;

import ec.edu.espe.oopconcepts.view.FrmMenu;
import javax.swing.UIManager;

/**
 *
 * @author Angie Ñacato, ERROR 404, @ESPE
 */
public class OOPConcepts {

    public static void main(String[] args) {

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(() -> {
            new FrmMenu().setVisible(true);
        });
    }
}
