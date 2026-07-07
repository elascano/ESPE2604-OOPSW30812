/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.mazeapplication.model;

import java.util.ArrayList;
/**
 *
 * @author Cristian Palomo, Error 404, @ESPE
 */
public class Path {
    private ArrayList<Room> rooms;

    public Path() {

        rooms = new ArrayList<>();

    }

    public void addRoom(Room room) {

        rooms.add(room);

    }

    public ArrayList<Room> getRooms() {

        return rooms;

    }
}
