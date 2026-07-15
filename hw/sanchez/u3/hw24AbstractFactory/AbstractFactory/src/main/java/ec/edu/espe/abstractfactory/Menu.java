/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.abstractfactory;

/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */
public abstract class Menu {
    protected String caption;

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public abstract void paint();
}