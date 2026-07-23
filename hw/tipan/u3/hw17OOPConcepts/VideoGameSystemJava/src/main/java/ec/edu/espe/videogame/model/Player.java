/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.videogame.model;

/**
 *
 * @author ronal
 */
public class Player {

    private String username;
    private Character character;

    public Player(String username, Character character) {
        this.username = username;
        this.character = character;
    }

    public String getUsername() {
        return username;
    }

    public Character getCharacter() {
        return character;
    }
}
