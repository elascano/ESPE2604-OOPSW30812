/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.videogame.model;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ronal
 */
public class Team {

    private String name;
    private List<Character> characters;

    public Team(String name) {
        this.name = name;
        characters = new ArrayList<>();
    }

    public void addCharacter(Character character) {
        characters.add(character);
    }

    public void showTeam() {
        System.out.println("Team: " + name);

        for (Character character : characters) {
            character.displayInfo();
        }
    }
}