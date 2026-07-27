/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.espe.animalfarrmsystem.controller;

import ec.edu.espe.animalfarrmsystem.model.Cut;
import ec.edu.espe.animalfarrmsystem.model.SlaughterHouse;
import java.util.ArrayList;


/**
 *
 * @author Mateo Artieda, MKA programmers ,@ESPE
 */
public interface IMeatAnimal {
  public ArrayList<Cut> cut();
  public void sendToSlaughterHouse(SlaughterHouse slaughterHouse);  
}
