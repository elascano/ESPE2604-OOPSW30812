/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.videogame.controller;
import ec.edu.espe.videogame.model.Character;

/**
 *
 * @author ronal
 */
public class CombatSystem {

    public void startBattle(Character character) {
        System.out.println("Battle Started");
        character.attack();
        character.defend();
    }
}
