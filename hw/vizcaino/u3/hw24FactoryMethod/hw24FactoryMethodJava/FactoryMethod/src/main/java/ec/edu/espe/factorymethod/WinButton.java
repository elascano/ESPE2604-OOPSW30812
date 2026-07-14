/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.factorymethod;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */
public class WinButton extends Button {
    public void paint() {
        System.out.println("I'm a WinButton: " + caption);
    }
}