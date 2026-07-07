/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.mazeapplication.controller;

import ec.edu.espe.mazeapplication.model.Path;
import ec.edu.espe.mazeapplication.model.Room;
/**
 *
 * @author Cristian Palomo, Error 404, @ESPE
 */
public class PathController {
    private Path path;

    public PathController(Path path) {

        this.path = path;

    }

    public void addRoom(Room room) {

        path.addRoom(room);

    }
}
