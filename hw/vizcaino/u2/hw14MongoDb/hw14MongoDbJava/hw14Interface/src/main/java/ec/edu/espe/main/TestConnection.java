/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.main;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */

import ec.edu.espe.model.MongoConnection;

public class TestConnection {

    public static void main(String[] args) {

        System.out.println("Connected to database: "
                + MongoConnection.getDatabase().getName());

    }
}