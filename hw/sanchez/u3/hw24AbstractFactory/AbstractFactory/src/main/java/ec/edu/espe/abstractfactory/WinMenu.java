/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.abstractfactory;

/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */
public class WinMenu extends Menu {

    @Override
    public void paint() {
        System.out.println("I'm a Windows Menu: " + caption);
    }
}
