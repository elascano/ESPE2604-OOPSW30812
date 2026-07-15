package ec.edu.espe.abstractfactory;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */
public class MacMenu extends Menu {

    @Override
    public void paint() {
        System.out.println("I'm a MacOS Menu: " + caption);
    }
}
