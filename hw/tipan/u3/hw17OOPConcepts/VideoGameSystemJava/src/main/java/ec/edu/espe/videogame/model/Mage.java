/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.videogame.model;

/**
 *
 * @author ronal
 */
public class Mage extends Character {

    public Mage(int id, String name, int level, int health) {
        super(id, name, level, health);
    }

    @Override
    public void attack() {
        System.out.println(getName() + " casts a fire spell");
    }

    @Override
    public void defend() {
        System.out.println(getName() + " creates a magic barrier");
    }

    @Override
    public void displayInfo() {
        System.out.println(
                "Mage: "
                + getName()
                + " Level: "
                + getLevel()
                + " Health: "
                + getHealth()
        );
    }
}