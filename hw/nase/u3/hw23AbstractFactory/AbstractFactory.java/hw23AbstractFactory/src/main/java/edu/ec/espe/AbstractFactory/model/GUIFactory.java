/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ec.espe.AbstractFactory.model;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Jennyfer Nase
 */
public abstract class GUIFactory {
    
    public static GUIFactory getFactory() {
        int sys = readFromFile("OS_TYPE");
        if (sys == 0) {
            return new WinFactory();
        } 
        else {
            return new LinuxFactory();
        }
    }

    private static int readFromFile(String key) {
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("config.properties"));
            return Integer.parseInt(prop.getProperty(key, "0"));
        } catch (IOException | NumberFormatException e) {
            return 0; 
        }
    }

    public abstract Button createButton();
    public abstract Menu createMenu();
}
