/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.mazeapplication.controller;

import ec.edu.espe.mazeapplication.model.Door;
/**
 *
 * @author Cristian Palomo, Error 404, @ESPE
 */
public class DoorController {
    private Door door;

    public DoorController(Door door) {

        this.door = door;

    }

    public void openDoor() {

        door.openDoor();

    }

    public void closeDoor() {

        door.closeDoor();

    }
}
