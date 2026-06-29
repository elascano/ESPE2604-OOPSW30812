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
public class Inventory {

    private List<Weapon> weapons;

    public Inventory() {
        weapons = new ArrayList<>();
    }

    public void addWeapon(Weapon weapon) {
        weapons.add(weapon);
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public void showWeapons() {
        for (Weapon weapon : weapons) {
            System.out.println(weapon);
        }
    }
}