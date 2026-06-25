/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.espe.oopconcepts.controller;

import ec.edu.espe.oopconcepts.model.Cut;
import ec.edu.espe.oopconcepts.model.SlaughterHouse;
import java.util.ArrayList;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public interface IMeatAnimal {
    public ArrayList<Cut> cut();
    
    public abstract void sendToSlaughterHouse(SlaughterHouse slaughterHouse);
}
