/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.mazeapplication.controller;

import ec.edu.espe.mazeapplication.model.Room;
/**
 *
 * @author Cristian Palomo, Error 404, @ESPE
 */
public class RoomController {
    private Room room;

    public RoomController(Room room) {

        this.room = room;

    }

    public boolean validateRoom() {

        return room.countDoors() <= 3 &&
               room.countWalls() <= 3;

    }
}
