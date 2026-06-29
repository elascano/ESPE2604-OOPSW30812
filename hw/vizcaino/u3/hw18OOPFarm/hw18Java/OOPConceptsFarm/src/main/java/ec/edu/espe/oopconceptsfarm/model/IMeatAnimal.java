/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espe.oopconceptsfarm.model;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */

import java.util.ArrayList;

public interface IMeatAnimal {

    ArrayList<Cut> cut();

    void sendToSlaughterHouse(SlaughterHouse slaughterHouse);
}