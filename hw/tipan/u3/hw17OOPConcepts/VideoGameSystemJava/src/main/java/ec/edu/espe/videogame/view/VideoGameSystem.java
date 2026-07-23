/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.videogame.view;
import ec.edu.espe.videogame.controller.CombatSystem;
import ec.edu.espe.videogame.model.Archer;
import ec.edu.espe.videogame.model.Character;
import ec.edu.espe.videogame.model.Mage;
import ec.edu.espe.videogame.model.Player;
import ec.edu.espe.videogame.model.Team;
import ec.edu.espe.videogame.model.Warrior;
import ec.edu.espe.videogame.model.Weapon;
import utils.CharacterDAO;

/**
 *
 * @author ronal
 */
public class VideoGameSystem {

    public static void main(String[] args) {

        Character warrior = new Warrior(1, "Arthur", 10, 100);
        Character mage = new Mage(2, "Merlin", 12, 80);
        Character archer = new Archer(3, "Robin", 11, 90);

        warrior.getInventory().addWeapon(new Weapon("Excalibur", 50));
        mage.getInventory().addWeapon(new Weapon("Magic Staff", 45));
        archer.getInventory().addWeapon(new Weapon("Long Bow", 40));

        warrior.displayInfo();
        mage.displayInfo();
        archer.displayInfo();

        Player player = new Player("PlayerOne", warrior);

        System.out.println();
        System.out.println("Player: " + player.getUsername());
        System.out.println("Character: " + player.getCharacter().getName());

        Team team = new Team("Legends");

        team.addCharacter(warrior);
        team.addCharacter(mage);
        team.addCharacter(archer);

        System.out.println();
        team.showTeam();

        CombatSystem combatSystem = new CombatSystem();

        System.out.println();
        combatSystem.startBattle(warrior);

        System.out.println();
        System.out.println("Inventory");

        warrior.getInventory().showWeapons();
        /*
        CharacterDAO dao = new CharacterDAO();

dao.saveCharacter(
        warrior.getId(),
        warrior.getName(),
        "Warrior",
        warrior.getLevel(),
        warrior.getHealth());

dao.saveCharacter(
        mage.getId(),
        mage.getName(),
        "Mage",
        mage.getLevel(),
        mage.getHealth());

dao.saveCharacter(
        archer.getId(),
        archer.getName(),
        "Archer",
        archer.getLevel(),
        archer.getHealth());
*/
    }
}
