/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.espe.animalfarmsystema.controller;

import ec.edu.espe.animalfarmsystema.model.Cut;
import ec.edu.espe.animalfarmsystema.model.SlaughterHouse;
import java.util.ArrayList;

/**
 *
 * @author Ronald Tipan <The_Softwarrios at ESPE>
 */
public interface IMeatAnimal {
    public ArrayList<Cut> cut();
    public void sendToSlaughterHouse(SlaughterHouse slaughterHouse);
}
