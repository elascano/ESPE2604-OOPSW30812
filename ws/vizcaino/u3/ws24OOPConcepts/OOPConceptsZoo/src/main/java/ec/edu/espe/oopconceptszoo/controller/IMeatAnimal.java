/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.espe.oopconceptszoo.controller;

import ec.edu.espe.oopconceptszoo.model.Cut;
import ec.edu.espe.oopconceptszoo.model.SlaughterHouse;
import java.util.ArrayList;

/**
 *
 * @author Adrian Vizcaino, SoftWarriors, @ESPE
 */
public interface IMeatAnimal {
    public ArrayList <Cut> cut ();
    public void sendToSlaughterHouse(SlaughterHouse slaugtherHouse);
}
