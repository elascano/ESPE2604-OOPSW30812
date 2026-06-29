/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.videogame.model;

/**
 *
 * @author ronal
 */
public class Warrior extends Character {

    public Warrior(int id, String name, int level, int health) {
        super(id, name, level, health);
    }

    @Override
    public void attack() {
        System.out.println(getName() + " attacks with a sword");
    }

    @Override
    public void defend() {
        System.out.println(getName() + " blocks with a shield");
    }

    @Override
    public void displayInfo() {
        System.out.println(
                "Warrior: "
                + getName()
                + " Level: "
                + getLevel()
                + " Health: "
                + getHealth()
        );
    }
}