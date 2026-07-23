/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.videogame.model;

/**
 *
 * @author ronal
 */
public class Archer extends Character {

    public Archer(int id, String name, int level, int health) {
        super(id, name, level, health);
    }

    @Override
    public void attack() {
        System.out.println(getName() + " shoots an arrow");
    }

    @Override
    public void defend() {
        System.out.println(getName() + " dodges the attack");
    }

    @Override
    public void displayInfo() {
        System.out.println(
                "Archer: "
                + getName()
                + " Level: "
                + getLevel()
                + " Health: "
                + getHealth()
        );
    }
}