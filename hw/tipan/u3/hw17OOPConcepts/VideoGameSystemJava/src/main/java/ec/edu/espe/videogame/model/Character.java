/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.videogame.model;
import ec.edu.espe.videogame.interfaces.Attackable;

/**
 *
 * @author ronal
 */
public abstract class Character implements Attackable {

    private int id;
    private String name;
    private int level;
    private int health;
    private Inventory inventory;

    public Character(int id, String name, int level, int health) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.health = health;
        inventory = new Inventory();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getHealth() {
        return health;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    
    public abstract void displayInfo();
}
