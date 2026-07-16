/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.abstractfactory.model;

public class WinButton extends Button {

    @Override
    public String paint() {
        return "I'm a WinButton: " + caption;
    }

}
