/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.widgets.model;

import ec.edu.espe.widgets.controller.ConfigReader;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public abstract class GUIFactory {

    public static GUIFactory getFactory() {

        int sys = ConfigReader.readFromConfigFile("OS_TYPE");

        if (sys == 0) {
            return new WinFactory();
        } else {
            return new LinuxFactory();
        }
    }

    public abstract Button createButton();

    public abstract Menu createMenu();
}
