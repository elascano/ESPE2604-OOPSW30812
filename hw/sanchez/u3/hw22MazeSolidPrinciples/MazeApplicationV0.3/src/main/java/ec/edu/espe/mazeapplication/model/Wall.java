/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.mazeapplication.model;

/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */
public class Wall {

    private boolean solid;

    public Wall() {
        solid = true;
    }

    public boolean isSolid() {
        return solid;
    }

    public void setSolid(boolean solid) {
        this.solid = solid;
    }

}
