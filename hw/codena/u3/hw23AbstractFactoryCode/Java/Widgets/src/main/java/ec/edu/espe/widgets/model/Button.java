/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.widgets.model;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public abstract class Button {
    
    private String caption;
    
    public abstract void paint();

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
    
}
