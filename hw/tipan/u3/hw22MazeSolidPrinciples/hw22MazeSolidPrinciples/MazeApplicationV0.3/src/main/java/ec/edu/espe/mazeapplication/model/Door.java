/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.mazeapplication.model;

/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */
public class Door {

    private boolean open;

    public Door() {
        open = false;
    }

    public boolean isOpen() {
        return open;
    }

    public void openDoor() {
        open = true;
    }

    public void closeDoor() {
        open = false;
    }

}
