/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.espe.animalfarmsystem.controller;

import ec.edu.espe.animalfarmsystem.model.Cut;
import ec.edu.espe.animalfarmsystem.model.SlaughterHouse;
import java.util.ArrayList;

/**
 *
 * @author Adrian Vizcaino, The Softwarriors, @ESPE
 */
public interface IMeatAnimal {
    public ArrayList<Cut> cut();
    public SlaughterHouse sendToSlaughterHouse(SlaughterHouse slaughterHouse);
}
